package service;

import bI.Util;
import dao.UserDAO;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserService extends Util implements UserDAO {
    private Connection connection = getConnection();
    @Override
    public void create(User user) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO USER (ID, NAME, SURNAME, ROLE_ID) VALUES (?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getSurname());
            preparedStatement.setInt(4,user.getRole_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(preparedStatement != null)
            {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public User getByName(String name) {
        return null;
    }

    @Override
    public User getBySurname(String surname) {
        return null;
    }

    @Override
    public User getByRole(Integer role) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void remove(User user) {

    }
}
