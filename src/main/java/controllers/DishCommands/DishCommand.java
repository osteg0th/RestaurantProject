package controllers.DishCommands;

import entities.Dish;
import service.DishService;

public abstract class DishCommand {
    Dish dish;
    DishService dishService = new DishService();
}
