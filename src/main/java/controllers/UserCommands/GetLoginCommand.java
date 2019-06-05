package controllers.UserCommands;

import bl.Command;
import entities.User;

public class GetLoginCommand extends UserCommand implements Command<User> {

    public GetLoginCommand(User user) {
        this.user = user;
    }

    @Override
    public User execute() {
        return userService.getLogin(user.getEmail(), user.getPassword());
    }
}
