/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.util;
import boooks.objects.Book;
import boooks.objects.Inventory;
import boooks.objects.SaleItem;
import boooks.objects.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mbaiu
 */
public class DatabaseHelper {
    private static Connection connection;

    public static void connectdbTables() {
        try {
            DatabaseHelper.connection = dbConnection.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (DatabaseHelper.connection == null){
            System.exit(1);
        }
    }

    
//     Books
    
    public static void addBook(Book book){
        try {
            privateAddBook(book);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void privateAddBook(Book book) throws SQLException{
        connectdbTables();
        
        
        String insertSQL = "INSERT INTO books (id,title,grade,subject,qty,cost,cost_discount_rate,profit_rate,total_qty) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setString(1,book.getId());
        preparedStatement.setString(2, book.getTitle());
        preparedStatement.setString(3, book.getGrade());
        preparedStatement.setString(4, book.getSubject());
        preparedStatement.setInt(5, book.getQty());
        preparedStatement.setDouble(6, book.getCost());
        preparedStatement.setDouble(7, book.getCostDiscountRate());
        preparedStatement.setDouble(8, book.getProfitRate());
        preparedStatement.setInt(9, book.getTotalQty());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public static void updateBook(Book book){
        try {
            privatUpdateBook(book);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void privatUpdateBook(Book book) throws SQLException{
        connectdbTables();
        
        String updateSQL = "UPDATE books SET title = ?, grade = ?, subject = ?, cost = ?, cost_discount_rate = ?,profit_rate = ? WHERE id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getGrade());
        preparedStatement.setString(3, book.getSubject());
        preparedStatement.setDouble(4,  book.getCost());
        preparedStatement.setDouble(5,  book.getCostDiscountRate());
        preparedStatement.setDouble(6,  book.getProfitRate());
        preparedStatement.setString(7,book.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public static void updateBookQty(Book book){
        try {
            privatUpdateBookQty(book);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void privatUpdateBookQty(Book book) throws SQLException{
        connectdbTables();
        
        String updateSQL = "UPDATE books SET qty = ? WHERE id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
        preparedStatement.setInt(1, book.getQty());
        preparedStatement.setString(2,book.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    
//    Invantory
    public static void addInventory(Inventory inventory){
        try {
            privateAddInventory(inventory);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void privateAddInventory(Inventory inventory) throws SQLException{
        connectdbTables();
        
        
        String insertSQL = "INSERT INTO inventory (id, book_id, rcv_qty, time, employee_id, rcv_index) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setString(1,inventory.getId());
        preparedStatement.setString(2, inventory.getBookID());
        preparedStatement.setInt(3, inventory.getRcvQty());
        preparedStatement.setString(4, inventory.getTime());
        preparedStatement.setString(5, inventory.getEmployeeID());
        preparedStatement.setInt(6, inventory.getRcvIndex());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    
    
    // Sales
    
    public static void addSaleItem(SaleItem saleItem){
        try {
            privateAddSaleItem(saleItem);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void privateAddSaleItem(SaleItem saleItem) throws SQLException{
        connectdbTables();
        
        
        String insertSQL = "INSERT INTO sales (id, purchase_id, invoice_id, time, employee_id, book_id,price,qty) VALUES (?, ?, ?, ?, ?, ?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setString(1,saleItem.getId());
        preparedStatement.setString(2, saleItem.getPurchaseID());
        preparedStatement.setString(3, saleItem.getInvoiceID());
        preparedStatement.setString(4, saleItem.getTime());
        preparedStatement.setString(5, saleItem.getEmployeeID());
        preparedStatement.setString(6, saleItem.getBookID());
        preparedStatement.setDouble(7, saleItem.getPrice());
        preparedStatement.setInt(8, saleItem.getQty());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    
    
    //Users
    
    public static void addUser(User user){
        try {
            privateAddUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void privateAddUser(User user) throws SQLException{
        connectdbTables();
        
        
        String insertSQL = "INSERT INTO users (id,password,access_books,access_sales,access_users,access_inventory,name,added_by) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setString(1,user.getId());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setBoolean(3, user.isAccessBooks());
        preparedStatement.setBoolean(4, user.isAccessSales());
        preparedStatement.setBoolean(5, user.isAccessUsers());
        preparedStatement.setBoolean(6, user.isAccessInventory());
        preparedStatement.setBoolean(6, user.isAccessInventory());
        preparedStatement.setString(7, user.getName());
        preparedStatement.setString(8, user.getAddedBy());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public static void updateUser(User user){
        try {
            privatUpdateUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void privatUpdateUser(User user) throws SQLException{
        connectdbTables();
        
        String updateSQL = "UPDATE users SET access_books = ?,access_sales = ?,access_users = ?,access_inventory = ? WHERE id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
        preparedStatement.setBoolean(1, user.isAccessBooks());
        preparedStatement.setBoolean(2, user.isAccessSales());
        preparedStatement.setBoolean(3, user.isAccessUsers());
        preparedStatement.setBoolean(4, user.isAccessInventory());
        preparedStatement.setString(5,user.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    
    
}