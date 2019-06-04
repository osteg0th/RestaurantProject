package controllers;

import bl.Command;

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

    public void create() {
        create.execute();
    }

    public void delete() {
        delete.execute();
    }

    public void setGetLogin() {
        getLogin.execute();
    }

    public void update() {
        update.execute();
    }

    public void getAll() {
        getAll.execute();
    }
}
