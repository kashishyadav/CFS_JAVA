package app.core.guis.mains;


import app.core.guis.products.ProductGUI;
import base.configurations.constants.SystemConstants;
import base.guis.controls.BaseFrame;

import javax.swing.*;

public class MainWindow extends BaseFrame {


ProductGUI productGUI;
    public MainWindow() throws InstantiationException, IllegalAccessException{
       

        productGUI = new ProductGUI();
        productGUI.setVisible(true);

        this.setTitle("MainWindow");
        this.setContentPane(productGUI);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(SystemConstants.CENTER_POSX, SystemConstants.CENTER_POSY,
                SystemConstants.DEFAULT_SCREEN_WIDTH, SystemConstants.DEFAULT_SCREEN_HEIGHT);
    }
}
