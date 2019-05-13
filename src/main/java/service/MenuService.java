package service;

import bI.Util;
import dao.MenuDAO;
import entities.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MenuService extends Util implements MenuDAO {
    private Connection connection = getConnection();
    private Properties properties = getProperties();

    @Override
    public void create(Menu menu) {
//        String query = "INSERT INTO MENU (id, dish_id) VALUES (?,?)";
        String query = properties.getProperty("menu.create");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, menu.getId());
            preparedStatement.setInt(2, menu.getDishId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> getAll() {
        List<Menu> menuList = new ArrayList<>();
        String query = properties.getProperty("menu.getAll");

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Menu menu = new Menu();

                menu.setId(resultSet.getInt("ID"));
                menu.setDishId(resultSet.getInt("DISH_ID"));

                menuList.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public Menu getById(Integer id) {
        String query = properties.getProperty("menu.getById");
        Menu menu = new Menu();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            menu.setId(resultSet.getInt("ID"));
            menu.setDishId(resultSet.getInt("DISH_ID"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public void update(Menu menu) {
        String query = properties.getProperty("menu.update");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, menu.getDishId());
            preparedStatement.setInt(2, menu.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Menu menu) {
        String query = properties.getProperty("menu.remove");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, menu.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
