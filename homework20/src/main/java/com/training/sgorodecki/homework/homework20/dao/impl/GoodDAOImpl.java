package com.training.sgorodecki.homework.homework20.dao.impl;

import com.training.sgorodecki.homework.homework20.dao.api.GoodDAO;
import com.training.sgorodecki.homework.homework20.entity.Good;
import com.training.sgorodecki.homework.homework20.exceptions.EntityException;
import com.training.sgorodecki.homework.homework20.util.Connector;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GoodDAOImpl implements GoodDAO {

    private static final String NAME = "name";
    private static final String ID = "id";
    private static final String COST = "cost";

    private static final String GET_ALL_GOODS_QUERY = "SELECT name, id, cost FROM GOODS";
    private static final String GET_GOOD_BY_ID_QUERY = "SELECT name, id, cost FROM GOODS WHERE GOODS.id = ?";

    private final Connector connector;

    public GoodDAOImpl(Connector connector) {
        this.connector = connector;
    }

    @Override
    public List<Good> getAll() {
        List<Good> allGoods = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_GOODS_QUERY)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Good good = new Good();
                    good.setName(resultSet.getString(NAME));
                    good.setId(resultSet.getInt(ID));
                    good.setPrice(BigDecimal.valueOf(resultSet.getDouble(COST)));
                    allGoods.add(good);
                }
            }
        } catch (SQLException exception) {
            throw new EntityException("GoodsNotFoundException");
        }
        return allGoods;
    }

    @Override
    public Good getById(int id) {
        Good good = new Good();
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_GOOD_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    good.setName(resultSet.getString(NAME));
                    good.setId(resultSet.getInt(ID));
                    good.setPrice(BigDecimal.valueOf(resultSet.getDouble(COST)));
                }
            }
        } catch (SQLException exception) {
            throw new EntityException("GoodNotFoundException");
        }
        return good;
    }
}