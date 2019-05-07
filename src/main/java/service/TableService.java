package service;

import bI.Util;
import dao.TableDAO;
import entities.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableService extends Util implements TableDAO {
    private Connection connection = getConnection();


    @Override
    public void create(Table table) {
        String query = "INSERT INTO table (id, status) VALUES (?,?) ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, table.getId());
            preparedStatement.setByte(2, table.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Table> getAll() {
        String query = "SELECT id, status FROM table";
        List<Table> tableList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Table table = new Table();

                table.setId(resultSet.getInt("ID"));
                table.setStatus(resultSet.getByte("STATUS"));

                tableList.add(table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableList;
    }

    @Override
    public Table getById(Integer id) {
        String query = "SELECT id,status FROM table WHERE id=?";
        Table table = new Table();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, table.getId());

            ResultSet resultSet = preparedStatement.executeQuery(query);
            table.setId(resultSet.getInt("ID"));
            table.setStatus(resultSet.getByte("STATUS"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return table;
    }

    @Override
    public Table getByStatus(Byte status) {
        String query = "SELECT id,status FROM table WHERE status=?";
        Table table = new Table();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setByte(1, table.getStatus());

            ResultSet resultSet = preparedStatement.executeQuery(query);
            table.setId(resultSet.getInt("ID"));
            table.setStatus(resultSet.getByte("STATUS"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return table;
    }

    @Override
    public void update(Table table) {
        String query = "UPDATE table SET status=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setByte(1, table.getStatus());
            preparedStatement.setInt(2, table.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Table table) {
        String query = "DELETE FROM table WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, table.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
