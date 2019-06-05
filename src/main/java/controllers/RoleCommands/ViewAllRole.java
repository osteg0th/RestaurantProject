package controllers.RoleCommands;

import bl.Command;
import entities.Role;

import java.util.List;

public class ViewAllRole extends RoleCommand implements Command<List<Role>> {
    public ViewAllRole() {
    }

    @Override
    public List<Role> execute() {
        return roleService.getAll();
    }
}
