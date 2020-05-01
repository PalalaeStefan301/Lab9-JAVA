/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Palalae
 */
public class Database {

    static Database instance = null;
    private static final String URL = "jdbc:mysql://localhost:3306/musicalbums";
    private static final String USER = "dba";
    private static final String PASSWORD = "sql";
    private static Connection connection = null;

    private Database() {
    }

    static public Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
        }

        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
