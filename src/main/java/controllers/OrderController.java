package controllers;

import bl.Command;

public class OrderController {
    Command create;
    Command delete;
    Command getAll;
    Command getByTable;
    Command update;

    public OrderController(Command create, Command delete, Command getAll, Command getByTable, Command update) {
        this.create = create;
        this.delete = delete;
        this.getAll = getAll;
        this.getByTable = getByTable;
        this.update = update;
    }

    public void create() {
        create.execute();
    }

    public void delete() {
        delete.execute();
    }

    public void getAll() {
        getAll.execute();
    }

    public void getByTable() {
        getByTable.execute();
    }

    public void update() {
        update.execute();
    }
}
