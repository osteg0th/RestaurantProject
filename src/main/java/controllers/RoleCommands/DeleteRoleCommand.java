package controllers.RoleCommands;

import bl.Command;
import entities.Role;

public class DeleteRoleCommand extends RoleCommand implements Command<Void> {
    public DeleteRoleCommand(Role role) {
        this.role = role;
    }

    @Override
    public Void execute() {
        roleService.delete(role);
        return null;
    }
}
