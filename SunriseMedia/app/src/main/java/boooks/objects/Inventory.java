/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boooks.objects;

import java.util.Date;

/**
 *
 * @author mbaiu
 */
public class Inventory {
    private String id;
    private String bookID;
    private int rcvQty; //the recived qty
    private String time;
    private String employeeID;
    private int rcvIndex;
    
    public Inventory(){}
    public Inventory(String id, String bookID, int rcvQty, String time, String employeeID, int rcvIndex) {
        this.id = id;
        this.bookID = bookID;
        this.rcvQty = rcvQty;
        this.time = time;
        this.employeeID = employeeID;
        this.rcvIndex = rcvIndex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public int getRcvQty() {
        return rcvQty;
    }

    public void setRcvQty(int rcvQty) {
        this.rcvQty = rcvQty;
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

    public int getRcvIndex() {
        return rcvIndex;
    }

    public void setRcvIndex(int rcvIndex) {
        this.rcvIndex = rcvIndex;
    }
    
}
