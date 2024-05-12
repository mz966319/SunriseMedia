/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books.table.models;

import boooks.objects.Inventory;
import boooks.objects.SaleItem;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mbaiu
 */
public class SalesInvoiceHistoryTableModel extends DefaultTableModel{
    private static String[] colNames={
            "Invoice ID","Time","Employee"
        };
    public SalesInvoiceHistoryTableModel(){
        super(colNames, 0);

    }
    
    @Override
    public boolean isCellEditable(int row, int column){  
        return false;  
    }
    
    public void setData(List<SaleItem> saleItems){
        setRowCount(0);
        for(SaleItem saleItem : saleItems){
            addRow(new String[]{
                    saleItem.getInvoiceID(),saleItem.getTime(),saleItem.getEmployeeID()
            });
        }
    }

}
