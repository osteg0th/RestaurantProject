import bI.Util;
import entities.*;
import org.apache.log4j.Logger;
import service.*;

public class Domain {
    private static final Logger log = Logger.getLogger(Domain.class);
    public static void main(String[] args) {

        Util util = new Util();
        util.getConnection();
        DishService dishService = new DishService();
        RoleService roleService = new RoleService();
        TableService tableService = new TableService();
        MenuService menuService = new MenuService();
        OrderService orderService = new OrderService();
        UserService userService = new UserService();

        Dish dish = new Dish();
        dish.setId(1);
        dish.setWeight(460.0);
        dish.setType("food");
        dish.setPrice(60.0);
        dish.setName("pizza");

        Role role = new Role();
        role.setId(1);
        role.setAccess("Administrator");

        Table table = new Table();
        table.setId(1);
        table.setStatus(0);

        Menu menu = new Menu();
        menu.setId(1);
        menu.setDishId(1);

        User user = new User();
        user.setId(1);
        user.setRole_id(1);
        user.setName("Alpha");
        user.setSurname("Beta");

//        Order order = new Order.Builder().setId(1).setMenuId(1).setConfirm(0).setPaid(0).setPriceTotal(460.0).setTableId(1).setUserId(1).build();

        dishService.create(dish);
        System.out.println(dishService.getById(1));

        roleService.create(role);
        System.out.println(roleService.getById(1));


        menuService.create(menu);
        System.out.println(menuService.getById(1));

        userService.create(user);
        System.out.println(userService.getById(1));

//        tableService.create(table);
//        tableService.getById(1);

//        orderService.create(order);
//        orderService.getById(1);

        System.out.println("end");
    }
}
