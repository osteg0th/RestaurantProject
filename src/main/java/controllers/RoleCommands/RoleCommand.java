package controllers.RoleCommands;

import entities.Role;
import service.RoleService;

public abstract class RoleCommand {
    Role role;
    RoleService roleService = new RoleService();
}
