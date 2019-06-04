package service;

import dao.RoleDAO;
import entities.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ConnectionSingleton;
import util.PropertiesSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RoleService implements RoleDAO {
    private ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstance();
    private Connection connection = connectionSingleton.getConnection();
    private Properties properties = PropertiesSingleton.PROPERTIES_SINGLETON.getProperties();
    private static Logger logger = LogManager.getLogger(RoleService.class);


    @Override
    public void create(Role role) {
        String query = properties.getProperty("role.create");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, role.getAccess());
            preparedStatement.executeUpdate();
            logger.info("Create success");
        } catch (SQLException e) {
            logger.error("Create fail with: " + e.getMessage());
        }
    }

    @Override
    public List<Role> getAll() {
        List<Role> roleList = new ArrayList<>();
        String query = properties.getProperty("role.getAll");
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("ID"));
                role.setAccess(resultSet.getString("ACCESS"));
                roleList.add(role);

            }
            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
        }
        return roleList;
    }

    @Override
    public Role getById(Integer id) {
        String query = properties.getProperty("role.getById");
        Role role = new Role();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.first();
            role.setId(resultSet.getInt("id"));
            role.setAccess(resultSet.getString("ACCESS"));
            logger.info("Search success");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Search fail with: " + e.getMessage());
        }
        return role;
    }

    @Override
    public List<Role> getByAccess(String access) {
        List<Role> roleList = new ArrayList<>();
        String query = properties.getProperty("role.getByAccess");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, access);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("ID"));
                role.setAccess(resultSet.getString("ACCESS"));
                roleList.add(role);
            }
            logger.info("Search success");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Search fail with: " + e.getMessage());
        }
        return roleList;
    }

    @Override
    public void update(Role role) {
        String query = properties.getProperty("role.update");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, role.getAccess());
            preparedStatement.setInt(2, role.getId());

            preparedStatement.executeUpdate();
            logger.info("Update success");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Update fail with: " + e.getMessage());
        }
    }

    @Override
    public void delete(Role role) {
        String query = properties.getProperty("role.remove");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, role.getId());
            preparedStatement.executeUpdate();
            logger.info("Remove success");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Remove fail with: " + e.getMessage());
        }
    }
}
