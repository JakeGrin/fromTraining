package com.training.sgorodecki.homework.homework19_2.dao.impl;

import com.training.sgorodecki.homework.homework19_2.Connector;
import com.training.sgorodecki.homework.homework19_2.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework19_2.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final String ID = "id";
    private static final String LOGIN = "login";

    private final Connector connector;

    public UserDAOImpl(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void addUser(User user) {
        String addUserQuery = "INSERT INTO USER (login,password) VALUES (?,?)";

        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addUserQuery)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User getUserByLogin(String login) {
        User user = new User();
        String getUserQuery = "SELECT id,login FROM USER WHERE login=?";

        try {
            Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getUserQuery);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt(ID));
                user.setLogin(resultSet.getString(LOGIN));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}