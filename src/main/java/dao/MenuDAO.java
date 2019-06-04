package dao;

import entities.Menu;

import java.util.List;

public interface MenuDAO {
    //create
    void create(Menu menu);
    //read
    List<Menu> getAll();
    Menu getById(Integer id);
    //update
    void update(Menu menu);
    //delete
    void delete(Integer id);

}

