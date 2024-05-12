/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books.table.models;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author mbaiu
 */
class ColorButton extends JButton {
    public ColorButton(String text) {
        super(text);
        setContentAreaFilled(false);
    }
    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        if (getParent() != null) {
            getParent().repaint();
        }
    }
}
