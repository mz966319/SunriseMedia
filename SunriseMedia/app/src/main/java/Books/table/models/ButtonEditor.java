/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books.table.models;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author mbaiu
 */
public class ButtonEditor extends DefaultCellEditor {
    private ColorButton button;
    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new ColorButton("");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setBackground(Color.GREEN);
            }
        });
    }
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        button.setText((value == null) ? "" : value.toString());
        return button;
    }
}