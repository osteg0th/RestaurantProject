package service;

import bI.Util;
import dao.RoleDAO;
import entities.Role;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleService extends Util implements RoleDAO {
    private Connection connection = getConnection();


    @Override
    public void create(Role role) {
        String query = "INSERT INTO ROLE (ID, ACCESS) VALUES (?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, role.getId());
            preparedStatement.setString(2, role.getAccess());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Role> getAll() {
        List<Role> roleList = new ArrayList<>();
        String query = "SELECT id, access FROM role";
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
        String query = "SELECT id, access FROM role WHERE id=?";
        Role role = new Role();
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery(query);

            role.setId(resultSet.getInt("ID"));
            role.setAccess(resultSet.getString("ACCESS"));

            preparedStatement.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public Role getByAccess(String access) {
        String query = "";
        Role role = new Role();
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, access);

            ResultSet resultSet = preparedStatement.executeQuery(query);

            role.setId(resultSet.getInt("ID"));
            role.setAccess(resultSet.getString("ACCESS"));

            preparedStatement.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void update(Role role) {
        String query = "UPDATE ROLE SET ACCESS=? WHERE ID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, role.getAccess());
            preparedStatement.setInt(2, role.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Role role) {
        String query = "DELETE FROM role WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, role.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
