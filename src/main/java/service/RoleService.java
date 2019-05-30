package service;

import bI.ConnectionSingleton;
import bI.PropertiesSingleton;
import dao.RoleDAO;
import entities.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RoleService implements RoleDAO {
    private ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstance();
    private Connection connection = connectionSingleton.getConnection();
    private Properties properties = PropertiesSingleton.PROPERTIES_SINGLETON.getProperties();


    @Override
    public void create(Role role) {
        String query = properties.getProperty("role.create");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, role.getAccess());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
        } catch (SQLException e) {
            e.printStackTrace();
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public Role getByAccess(String access) {
        String query = properties.getProperty("role.getByAccess");
        Role role = new Role();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, access);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.first();
            role.setId(resultSet.getInt("ID"));
            role.setAccess(resultSet.getString("ACCESS"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void update(Role role) {
        String query = properties.getProperty("role.update");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, role.getAccess());
            preparedStatement.setInt(2, role.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Integer id) {
        String query = properties.getProperty("role.remove");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
