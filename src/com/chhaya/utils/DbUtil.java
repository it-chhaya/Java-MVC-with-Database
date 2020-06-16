package com.chhaya.utils;

import sun.security.util.Password;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static Connection con;

    private final static String URL = "jdbc:postgresql://localhost:5432/stock_ms";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "qwer";

    static {
        try {
            // Load driver
            Class.forName("org.postgresql.Driver");
            // Instantiate connection object
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        return con;
    }

}
