/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.common.controls;

import base.configurations.constants.AppStringConstants;
import base.configurations.constants.SystemConstants;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import base.ultilities.helpers.FileHelper;

/**
 *
 * @author Khang
 */
public class ImagePicker extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form ImagePicker
     */
    String categoryFolderName;

    public ImagePicker() {
        initComponents();
        Border border = BorderFactory.createLineBorder(Color.black);
        btnUpload.addActionListener(this);
        this.lbImageContainer.setHorizontalAlignment(SwingConstants.CENTER);
        this.lbImageContainer.setBorder(border);
    }

    public void setCategoryFolderName(String categoryFolderName) {
        this.categoryFolderName = "/"+categoryFolderName;
    }

    public String getCategoryFolderName() {
        return this.categoryFolderName;
    }

    public String getValue() {
        return this.txtFilePath.getText();
    }

    public void setValue(String imgPath) {
        Image img = null;
        if (imgPath != null && !imgPath.isEmpty()) {
            img = ResizeImage(new StringBuilder(SystemConstants.DOMAIN_FOLDER).append(imgPath).toString());
        }

        if (img != null) {
            this.lbImageContainer.setText(new StringBuilder().toString());
        } else {
            this.lbImageContainer.setText(AppStringConstants.NO_IMAGE_TEXT);
        }

        ImageIcon icon = FileHelper.convertImageToImageIcon(img);
        lbImageContainer.setIcon(icon);
        txtFilePath.setText(imgPath);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbImageContainer = new javax.swing.JLabel();
        txtFilePath = new javax.swing.JTextField();
        btnUpload = new javax.swing.JButton();

        lbImageContainer.setText("No Image");

        btnUpload.setText("Tải lên");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtFilePath, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lbImageContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbImageContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilePath)
                    .addComponent(btnUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel lbImageContainer;
    private javax.swing.JTextField txtFilePath;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(SystemConstants.DESKTOP_FOLDER_PATH));
        //filter the files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        //if the user click on save in Jfilechooser
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = file.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                String cateName = (this.categoryFolderName != null && !this.categoryFolderName.isEmpty()) ? this.categoryFolderName : "";
                String desFolderPath = new StringBuilder(SystemConstants.IMG_SOURCE_FOLDER).append(cateName).toString();
                String fileName = FileHelper.removeExtensionFromFileName(selectedFile.getName());
                String imgPath = FileHelper.writeImageToFolder(path, desFolderPath, fileName);
                this.setValue(imgPath);
            } catch (IOException ex) {
                Logger.getLogger(ImagePicker.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No File Select");
        }

    }

    public Image ResizeImage(String imagePath) {
        if (!imagePath.isEmpty()) {
            ImageIcon MyImage = new ImageIcon(imagePath);
            Image img = MyImage.getImage();
            Image newImg = img.getScaledInstance(lbImageContainer.getWidth()-5, lbImageContainer.getHeight()-5, Image.SCALE_SMOOTH);
            //ImageIcon image = new ImageIcon(newImg);
            return newImg;
        }
        return null;
    }
}
