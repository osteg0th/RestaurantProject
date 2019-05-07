package service;

import bI.Util;
import dao.UserDAO;
import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService extends Util implements UserDAO {
    private Connection connection = getConnection();

    @Override
    public void create(User user) {
        String query = "INSERT INTO USER (ID, NAME, SURNAME, ROLE_ID) VALUES (?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setInt(4, user.getRole_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT ID, NAME, SURNAME, ROLE_ID FROM USER";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();

                userQuery(user, resultSet);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User getById(Integer id) {
        String query = "SELECT id, name, surname, role_id FROM user WHERE ID = ?";
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery(query);

            userQuery(user, resultSet);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getByName(String name) {
        String query = "SELECT id, name, surname, role_id FROM user WHERE NAME = ?";
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,name);

            ResultSet resultSet = preparedStatement.executeQuery(query);

            userQuery(user, resultSet);
            preparedStatement.executeUpdate();  //what is it?
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
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
        String query = "UPDATE USER SET NAME=?, SURNAME=?, ROLE_ID=? WHERE ID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getRole_id());
            preparedStatement.setInt(4, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(User user) {
        String query = "DELETE FROM USER WHERE ID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void userQuery(User user, ResultSet resultSet) throws SQLException {    //TODO: rename this
        user.setId(resultSet.getInt("ID"));
        user.setName(resultSet.getString("NAME"));
        user.setSurname(resultSet.getString("SURNAME"));
        user.setRole_id(resultSet.getInt("ROLE_ID"));       //duplicate?
    }
}
