package controllers.RoleCommands;

import bl.Command;
import entities.Role;

public class CreateRoleCommand extends RoleCommand implements Command {
    public CreateRoleCommand(Role role) {
        this.role = role;
    }

    @Override
    public void execute() {
        roleService.create(role);
    }
}
