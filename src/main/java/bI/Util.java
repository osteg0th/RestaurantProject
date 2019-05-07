package bI;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    //    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
//    private static final String DB_USERNAME = "root";
//    private static final String DB_PASSWORD = "root";
//TODO fix timezone error
    public Connection getConnection()   {
        Connection connection = null;
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            Class.forName(property.getProperty("db.driver"));   //what is this?
            connection = DriverManager.getConnection(property.getProperty("db.host"),
                    property.getProperty("db.login"), property.getProperty("db.password"));
            System.out.println("Connection OK");
        } catch (ClassNotFoundException | IOException | SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return connection;
    }
}
