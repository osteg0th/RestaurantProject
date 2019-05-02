package dao;

import entities.Role;

import java.util.List;

public interface RoleDAO {
    //create
    void crate(Role role);
    //read
    List<Role> getAll();
    Role getById(Integer id);
    Role getByAccess(String access);
    //update
    void update(Role role);
    //delete
    void remove(Role role);
}
