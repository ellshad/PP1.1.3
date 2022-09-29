package jm.task.core.jdbc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    public static Connection getConnection(){
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream("src/main/resources/database.properties")){
            properties.load(in);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
