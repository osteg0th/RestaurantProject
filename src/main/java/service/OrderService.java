package service;

import dao.OrderDAO;
import entities.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ConnectionSingleton;
import util.PropertiesSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrderService implements OrderDAO {
    private ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstance();
    private Connection connection = connectionSingleton.getConnection();
    private Properties properties = PropertiesSingleton.PROPERTIES_SINGLETON.getProperties();
    private static Logger logger = LogManager.getLogger(MenuService.class);

    @Override
    public void create(Order order) {
        String query = properties.getProperty("order.create");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, order.getPriceTotal());
            preparedStatement.setInt(2, order.getMenuId());
            preparedStatement.setInt(3, order.getConfirm());
            preparedStatement.setInt(4, order.getPaid());
            preparedStatement.setInt(5, order.getUserId());
            preparedStatement.setInt(6, order.getTableId());
            preparedStatement.executeUpdate();
            logger.info("Create success");
        } catch (SQLException e) {
            logger.error("Create fail with: " + e.getMessage());
        }
    }

    @Override
    public List<Order> getAll() {
        String query = properties.getProperty("order.getAll");
        List<Order> orderList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Order order = new Order();

                getOrder(resultSet, order);

                orderList.add(order);
            }
            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
        }

        return orderList;
    }

    @Override
    public Order getById(Integer id) {
        String query = properties.getProperty("order.getById");
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            getOrder(resultSet, order);
            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
        }
        return order;
    }

    @Override
    public Order getByTotalPrice(Double priceTotal) {
        String query = properties.getProperty("order.getByTotalPrice");
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, priceTotal);
            ResultSet resultSet = preparedStatement.executeQuery();

            getOrder(resultSet, order);

            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
        }
        return order;
    }

    @Override
    public Order getByMenuId(Integer menuId) {
        String query = properties.getProperty("order.getByMenuId");
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, menuId);
            ResultSet resultSet = preparedStatement.executeQuery();

            getOrder(resultSet, order);
            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
        }
        return order;
    }

    @Override
    public Order getByConfirm(Byte confirm) {
        String query = properties.getProperty("order.getByConfirm");
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, confirm);
            ResultSet resultSet = preparedStatement.executeQuery();

            getOrder(resultSet, order);
            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
        }
        return order;
    }

    @Override
    public Order getByPaid(Byte paid) {
        String query = properties.getProperty("order.getByPaid");
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, paid);
            ResultSet resultSet = preparedStatement.executeQuery();

            getOrder(resultSet, order);
            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
        }
        return order;
    }

    @Override
    public Order getByUserId(Integer userId) {
        String query = properties.getProperty("order.getByUserId");
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            getOrder(resultSet, order);

            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
        }
        return order;
    }

    @Override
    public Order getByTable(Integer tableId) {
        String query = properties.getProperty("order.getByTable");
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            getOrder(resultSet, order);

            logger.info("Search success");
        } catch (SQLException e) {
            logger.error("Search fail with: " + e.getMessage());
        }
        return order;
    }

    private void getOrder(ResultSet resultSet, Order order) throws SQLException {
        resultSet.first();
        order.setId(resultSet.getInt("ID"));
        order.setPriceTotal(resultSet.getDouble("PRICE_TOTAL"));
        order.setMenuId(resultSet.getInt("MENU_ID"));
        order.setConfirm(resultSet.getInt("CONFIRM"));
        order.setPaid(resultSet.getInt("PAID"));
        order.setUserId(resultSet.getInt("USER_ID"));
        order.setTableId(resultSet.getInt("TABLE_ID"));
    }

    @Override
    public void update(Order order) {
        String query = properties.getProperty("order.update");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, order.getPriceTotal());
            preparedStatement.setInt(2, order.getMenuId());
            preparedStatement.setInt(3, order.getConfirm());
            preparedStatement.setInt(4, order.getPaid());
            preparedStatement.setInt(5, order.getUserId());
            preparedStatement.setInt(6, order.getTableId());
            preparedStatement.setInt(7, order.getId());
            logger.info("Update success");
        } catch (SQLException e) {
            logger.error("Update fail with: " + e.getMessage());
        }
    }

    @Override
    public void remove(Integer id) {
        String query = properties.getProperty("order.remove");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.info("Remove success");
        } catch (SQLException e) {
            logger.error("Remove fail with: " + e.getMessage());
        }
    }
}
