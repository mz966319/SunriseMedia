/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mbaiu
 */

public class dbConnection {

    private static final String SQCONN = "jdbc:sqlite:sunrise.sqlite";
//    private static final String SQCONN = "jdbc:sqlite:app/sunrise.sqlite";

    public static Connection getConnection() throws SQLException {

        try{
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQCONN);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}