/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.users;

/**
 *
 * @author mbaiu
 */
public class UserManger {
        private static UserManger ref;
    private String userID;

    public UserManger() {
        if(getUserManger()==null){
            ref = new UserManger();
            
        }
            
    }
    
    public UserManger getUserManger(){
        return ref;
    }
    public static String getLocalUser(){
        return "moaz";
    }
    
}
