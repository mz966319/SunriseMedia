/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books.table.models;

import boooks.objects.Book;
import java.awt.Button;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mbaiu
 */
public class BooksTableModel extends DefaultTableModel{
    private static String[] colNames={
            "ID","Title","Grade","Subject","Qty","Total Qty","Price","Barcode","Object"
        };
    public BooksTableModel(){
        super(colNames, 0);

    }
    @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex==8 ) {
                return Book.class;
            }
            if (columnIndex==7 ) {
                return Boolean.class;
            }
            return super.getColumnClass(columnIndex);
        }
    @Override
    public boolean isCellEditable(int row, int column){  
        if(column==7)
            return true;
        return false;  
    }
    
    public void setData(List<Book> books){
        setRowCount(0);
        for(Book book : books){
            addRow(new Object[]{
//                "ID","Title","Grade","Subject","Qty","Cost","DISC","Profit","Price"
                String.valueOf(book.getId()),book.getTitle(),book.getGrade(),book.getSubject(),String.valueOf(book.getQty()),
                String.valueOf(book.getTotalQty()),String.valueOf(book.getCost()),false,book
            });
        }
    }

}
