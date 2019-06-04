package controllers.RoleCommands;

import bl.Command;
import entities.Role;

public class DeleteRoleCommand extends RoleCommand implements Command {
    public DeleteRoleCommand(Role role) {
        this.role = role;
    }

    @Override
    public void execute() {
        roleService.delete(role);
    }
}
