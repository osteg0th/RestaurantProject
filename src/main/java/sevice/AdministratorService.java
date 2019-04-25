package sevice;

import bI.Util;
import dao.AdministratorDAO;
import dao.entities.Administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdministratorService extends Util implements AdministratorDAO {
    private Connection connection = getConnection();
    @Override
    public void create(Administrator administrator) {       //rewrite with try-with-resources
        PreparedStatement preparedStatement = null; //what is this?
        String query = "INSERT INTO ADMINISTRATOR (ID, NAME, SURNAME, EMAIL, PASSWORD) VALUES (?,?,?,?,?)";

       try {
           preparedStatement = connection.prepareStatement(query);
           preparedStatement.setInt(1, administrator.getId());
           preparedStatement.setString(2,administrator.getName());
           preparedStatement.setString(3,administrator.getSurname());
           preparedStatement.setString(4,administrator.getEmail());
           preparedStatement.setString(5,administrator.getPassword());
       } catch (SQLException e) {
           e.printStackTrace();
       }
       finally {
           if(preparedStatement != null)
           {
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           if(connection != null) {
               try {
                   connection.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
       }
    }

    @Override
    public List<Administrator> getAll() {
        return null;
    }

    @Override
    public Administrator getById(Integer id) {
        return null;
    }

    @Override
    public Administrator getByName(String name) {
        return null;
    }

    @Override
    public Administrator getBySurname(String surname) {
        return null;
    }

    @Override
    public Administrator getByEmail(String email) {
        return null;
    }

    @Override
    public Administrator getByPassword(String password) {
        return null;
    }

    @Override
    public void update(Administrator administrator) {

    }

    @Override
    public void remove(Administrator administrator) {

    }
}
