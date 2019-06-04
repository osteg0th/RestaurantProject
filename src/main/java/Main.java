import controllers.RoleCommands.CreateRoleCommand;
import controllers.RoleCommands.DeleteRoleCommand;
import controllers.RoleCommands.SearchByRoleCommand;
import controllers.RoleCommands.ViewAllRole;
import controllers.RoleController;
import entities.Role;
import service.RoleService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Role role = new Role();
        role.setAccess("Command test2");
        RoleService roleService;
//        roleService.create();
        role.setId(21);
        RoleController r = new RoleController(new CreateRoleCommand(role), new DeleteRoleCommand(role), new ViewAllRole(), new SearchByRoleCommand("Test"));
//        r.viewAll();
        r.searchByAccess();
    }
}
