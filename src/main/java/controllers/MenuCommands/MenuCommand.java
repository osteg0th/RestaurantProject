package controllers.MenuCommands;

import entities.Menu;
import service.MenuService;

public abstract class MenuCommand {
    Menu menu;
    MenuService menuService = new MenuService();
}
