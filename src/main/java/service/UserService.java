package service;

import bI.Util;
import dao.UserDAO;
import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserService extends Util implements UserDAO {
    private Connection connection = getConnection();
    private Properties properties = getProperties();

    @Override
    public void create(User user) {
        String query = properties.getProperty("user.create");
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
        String query = properties.getProperty("user.getAll");

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
        String query = properties.getProperty("user.getById");
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
        String query = properties.getProperty("user.getByName");
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

        String query = properties.getProperty("user.getBySurname");
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, surname);

            ResultSet resultSet = preparedStatement.executeQuery(query);

            userQuery(user, resultSet);
            preparedStatement.executeUpdate();  //what is it?
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getByRole(Integer role) {
        String query = properties.getProperty("user.getByRole");
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, role);

            ResultSet resultSet = preparedStatement.executeQuery(query);

            userQuery(user, resultSet);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {
        String query = properties.getProperty("user.update");
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
        String query = properties.getProperty("user.remove");
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
