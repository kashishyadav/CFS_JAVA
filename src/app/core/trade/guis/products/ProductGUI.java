/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.guis.products;

import app.common.controls.Selector;
import app.core.modules.constants.PageConstants;
import app.core.modules.constants.StoreConstants;
import app.core.trade.dtos.productCategories.ProductCategoryEntity;
import app.core.trade.dtos.products.ProductDisplayDto;
import app.core.trade.dtos.products.ProductEntity;
import base.applications.imps.BaseService;
import base.data.dal.StoreProvider;


import base.guis.controls.BaseEditPanel;
import base.infrastructures.ComponentRunnable;
import java.util.List;
import java.util.Map;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import ultilities.utils.MathUtils;
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
     StoreProvider<ProductCategoryEntity> categoryProvider;
     

    public ProductGUI() throws InstantiationException, IllegalAccessException {     
        //current obj, search obj, display obj
        super(new ProductEntity(),new ProductEntity(),new ProductDisplayDto());  
        initComponents();       
        init();
    }
    private void init() throws InstantiationException, IllegalAccessException{
        this.appService = new BaseService(ProductEntity.class,ProductDisplayDto.class);
        
        //Selector(combobox) StoreProvider
        this.categoryProvider = new StoreProvider(ProductCategoryEntity.class);
        
        //COMBOBOX
       // init Selector
       initSelector();
       this.allCodeSelector1.loadListByCode("ORDER_STATUS");
       // 
       //
       
        dataTable.setEditPanel(this);           
             
        this.setIdControl(txtCode);
        this.tableModel = (DefaultTableModel) dataTable.getTable().getModel();   
        this.appCrudToolBar.setEditPanelUI(this);
        this.setGroupInformation(this.gbInfo,PageConstants.PRODUCT);
        setTableColumns();
        
        // set store procedure names
        this.setStoreProcedureNames(
                StoreConstants.PRODUCT_SEARCH(),
                StoreConstants.PRODUCT_INSORUPD(),
                StoreConstants.PRODUCT_BYID());
        
        this.dataTable.onResetSearch();
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
        //System.out.println(txtPrice.getValue());
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
    

    public void initSelector(){
        //default display member = id
         this.getProductCategorySelector().setDisplayMember("name");
         Runnable runnableCategories =  new ComponentRunnable(this) {
            
            @Override
            public void run() {
                try{
                    List<Map<String,Object>> categories = categoryProvider.executeToListMapProperties(
                            StoreConstants.PRODUCTCATEGORY_LST(), new ProductCategoryEntity());
                    ((ProductGUI)this.getComponent()).getProductCategorySelector().setDataSource(categories);
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }finally{
                    System.gc();
                }
            }
        };
        Thread threadCategories = new Thread(runnableCategories);  
       threadCategories.start();
    }
    public Selector getProductCategorySelector(){
        return this.selectorCategory;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataTable = new app.common.controls.DataTable();
        appCrudToolBar = new app.common.controls.AppCrudToolBar();
        gbInfo = new app.common.controls.GroupBox();
        jLabel2 = new javax.swing.JLabel();
        txtImage = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        try {
            txtPrice = new app.common.controls.DecimalInput();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        selectorCategory = new app.common.controls.Selector();
        allCodeSelector1 = new app.common.controls.AllCodeSelector();

        jLabel2.setText("Tên sản phẩm:");

        jLabel3.setText("Gía: bán");

        jLabel4.setText("Hình ảnh:");

        jLabel1.setText("Mã sản phẩm:");

        javax.swing.GroupLayout gbInfoLayout = new javax.swing.GroupLayout(gbInfo);
        gbInfo.setLayout(gbInfoLayout);
        gbInfoLayout.setHorizontalGroup(
            gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtImage, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        gbInfoLayout.setVerticalGroup(
            gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(selectorCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(allCodeSelector1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(gbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(selectorCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(allCodeSelector1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appCrudToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(dataTable, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.common.controls.AllCodeSelector allCodeSelector1;
    private app.common.controls.AppCrudToolBar appCrudToolBar;
    private app.common.controls.DataTable dataTable;
    private app.common.controls.GroupBox gbInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private app.common.controls.Selector selectorCategory;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtImage;
    private javax.swing.JTextField txtName;
    private app.common.controls.DecimalInput txtPrice;
    // End of variables declaration//GEN-END:variables

    
    


}
