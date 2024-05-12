/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boooks.objects;

import java.math.BigInteger;

/**
 *
 * @author mbaiu
 */
public class Book {
    private String id;
    private String title;
    private String grade;
    private String subject;
    private int qty;
    private int totalQty;
    private double cost;
    private double costDiscountRate;
    private double profitRate;
    public Book(String id) {
        this.id = id;
    }

    public Book(String id, int totalQty, String title, String grade, String subject, double cost, double costDiscountRate, double profitRate) {
        this.id = id;
        this.totalQty = totalQty;
        this.title = title;
        this.grade = grade;
        this.subject = subject;
        this.cost = cost;
        this.costDiscountRate = costDiscountRate;
        this.profitRate = profitRate;
    }
    

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCostDiscountRate() {
        return costDiscountRate;
    }

    public void setCostDiscountRate(double costDiscountRate) {
        this.costDiscountRate = costDiscountRate;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    
    
    public double getPrice() {
        //TODO: 
        double discRate = this.costDiscountRate/100;
        double profitRate = 1+(this.profitRate/100);
        return this.cost*discRate*profitRate;
    }
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Book other = (Book) obj;
        // If the object is compared with itself then return true 
        if (this.id.equals(other.getId())) {
            return true;
        }
        return false;
    }
    
}
