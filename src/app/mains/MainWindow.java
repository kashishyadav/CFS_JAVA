/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mains;

import app.core.purchases.guis.goods.GoodsGUI;
import app.core.purchases.guis.goodsCategories.GoodsCategoryGUI;
import app.core.reports.guis.orders.RptOrderRevenueGUI;
import app.core.systems.dtos.users.UserEntity;
import app.core.systems.guis.allcodes.AllCodeGUI;
import app.core.systems.guis.errors.ErrorGUI;
import app.core.systems.guis.roles.RoleGUI;
import app.core.systems.guis.softwares.SoftwareInfoGUI;
import app.core.systems.guis.users.UserGUI;
import app.core.trade.guis.employees.EmployeeGUI;
import app.core.trade.guis.orders.OrderGUI;
import app.core.trade.guis.orders.OrderUpdateGUI;
import app.core.trade.guis.productCategories.ProductCategoryGUI;
import app.core.trade.guis.products.ProductGUI;
import app.mains.guis.homes.HomeGUI;
import app.mains.navigations.AppNavigator;
import base.configurations.constants.SystemConstants;
import base.guis.controls.BaseFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Khang
 */
public class MainWindow extends BaseFrame implements ActionListener  {

     /**
     * Creates new form MainWindow1
     */
    //main
    HomeGUI homeGUI;
    //common
    EmployeeGUI employeeGUI;

    GoodsGUI goodsGUI;
    GoodsCategoryGUI goodsCategoryGUI;

    //trade
    ProductGUI productGUI;
    ProductCategoryGUI productCategoryGUI;
    OrderGUI orderGUI;
    OrderUpdateGUI orderUpdateGUI;
     ErrorGUI errorGUI;
     SoftwareInfoGUI softwareInfoGUI;

    //common
    
    //report
    RptOrderRevenueGUI rptOrderRevenueGUI;
    
    //system
    AllCodeGUI allCodeGUI;
    RoleGUI roleGUI;
    UserGUI userGUI;

    private static MainWindow _instance;

    public static MainWindow getInstance() {
        if (_instance == null) {
            _instance = new MainWindow();
        }
        return _instance;
    }

    private MainWindow() {
        super();
        initComponents();
        init();
    }

    private void init() {

        this.setTitle("MainWindow");
        this.setContentPane(this.paneMain);
        paneMain.setLayout(new BorderLayout());

        addScreenToPanel(getSubScreen(homeGUI, HomeGUI.class));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(SystemConstants.CENTER_POSX, SystemConstants.CENTER_POSY,
                SystemConstants.DEFAULT_SCREEN_WIDTH, SystemConstants.DEFAULT_SCREEN_HEIGHT);

        menuHome.addActionListener(this);

        //order
        mItemOrder.addActionListener(this);
        mItemOrderUpdate.addActionListener(this);

        //common
        mItemEmployee.addActionListener(this);
        mItemProduct.addActionListener(this);
        mItemProductCategory.addActionListener(this);
        mItemUser.addActionListener(this);
        mItemRole.addActionListener(this);
        mItemAllCode.addActionListener(this);
        mitemSysInfo.addActionListener(this);
        mItemSysError.addActionListener(this);
        //statistics
        mItemRevenueReport.addActionListener(this);

        //system
      
        mItemExit.addActionListener(this);
    }

    public void setAuthentication(UserEntity user) {
        AppNavigator.getInstance().setEnableToggleMenu(false, menuHome, menuTrade, menuCommon, menuReport, menuSystem);
        if (user != null) {
            if (user.getRoleCode().equals("Manager")) {
                AppNavigator.getInstance().setEnableToggleMenu(true, menuHome, menuTrade, menuCommon, menuReport, menuSystem);
            }

            if (user.getRoleCode().equals("Staff")) {
                AppNavigator.getInstance().setEnableToggleMenu(true, menuTrade);
            }
        }
    }

    public void addScreenToPanel(JPanel childScreen) {
        paneMain.removeAll();

        if (childScreen != null) {
            childScreen.setVisible(true);
            this.paneMain.add(childScreen, BorderLayout.CENTER);

        }
        paneMain.revalidate();
        paneMain.repaint();
    }

    public JPanel getSubScreen(JPanel subScreen, Class<? extends JPanel> clazz) {
        if (subScreen == null) {
            try {
                try {
                    subScreen = clazz.getDeclaredConstructor().newInstance();
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (InstantiationException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return subScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == menuHome) {
            this.addScreenToPanel(getSubScreen(homeGUI, HomeGUI.class));
        }
        //order
        if (e.getSource() == mItemOrder) {
            this.addScreenToPanel(getSubScreen(orderGUI, OrderGUI.class));
        } else if (e.getSource() == mItemOrderUpdate) {
            this.addScreenToPanel(getSubScreen(orderUpdateGUI, OrderUpdateGUI.class));
        }

        //common
        if (e.getSource() == mItemEmployee) {
            this.addScreenToPanel(getSubScreen(employeeGUI, EmployeeGUI.class));
        } else if (e.getSource() == mItemProduct) {
            this.addScreenToPanel(getSubScreen(productGUI, ProductGUI.class));
        } else if (e.getSource() == mItemProductCategory) {
            this.addScreenToPanel(getSubScreen(productCategoryGUI, ProductCategoryGUI.class));
        } else if (e.getSource() == mItemUser) {
            this.addScreenToPanel(getSubScreen(userGUI, UserGUI.class));
        } else if (e.getSource() == mItemRole) {
            this.addScreenToPanel(getSubScreen(roleGUI, RoleGUI.class));
        } else if (e.getSource() == mItemAllCode) {
            this.addScreenToPanel(getSubScreen(allCodeGUI, AllCodeGUI.class));
        }else if (e.getSource() == mitemSysInfo) {
             this.addScreenToPanel(getSubScreen(softwareInfoGUI, SoftwareInfoGUI.class));
        }else if (e.getSource() == mItemSysError) {
            this.addScreenToPanel(getSubScreen(errorGUI, ErrorGUI.class));
        }

        //stastistics
        if(e.getSource()== mItemRevenueReport){
             this.addScreenToPanel(getSubScreen(rptOrderRevenueGUI, RptOrderRevenueGUI.class));
        }
        
        //system
        if (e.getSource() == mItemExit) {
            System.exit(0);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneMain = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuHome = new javax.swing.JMenu();
        mItemHome = new javax.swing.JMenuItem();
        menuTrade = new javax.swing.JMenu();
        mItemOrder = new javax.swing.JMenuItem();
        mItemOrderUpdate = new javax.swing.JMenuItem();
        menuCommon = new javax.swing.JMenu();
        mItemProduct = new javax.swing.JMenuItem();
        mItemProductCategory = new javax.swing.JMenuItem();
        mItemEmployee = new javax.swing.JMenuItem();
        mItemUser = new javax.swing.JMenuItem();
        mItemRole = new javax.swing.JMenuItem();
        mItemAllCode = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenu();
        mItemRevenueReport = new javax.swing.JMenuItem();
        menuSystem = new javax.swing.JMenu();
        mitemSysInfo = new javax.swing.JMenuItem();
        mItemSysError = new javax.swing.JMenuItem();
        mItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout paneMainLayout = new javax.swing.GroupLayout(paneMain);
        paneMain.setLayout(paneMainLayout);
        paneMainLayout.setHorizontalGroup(
            paneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        paneMainLayout.setVerticalGroup(
            paneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        menuHome.setText("Trang chủ");

        mItemHome.setText("Trang chính");
        menuHome.add(mItemHome);

        jMenuBar1.add(menuHome);

        menuTrade.setText("Bán hàng");

        mItemOrder.setText("Lập phiếu gọi món");
        mItemOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemOrderActionPerformed(evt);
            }
        });
        menuTrade.add(mItemOrder);

        mItemOrderUpdate.setText("Cập nhật thông tin đặt món");
        menuTrade.add(mItemOrderUpdate);

        jMenuBar1.add(menuTrade);

        menuCommon.setText("Quản lý chung");

        mItemProduct.setText("Sản phẩm");
        menuCommon.add(mItemProduct);

        mItemProductCategory.setText("Loại sản phẩm");
        menuCommon.add(mItemProductCategory);

        mItemEmployee.setText("Nhân viên");
        menuCommon.add(mItemEmployee);

        mItemUser.setText("Người dùng");
        menuCommon.add(mItemUser);

        mItemRole.setText("Quyền ");
        menuCommon.add(mItemRole);

        mItemAllCode.setText("Các trường giao dịch");
        menuCommon.add(mItemAllCode);

        jMenuBar1.add(menuCommon);

        menuReport.setText("Báo cáo");

        mItemRevenueReport.setText("Thống kê doanh thu");
        menuReport.add(mItemRevenueReport);

        jMenuBar1.add(menuReport);

        menuSystem.setText("Hệ thống");

        mitemSysInfo.setText("Thông tin phần mềm");
        menuSystem.add(mitemSysInfo);

        mItemSysError.setText("Các lỗi hệ thống");
        menuSystem.add(mItemSysError);

        mItemExit.setText("Thoát");
        menuSystem.add(mItemExit);

        jMenuBar1.add(menuSystem);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mItemOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mItemOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mItemAllCode;
    private javax.swing.JMenuItem mItemEmployee;
    private javax.swing.JMenuItem mItemExit;
    private javax.swing.JMenuItem mItemHome;
    private javax.swing.JMenuItem mItemOrder;
    private javax.swing.JMenuItem mItemOrderUpdate;
    private javax.swing.JMenuItem mItemProduct;
    private javax.swing.JMenuItem mItemProductCategory;
    private javax.swing.JMenuItem mItemRevenueReport;
    private javax.swing.JMenuItem mItemRole;
    private javax.swing.JMenuItem mItemSysError;
    private javax.swing.JMenuItem mItemUser;
    private javax.swing.JMenu menuCommon;
    private javax.swing.JMenu menuHome;
    private javax.swing.JMenu menuReport;
    private javax.swing.JMenu menuSystem;
    private javax.swing.JMenu menuTrade;
    private javax.swing.JMenuItem mitemSysInfo;
    private javax.swing.JPanel paneMain;
    // End of variables declaration//GEN-END:variables
}
