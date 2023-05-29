package com.training.sgorodecki.homework.homework18.dao.impl;

import com.training.sgorodecki.homework.homework18.exceptions.EntityException;
import com.training.sgorodecki.homework.homework18.exceptions.OperationException;
import com.training.sgorodecki.homework.homework18.util.Connector;
import com.training.sgorodecki.homework.homework18.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework18.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private static final String ID = "id";
    private static final String LOGIN = "login";
    private final Connector connector = Connector.getConnectorInstance();
    private static final String ADD_USER_QUERY = "INSERT INTO USER (login,password) VALUES (?,?)";
    private static final String GET_USER_QUERY = "SELECT id,login FROM USER WHERE login=?";

    @Override
    public void addUser(User user) {
        try (Connection connection =  connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_QUERY)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new OperationException("UserCantAddedException");
        }
    }

    @Override
    public User getByLogin(String login) {
        User user = new User();
        try {
            Connection connection =  connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_QUERY);
            preparedStatement.setString(1, login);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user.setId(resultSet.getInt(ID));
                    user.setLogin(resultSet.getString(LOGIN));
                }
            }
        } catch (SQLException exception) {
           throw new EntityException("UserNotFoundException");
        }
        return user;
    }
}