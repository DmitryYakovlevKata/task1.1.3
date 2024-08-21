package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "rootroot";

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
