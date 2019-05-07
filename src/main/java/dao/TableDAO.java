package dao;

import entities.Table;

import java.util.List;

public interface TableDAO {
    //create
    void create(Table table);
    //read
    List<Table> getAll();
    Table getById(Integer id);

    Table getByStatus(Byte status);
    //update
    void update(Table table);
    //delete
    void remove(Table table);
}
