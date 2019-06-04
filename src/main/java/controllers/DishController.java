package controllers;

import bl.Command;

public class DishController {
    Command create;
    Command delete;
    Command getAll;
    Command getById;
    Command getByType;

    public DishController(Command create, Command delete, Command getAll, Command getById, Command getByType) {
        this.create = create;
        this.delete = delete;
        this.getAll = getAll;
        this.getById = getById;
        this.getByType = getByType;
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

    public void getByType() {
        getByType.execute();
    }
}
