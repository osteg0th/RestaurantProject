import entities.Role;
import entities.Table;
import org.apache.log4j.Logger;
import service.DishService;
import service.RoleService;
import service.TableService;

public class Domain {
    private static final Logger log = Logger.getLogger(Domain.class);
    public static void main(String[] args) {

        RoleService roleService = new RoleService();
        TableService tableService = new TableService();
        DishService dishService = new DishService();

        Role role = new Role();
        role.setAccess("test");
        roleService.create(role);
        System.out.println(roleService.getById(1));
        System.out.println(roleService.getById(10));

        Table table = new Table();
        table.setId(1);
        table.setStatus(1);

        tableService.create(table);
        System.out.println(tableService.getById(1));
        System.out.println(tableService.getById(2));

        System.out.println("end");
    }
}
