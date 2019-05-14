package dao;

import entities.Order;

import java.util.List;

public interface OrderDAO {
    //create
    void create(Order order);
    //read
    List<Order> getAll();
    Order getById(Integer id);
    Order getByTotalPrice(Double priceTotal);
    Order getByMenuId(Integer menuId);
    Order getByConfirm(Byte confirm);
    Order getByPaid(Byte paid);
    Order getByUserId(Integer userId);
    Order getByTable(Integer tableId);
    //update
    void update(Order order);
    //delete
    void remove(Order order);

}
