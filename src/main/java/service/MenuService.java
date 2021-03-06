package service;

import dao.MenuDAO;
import entities.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ConnectionSingleton;
import util.PropertiesSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MenuService implements MenuDAO {
    private ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstance();
    private Connection connection = connectionSingleton.getConnection();
    private Properties properties = PropertiesSingleton.PROPERTIES_SINGLETON.getProperties();
    private static Logger logger = LogManager.getLogger(MenuService.class);

    @Override
    public void create(Menu menu) {
        String query = properties.getProperty("menu.create");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, menu.getId());
            preparedStatement.setInt(2, menu.getDishId());
            preparedStatement.executeUpdate();
            logger.info("Create success");
        } catch (SQLException e) {
            logger.error("Create fail with: " + e.getMessage());
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
            logger.info("Search success");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Search fail with: " + e.getMessage());
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
            resultSet.first();
            menu.setId(resultSet.getInt("ID"));
            menu.setDishId(resultSet.getInt("DISH_ID"));
            logger.info("Search success");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Search fail with: " + e.getMessage());
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
            logger.info("Update success");
        } catch (SQLException e) {
            logger.error("Update fail with: " + e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        String query = properties.getProperty("menu.remove");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.info("Remove success");
        } catch (SQLException e) {
            logger.error("Remove fail with: " + e.getMessage());
        }
    }
}
