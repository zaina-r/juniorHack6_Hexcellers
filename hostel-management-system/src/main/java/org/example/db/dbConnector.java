package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnector {
    private final static String URL = "jdbc:mysql://localhost:3306/hms";
    private final static String user = "root";
    private final static String password = "98765";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }
}
