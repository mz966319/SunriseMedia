/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books.table.models;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mbaiu
 */
public class ButtonRenderer extends DefaultTableCellRenderer {
    private ColorButton button;
    public ButtonRenderer() {
        super();
        button = new ColorButton("");
    }
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        button.setText((value == null) ? "" : value.toString());
        return button;
    }
}