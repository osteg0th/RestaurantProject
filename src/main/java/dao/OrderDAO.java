package dao;

import entities.Order;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDAO {
    //create
    void create(Order order);
    //read
    List<Order> getAll();
    Order getById(Integer id);
    Order getByTotalPrice(Double priceTotal);
    Order getByMenuId(Integer menuId);
    Order getByOrderTime(Timestamp orderTime);
    Order getByConfirm(Boolean confirm);
    Order getByPaid(Boolean paid);
    Order getByUserId(Integer userId);
    Order getByTable(Integer tableId);
    //update
    void update(Order order);
    //delete
    void remove(Order order);

}
