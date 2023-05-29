package com.training.sgorodecki.homework.homework21.dao.impl;

import com.training.sgorodecki.homework.homework21.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework21.entity.User;
import com.training.sgorodecki.homework.homework21.entity.enums.UserRole;
import com.training.sgorodecki.homework.homework21.exceptions.EntityException;
import com.training.sgorodecki.homework.homework21.exceptions.OperationException;
import com.training.sgorodecki.homework.homework21.util.Connector;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final String ID = "id";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ADD_USER_QUERY = "INSERT INTO USER (login,password,user_role) VALUES (?,?,?)";
    private static final String GET_USER_QUERY = "SELECT id,login,password FROM USER WHERE login=?";

    private final Connector connector;

    public UserDAOImpl(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void addUser(User user) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatementInsert = connection.prepareStatement(ADD_USER_QUERY);
        ) {
            preparedStatementInsert.setString(1, user.getLogin());
            preparedStatementInsert.setString(2, user.getPassword());
            preparedStatementInsert.setString(3, user.getUserRole().name());
            preparedStatementInsert.executeUpdate();
        } catch (SQLException exception) {
            throw new OperationException("UserCantAddedException");
        }
    }

    @Override
    public User getByLogin(String login) {
        User user = null;
        try {
            Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_QUERY);
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt(ID));
                    user.setLogin(resultSet.getString(LOGIN));
                    user.setUserRole(UserRole.USER);
                    user.setPassword(resultSet.getString(PASSWORD));
                }
            }
        } catch (SQLException exception) {
            throw new EntityException("UserNotFoundException");
        }
        return user;
    }

}