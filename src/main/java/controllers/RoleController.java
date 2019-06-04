package controllers;

import bl.Command;

public class RoleController {
    Command create;
    Command delete;
    Command viewAll;
    Command searchByAccess;

    public RoleController(Command create, Command delete, Command viewAll, Command searchByAccess) {
        this.create = create;
        this.delete = delete;
        this.viewAll = viewAll;
        this.searchByAccess = searchByAccess;
    }

    public void createRole() {
        create.execute();
    }

    public void deleteRole() {
        delete.execute();
    }

    public void viewAll() {
        viewAll.execute();
    }

    public void searchByAccess() {
        searchByAccess.execute();
    }
}
