package controllers;

import bl.Command;

public class TableController {
    Command create;
    Command delete;
    Command viewAll;
    Command setStatus;

    public TableController(Command create, Command delete, Command viewAll, Command setStatus) {
        this.create = create;
        this.delete = delete;
        this.viewAll = viewAll;
        this.setStatus = setStatus;
    }

    public void createTable() {
        create.execute();
    }

    public void deleteTable() {
        delete.execute();
    }

    public void viewAll() {
        viewAll.execute();
    }

    public void setStatus() {
        setStatus.execute();
    }
}
