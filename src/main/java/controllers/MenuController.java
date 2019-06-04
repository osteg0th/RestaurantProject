package controllers;

import bl.Command;

public class MenuController {
    Command create;
    Command delete;
    Command getAll;
    Command getById;
    Command update;

    public MenuController(Command create, Command delete, Command getAll, Command getById, Command update) {
        this.create = create;
        this.delete = delete;
        this.getAll = getAll;
        this.getById = getById;
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

    public void getById() {
        getById.execute();
    }

    public void update() {
        update.execute();
    }
}
