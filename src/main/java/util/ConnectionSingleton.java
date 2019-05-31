package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionSingleton {

    private Connection connection;

    private ConnectionSingleton() {
        Properties properties = PropertiesSingleton.PROPERTIES_SINGLETON.getProperties();

        try {
            Class.forName(properties.getProperty("db.driver"));   //what is this?
            this.connection = DriverManager.getConnection(properties.getProperty("db.host"),
                    properties.getProperty("db.login"), properties.getProperty("db.password"));
            System.out.println("Connection OK");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private static class SingletonHolder {
        static final ConnectionSingleton HOLDER_INSTANCE = new ConnectionSingleton();
    }

    public static ConnectionSingleton getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
