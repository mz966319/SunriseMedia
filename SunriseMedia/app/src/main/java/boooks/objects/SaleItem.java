/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boooks.objects;

import Database.util.SearchHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mbaiu
 */
public class SaleItem {
    private String id;
    private String customerName;
    private String purchaseID;
    private String invoiceID;
    private String time;
    private String employeeID;
    private String bookID;
    private double price;
    private int qty;
    
    public SaleItem(){}
    public SaleItem(String id, String purchaseOrderID, String invoiceID, String time, String employeeID, String bookID,int qty,double price) {
        this.id = id;
        this.purchaseID = purchaseOrderID;
        this.invoiceID = invoiceID;
        this.time = time;
        this.employeeID = employeeID;
        this.bookID = bookID;
        this.price=price;
        this.qty=qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(String purchaseID) {
        this.purchaseID = purchaseID;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "SaleItem{" + "id=" + id + ", purchaseID=" + purchaseID + ", invoiceID=" + invoiceID + ", time=" + time + ", employeeID=" + employeeID + ", bookID=" + bookID + ", price=" + price + ", qty=" + qty + '}';
    }
    
    
    public static SortedMap<String,SortedMap<String,List<SaleItem>>> getSalesHistoryMap(List<SaleItem>salesList){
        SortedMap<String,SortedMap<String,List<SaleItem>>> salesHistory = new TreeMap<>();
        for(SaleItem item : salesList){
            if(!salesHistory.containsKey(item.getPurchaseID())){
                SortedMap<String,List<SaleItem>> invoiceMap = new TreeMap<>();
                salesHistory.put(item.getPurchaseID(), invoiceMap);
            }
            if(!salesHistory.get(item.getPurchaseID()).containsKey(item.getInvoiceID())){
                List<SaleItem> list = new ArrayList<>();
                salesHistory.get(item.getPurchaseID()).put(item.getInvoiceID(), list);                
            }
            salesHistory.get(item.getPurchaseID()).get(item.getInvoiceID()).add(item);
        }
        return salesHistory;
    }
    
    public static SortedMap<String,List<SaleItem>> getSalesHistoryMapByYear(List<SaleItem>salesList){
        SortedMap<String,List<SaleItem>> salesHistory = new TreeMap<>();
        for(SaleItem item : salesList){
            try {
                Date date1;
                date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(item.getTime());
                Calendar cal = Calendar.getInstance();
                cal.setTime(date1);
                String year = String.valueOf(cal.get(Calendar.YEAR));

                if(!salesHistory.containsKey(year)){
                    List<SaleItem> list = new ArrayList<>();
                    salesHistory.put(year, list);                
                }
                salesHistory.get(year).add(item);
            } catch (ParseException ex) {
                Logger.getLogger(SaleItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return salesHistory;
    }
    
    
    public static SortedMap<String,SortedMap<String,SortedMap<String,List<SaleItem>>>> getSalesWithGradeHistoryMap(List<SaleItem>salesList){
        SortedMap<String,SortedMap<String,SortedMap<String,List<SaleItem>>>> salesHistory = new TreeMap<>();
        for(SaleItem item : salesList){
            if(!salesHistory.containsKey(item.getPurchaseID())){
                SortedMap<String,SortedMap<String,List<SaleItem>>> gradeMap = new TreeMap<>(); //create a map that has grade as its key
                salesHistory.put(item.getPurchaseID(), gradeMap);
            }
            String grade = SearchHelper.getBookByID(item.getBookID()).getGrade();
            if(!salesHistory.get(item.getPurchaseID()).containsKey(grade)){
                SortedMap<String,List<SaleItem>> invoiceMap = new TreeMap<>();
                salesHistory.get(item.getPurchaseID()).put(grade, invoiceMap);                
            }
            if(!salesHistory.get(item.getPurchaseID()).get(grade).containsKey(item.getInvoiceID())){
                List<SaleItem> list = new ArrayList<>();
                salesHistory.get(item.getPurchaseID()).get(grade).put(item.getInvoiceID(), list);                
            }
            salesHistory.get(item.getPurchaseID()).get(grade).get(item.getInvoiceID()).add(item);
        }
        return salesHistory;
    }
    
    
}
