package dao;

import entities.Role;

import java.util.List;

public interface RoleDAO {
    //create
    void create(Role role); //throws SQLException is needed?
    //read
    List<Role> getAll();
    Role getById(Integer id);
    Role getByAccess(String access);
    //update
    void update(Role role);
    //delete
    void remove(Integer id);
}
