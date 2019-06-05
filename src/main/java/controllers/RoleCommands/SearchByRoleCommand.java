package controllers.RoleCommands;

import bl.Command;
import entities.Role;

import java.util.List;

public class SearchByRoleCommand extends RoleCommand implements Command<List<Role>> {
    String access;

    public SearchByRoleCommand(String access) {
        this.access = access;
    }

    @Override
    public List<Role> execute() {
        return roleService.getByAccess(access);
    }
}
