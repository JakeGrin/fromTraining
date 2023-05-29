package com.training.sgorodecki.homework.homework19_2.dao.impl;

import com.training.sgorodecki.homework.homework19_2.Connector;
import com.training.sgorodecki.homework.homework19_2.dao.api.OrderDAO;
import com.training.sgorodecki.homework.homework19_2.entity.Good;
import com.training.sgorodecki.homework.homework19_2.entity.Order;
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

    @Override
    public void addOrder(int userId) {
        String addOrderQuery = "INSERT INTO ORDERS (user_id,total_price) VALUES (?,?) ";
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addOrderQuery)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setBigDecimal(2, BigDecimal.ZERO);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Order getOrderByUserId(int id) {
        Order order = new Order();
        String getOrderByUserIdQuery = "SELECT id,user_id,total_price FROM ORDERS WHERE user_id=?";
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getOrderByUserIdQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                order.setId(resultSet.getInt(ID));
                order.setUserId(resultSet.getInt(USER_ID));
                order.setTotalPrice(resultSet.getBigDecimal(TOTAL_PRICE));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }

    @Override
    public void updateTotalPriceOfOrder(String username) {
        BigDecimal totalPrice = null;
        Integer orderId = null;

        String updateTotalPriceQuery = "UPDATE ORDERS SET total_price=? WHERE ORDERS.id=?";
        String countPriceQuery = "SELECT SUM(GOODS.cost), ORDERS.id FROM GOODS" +
                " JOIN ORDER_GOOD ON GOODS.id = ORDER_GOOD.good_id" +
                " JOIN ORDERS ON ORDER_GOOD.order_id = ORDERS.id " +
                " JOIN USER ON USER.id = ORDERS.user_id" +
                " WHERE USER.login = ?";

        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatementUpdate = connection.prepareStatement(updateTotalPriceQuery);
             PreparedStatement preparedStatementCountPrice = connection.prepareStatement(countPriceQuery)) {

            preparedStatementCountPrice.setString(1, username);
            ResultSet resultSet = preparedStatementCountPrice.executeQuery();
            while (resultSet.next()) {
                totalPrice = resultSet.getBigDecimal(1);
                orderId = resultSet.getInt(2);
            }
            preparedStatementUpdate.setBigDecimal(1, totalPrice);
            preparedStatementUpdate.setInt(2, orderId);
            preparedStatementUpdate.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addGoodInOrder(Order order, Good good) {
        String addGoodInOrderQuery = "INSERT INTO ORDER_GOOD (order_id,good_id) VALUES (?,?) ";
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addGoodInOrderQuery)) {
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setInt(2, good.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Good> getUserGoods(String username) {
        List<Good> listOfGoods = new ArrayList<>();
        String getUserGoodsQuery = "SELECT GOODS.name,GOODS.id, GOODS.cost FROM GOODS " +
                "JOIN ORDER_GOOD ON GOODS.id  = ORDER_GOOD.good_id " +
                "Join ORDERS on ORDER_GOOD.order_id = ORDERS.id " +
                "JOIN USER ON USER.id = ORDERS.user_id " +
                "WHERE USER.login = ?";

        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getUserGoodsQuery)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Good good = new Good();
                good.setId(resultSet.getInt(ID));
                good.setName(resultSet.getString(NAME));
                good.setPrice(resultSet.getBigDecimal(COST));
                listOfGoods.add(good);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listOfGoods;
    }
}