package controllers.RoleCommands;

import bl.Command;

public class ViewAllRole extends RoleCommand implements Command {
    public ViewAllRole() {
    }

    @Override
    public void execute() {
        System.out.println(roleService.getAll());   //TODO rewrite test output
    }
}
