/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books.table.models;

import Database.util.SearchHelper;
import boooks.objects.Book;
import boooks.objects.Inventory;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mbaiu
 */
public class InventoryTableModel extends DefaultTableModel{
    private static String[] colNames={
            "Book ID","Title","RCV. Qty","RCV. Index","Date","Employee"
        };
    public InventoryTableModel(){
        super(colNames, 0);

    }
    
    @Override
    public boolean isCellEditable(int row, int column){  
        return false;  
    }
    
    public void setData(List<Inventory> inventories){
        setRowCount(0);
        for(Inventory inventory : inventories){
            Book book = SearchHelper.getBookByID(inventory.getBookID());
            addRow(new String[]{String.valueOf(
                    inventory.getBookID()),book.getTitle(),String.valueOf(inventory.getRcvQty()),String.valueOf(inventory.getRcvIndex()),inventory.getTime(),inventory.getEmployeeID()
            });
        }
    }

}
