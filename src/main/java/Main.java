import controllers.UserCommands.GetLoginCommand;
import controllers.UserController;
import entities.User;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
//        Role role = new Role();
//        role.setAccess("Command test2");
//        RoleService roleService;
////        roleService.create();
//        role.setId(21);
//        RoleController r = new RoleController(new CreateRoleCommand(role), new DeleteRoleCommand(role), new ViewAllRole(), new SearchByRoleCommand("Test"));
////        r.viewAll();
//        r.searchByAccess();

        User user = new User();
        user.setEmail("123");
        user.setPassword("3221");
        user.setRole_id(2);
        UserService userService = new UserService();
//        userService.create(user);
        UserController ur = new UserController(new GetLoginCommand(user));
//        ur.getLogin();
        if (ur.getLogin() == null) {
            System.out.println("null");
        }
        System.out.println("end");
    }
}
