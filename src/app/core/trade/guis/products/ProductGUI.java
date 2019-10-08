/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.guis.products;

import app.core.modules.constants.StoreConstants;
import app.core.trade.dtos.products.ProductDisplayDto;
import app.core.trade.dtos.products.ProductEntity;
import base.applications.imps.BaseService;


import base.guis.controls.BaseEditPanel;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import ultilities.Utils.MathUtils;
import ultilities.helpers.FormatRenderHelper;
import ultilities.helpers.NumberRendererHelper;

/**
 *
 * @author Khang
 */
public class ProductGUI extends BaseEditPanel {

    /**
     * Creates new form ProductGUI
     */    
     

    public ProductGUI() throws InstantiationException, IllegalAccessException {     
        //current obj, search obj, display obj
        super(new ProductEntity(),new ProductEntity(),new ProductDisplayDto());  
        initComponents();       
        init();
    }
    private void init() throws InstantiationException, IllegalAccessException{
        this.appService = new BaseService(ProductEntity.class,ProductDisplayDto.class);
        dataTable.setEditPanel(this);             
       
        this.tableModel = (DefaultTableModel) dataTable.getTable().getModel();   
        this.appCrudToolBar.setEditPanelUI(this);
        this.setGroupInformation(this.groupInformation);
        setTableColumns();
        
        // set store procedure names
        this.setStoreProcedureNames(
                StoreConstants.PRODUCT_SEARCH(),
                StoreConstants.PRODUCT_INSORUPD(),
                StoreConstants.PRODUCT_BYID());
        
        this.search();
    }
    
    @Override
    public void setTableColumns() {
                
        String[] headers = new String[]{"STT","Id","Tên sản phẩm","Gía","Ngày tạo","Người tạo"};
        tableModel.setColumnIdentifiers(headers); 
      
        TableColumnModel colModel = dataTable.getTable().getColumnModel();
      
        //format cho các cột
        colModel.getColumn(3).setCellRenderer(NumberRendererHelper.getCurrencyRenderer());
        colModel.getColumn(4).setCellRenderer(FormatRenderHelper.getDateRenderer());     
    }

        @Override
    public void bindingModelToView( ) {
        System.out.println(txtPrice.getValue());
        ProductEntity obj = (ProductEntity) this.getCurrentObj();
        txtCode.setText(obj.getCode());
        txtName.setText(obj.getName());
        txtPrice.setValue(obj.getPrice());
        txtImage.setText(obj.getCode());
    }

    @Override
    public void bindingViewToModel() {
      ProductEntity entity = (ProductEntity) this.getCurrentObj();
      entity.setCode(txtCode.getText());
      entity.setName(txtName.getText());
      entity.setPrice(MathUtils.getBigDecimal(txtPrice.getValue()));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataTable = new app.common.controls.DataTableCustom();
        appCrudToolBar = new app.common.controls.AppCrudToolBar();
        groupInformation = new app.common.controls.GroupBox();
        jLabel2 = new javax.swing.JLabel();
        txtImage = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        try {
            txtPrice = new app.common.controls.MoneyInput();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }

        jLabel2.setText("Tên sản phẩm:");

        jLabel3.setText("Gía: bán");

        jLabel4.setText("Hình ảnh:");

        jLabel1.setText("Mã sản phẩm:");

        javax.swing.GroupLayout groupInformationLayout = new javax.swing.GroupLayout(groupInformation);
        groupInformation.setLayout(groupInformationLayout);
        groupInformationLayout.setHorizontalGroup(
            groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtImage, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        groupInformationLayout.setVerticalGroup(
            groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(groupInformationLayout.createSequentialGroup()
                        .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(groupInformationLayout.createSequentialGroup()
                        .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("LBL1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appCrudToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(groupInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 241, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(groupInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appCrudToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(dataTable, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.common.controls.AppCrudToolBar appCrudToolBar;
    private app.common.controls.DataTableCustom dataTable;
    private app.common.controls.GroupBox groupInformation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtImage;
    private javax.swing.JTextField txtName;
    private app.common.controls.MoneyInput txtPrice;
    // End of variables declaration//GEN-END:variables

    
    


}
