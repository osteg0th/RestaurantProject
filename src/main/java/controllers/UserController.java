package controllers;

import bl.Command;
import entities.User;

public class UserController {
    Command create;
    Command delete;
    Command getLogin;
    Command update;
    Command getAll;

    public UserController(Command create, Command delete, Command getLogin, Command update, Command getAll) {
        this.create = create;
        this.delete = delete;
        this.getLogin = getLogin;
        this.update = update;
        this.getAll = getAll;
    }

    public UserController(Command getLogin) {
        this.getLogin = getLogin;
    }

    public void create() {
        create.execute();
    }

    public void delete() {
        delete.execute();
    }

    public User getLogin() {
        return (User) getLogin.execute();
    }

    public void update() {
        update.execute();
    }

    public void getAll() {
        getAll.execute();
    }
}
