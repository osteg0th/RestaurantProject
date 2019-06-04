package service;

import dao.TableDAO;
import entities.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ConnectionSingleton;
import util.PropertiesSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TableService implements TableDAO {
    private ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstance();
    private Connection connection = connectionSingleton.getConnection();
    private Properties properties = PropertiesSingleton.PROPERTIES_SINGLETON.getProperties();
    private static Logger logger = LogManager.getLogger(TableService.class);

    @Override
    public void create(Table table) {
        String query = properties.getProperty("table.create");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, table.getId());
            preparedStatement.setInt(2, table.getStatus());
            preparedStatement.executeUpdate();
            logger.info("Create success");
        } catch (SQLException e) {
            logger.error("Create fail with: " + e.getMessage());
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
            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
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
            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
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
            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
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
            logger.info("Update success");
        } catch (SQLException e) {
            logger.error("Update fail with: " + e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        String query = properties.getProperty("table.remove");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.info("Remove success");
        } catch (SQLException e) {
            logger.error("Remove fail with: " + e.getMessage());
        }
    }
}
