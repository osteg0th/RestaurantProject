package service;

import bI.Util;
import dao.DishDAO;
import entities.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishService extends Util implements DishDAO {
    private Connection connection = getConnection();

    @Override
    public void create(Dish dish) {
        String query = "INSERT INTO dish (id, name, type, price, weight) VALUE(?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, dish.getId());
            preparedStatement.setString(2, dish.getName());
            preparedStatement.setString(3, dish.getType());
            preparedStatement.setDouble(4, dish.getPrice());
            preparedStatement.setDouble(5, dish.getWeight());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Dish> getAll() {
        List<Dish> dishList = new ArrayList<>();
        String query = "SELECT id, name, type, price, weight FROM dish";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Dish dish = new Dish();

                dishQuery(dish, resultSet);

                dishList.add(dish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dishList;
    }

    @Override
    public Dish getById(Integer id) {
        String query = "SELECT id, name, type, price, weight FROM dish where id=?";
        Dish dish = new Dish();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, dish.getId());
            ResultSet resultSet = preparedStatement.executeQuery(query);

            dishQuery(dish, resultSet);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public Dish getByName(String name) {
        String query = "SELECT id, name, type, price, weight FROM dish where name=?";
        Dish dish = new Dish();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, dish.getName());
            ResultSet resultSet = preparedStatement.executeQuery(query);

            dishQuery(dish, resultSet);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public Dish getByType(String type) {

        String query = "SELECT id, name, type, price, weight FROM dish where type=?";
        Dish dish = new Dish();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, dish.getType());
            ResultSet resultSet = preparedStatement.executeQuery(query);

            dishQuery(dish, resultSet);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public Dish getByPrice(Double price) {

        String query = "SELECT id, name, type, price, weight FROM dish where price=?";
        Dish dish = new Dish();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, dish.getPrice());
            ResultSet resultSet = preparedStatement.executeQuery(query);

            dishQuery(dish, resultSet);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public Dish getByWeight(Double weight) {

        String query = "SELECT id, name, type, price, weight FROM dish where price=?";
        Dish dish = new Dish();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, dish.getWeight());
            ResultSet resultSet = preparedStatement.executeQuery(query);

            dishQuery(dish, resultSet);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public void update(Dish dish) {
        String query = "UPDATE dish SET name=?,type=?,price=?,weight=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, dish.getName());
            preparedStatement.setString(2, dish.getType());
            preparedStatement.setDouble(3, dish.getPrice());
            preparedStatement.setDouble(4, dish.getWeight());
            preparedStatement.setInt(5, dish.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Dish dish) {
        String query = "DELETE FROM dish WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, dish.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dishQuery(Dish dish, ResultSet resultSet) throws SQLException {    //TODO: rename this
        dish.setId(resultSet.getInt("ID"));
        dish.setName(resultSet.getString("NAME"));
        dish.setType(resultSet.getString("TYPE"));
        dish.setPrice(resultSet.getDouble("PRICE"));
        dish.setWeight(resultSet.getDouble("WEIGHT"));     //duplicate?
    }
}
