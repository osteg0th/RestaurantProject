package controllers.RoleCommands;

import bl.Command;
import entities.Role;

public class CreateRoleCommand extends RoleCommand implements Command<Void> {
    public CreateRoleCommand(Role role) {
        this.role = role;
    }

    @Override
    public Void execute() {
        roleService.create(role);
        return null;
    }
}
