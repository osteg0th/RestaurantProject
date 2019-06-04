package controllers.RoleCommands;

import bl.Command;

public class SearchByRoleCommand extends RoleCommand implements Command {
    String access;

    public SearchByRoleCommand(String access) {
        this.access = access;
    }

    @Override
    public void execute() {
        System.out.println(roleService.getByAccess(access));
    }
}
