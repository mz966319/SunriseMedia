/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Books.sale.windows;

import Database.util.SearchHelper;
import boooks.objects.SaleItem;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 *
 * @author mbaiu
 */
public class InvoiceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form InvoiceJPanel
     */
    public InvoiceJPanel(List<SaleItem> saleItemList) {
        initComponents();
        
        
        
        this.jPanelList.setLayout(new GridBagLayout());
        // add child panels to parent panel
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.insets = new Insets(0, 0, 1, 0); // top, left, bottom, right
        
        int count =1;
        if(!saleItemList.isEmpty()){
            this.jLabelInvoiceNumber.setText(saleItemList.get(0).getInvoiceID());
            this.jLabelTime.setText(saleItemList.get(0).getTime());
            this.jLabelEmployeeName.setText(SearchHelper.getUserByEmployeeID(saleItemList.get(0).getEmployeeID()).getName());
        }
        
        SaleItem headerRow= new SaleItem();
        headerRow.setBookID(null);
        this.jPanelList.add(new BookSaleJPanel(headerRow), c);
        c.gridy = count++;
        for(SaleItem item :saleItemList){
            this.jPanelList.add(new BookSaleJPanel(item), c);
            c.gridy = count++;
        }
//        // create child panels
//        BookSaleJPanel panel1 = new BookSaleJPanel();
//        BookSaleJPanel panel2 = new BookSaleJPanel();
//        BookSaleJPanel panel3 = new BookSaleJPanel();
//        BookSaleJPanel panel4 = new BookSaleJPanel();
//        
//        this.jPanelList.add(panel1, c);
//
//        c.gridy = 1;
//        this.jPanelList.add(panel2, c);
//
//        c.gridy = 2;
//        this.jPanelList.add(panel3, c);
//
//        c.gridy = 3;
//        this.jPanelList.add(panel4, c);
//        

        
//        this.jPanelList.setLayout(new GridBagLayout());
//            GridBagConstraints gbc = new GridBagConstraints();
//            gbc.gridx = 0;
//            gbc.gridy = GridBagConstraints.RELATIVE;
//            gbc.fill = GridBagConstraints.HORIZONTAL;
//            gbc.weightx = 1;
//            this.jPanelList.add(new BookSaleJPanel(), gbc);
//            this.jPanelList.add(new BookSaleJPanel(), gbc);
//            this.jPanelList.add(new BookSaleJPanel(), gbc);//        this.jPanelList.setAlignmentX(Box.TOP_ALIGNMENT);
            
            
            
            
            
            
            
            
//        this.jPanelList.setLayout(new GridLayout(3,1));

//        BookSaleJPanel panel1= new BookSaleJPanel();
//        BookSaleJPanel panel2= new BookSaleJPanel();
//        BookSaleJPanel panel3= new BookSaleJPanel();
//        this.jPanelList.add(panel1);
//        this.add(Box.createVerticalStrut(-panel1.getInsets().top)); // set negative margin to remove the gap
//        this.jPanelList.add(panel2);
//        this.add(Box.createVerticalStrut(-panel2.getInsets().top)); // set negative margin to remove the gap
//        this.jPanelList.add(panel3);
//        this.add(Box.createVerticalStrut(-panel1.getInsets().top)); // set negative margin to remove the gap
////        this.jPanelList.add(Box.createVerticalGlue());
//        this.jPanelList.add(new BookSaleJPanel());
//        this.jPanelList.add(Box.createVerticalGlue());
//        this.jPanelList.add(new BookSaleJPanel());
//        this.jPanelList.add(Box.createVerticalGlue());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelInvoiceNumber = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelEmployeeName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jPanelList = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 0), null));

        jLabel1.setText("Invoice #:");

        jLabelInvoiceNumber.setText("jLabel2");

        jLabel3.setText("Employee:");

        jLabelEmployeeName.setText("jLabel4");

        jLabel2.setText("Time:");

        jLabelTime.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmployeeName)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelInvoiceNumber)
                    .addComponent(jLabel3)
                    .addComponent(jLabelEmployeeName)
                    .addComponent(jLabel2)
                    .addComponent(jLabelTime))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanelList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelListLayout = new javax.swing.GroupLayout(jPanelList);
        jPanelList.setLayout(jPanelListLayout);
        jPanelListLayout.setHorizontalGroup(
            jPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );
        jPanelListLayout.setVerticalGroup(
            jPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelEmployeeName;
    private javax.swing.JLabel jLabelInvoiceNumber;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelList;
    // End of variables declaration//GEN-END:variables
}
