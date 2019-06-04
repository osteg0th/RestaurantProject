package controllers.OrderCommands;

import entities.Order;
import service.OrderService;

public abstract class OrderCommand {
    Order order;
    OrderService orderService = new OrderService();
}
