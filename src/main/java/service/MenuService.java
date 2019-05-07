package service;

import bI.Util;
import dao.MenuDAO;
import entities.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuService extends Util implements MenuDAO {
    private Connection connection = getConnection();

    @Override
    public void create(Menu menu) {
        String query = "INSERT INTO MENU (id, dish_id) VALUES (?,?)";
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
        String query = "";

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
        String query = "SELECT ID, DISH_ID from menu where ID=?";
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
        String query = "UPDATE MENU SET DISH_ID=? WHERE ID=?";
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
        String query = "DELETE FROM MENU WHERE ID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, menu.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
