import bI.Util;
import org.apache.log4j.Logger;
import service.MenuService;
import service.RoleService;
import service.TableService;

public class Domain {
    private static final Logger log = Logger.getLogger(Domain.class);
    public static void main(String[] args) {

        Util util = new Util();
        util.getConnection();
        RoleService roleService = new RoleService();
        TableService tableService = new TableService();
        MenuService menuService = new MenuService();
//
//        Menu menu = new Menu();
//        menu.setId(1);
//        menu.setDishId(1);
//        menuService.create(menu);

//        Role role = new Role();
//        log.info("role added");
//        role.setId(3);
//        log.info("Id set");
//        role.setAccess("test3");
//        log.info("access set");
//        Table table = new Table();
//        table.setId(1);
//        table.setStatus((byte) 1);
//
//        roleService.create(role);
        log.info("role created");
        roleService.getById(3);
        tableService.getById(1);
        menuService.getById(1);
        roleService.getAll();
        System.out.println(roleService.getAll());
        log.info("id search");

        System.out.println("end");
    }
}
