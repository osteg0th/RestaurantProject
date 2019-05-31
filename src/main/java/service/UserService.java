package service;

import dao.UserDAO;
import entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ConnectionSingleton;
import util.PropertiesSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserService implements UserDAO {
    private ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstance();
    private Connection connection = connectionSingleton.getConnection();
    private Properties properties = PropertiesSingleton.PROPERTIES_SINGLETON.getProperties();
    private static Logger logger = LogManager.getLogger(UserService.class);

    @Override
    public void create(User user) {
        String query = properties.getProperty("user.create");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getRole_id());
            preparedStatement.executeUpdate();
            logger.info("Create success");
        } catch (SQLException e) {
            logger.error("Create fail with: " + e.getMessage());
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

                getUser(user, resultSet);

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

            ResultSet resultSet = preparedStatement.executeQuery();

            getUser(user, resultSet);
            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
        }
        return user;
    }

    @Override
    public User getByName(String name) {
        String query = properties.getProperty("user.getByName");
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,name);

            ResultSet resultSet = preparedStatement.executeQuery();

            getUser(user, resultSet);
            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
        }
        return user;
    }

    @Override
    public User getBySurname(String surname) {

        String query = properties.getProperty("user.getBySurname");
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, surname);

            ResultSet resultSet = preparedStatement.executeQuery();

            getUser(user, resultSet);
            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
        }
        return user;
    }

    @Override
    public User getByRole(Integer role) {
        String query = properties.getProperty("user.getByRole");
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, role);

            ResultSet resultSet = preparedStatement.executeQuery();

            getUser(user, resultSet);
            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
        }
        return user;
    }

    @Override
    public User getLogin(String email, String password) {
        String query = properties.getProperty("user.getLogin");
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            getUser(user, resultSet);
            logger.info("User exist");
        } catch (SQLException e) {
            logger.error("No such user found" + e.getMessage());
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
            logger.info("Update success");
        } catch (SQLException e) {
            logger.error("Update fail with: " + e.getMessage());
        }
    }

    @Override
    public void remove(Integer id) {
        String query = properties.getProperty("user.remove");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.info("Remove success");
        } catch (SQLException e) {
            logger.error("Remove fail with: " + e.getMessage());
        }
    }

    private void getUser(User user, ResultSet resultSet) throws SQLException {    //TODO: rename this
        resultSet.first();
        user.setId(resultSet.getInt("ID"));
        user.setName(resultSet.getString("NAME"));
        user.setSurname(resultSet.getString("SURNAME"));
        user.setRole_id(resultSet.getInt("ROLE_ID"));       //duplicate?
    }
}
