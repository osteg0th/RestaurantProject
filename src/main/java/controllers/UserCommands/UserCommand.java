package controllers.UserCommands;

import entities.User;
import service.UserService;

public abstract class UserCommand {
    User user;
    UserService userService = new UserService();
}
