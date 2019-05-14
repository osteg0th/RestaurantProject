package service;

import bI.Util;
import dao.DishDAO;
import entities.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DishService extends Util implements DishDAO {
    private Connection connection = getConnection();
    private Properties properties = getProperties();

    @Override
    public void create(Dish dish) {
        String query = properties.getProperty("dish.create");
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
        String query = properties.getProperty("dish.getAll");

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
        String query = properties.getProperty("dish.getById");
        Dish dish = new Dish();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            dishQuery(dish, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public Dish getByName(String name) {
        String query = properties.getProperty("dish.getByName");
        Dish dish = new Dish();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            dishQuery(dish, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public Dish getByType(String type) {
        String query = properties.getProperty("dish.getByType");
        Dish dish = new Dish();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();

            dishQuery(dish, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public Dish getByPrice(Double price) {
        String query = properties.getProperty("dish.getByPrice");
        Dish dish = new Dish();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, price);
            ResultSet resultSet = preparedStatement.executeQuery();

            dishQuery(dish, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public Dish getByWeight(Double weight) {
        String query = properties.getProperty("dish.getByWeight");
        Dish dish = new Dish();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, weight);
            ResultSet resultSet = preparedStatement.executeQuery();

            dishQuery(dish, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public void update(Dish dish) {
        String query = properties.getProperty("dish.update");
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
        String query = properties.getProperty("dish.remove");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, dish.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dishQuery(Dish dish, ResultSet resultSet) throws SQLException {    //TODO: rename this
        resultSet.first();
        dish.setId(resultSet.getInt("ID"));
        dish.setName(resultSet.getString("NAME"));
        dish.setType(resultSet.getString("TYPE"));
        dish.setPrice(resultSet.getDouble("PRICE"));
        dish.setWeight(resultSet.getDouble("WEIGHT"));     //duplicate?
    }
}
