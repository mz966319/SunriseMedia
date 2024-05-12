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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mbaiu
 */
public class SearchHelper {
    private static Connection connection;

    public static void connectdbTables() {
        try {
            SearchHelper.connection = dbConnection.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (SearchHelper.connection == null){
            System.exit(1);
        }
    }

    public static ResultSet getLoginTable(String user, String pass, String opt) throws Exception{
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM login WHERE username = ? AND password = ? AND division = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,pass);
            preparedStatement.setString(3,opt);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            //System.out.println("DatabseTable0: "+resultSet.next());
            return resultSet;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        finally {
            //mSystem.out.println("DatabseTable: "+resultSet.next());
            preparedStatement.close();
            resultSet.close();
        }
    }
    
    
    // ====== Book =======
    public static ArrayList<Book> getBooks(){
        try {
            return PrivategetBooks();
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private static ArrayList<Book> PrivategetBooks() throws Exception{
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM books";

        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<Book> list = new ArrayList<>();
            
            while(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getString("id"));
                book.setTitle(resultSet.getString("title"));
                book.setGrade(resultSet.getString("grade"));
                book.setSubject(resultSet.getString("subject"));
                book.setQty(resultSet.getInt("qty"));
                book.setCost(resultSet.getDouble("cost"));
                book.setCostDiscountRate(resultSet.getDouble("cost_discount_rate"));
                book.setProfitRate(resultSet.getDouble("profit_rate"));
                
                list.add(book);
            }
            
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    public static Book getBookByID(String id){
        try {
            return privateGetBookByID(id);
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private static Book privateGetBookByID(String id) throws Exception{
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM books where id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<Book> list = new ArrayList<>();
            
            while(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getString("id"));
                book.setTitle(resultSet.getString("title"));
                book.setGrade(resultSet.getString("grade"));
                book.setSubject(resultSet.getString("subject"));
                book.setQty(resultSet.getInt("qty"));
                book.setCost(resultSet.getDouble("cost"));
                book.setCostDiscountRate(resultSet.getDouble("cost_discount_rate"));
                book.setProfitRate(resultSet.getDouble("profit_rate"));
                
                list.add(book);
            }
            try {
                return list.get(0);
            } catch (Exception e) {
                return null;
            }
                
            
            

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    public static Book getBookByTitle(String title){
        try {
            return privateGetBookByTitle(title);
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private static Book privateGetBookByTitle(String title) throws Exception{
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM books where title=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,title);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<Book> list = new ArrayList<>();
            
            while(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getString("id"));
                book.setTitle(resultSet.getString("title"));
                book.setGrade(resultSet.getString("grade"));
                book.setSubject(resultSet.getString("subject"));
                book.setQty(resultSet.getInt("qty"));
                book.setCost(resultSet.getDouble("cost"));
                book.setCostDiscountRate(resultSet.getDouble("cost_discount_rate"));
                book.setProfitRate(resultSet.getDouble("profit_rate"));
                
                list.add(book);
            }
            try {
                return list.get(0);
            } catch (Exception e) {
                return null;
            }
                
            
            

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    
    
    // ==================================================== Inventory =====================================
    
    public static ArrayList<Inventory> getInventories(){
        try {
            return PrivategetInventories();
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private static ArrayList<Inventory> PrivategetInventories() throws Exception{
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM inventory";

        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<Inventory> list = new ArrayList<>();
            
            while(resultSet.next()){
                Inventory inventory = new Inventory();
                inventory.setId(resultSet.getString("id"));
                inventory.setBookID(resultSet.getString("book_id"));
                inventory.setRcvQty(resultSet.getInt("rcv_qty"));
                inventory.setTime(resultSet.getString("time"));
                inventory.setEmployeeID(resultSet.getString("employee_id"));
                inventory.setRcvIndex(resultSet.getInt("rcv_index"));
                
                list.add(inventory);
            }
            
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    
    
    
    public static ArrayList<Inventory> getInventoriesByIndex(int index){
        try {
            return PrivategetInventoriesByIndex(index);
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private static ArrayList<Inventory> PrivategetInventoriesByIndex(int index) throws Exception{
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM inventory WHERE rcv_index=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,index);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<Inventory> list = new ArrayList<>();
            
            while(resultSet.next()){
                Inventory inventory = new Inventory();
                inventory.setId(resultSet.getString("id"));
                inventory.setBookID(resultSet.getString("book_id"));
                inventory.setRcvQty(resultSet.getInt("rcv_qty"));
                inventory.setTime(resultSet.getString("time"));
                inventory.setEmployeeID(resultSet.getString("employee_id"));
                inventory.setRcvIndex(resultSet.getInt("rcv_index"));
                
                list.add(inventory);
            }
            
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    
    
    
     public static int getLastRcvIndex(){
        try {
            return privateGetLastRcvIndex();
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    private static int privateGetLastRcvIndex() throws Exception{
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT MAX(rcv_index) FROM inventory;";

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set            
            if(resultSet.next()){
                return resultSet.getInt(1);  
            }
            return -1;
            

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    
    
    //===================================   Sales   =======================================
    public static ArrayList<SaleItem> getSales(){
        try {
            return PrivateGetSales();
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private static ArrayList<SaleItem> PrivateGetSales() throws Exception{
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM sales ORDER BY time DESC";

        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<SaleItem> list = new ArrayList<>();
            
            while(resultSet.next()){
                SaleItem saleItem = new SaleItem();
                saleItem.setId(resultSet.getString("id"));
                saleItem.setPurchaseID(resultSet.getString("purchase_id"));
                saleItem.setInvoiceID(resultSet.getString("invoice_id"));
                saleItem.setTime(resultSet.getString("time"));
                saleItem.setEmployeeID(resultSet.getString("employee_id"));
                saleItem.setBookID(resultSet.getString("book_id"));
                saleItem.setPrice(resultSet.getDouble("price"));
                saleItem.setQty(resultSet.getInt("qty"));
           
                list.add(saleItem);
            }
            
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    
    
    public static ArrayList<SaleItem> getSalesByEmployeeID(String id){
        try {
            return PrivateGetSalesByEmployeeID(id);
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private static ArrayList<SaleItem> PrivateGetSalesByEmployeeID(String id) throws Exception{
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM sales WHERE employee_id=? ORDER BY time DESC";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<SaleItem> list = new ArrayList<>();
            
            while(resultSet.next()){
                SaleItem saleItem = new SaleItem();
                saleItem.setId(resultSet.getString("id"));
                saleItem.setPurchaseID(resultSet.getString("purchase_id"));
                saleItem.setInvoiceID(resultSet.getString("invoice_id"));
                saleItem.setTime(resultSet.getString("time"));
                saleItem.setEmployeeID(resultSet.getString("employee_id"));
                saleItem.setBookID(resultSet.getString("book_id"));
                saleItem.setPrice(resultSet.getDouble("price"));
                saleItem.setQty(resultSet.getInt("qty"));
           
                list.add(saleItem);
            }
            Collections.sort(list, new Comparator<SaleItem>() {
                @Override
                public int compare(SaleItem s1, SaleItem s2) {
                    return s2.getTime().compareTo(s1.getTime());
                }
            });
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    
    
    
     public static int getLastInvoiceNumber(){
        try {
            return privateGetLastInvoiceNumber();
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    private static int privateGetLastInvoiceNumber() throws Exception{
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT MAX(invoice_id) FROM sales;";

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set            
            if(resultSet.next()){
                return Integer.valueOf(resultSet.getString(1));  
            }
            return 0;
            

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    
    
    
    
    //=========================================== Users =====================================
    public static ArrayList<User> getUsers(){
        try {
            return PrivateGetUsers();
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private static ArrayList<User> PrivateGetUsers() throws Exception{
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM users";

        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<User> list = new ArrayList<>();
            
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setAccessBooks(resultSet.getBoolean("access_books"));
                user.setAccessSales(resultSet.getBoolean("access_sales"));
                user.setAccessUsers(resultSet.getBoolean("access_users"));
                user.setAccessInventory(resultSet.getBoolean("access_inventory"));
                user.setAccessBookLists(true);
                list.add(user);
            }
            
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    
    public static ArrayList<String> getAllUserIDs(){
        try {
            return PrivateGetAllUserIDs();
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private static ArrayList<String> PrivateGetAllUserIDs() throws Exception{
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT id FROM users";

        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<String> list = new ArrayList<>();
            
            while(resultSet.next()){
                list.add(resultSet.getString("id"));
            }
            
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    
    public static User getUserByEmployeeID(String id){
        try {
            return privateGetUserByEmployeeID(id);
        } catch (Exception ex) {
            Logger.getLogger(SearchHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private static User privateGetUserByEmployeeID(String id) throws Exception{
        connectdbTables();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM users where id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);

            resultSet = preparedStatement.executeQuery();  //create a method that returns this result set
            ArrayList<User> list = new ArrayList<>();
            
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                
                list.add(user);
            }
            try {
                return list.get(0);
            } catch (Exception e) {
                return null;
            }
                
            
            

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    
}
