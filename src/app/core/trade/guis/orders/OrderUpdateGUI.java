/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.guis.orders;
import app.common.appControls.productModals.ProductListModal;
import app.common.interfaces.modals.IModalEvent;
import app.common.modules.constants.PageConstants;
import app.common.modules.constants.StoreConstants;
import app.core.trade.dtos.orders.OrderDetailDisplayDto;
import app.core.trade.dtos.orders.OrderDetailEntity;
import app.core.trade.dtos.orders.OrderDisplayDto;
import app.core.trade.dtos.orders.OrderEntity;
import app.core.trade.dtos.products.ProductEntity;

import app.mains.MainWindow;
import base.applications.imps.BaseService;
import base.configurations.constants.SystemStringConstants;
import base.data.dal.ConnectionFactory;
import base.data.dal.StoreProvider;
import base.data.entities.EntityBase;

import base.guis.controls.BaseEditPanel;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import base.ultilities.utils.MathUtils;
import base.ultilities.helpers.FormatRenderHelper;
import base.ultilities.helpers.NumberRendererHelper;
import base.ultilities.helpers.ReflectionExHelper;
import base.ultilities.utils.MessageUtils;
import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
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
public class OrderUpdateGUI extends BaseEditPanel implements ActionListener, IModalEvent {

    /**
     * Creates new form OrderUpdateGUI3
     */
    OrderDetailEntity detailEntity;
    OrderDetailDisplayDto detailDisplayDto;
    StoreProvider orderDetailProvider;
    Gson gson;

    ProductListModal productListModal;
    public OrderUpdateGUI() {
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
        btnPrint.addActionListener(this);

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
        txtDiscount.setValue(entity.getFee());
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
        entity.setFee(MathUtils.getBigDecimal(txtDiscount.getValue()));
        entity.setTotalPrice(MathUtils.getBigDecimal(txtTotalValue.getValue()));
        entity.setNote(txtNote.getText());
        entity.setStatus((String) allCodeSelectorStatus.getSelectedValue());

        this.onResetPrice();
        
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
        } else if (e.getSource() == btnPrint) {
            OrderEntity orderEntity = (OrderEntity)this.getCurrentObj();
            if(orderEntity!=null){
                int id = orderEntity.getId();
                this.createReport(id);
            }else{
                MessageUtils.showErrorMessage(this, "Chưa chọn đối tượng xuất");
            }
          
        }else {
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
        curOrder.setPrice(BigDecimal.ZERO);
        curOrder.setTotalPrice(BigDecimal.ZERO);
        curOrder.setDiscountPercent(this.txtDiscount.getValue());
        curOrder.setFee(MathUtils.getBigDecimal(this.txtDiscount.getValue()));

        if (curOrder.getDetails() != null) {
            for (int i = 0; i < curOrder.getDetails().size(); i++) {
                BigDecimal itemTotalPrice = curOrder.getDetails().get(i).getTotalPrice();
                curOrder.setPrice(curOrder.getPrice().add(itemTotalPrice));
                // totalValue = totalValue.add(itemTotalPrice);
                this.editTable1.getTableModel().setValueAt(itemTotalPrice, i, 5);
                this.editTable1.getTableModel().setValueAt(curOrder.getDetails().get(i).getQuantity(), i, 4);
            }
        }

        curOrder.setTotalPrice(curOrder.getPrice().add(curOrder.getFee()));
        BigDecimal amortValue = curOrder.getTotalPrice().multiply(curOrder.getDiscountPercent());
        curOrder.setTotalPrice(curOrder.getTotalPrice().subtract(amortValue));
        if (curOrder.getTotalPrice().intValue() < 0) {
            curOrder.setTotalPrice(BigDecimal.ZERO);
            curOrder.setPrice(BigDecimal.ZERO);
        }
        this.txtTotalValue.setValue(curOrder.getTotalPrice());
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

        gbInfo = new app.common.controls.GroupBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editTable1 = new app.common.controls.EditTable();
        try {
            txtFee = new app.common.controls.DecimalInput();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        try {
            txtTotalValue = new app.common.controls.DecimalInput();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        txtDiscount = new app.common.controls.JPercentField();
        txtName = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        allCodeSelectorStatus = new app.common.controls.AllCodeSelector();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        btnCalculate = new javax.swing.JButton();
        appCrudToolBar = new app.common.controls.AppCrudToolBar();
        btnPrint = new javax.swing.JButton();
        dataTable = new app.common.controls.DataTable();

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Số phiếu đặt:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Số bàn:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Phí vận chuyển:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Tỷ lệ giảm giá:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Tổng giá trị thanh toán:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Tình trạng");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Diễn giải:");

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane1.setViewportView(txtNote);

        btnCalculate.setText("Tính");

        javax.swing.GroupLayout gbInfoLayout = new javax.swing.GroupLayout(gbInfo);
        gbInfo.setLayout(gbInfoLayout);
        gbInfoLayout.setHorizontalGroup(
            gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gbInfoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(allCodeSelectorStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(gbInfoLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gbInfoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(59, 59, 59)
                                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(gbInfoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCalculate)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        gbInfoLayout.setVerticalGroup(
            gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbInfoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(allCodeSelectorStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalculate)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(editTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnPrint.setText("In phiếu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(appCrudToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(gbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(gbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(appCrudToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint))
                .addGap(18, 18, 18)
                .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.common.controls.AllCodeSelector allCodeSelectorStatus;
    private app.common.controls.AppCrudToolBar appCrudToolBar;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnPrint;
    private app.common.controls.DataTable dataTable;
    private app.common.controls.EditTable editTable1;
    private app.common.controls.GroupBox gbInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCode;
    private app.common.controls.JPercentField txtDiscount;
    private app.common.controls.DecimalInput txtFee;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtNote;
    private app.common.controls.DecimalInput txtTotalValue;
    // End of variables declaration//GEN-END:variables
}
