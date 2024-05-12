/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package boooks.objects;

/**
 *
 * @author mbaiu
 */
public class User {
    private String id;
    private String name;
    private String password;
    private String addedBy;
    private boolean accessSales;
    private boolean accessInventory;
    private boolean accessBooks;
    private boolean accessUsers;
    private boolean accessBookLists;
    
    public User(){}

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }
    
    public User(String id,String name, String password, String addedBy,boolean accessSales, boolean accessInventory, boolean accessBooks, boolean accessUsers,boolean accessBookLists) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.addedBy=addedBy;
        this.accessSales = accessSales;
        this.accessInventory = accessInventory;
        this.accessBooks = accessBooks;
        this.accessUsers = accessUsers;
        this.accessBookLists = accessBookLists;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public boolean isAccessSales() {
        return accessSales;
    }

    public void setAccessSales(boolean accessSales) {
        this.accessSales = accessSales;
    }

    public boolean isAccessInventory() {
        return accessInventory;
    }

    public void setAccessInventory(boolean accessInventory) {
        this.accessInventory = accessInventory;
    }

    public boolean isAccessBooks() {
        return accessBooks;
    }

    public void setAccessBooks(boolean accessBooks) {
        this.accessBooks = accessBooks;
    }

    public boolean isAccessUsers() {
        return accessUsers;
    }

    public void setAccessUsers(boolean accessUsers) {
        this.accessUsers = accessUsers;
    }

    public boolean isAccessBookLists() {
        return accessBookLists;
    }

    public void setAccessBookLists(boolean accessBookLists) {
        this.accessBookLists = accessBookLists;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        User other = (User) obj;
        if(other.getId().equals(this.id)&&other.getPassword().equals(this.getPassword())){
            return true;
        }
        return false; 
    }
    
}
