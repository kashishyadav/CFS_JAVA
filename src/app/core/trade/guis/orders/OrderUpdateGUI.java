/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.guis.orders;

import app.common.appControls.productModals.ProductListModal;
import app.common.interfaces.modals.IModalEvent;
import app.core.modules.constants.PageConstants;
import app.core.modules.constants.StoreConstants;
import app.core.trade.dtos.orders.OrderDetailDisplayDto;
import app.core.trade.dtos.orders.OrderDetailEntity;
import app.core.trade.dtos.orders.OrderDisplayDto;
import app.core.trade.dtos.orders.OrderEntity;
import app.core.trade.dtos.products.ProductEntity;

import app.mains.MainWindow;
import base.applications.imps.BaseService;
import base.configurations.constants.AppStringConstants;
import base.configurations.constants.SystemStringConstants;
import base.data.dal.StoreProvider;
import base.data.entities.EntityBase;

import base.guis.controls.BaseEditPanel;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import base.ultilities.utils.MathUtils;
import base.ultilities.helpers.FormatRenderHelper;
import base.ultilities.helpers.NumberRendererHelper;
import base.ultilities.helpers.ReflectionExHelper;
import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

/**
 *
 * @author Khang
 */
public class OrderUpdateGUI extends BaseEditPanel implements ActionListener, IModalEvent {

    /**
     * Creates new form OrderUpdateGUI
     */
    OrderDetailEntity detailEntity;
    OrderDetailDisplayDto detailDisplayDto;
    StoreProvider orderDetailProvider;
    Gson gson;

    ProductListModal productListModal;
    public OrderUpdateGUI() {
        //current obj, search obj, display obj
        super(new OrderEntity(), new OrderEntity(), new OrderDisplayDto());
        initComponents();
        init();
    }

    private void init() {

        this.appService = new BaseService(OrderEntity.class, OrderDisplayDto.class);
        this.orderDetailProvider = new StoreProvider(OrderDetailEntity.class);

        gson = new Gson();
        detailEntity = new OrderDetailEntity();
        detailDisplayDto = new OrderDetailDisplayDto();
        
        productListModal = new ProductListModal(this);

        dataTable.setEditPanel(this);

        this.setIdControl(txtCode);
        this.tableModel = (DefaultTableModel) dataTable.getTable().getModel();
        this.appCrudToolBar.setEditPanelUI(this);
        this.appCrudToolBar.setVisibleButtons(false, true, false);
        this.setGroupInformation(this.gbInfo, PageConstants.ORDER);
        setTableColumns();
        this.setIdControl(txtCode);
        this.setIsAutoGenKey(true);

        // set store procedure names
        this.setStoreProcedureNames(
                StoreConstants.ORDER_SEARCH,
                StoreConstants.ORDER_INSORUPD,
                StoreConstants.ORDER_BYID);

        initSelector();
        initTableDetail();
        //
        //
        this.editTable1.getButtonDelete().addActionListener(this);
        this.editTable1.getButtonEdit().addActionListener(this);
        this.editTable1.getButtonAdd().addActionListener(this);

        this.btnCalculate.addActionListener(this);

        this.dataTable.onResetSearch();

    }

    @Override
    public String strIsValid() {
        if (((EntityBase) this.getCurrentObj()).getId() == 0) {
            return SystemStringConstants.STR_ERROR_EMPTY_ID;
        }
        return this.getEmptyText();
    }

    @Override
    public void setTableColumns() {

        String[] headers = new String[]{
            //0     1       2           3         4                          5           6              7           8
            "STT", "Id", "Số hóa đơn", "Số bàn", "Phí vận chuyển", "Tỷ lệ giảm giá", "Tổng giá trị", "Ngày tạo", "Người tạo"};
        tableModel.setColumnIdentifiers(headers);

        TableColumnModel colModel = dataTable.getTable().getColumnModel();
        this.dataTable.hideColumnAt(1);
        //format cho các cột
        colModel.getColumn(4).setCellRenderer(NumberRendererHelper.getCurrencyRenderer());
        colModel.getColumn(5).setCellRenderer(NumberRendererHelper.getPercentRenderer());
        colModel.getColumn(6).setCellRenderer(NumberRendererHelper.getCurrencyRenderer());
        colModel.getColumn(7).setCellRenderer(FormatRenderHelper.getDateRenderer());
    }

    @Override
    public void bindingModelToView() {
        //System.out.println(txtPrice.getValue());
        OrderEntity entity = (OrderEntity) this.getCurrentObj();
        txtCode.setText(entity.getCode());
        txtName.setText(entity.getName());
        txtFee.setValue(entity.getFee());
        txtDiscount.setValue(entity.getDiscountPercent());
        txtTotalValue.setValue(entity.getTotalPrice());
        txtNote.setText(entity.getNote());

        allCodeSelectorStatus.setValue(entity.getStatus());

        //detail
        if (entity.getDetails() != null && entity.getDetails().size() > 0) {
            int counter = 1;
            for (OrderDetailEntity item : entity.getDetails()) {
                try {
                    Vector displayRow = new Vector();
                    displayRow.add(counter);
                    OrderDetailDisplayDto displayObj = new OrderDetailDisplayDto();
                    ReflectionExHelper.convertObjectIntoObject(item, displayObj);
                    ReflectionExHelper.loadObjIntoVector(displayObj, displayRow);
                    this.editTable1.getTableModel().addRow(displayRow);
                    counter++;
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(OrderUpdateGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(OrderUpdateGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.editTable1.setTotalCountLabel(entity.getDetails().size());
            this.onResetPrice();
        }
    }

    @Override
    public void bindingViewToModel() {
        OrderEntity entity = (OrderEntity) this.getCurrentObj();
        entity.setCode(txtCode.getText());
        entity.setName(txtName.getText());
        entity.setPrice(MathUtils.getBigDecimal(txtDiscount.getValue()));
        entity.setFee(MathUtils.getBigDecimal(txtFee.getValue()));
        entity.setTotalPrice(MathUtils.getBigDecimal(txtTotalValue.getValue()));
        entity.setNote(txtNote.getText());
        entity.setStatus((String) allCodeSelectorStatus.getSelectedValue());

        if (entity.getDetails() != null && entity.getDetails().size() > 0) {
            entity.setStrOrderDetails(gson.toJson(entity.getDetails()));
        } else {
            entity.setStrOrderDetails(this.getEmptyText());
        }

    }

    @Override
    public OrderEntity getById(int id) {
        this.refreshEditForm();
        OrderEntity tmpModel = null;
        ((OrderEntity) this.getCurrentObj()).setId(id);
        tmpModel = (OrderEntity) appService.getById(this.getStoredProcedureById(), this.getCurrentObj());
        if (tmpModel != null) {
            try {
                detailEntity.setId(tmpModel.getId());
                tmpModel.setDetails(orderDetailProvider.executeToList(StoreConstants.ORDERDETAIL_BYID, detailEntity));
            } catch (Exception ex) {
                Logger.getLogger(OrderUpdateGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tmpModel;
    }

    @Override
    public void refreshEditForm() {
        super.refreshEditForm();
        OrderEntity tmpEntity = (OrderEntity) this.getCurrentObj();
        this.editTable1.removeAll();
        if (tmpEntity.getDetails() != null && tmpEntity.getDetails().size() > 0) {
            this.editTable1.removeAll();
            tmpEntity.getDetails().removeAll(tmpEntity.getDetails());
        }
        tmpEntity = null;
        System.gc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.editTable1.getButtonDelete()) {
            onDeleteItem();
        } else if (e.getSource() == this.editTable1.getButtonEdit()) {
            onEditItem();
        } else if (e.getSource() == this.editTable1.getButtonAdd()) {
            onAddItems();
        } else {
            this.onResetPrice();
        }
    }

    @Override
    public void onGetItems() {
        List<ProductEntity> items = this.productListModal.getSelectedItems();
        OrderEntity curOrder = (OrderEntity) this.getCurrentObj();
        if (items != null && items.size() > 0) {
            //this.editTable1.getTableModel().addRow(rowData);  
            int curIndex = curOrder.getDetails().size() + 1;
            boolean isInList;
            for (ProductEntity pd : items) {
                try {
                    isInList = false;
                    for (OrderDetailEntity ordIm : curOrder.getDetails()) {
                        if (ordIm.getProductId() == pd.getId()) {
                            isInList = true;
                            break;
                        }
                    }

                    if (!isInList) {
                        OrderDetailEntity ordItem = new OrderDetailEntity();
                        ordItem.setDataFromProduct(pd);
                        curOrder.getDetails().add(ordItem);
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
        this.editTable1.setTotalCountLabel(curOrder.getDetails().size());
        this.onResetPrice();
    }

    public void initSelector() {
        this.allCodeSelectorStatus.loadListByCode("ORDER_UPDATE_STATUS");
    }

    public void initTableDetail() {
        this.editTable1.setColumns("STT", "Mã SP", "Tên SP", "Gía", "Số lượng", "Thành tiền");
        TableColumnModel colModel = this.editTable1.getTable().getColumnModel();

        colModel.getColumn(3).setCellRenderer(NumberRendererHelper.getCurrencyRenderer());
        colModel.getColumn(4).setCellRenderer(NumberRendererHelper.getIntegerRenderer());
        colModel.getColumn(5).setCellRenderer(NumberRendererHelper.getCurrencyRenderer());
    }

    //BUS
    public void onAddItems() {
       
        productListModal.setVisible(true);
//        JDialog jd = new JDialog(MainWindow.getInstance(), PageConstants.PRODUCT_INFO);
//        this.showComponentDialog(new ProductListFrameModal( this,jd), jd);
    }

    public void onEditItem() {
        int rowIndex = this.editTable1.getCurrentSelectedRow();
        if (rowIndex != -1) {

            OrderDetailEntity item = ((OrderEntity) this.getCurrentObj()).getDetails().get(rowIndex);
            JDialog jd = new JDialog(MainWindow.getInstance(), PageConstants.EDIT_DETAIL);
            this.showComponentDialog(new OrderDetailEditPanel(item, jd), jd);

            this.onResetPrice();
        }

    }

    public void onDeleteItem() {
        int rowIndex = this.editTable1.getTable().getSelectedRow();

        OrderEntity curOrder = (OrderEntity) this.getCurrentObj();
        if (rowIndex != -1) {

            this.editTable1.getTableModel().removeRow(rowIndex);
            curOrder.getDetails().remove(rowIndex);

            for (int i = 0; i < curOrder.getDetails().size(); i++) {
                this.editTable1.getTableModel().setValueAt(i + 1, i, 0);
            }
            this.editTable1.setTotalCountLabel(curOrder.getDetails().size());
        }
        this.onResetPrice();
    }

    public void onResetPrice() {

        OrderEntity curOrder = (OrderEntity) this.getCurrentObj();
        curOrder.setTotalPrice(BigDecimal.ZERO);
        curOrder.setDiscountPercent(this.txtDiscount.getValue());
        curOrder.setFee(MathUtils.getBigDecimal(this.txtFee.getValue()));

        if (curOrder.getDetails() != null) {
            for (int i = 0; i < curOrder.getDetails().size(); i++) {
                BigDecimal itemTotalPrice = curOrder.getDetails().get(i).getTotalPrice();
                curOrder.setTotalPrice(curOrder.getTotalPrice().add(itemTotalPrice));
                // totalValue = totalValue.add(itemTotalPrice);
                this.editTable1.getTableModel().setValueAt(itemTotalPrice, i, 5);
                this.editTable1.getTableModel().setValueAt(curOrder.getDetails().get(i).getQuantity(), i, 4);
            }
        }

        curOrder.setPrice(curOrder.getTotalPrice());
        curOrder.setTotalPrice(curOrder.getTotalPrice().add(curOrder.getFee()));
        // totalValue = totalValue.add(fee);
        BigDecimal amortValue = curOrder.getTotalPrice().multiply(curOrder.getDiscountPercent());
        curOrder.setTotalPrice(curOrder.getTotalPrice().subtract(amortValue));
        //totalValue = totalValue.subtract(amortValue);
        if (curOrder.getTotalPrice().intValue() < 0) {
            curOrder.setTotalPrice(BigDecimal.ZERO);
            curOrder.setPrice(BigDecimal.ZERO);
        }
        this.txtTotalValue.setValue(curOrder.getTotalPrice());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gbInfo = new app.common.controls.GroupBox();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        allCodeSelectorStatus = new app.common.controls.AllCodeSelector();
        editTable1 = new app.common.controls.EditTable();
        btnCalculate = new javax.swing.JButton();
        try {
            txtTotalValue = new app.common.controls.DecimalInput();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDiscount = new app.common.controls.JPercentField();
        try {
            txtFee = new app.common.controls.DecimalInput();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        dataTable = new app.common.controls.DataTable();
        appCrudToolBar = new app.common.controls.AppCrudToolBar();

        jLabel2.setText("Số bàn:");

        jLabel1.setText("Số phiếu đặt:");

        jLabel6.setText("Tình trạng:");

        allCodeSelectorStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allCodeSelectorStatusActionPerformed(evt);
            }
        });

        btnCalculate.setText("Tính");

        jLabel7.setText("Tổng giá trị thanh toán:");

        jLabel8.setText("Tỷ lệ giảm giá:");

        jLabel9.setText("Tiền phí vận chuyển:");

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane1.setViewportView(txtNote);

        jLabel10.setText("Diễn giải:");

        javax.swing.GroupLayout gbInfoLayout = new javax.swing.GroupLayout(gbInfo);
        gbInfo.setLayout(gbInfoLayout);
        gbInfoLayout.setHorizontalGroup(
            gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(68, 68, 68)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(txtCode))
                        .addGap(147, 147, 147)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addGap(47, 47, 47)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(allCodeSelectorStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gbInfoLayout.createSequentialGroup()
                                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTotalValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        gbInfoLayout.setVerticalGroup(
            gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(allCodeSelectorStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTotalValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalculate)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(appCrudToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gbInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appCrudToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void allCodeSelectorStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allCodeSelectorStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allCodeSelectorStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.common.controls.AllCodeSelector allCodeSelectorStatus;
    private app.common.controls.AppCrudToolBar appCrudToolBar;
    private javax.swing.JButton btnCalculate;
    private app.common.controls.DataTable dataTable;
    private app.common.controls.EditTable editTable1;
    private app.common.controls.GroupBox gbInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCode;
    private app.common.controls.JPercentField txtDiscount;
    private app.common.controls.DecimalInput txtFee;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtNote;
    private app.common.controls.DecimalInput txtTotalValue;
    // End of variables declaration//GEN-END:variables
}
