package service;

import bI.ConnectionSingleton;
import bI.PropertiesSingleton;
import dao.TableDAO;
import entities.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TableService extends Util implements TableDAO {
    private ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstance();
    private Connection connection = connectionSingleton.getConnection();
    private PropertiesSingleton propertiesSingleton = PropertiesSingleton.getInstance();
    private Properties properties = propertiesSingleton.getProperties();


    @Override
    public void create(Table table) {
        String query = properties.getProperty("table.create");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, table.getId());
            preparedStatement.setInt(2, table.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Table> getAll() {
        String query = properties.getProperty("table.getAll");
        List<Table> tableList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Table table = new Table();

                table.setId(resultSet.getInt("ID"));
                table.setStatus(resultSet.getInt("STATUS"));

                tableList.add(table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableList;
    }

    @Override
    public Table getById(Integer id) {
        String query = properties.getProperty("table.getById");
        Table table = new Table();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.first();
            table.setId(resultSet.getInt("ID"));
            table.setStatus(resultSet.getInt("STATUS"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return table;
    }

    @Override
    public Table getByStatus(Integer status) {
        String query = properties.getProperty("table.getByStatus");
        Table table = new Table();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, status);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.first();
            table.setId(resultSet.getInt("ID"));
            table.setStatus(resultSet.getInt("STATUS"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return table;
    }

    @Override
    public void update(Table table) {
        String query = properties.getProperty("table.update");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, table.getStatus());
            preparedStatement.setInt(2, table.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Integer id) {
        String query = properties.getProperty("table.remove");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
