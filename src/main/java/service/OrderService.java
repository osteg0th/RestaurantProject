package service;

import bI.Util;
import dao.OrderDAO;
import entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService extends Util implements OrderDAO {
    private Connection connection = getConnection();

    @Override
    public void create(Order order) {
        String query = "INSERT INTO order (id, price_total, menu_id, order_time, confirm, paid, user_id, table_id) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setDouble(2, order.getPriceTotal());
            preparedStatement.setInt(3, order.getMenuId());
//            preparedStatement.setDate(4,order.getOrderTime());        TODO try to fix data types
            preparedStatement.setByte(5, order.getConfirm());
            preparedStatement.setByte(6, order.getPaid());
            preparedStatement.setInt(7, order.getUserId());
            preparedStatement.setInt(8, order.getTableId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAll() {
        String query = "SELECT id, price_total, menu_id, order_time, confirm, paid, user_id, table_id FROM order";
        List<Order> orderList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Order order = new Order();

                order.setId(resultSet.getInt("ID"));
                order.setPriceTotal(resultSet.getDouble("PRICE_TOTAL"));
                order.setMenuId(resultSet.getInt("MENU_ID"));
//            order.setOrderTime();
                order.setConfirm(resultSet.getByte("CONFIRM"));
                order.setPaid(resultSet.getByte("PAID"));
                order.setUserId(resultSet.getInt("USER_ID"));
                order.setTableId(resultSet.getInt("TABLE_ID"));

                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderList;
    }

    @Override
    public Order getById(Integer id) {
        String query = "SELECT id, price_total, menu_id, order_time, confirm, paid, user_id, table_id FROM order ID=?";
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getId());
            ResultSet resultSet = preparedStatement.executeQuery(query);

            order.setId(resultSet.getInt("ID"));
            order.setPriceTotal(resultSet.getDouble("PRICE_TOTAL"));
            order.setMenuId(resultSet.getInt("MENU_ID"));
//            order.setOrderTime();
            order.setConfirm(resultSet.getByte("CONFIRM"));
            order.setPaid(resultSet.getByte("PAID"));
            order.setUserId(resultSet.getInt("USER_ID"));
            order.setTableId(resultSet.getInt("TABLE_ID"));


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order getByTotalPrice(Double priceTotal) {
        String query = "SELECT id, price_total, menu_id, order_time, confirm, paid, user_id, table_id FROM order priceTotal=?";
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getId());
            ResultSet resultSet = preparedStatement.executeQuery(query);

            order.setId(resultSet.getInt("ID"));
            order.setPriceTotal(resultSet.getDouble("PRICE_TOTAL"));
            order.setMenuId(resultSet.getInt("MENU_ID"));
//            order.setOrderTime();
            order.setConfirm(resultSet.getByte("CONFIRM"));
            order.setPaid(resultSet.getByte("PAID"));
            order.setUserId(resultSet.getInt("USER_ID"));
            order.setTableId(resultSet.getInt("TABLE_ID"));


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order getByMenuId(Integer menuId) {
        String query = "SELECT id, price_total, menu_id, order_time, confirm, paid, user_id, table_id FROM order menu_id=?";
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getId());
            ResultSet resultSet = preparedStatement.executeQuery(query);

            order.setId(resultSet.getInt("ID"));
            order.setPriceTotal(resultSet.getDouble("PRICE_TOTAL"));
            order.setMenuId(resultSet.getInt("MENU_ID"));
//            order.setOrderTime();
            order.setConfirm(resultSet.getByte("CONFIRM"));
            order.setPaid(resultSet.getByte("PAID"));
            order.setUserId(resultSet.getInt("USER_ID"));
            order.setTableId(resultSet.getInt("TABLE_ID"));


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order getByOrderTime(Timestamp orderTime) {
        return null;
    }

    @Override
    public Order getByConfirm(Byte confirm) {
        String query = "SELECT id, price_total, menu_id, order_time, confirm, paid, user_id, table_id FROM order confirm=?";
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getId());
            ResultSet resultSet = preparedStatement.executeQuery(query);

            order.setId(resultSet.getInt("ID"));
            order.setPriceTotal(resultSet.getDouble("PRICE_TOTAL"));
            order.setMenuId(resultSet.getInt("MENU_ID"));
//            order.setOrderTime();
            order.setConfirm(resultSet.getByte("CONFIRM"));
            order.setPaid(resultSet.getByte("PAID"));
            order.setUserId(resultSet.getInt("USER_ID"));
            order.setTableId(resultSet.getInt("TABLE_ID"));


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order getByPaid(Byte paid) {
        String query = "SELECT id, price_total, menu_id, order_time, confirm, paid, user_id, table_id FROM order paid=?";
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getId());
            ResultSet resultSet = preparedStatement.executeQuery(query);

            order.setId(resultSet.getInt("ID"));
            order.setPriceTotal(resultSet.getDouble("PRICE_TOTAL"));
            order.setMenuId(resultSet.getInt("MENU_ID"));
//            order.setOrderTime();
            order.setConfirm(resultSet.getByte("CONFIRM"));
            order.setPaid(resultSet.getByte("PAID"));
            order.setUserId(resultSet.getInt("USER_ID"));
            order.setTableId(resultSet.getInt("TABLE_ID"));


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order getByUserId(Integer userId) {
        String query = "SELECT id, price_total, menu_id, order_time, confirm, paid, user_id, table_id FROM order user_id=?";
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getId());
            ResultSet resultSet = preparedStatement.executeQuery(query);

            order.setId(resultSet.getInt("ID"));
            order.setPriceTotal(resultSet.getDouble("PRICE_TOTAL"));
            order.setMenuId(resultSet.getInt("MENU_ID"));
//            order.setOrderTime();
            order.setConfirm(resultSet.getByte("CONFIRM"));
            order.setPaid(resultSet.getByte("PAID"));
            order.setUserId(resultSet.getInt("USER_ID"));
            order.setTableId(resultSet.getInt("TABLE_ID"));


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order getByTable(Integer tableId) {
        String query = "SELECT id, price_total, menu_id, order_time, confirm, paid, user_id, table_id FROM order table_id=?";
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getId());
            ResultSet resultSet = preparedStatement.executeQuery(query);

            order.setId(resultSet.getInt("ID"));
            order.setPriceTotal(resultSet.getDouble("PRICE_TOTAL"));
            order.setMenuId(resultSet.getInt("MENU_ID"));
//            order.setOrderTime();
            order.setConfirm(resultSet.getByte("CONFIRM"));
            order.setPaid(resultSet.getByte("PAID"));
            order.setUserId(resultSet.getInt("USER_ID"));
            order.setTableId(resultSet.getInt("TABLE_ID"));


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void update(Order order) {
        String query = "UPDATE order SET price_total=?, menu_id=?, order_time=?, confirm=?, paid=?, user_id=?, table_id=? WHERE ID=?,";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, order.getPriceTotal());
            preparedStatement.setInt(2, order.getMenuId());
//            preparedStatement.setDate(3);
            preparedStatement.setByte(4, order.getConfirm());
            preparedStatement.setByte(5, order.getPaid());
            preparedStatement.setInt(6, order.getUserId());
            preparedStatement.setInt(7, order.getTableId());
            preparedStatement.setInt(8, order.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Order order) {
        String query = "DELET FROM order WHERE ID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
