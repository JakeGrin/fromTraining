package com.training.sgorodecki.homework.homework21.dao.impl;

import com.training.sgorodecki.homework.homework21.dao.api.OrderDAO;
import com.training.sgorodecki.homework.homework21.entity.Good;
import com.training.sgorodecki.homework.homework21.entity.Order;
import com.training.sgorodecki.homework.homework21.exceptions.EntityException;
import com.training.sgorodecki.homework.homework21.exceptions.OperationException;
import com.training.sgorodecki.homework.homework21.util.Connector;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private static final String ID = "id";
    private static final String USER_ID = "user_id";
    private static final String TOTAL_PRICE = "total_price";
    private static final String NAME = "name";
    private static final String COST = "cost";

    private final Connector connector;

    public OrderDAOImpl(Connector connector) {
        this.connector = connector;
    }

    private static final String ADD_ORDER_QUERY = "INSERT INTO ORDERS (user_id,total_price) VALUES (?,?) ";
    private static final String GET_ORDER_BY_USER_ID_QUERY = "SELECT id,user_id,total_price FROM ORDERS WHERE user_id=?";
    private static final String UPDATE_TOTAL_PRICE_QUERY = "UPDATE ORDERS SET total_price=? WHERE ORDERS.id=?";
    private static final String COUNT_PRICE_QUERY = "SELECT SUM(GOODS.cost), ORDERS.id FROM GOODS" +
            " JOIN ORDER_GOOD ON GOODS.id = ORDER_GOOD.good_id" +
            " JOIN ORDERS ON ORDER_GOOD.order_id = ORDERS.id " +
            " JOIN USER ON USER.id = ORDERS.user_id" +
            " WHERE USER.login = ?";
    private static final String ADD_GOOD_IN_ORDER_QUERY = "INSERT INTO ORDER_GOOD (order_id,good_id) VALUES (?,?) ";
    private static final String GET_USER_GOODS_QUERY = "SELECT GOODS.name,GOODS.id, GOODS.cost FROM GOODS " +
            "JOIN ORDER_GOOD ON GOODS.id  = ORDER_GOOD.good_id " +
            "Join ORDERS on ORDER_GOOD.order_id = ORDERS.id " +
            "JOIN USER ON USER.id = ORDERS.user_id " +
            "WHERE USER.login = ?";

    @Override
    public void addOrder(int userId) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_ORDER_QUERY)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setBigDecimal(2, BigDecimal.ZERO);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new OperationException("OrderCantAddedException");
        }
    }

    @Override
    public Order getByUserId(int id) {
        Order order = new Order();
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_USER_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    order.setId(resultSet.getInt(ID));
                    order.setUserId(resultSet.getInt(USER_ID));
                    order.setTotalPrice(resultSet.getBigDecimal(TOTAL_PRICE));
                }
            }
        } catch (SQLException exception) {
            throw new EntityException("UserNotFoundException");
        }
        return order;
    }

    @Override
    public void updatePrice(String username) {
        BigDecimal totalPrice = null;
        Integer orderId = null;
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatementUpdate = connection.prepareStatement(UPDATE_TOTAL_PRICE_QUERY);
             PreparedStatement preparedStatementCountPrice = connection.prepareStatement(COUNT_PRICE_QUERY)) {

            preparedStatementCountPrice.setString(1, username);
            try (ResultSet resultSet = preparedStatementCountPrice.executeQuery()) {
                while (resultSet.next()) {
                    totalPrice = resultSet.getBigDecimal(1);
                    orderId = resultSet.getInt(2);
                }
                preparedStatementUpdate.setBigDecimal(1, totalPrice);
                preparedStatementUpdate.setInt(2, orderId);
                preparedStatementUpdate.executeUpdate();
            }
        } catch (SQLException exception) {
            throw new OperationException("PriceCantUpdatedException");
        }
    }

    @Override
    public void addGood(Order order, Good good) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_GOOD_IN_ORDER_QUERY)) {
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setInt(2, good.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new OperationException("GoodCantAddedException");
        }
    }

    @Override
    public List<Good> getGoods(String username) {
        List<Good> listOfGoods = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_GOODS_QUERY)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Good good = new Good();
                    good.setId(resultSet.getInt(ID));
                    good.setName(resultSet.getString(NAME));
                    good.setPrice(resultSet.getBigDecimal(COST));
                    listOfGoods.add(good);
                }
            }
        } catch (SQLException exception) {
            throw new EntityException("GoodsNotFoundException");
        }
        return listOfGoods;
    }
}