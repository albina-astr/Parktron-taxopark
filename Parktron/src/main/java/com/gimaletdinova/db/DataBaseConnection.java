package com.gimaletdinova.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:h2:mem:Parktron://http://localhost:8080/h2-console/";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found");
            ex.printStackTrace();
            System.exit(1);
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Connection failed! Check output console!");
            ex.printStackTrace();
            System.exit(2);
        }

        if (connection != null) {
            System.out.println("Connection success");
            return connection;
        } else {
            System.out.println("Connection failed!");
            return null;
        }
    }
}
