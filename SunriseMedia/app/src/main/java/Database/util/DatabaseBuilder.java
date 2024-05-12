/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.util;

import Books.windows.MainBooksWindow;
import boooks.objects.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mbaiu
 */
public class DatabaseBuilder {
    private static Connection connection;
    
    
    public static void createAllTables(){
        connectdbTables();
        try {
            createStudentsTable();
            createBooksTable();
            createUsersTable();
            createSalesTable();
            createInventoryTable();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void connectdbTables() {
        try {
            DatabaseBuilder.connection = dbConnection.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (DatabaseBuilder.connection == null){
            System.exit(1);
        }
    }
    
    public static void createStudentsTable() throws SQLException {
        String sql = "CREATE TABLE students(" +
                "id String KEY NOT NULL," +
                "phone_number STRING);";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='students'");
        if(!resultSet.next()){
            System.out.println("Building the books table");
            Statement createTableStatement=connection.createStatement();
            createTableStatement.execute(sql);
            createTableStatement.close();
        }
        statement.close();
        resultSet.close();
    }
    
    public static void createBooksTable() throws SQLException {
        String sql = "CREATE TABLE books(" +
                "id String KEY NOT NULL," +
                "title TEXT," +
                "grade STRING," +
                "subject STRING," +
                "qty INTEGER," +
                "cost DOUBLE," +
                "cost_discount_rate DOUBLE," +
                "total_qty INTEGER," +
                "profit_rate DOUBLE);";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='books'");
        if(!resultSet.next()){
            System.out.println("Building the books table");
            Statement createTableStatement=connection.createStatement();
            createTableStatement.execute(sql);
            createTableStatement.close();
        }
        statement.close();
        resultSet.close();
    }
    public static void createInventoryTable() throws SQLException {
        String sql = "CREATE TABLE inventory(" +
                "id STRING PRIMARY KEY," +
                "book_id BIGINT REFERENCES books (id)," +
                "rcv_qty INTEGER," +
                "time STRING," +
                "employee_id STRING REFERENCES users (id)," +
                "rcv_index INTEGER);";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='inventory'");
        if(!resultSet.next()){
            System.out.println("Building the inventory table");
            Statement createTableStatement=connection.createStatement();
            createTableStatement.execute(sql);
            createTableStatement.close();
        }
        statement.close();
        resultSet.close();
    }
    public static void createSalesTable() throws SQLException {
        String sql = "CREATE TABLE sales(" +
                "id STRING PRIMARY KEY," +
                "purchase_id STRING," +
                "invoice_id STRING," +
                "time STRING," +
                "employee_id STRING," +
                "book_id STRING REFERENCES books (id)," +
                "price DOUBLE," +
                "qty INTEGER);";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='sales'");
        if(!resultSet.next()){
            System.out.println("Building the sales table");
            Statement createTableStatement=connection.createStatement();
            createTableStatement.execute(sql);
            createTableStatement.close();
        }
        statement.close();
        resultSet.close();
    }
    public static void createUsersTable() throws SQLException {
        String sql = "CREATE TABLE users(" +
                "id               STRING  PRIMARY KEY," +
                "name             STRING," +
                "password         STRING," +
                "access_books     BOOLEAN," +
                "access_sales     BOOLEAN," +
                "access_users     BOOLEAN," +
                "access_inventory     BOOLEAN," +
                "added_by         STRING);";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='users'");
        if(!resultSet.next()){
            System.out.println("Building the users table");
            Statement createTableStatement=connection.createStatement();
            createTableStatement.execute(sql);
            createTableStatement.close();
            DatabaseHelper.addUser(new User(MainBooksWindow.xUser, MainBooksWindow.xUser, MainBooksWindow.xPass, "Mo", true, true, true, true, true));
        }
        statement.close();
        resultSet.close();
        
        
    }
    
}
