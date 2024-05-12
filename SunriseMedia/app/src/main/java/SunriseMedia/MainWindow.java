/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SunriseMedia;

import Books.windows.AddBooksWindow;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author mbaiu
 */
public class MainWindow extends javax.swing.JFrame {

    private File imagesFile;

    public MainWindow() {
        initComponents();
        this.setTitle("Moaaz Moaaz Moaz Moaz Mo Mo M M");
        this.jLabel1.setVisible(false);
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        imagesFile = new File("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSelectImagesFolder = new javax.swing.JButton();
        jButtonCreate = new javax.swing.JButton();
        jLabelImagesFolderPath = new javax.swing.JLabel();
        jLabelLogoPath = new javax.swing.JLabel();
        jButtonUpldateLogoImage = new javax.swing.JButton();
        jLabelResultLocation = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonClear = new javax.swing.JButton();
        jButtonBooks = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonSelectImagesFolder.setText("Select Images Folder");
        jButtonSelectImagesFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectImagesFolderActionPerformed(evt);
            }
        });

        jButtonCreate.setText("Create");
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        jLabelImagesFolderPath.setText("Images Folder");

        jLabelLogoPath.setText("Logo");

        jButtonUpldateLogoImage.setText("Select Logo");
        jButtonUpldateLogoImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpldateLogoImageActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(62, 168, 151));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Eh el kalam?");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonBooks.setText("Books");
        jButtonBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBooksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelResultLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelImagesFolderPath, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                            .addComponent(jLabelLogoPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSelectImagesFolder, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(jButtonUpldateLogoImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogoPath)
                    .addComponent(jButtonUpldateLogoImage))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSelectImagesFolder)
                    .addComponent(jLabelImagesFolderPath))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelResultLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonClear))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBooks)
                        .addGap(36, 36, 36))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelectImagesFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectImagesFolderActionPerformed
        JFileChooser imagesDirectoryChooser = new JFileChooser(new File(System.getProperty("user.home")) + "//Desktop");
//        imagesDirectoryChooser.setCurrentDirectory(new java.io.File(""));
        imagesDirectoryChooser.setDialogTitle("select folder");
        imagesDirectoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        imagesDirectoryChooser.setAcceptAllFileFilterUsed(false);

        imagesDirectoryChooser.showSaveDialog(this);
//        this.jLabelImagesFolderPath.setText(imagesDirectoryChooser.getSelectedFile().toString());
        imagesFile = imagesDirectoryChooser.getSelectedFile();
        this.jLabelImagesFolderPath.setText(imagesFile.toString());

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSelectImagesFolderActionPerformed


    private void jButtonUpldateLogoImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpldateLogoImageActionPerformed
        JFileChooser logoFileChooser = new JFileChooser(new File(System.getProperty("user.home")) + "//Desktop");
        logoFileChooser.setDialogTitle("select Image");
//        imagesDirectoryChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        logoFileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png", "jpeg");
        logoFileChooser.addChoosableFileFilter(filter);
//        logoFileChooser.addChoosableFileFilter(new ImageFilter());

        logoFileChooser.showSaveDialog(this);
//        this.jLabelImagesFolderPath.setText(imagesDirectoryChooser.getSelectedFile().toString());
//        imagesFile = logoFileChooser.getSelectedFile();

        this.jLabelLogoPath.setText(MainWindow.class.getResource("/logos/Sunrise.png").toString());

        this.jLabelLogoPath.setText(logoFileChooser.getSelectedFile().getPath());
//        Mat matrix = Imgcodecs.imread(logoFileChooser.getSelectedFile().getPath());
//        Mat mat = new Mat();

        //to write to path
//        this.jLabelLogoPath.setText(MainWindow.class.getResource("/logos/Sunrise.png").toString());
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUpldateLogoImageActionPerformed

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        
        if(!this.jLabelImagesFolderPath.equals("Images Folder")&& !this.jLabelLogoPath.equals("Logo")){
            try {
                File resultDer = new File(jLabelImagesFolderPath.getText() + "/result");
                if (!resultDer.exists()) {
                    resultDer.mkdirs();
                }
                List<String> imagesPathList = ImageHandler.getImagesPathList(jLabelImagesFolderPath.getText());
                int count = 1;
                for (String imagePath : imagesPathList) {

                    String resultPathName = resultDer + "/result" + count + ".png";
                    ImageHandler.overLayTwoImages(jLabelLogoPath.getText(), imagePath, resultPathName);
                    count++;
                }
                this.jLabelResultLocation.setText("Result location: " + resultDer.getPath());
                this.jLabel1.setVisible(true);

                // TODO add your handling code here:
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Select Logo and images folder");
        }
    }//GEN-LAST:event_jButtonCreateActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        this.jLabelLogoPath.setText("Logo");
        this.jLabelImagesFolderPath.setText("Images Folder");
        this.jLabel1.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBooksActionPerformed
        // TODO add your handling code here:
        AddBooksWindow addBooksWindow = new AddBooksWindow();
        addBooksWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonBooksActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBooks;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonSelectImagesFolder;
    private javax.swing.JButton jButtonUpldateLogoImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelImagesFolderPath;
    private javax.swing.JLabel jLabelLogoPath;
    private javax.swing.JLabel jLabelResultLocation;
    // End of variables declaration//GEN-END:variables
}
