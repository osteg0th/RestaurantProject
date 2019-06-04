package dao;

import entities.Table;

import java.util.List;

public interface TableDAO {
    //create
    void create(Table table);
    //read
    List<Table> getAll();
    Table getById(Integer id);

    Table getByStatus(Integer status);
    //update
    void update(Table table);
    //delete
    void delete(Integer id);
}
