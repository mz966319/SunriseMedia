/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books.table.models;

import boooks.objects.Book;
import boooks.objects.User;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mbaiu
 */
public class UsersTableModel extends DefaultTableModel{
    private static String[] colNames={
            "ID","Name","Sales","Inventory","Books","Users"
        };
    public UsersTableModel(){
        super(colNames, 0);
    }
    
    @Override
    public boolean isCellEditable(int row, int column){  
        return column>1;  
    }


    @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex>1 ) {
                return Boolean.class;
            }
            return super.getColumnClass(columnIndex);
        }
    
    public void setData(List<User> users){
        setRowCount(0);
        for(User user : users){
            addRow(new Object[]{user.getId(),user.getName(),user.isAccessSales(),user.isAccessInventory(),user.isAccessBooks(),user.isAccessUsers()
                
            });
        }
    }

}
