package dao;

import entities.User;

import java.util.List;

public interface UserDAO {
    //create
    void create(User user);
    //read
    List<User> getAll();
    User getById(Integer id);
    User getByName(String name);
    User getBySurname(String surname);
    User getByRole(Integer role);

    User getLogin(String email, String password);
    //update
    void update(User user);
    //delete
    void delete(Integer id);

}
