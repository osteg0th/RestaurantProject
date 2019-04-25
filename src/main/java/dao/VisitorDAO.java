package dao;

import dao.entities.Visitor;

import java.util.List;

public interface VisitorDAO {
    //create
    void create(Visitor visitor);
    //read
    List<Visitor> getAll();
    Visitor getById(Integer id);
    Visitor getByName(String name);
    //update
    void update(Visitor visuor);
    //delete
    void remove(Visitor visuor);

}
