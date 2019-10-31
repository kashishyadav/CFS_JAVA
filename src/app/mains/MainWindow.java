package app.mains;

import app.core.purchases.guis.goods.GoodsGUI;
import app.core.purchases.guis.goodsCategories.GoodsCategoryGUI;
import app.core.trade.guis.employees.EmployeeGUI;
import app.core.trade.guis.orders.OrderGUI;
import app.core.trade.guis.productCategories.ProductCategoryGUI;
import app.core.trade.guis.products.ProductGUI;
import base.configurations.constants.SystemConstants;
import base.guis.controls.BaseFrame;

import javax.swing.*;

public class MainWindow extends BaseFrame {

    ProductGUI productGUI;
    ProductCategoryGUI productCategoryGUI;
    EmployeeGUI employeeGUI;
    GoodsGUI goodsGUI;
    GoodsCategoryGUI goodsCategoryGUI;
    OrderGUI orderGUI;

    private static MainWindow _instance;
    public static MainWindow getInstance(){
        if(_instance==null){
            _instance = new MainWindow();
        }
        return _instance;
    }
    private MainWindow(){

        productGUI = new ProductGUI();
        productGUI.setVisible(true);

        productCategoryGUI = new ProductCategoryGUI();
        productCategoryGUI.setVisible(true);

        employeeGUI = new EmployeeGUI();
        employeeGUI.setVisible(true);

        orderGUI = new OrderGUI();
        orderGUI.setVisible(true);
        
        goodsGUI = new GoodsGUI();
        goodsGUI.setVisible(true);
        
        goodsCategoryGUI = new GoodsCategoryGUI();
        goodsCategoryGUI.setVisible(true);
        
        this.setTitle("MainWindow");
        this.setContentPane(orderGUI);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(SystemConstants.CENTER_POSX, SystemConstants.CENTER_POSY,
                SystemConstants.DEFAULT_SCREEN_WIDTH, SystemConstants.DEFAULT_SCREEN_HEIGHT);
    }
}
