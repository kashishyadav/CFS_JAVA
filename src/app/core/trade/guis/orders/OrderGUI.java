/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.guis.orders;

import app.common.modules.constants.PageConstants;
import app.common.modules.constants.StoreConstants;
import app.core.trade.dtos.orders.OrderDetailEntity;
import app.core.trade.dtos.orders.OrderEntity;
import app.core.trade.dtos.products.ProductEntity;
import app.mains.MainWindow;
import base.configurations.constants.SystemStringConstants;
import base.data.dal.ConnectionFactory;
import base.data.dal.StoreProvider;
import base.guis.controls.BaseComponent;
import base.infrastructures.systems.AppContext;
import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.table.TableColumnModel;
import base.ultilities.helpers.NumberRendererHelper;
import base.ultilities.utils.MathUtils;
import base.ultilities.utils.MessageUtils;

import base.infrastructures.systems.AppContext;
import java.sql.Connection;
import java.sql.Date;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Khang
 */
public class OrderGUI extends BaseComponent implements ActionListener {

    /**
     * Creates new form OrderGUI
     */
    //List<OrderDetailEntity> curItems = null;
    StoreProvider<OrderEntity> storeProvider;
    Gson gson;
    OrderEntity curOrder;

    public OrderGUI() {
        initComponents();
        init();
    }

    private void init() {
        gson = new Gson();
        curOrder = new OrderEntity();
        storeProvider = new StoreProvider(OrderEntity.class);

        //this.lvProducts.setVisibleFilter(false);
        this.editTable1.setDisableEdit(true);
        initTableDetail();

        //curItems = new ArrayList<OrderDetailEntity>();
        this.productListComponent1.getBtnSelect().addActionListener(this);

        this.editTable1.setVisibleButtonAdd(false);
        this.editTable1.getButtonDelete().addActionListener(this);
        this.editTable1.getButtonEdit().addActionListener(this);
        this.btnCalculate.addActionListener(this);
        this.btnSubmit.addActionListener(this);

        this.gbInfo.setTittle(PageConstants.ORDER);
        this.lbAddress.setText(AppContext.getInstance().getAddressBranch());

    }

    public void initTableDetail() {
        this.editTable1.setColumns("STT", "Mã SP", "Tên SP", "Gía", "Số lượng", "Thành tiền");
        TableColumnModel colModel = this.editTable1.getTable().getColumnModel();

        colModel.getColumn(3).setCellRenderer(NumberRendererHelper.getCurrencyRenderer());
        colModel.getColumn(4).setCellRenderer(NumberRendererHelper.getIntegerRenderer());
        colModel.getColumn(5).setCellRenderer(NumberRendererHelper.getCurrencyRenderer());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.productListComponent1.getBtnSelect()) {
            onGetItems();
        } else if (e.getSource() == this.editTable1.getButtonDelete()) {
            onDeleteItem();
        } else if (e.getSource() == this.editTable1.getButtonEdit()) {
            onEditItem();
        } else if (e.getSource() == btnSubmit) {
            onSubmit();
        } else {
            this.onResetPrice();
        }
    }

    public void onSubmit() {
        if (this.curOrder.getDetails() != null && this.curOrder.getDetails().size() > 0) {
            this.onResetPrice();
            this.curOrder.setName(txtName.getText());
            this.curOrder.setEmployeeId(AppContext.getInstance().getCurrentUser().getEmployeeId());
            this.curOrder.setCreatedBy(AppContext.getInstance().getCurrentUser().getUserName());
            this.curOrder.setUpdatedBy(AppContext.getInstance().getCurrentUser().getUserName());

            this.curOrder.setStrOrderDetails(gson.toJson(this.curOrder.getDetails()));
            System.out.println(this.curOrder.getStrOrderDetails());
            Map<String, Object> results = storeProvider.executeToMap(StoreConstants.ORDER_INSORUPD, this.curOrder);

            if (!results.get("Result").equals("0")) {
                onRefreshhForm();
                createReport((int)results.get("Id"));
                //MessageUtils.showSuccessMessage(this, SystemStringConstants.STR_SAVE_SUCCESS);
            } else {
                MessageUtils.showErrorMessage(this, (String) results.get("ErrorDesc"));
            }
        } else {
            MessageUtils.showErrorMessage(this, SystemStringConstants.STR_ERROR_EMPTY_LIST);
        }
    }

    public void onRefreshhForm() {
        this.txtTotalValue.setValue(BigDecimal.ZERO);
        this.txtFee.setValue(BigDecimal.ZERO);
        this.txtDiscount.setValue(BigDecimal.ZERO);
        if (this.curOrder.getDetails() != null && this.curOrder.getDetails().size() > 0) {
            this.editTable1.removeAll();
            this.curOrder.getDetails().removeAll(this.curOrder.getDetails());
        }

        //this.curOrder.getDetails().removeAll(this.curOrder.getDetails());
    }

    public void onEditItem() {
        int rowIndex = this.editTable1.getCurrentSelectedRow();
        if (rowIndex != -1) {
            OrderDetailEntity item = this.curOrder.getDetails().get(rowIndex);
            JDialog jd = new JDialog(MainWindow.getInstance(), PageConstants.EDIT_DETAIL);
//            jd.add(new OrderDetailEditPanel(item, jd));
//            jd.setModal(true);
//            jd.setResizable(false);
//            jd.setBounds(SystemConstants.CENTER_POSX + MainWindow.getInstance().getWidth() / 4,
//                    SystemConstants.CENTER_POSY + +MainWindow.getInstance().getHeight() / 4, 479, 329);
//            jd.setVisible(true);
            this.showComponentDialog(new OrderDetailEditPanel(item, jd), jd);

            this.onResetPrice();
        }

    }

    public void onDeleteItem() {
        int rowIndex = this.editTable1.getTable().getSelectedRow();

        if (rowIndex != -1) {

            this.editTable1.getTableModel().removeRow(rowIndex);
            this.curOrder.getDetails().remove(rowIndex);

            for (int i = 0; i < this.curOrder.getDetails().size(); i++) {
                this.editTable1.getTableModel().setValueAt(i + 1, i, 0);
            }
            this.editTable1.setTotalCountLabel(this.curOrder.getDetails().size());
        }
        this.onResetPrice();
    }

    public void onGetItems() {

        List<ProductEntity> items = this.productListComponent1.getSelectedItems();
        if (items != null && items.size() > 0) {
            //this.editTable1.getTableModel().addRow(rowData);  
            int curIndex = this.curOrder.getDetails().size() + 1;
            boolean isInList;
            for (ProductEntity pd : items) {
                try {
                    isInList = false;
                    for (OrderDetailEntity ordIm : this.curOrder.getDetails()) {
                        if (ordIm.getProductId() == pd.getId()) {
                            isInList = true;
                            break;
                        }
                    }

                    if (!isInList) {
                        OrderDetailEntity ordItem = new OrderDetailEntity();
                        ordItem.setDataFromProduct(pd);
                        this.curOrder.getDetails().add(ordItem);
                        Vector displayRow = new Vector();
                        displayRow.add(curIndex);
                        ordItem.convertDataToVectorRowVector(displayRow);
                        this.editTable1.getTableModel().addRow(displayRow);
                        curIndex++;
                    }

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(OrderGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.editTable1.setTotalCountLabel(this.curOrder.getDetails().size());
        this.onResetPrice();
    }

    public void onResetPrice() {

        this.curOrder.setPrice(BigDecimal.ZERO);
        this.curOrder.setTotalPrice(BigDecimal.ZERO);
        this.curOrder.setDiscountPercent(this.txtDiscount.getValue());
        this.curOrder.setFee(MathUtils.getBigDecimal(this.txtFee.getValue()));

        if (this.curOrder.getDetails() != null) {
            for (int i = 0; i < this.curOrder.getDetails().size(); i++) {
                BigDecimal itemTotalPrice = this.curOrder.getDetails().get(i).getTotalPrice();
                this.curOrder.setPrice(this.curOrder.getPrice().add(itemTotalPrice));
                // totalValue = totalValue.add(itemTotalPrice);
                this.editTable1.getTableModel().setValueAt(itemTotalPrice, i, 5);
                this.editTable1.getTableModel().setValueAt(this.curOrder.getDetails().get(i).getQuantity(), i, 4);
            }
        }

        this.curOrder.setTotalPrice(this.curOrder.getPrice().add(this.curOrder.getFee()));
        BigDecimal amortValue = this.curOrder.getTotalPrice().multiply(this.curOrder.getDiscountPercent());
        this.curOrder.setTotalPrice(this.curOrder.getTotalPrice().subtract(amortValue));
        if (this.curOrder.getTotalPrice().intValue() < 0) {
            this.curOrder.setTotalPrice(BigDecimal.ZERO);
            this.curOrder.setPrice(BigDecimal.ZERO);
        }
        this.txtTotalValue.setValue(this.curOrder.getTotalPrice());
    }

    void createReport(int id){
        Connection conn = null;
        try {
            conn = ConnectionFactory.Instance().getConnection();
            Map<String,Object> parameters = new HashMap<String,Object>();
            parameters.put("p_order_id", id);
            JasperReport jreport = JasperCompileManager.compileReport("E:\\WORKPLACE\\UNI COURSE\\Java\\CFS_JAVA\\App\\CFS_JAVA\\src\\app\\core\\trade\\guis\\orders\\rptOrderDetail.jrxml");
            JasperPrint jprint = JasperFillManager.fillReport(jreport, parameters, conn);
            JasperViewer.viewReport(jprint,false );
          
        } catch (JRException ex) {
            Logger.getLogger(OrderGUI.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                  ConnectionFactory.Instance().closeConn(conn);
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

        productListComponent1 = new app.core.trade.guis.products.ProductListComponent();
        gbInfo = new app.common.controls.GroupBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbAddress = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        try {
            txtTotalValue = new app.common.controls.DecimalInput();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        try {
            txtFee = new app.common.controls.DecimalInput();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        txtDiscount = new app.common.controls.JPercentField();
        txtName = new javax.swing.JTextField();
        btnCalculate = new javax.swing.JButton();
        editTable1 = new app.common.controls.EditTable();
        btnSubmit = new javax.swing.JButton();

        jLabel1.setText("Mã nhân viên:");

        jLabel2.setText("Chi nhánh:");

        lbAddress.setText("Chi nhánh:");

        jLabel3.setText("Số bàn:");

        jLabel4.setText("Phí vận chuyển:");

        jLabel5.setText("Tỷ lệ giảm giá:");

        jLabel6.setText("Tổng tiền thanh toán:");

        btnCalculate.setText("Tính");

        javax.swing.GroupLayout gbInfoLayout = new javax.swing.GroupLayout(gbInfo);
        gbInfo.setLayout(gbInfoLayout);
        gbInfoLayout.setHorizontalGroup(
            gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotalValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(txtFee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCalculate))
                    .addComponent(jLabel1)
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(lbAddress)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gbInfoLayout.setVerticalGroup(
            gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnCalculate))
                .addContainerGap())
        );

        btnSubmit.setText("Lập phiếu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productListComponent1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gbInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(productListComponent1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnSubmit;
    private app.common.controls.EditTable editTable1;
    private app.common.controls.GroupBox gbInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbAddress;
    private app.core.trade.guis.products.ProductListComponent productListComponent1;
    private app.common.controls.JPercentField txtDiscount;
    private app.common.controls.DecimalInput txtFee;
    private javax.swing.JTextField txtName;
    private app.common.controls.DecimalInput txtTotalValue;
    // End of variables declaration//GEN-END:variables
}
