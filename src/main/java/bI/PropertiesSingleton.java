package bI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesSingleton {
    private Properties properties;

    private PropertiesSingleton() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            this.properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final PropertiesSingleton PROPERTIES_SINGLETON = new PropertiesSingleton();

    public Properties getProperties() {
        return properties;
    }

//    private static class SingletonHolder {
//        public static final PropertiesSingleton HOLDER_INSTANCE = new PropertiesSingleton();
//    }
//
//    public static PropertiesSingleton getInstance() {
//        return SingletonHolder.HOLDER_INSTANCE;
//    }
}
