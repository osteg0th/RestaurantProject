package dao;

import dao.entities.Dish;

import java.util.List;

public interface DishDAO {
    //create
    void create(Dish dish);
    //read
    List<Dish> getAll();
    Dish getById(Integer id);
    Dish getByName(String name);
    Dish getByType(String type);
    Dish getByPrice(Float price);
    //update
    void update(Dish dish);
    //delete
    void remove(Dish dish);

}
