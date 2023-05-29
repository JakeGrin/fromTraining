package com.training.sgorodecki.homework.homework19_3.dao.impl;

import com.training.sgorodecki.homework.homework19_3.Connector;
import com.training.sgorodecki.homework.homework19_3.dao.api.GoodDAO;
import com.training.sgorodecki.homework.homework19_3.entity.Good;
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

    private final Connector connector;

    public GoodDAOImpl(Connector connector) {
        this.connector = connector;
    }

    @Override
    public List<Good> getAllGoods() {
        List<Good> allGoods = new ArrayList<>();
        String getAllGoodsQuery = "SELECT name, id, cost FROM GOODS";
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getAllGoodsQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Good good = new Good();
                good.setName(resultSet.getString(NAME));
                good.setId(resultSet.getInt(ID));
                good.setPrice(BigDecimal.valueOf(resultSet.getDouble(COST)));
                allGoods.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allGoods;
    }

    @Override
    public Good getGoodById(int id) {
        String getGoodByIdQuery = "SELECT name, id, cost FROM GOODS WHERE GOODS.id = ?";
        Good good = new Good();

        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getGoodByIdQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                good.setName(resultSet.getString(NAME));
                good.setId(resultSet.getInt(ID));
                good.setPrice(BigDecimal.valueOf(resultSet.getDouble(COST)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return good;
    }
}