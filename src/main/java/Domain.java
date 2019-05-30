import bI.Util;
import entities.Dish;
import org.apache.log4j.Logger;
import service.DishService;
import service.RoleService;
import service.TableService;

public class Domain {
    private static final Logger log = Logger.getLogger(Domain.class);
    public static void main(String[] args) {

        Util util = new Util();
        util.getConnection();
        RoleService roleService = new RoleService();
        TableService tableService = new TableService();
        DishService dishService = new DishService();

        Dish dish = new Dish();
        dish.setName("1");
        dish.setPrice(1.);
        dish.setType("1");
        dish.setWeight(1.);

        dishService.create(dish);
        System.out.println(dishService.getById(1));



        System.out.println("end");
    }
}
