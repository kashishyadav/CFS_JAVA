/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.guis.products;

import app.common.controls.Selector;
import app.common.modules.constants.PageConstants;
import app.common.modules.constants.StoreConstants;
import app.core.trade.dtos.productCategories.ProductCategoryEntity;
import app.core.trade.dtos.products.ProductDisplayDto;
import app.core.trade.dtos.products.ProductEntity;
import base.applications.imps.BaseService;
import base.configurations.constants.SystemConstants;
import base.data.dal.StoreProvider;

import base.guis.controls.BaseEditPanel;
import base.infrastructures.manipulations.ComponentRunnable;
import java.util.List;
import java.util.Map;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import base.ultilities.utils.MathUtils;
import base.ultilities.helpers.FormatRenderHelper;
import base.ultilities.helpers.NumberRendererHelper;

/**
 *
 * @author Khang
 */
public class ProductGUI extends BaseEditPanel {

    /**
     * Creates new form ProductGUI
     */
    StoreProvider<ProductCategoryEntity> categoryProvider;

    public ProductGUI() {
        //current obj, search obj, display obj
        super(new ProductEntity(), new ProductEntity(), new ProductDisplayDto());
        initComponents();
        init();
    }

    private void init() {

        this.appService = new BaseService(ProductEntity.class, ProductDisplayDto.class);

        dataTable.setEditPanel(this);

        this.setIdControl(txtCode);
        this.tableModel = (DefaultTableModel) dataTable.getTable().getModel();
        this.appCrudToolBar.setEditPanelUI(this);
        this.setGroupInformation(this.gbInfo, PageConstants.PRODUCT);
        setTableColumns();
        this.setIdControl(txtCode);
        this.setIsAutoGenKey(true);

        //image picker folder
        this.imagePicker.setCategoryFolderName(new StringBuilder(SystemConstants.STR_PRODUCTS).toString().toLowerCase());

        // set store procedure names
        this.setStoreProcedureNames(
                StoreConstants.PRODUCT_SEARCH,
                StoreConstants.PRODUCT_INSORUPD,
                StoreConstants.PRODUCT_BYID);

        //COMBOBOX
        //Selector(combobox) StoreProvider
        this.categoryProvider = new StoreProvider(ProductCategoryEntity.class);
        initSelector();
        //
        //
        this.dataTable.onResetSearch();

    }

    @Override
    public void setTableColumns() {

        String[] headers = new String[]{
            //0     1       2           3       4       5           6
            "STT", "Id", "Mã sản phẩm", "Tên sản phẩm", "Gía", "Mô tả", "Ngày tạo", "Người tạo"};
        tableModel.setColumnIdentifiers(headers);

        TableColumnModel colModel = dataTable.getTable().getColumnModel();
        this.dataTable.hideColumnAt(1);
        //format cho các cột
        colModel.getColumn(4).setCellRenderer(NumberRendererHelper.getCurrencyRenderer());
        colModel.getColumn(6).setCellRenderer(FormatRenderHelper.getDateRenderer());
    }

    @Override
    public void bindingModelToView() {
        //System.out.println(txtPrice.getValue());
        ProductEntity entity = (ProductEntity) this.getCurrentObj();
        txtCode.setText(entity.getCode());
        txtName.setText(entity.getName());
        txtPrice.setValue(entity.getPrice());
        txtDescription.setText(entity.getDescription());
        imagePicker.setValue(entity.getImage());
        allCodeSelectorStatus.setValue(entity.getStatus());
        selectorCategory.setValue(entity.getCategoryId());
    }

    @Override
    public void bindingViewToModel() {
        ProductEntity entity = (ProductEntity) this.getCurrentObj();
        entity.setCode(txtCode.getText());
        entity.setName(txtName.getText());
        entity.setPrice(MathUtils.getBigDecimal(txtPrice.getValue()));
        entity.setDescription(txtDescription.getText());
        entity.setCategoryId((int) selectorCategory.getSelectedValue());
        entity.setStatus((String) allCodeSelectorStatus.getSelectedValue());
        entity.setImage(imagePicker.getValue());
    }

    public void initSelector() {
        //default display member = id
        this.getProductCategorySelector().setDisplayMember("name");
        Runnable runnableCategories = new ComponentRunnable(this) {

            @Override
            public void run() {
                try {
                    List<Map<String, Object>> categories = categoryProvider.executeToListMapProperties(
                            StoreConstants.PRODUCTCATEGORY_LST, new ProductCategoryEntity());
                    ((ProductGUI) this.getComponent()).getProductCategorySelector().setDataSource(categories);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                } finally {
                    System.gc();
                }
            }
        };
        Thread threadCategories = new Thread(runnableCategories);
        threadCategories.start();
        this.allCodeSelectorStatus.loadListByCode("A_STATUS");
    }

    public Selector getProductCategorySelector() {
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
        jLabel3 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        try {
            txtPrice = new app.common.controls.DecimalInput();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        allCodeSelectorStatus = new app.common.controls.AllCodeSelector();
        selectorCategory = new app.common.controls.Selector();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        imagePicker = new app.common.controls.ImagePicker();

        jLabel2.setText("Tên sản phẩm:");

        jLabel3.setText("Gía bán:");

        jLabel1.setText("Mã sản phẩm:");

        jLabel5.setText("Mô tả:");

        jLabel4.setText("Loại:");

        jLabel6.setText("Tình trạng:");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        javax.swing.GroupLayout gbInfoLayout = new javax.swing.GroupLayout(gbInfo);
        gbInfo.setLayout(gbInfoLayout);
        gbInfoLayout.setHorizontalGroup(
            gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(53, 53, 53)
                        .addComponent(selectorCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(allCodeSelectorStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
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
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gbInfoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(selectorCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(allCodeSelectorStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleName("LBL1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appCrudToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imagePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(appCrudToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.common.controls.AllCodeSelector allCodeSelectorStatus;
    private app.common.controls.AppCrudToolBar appCrudToolBar;
    private app.common.controls.DataTable dataTable;
    private app.common.controls.GroupBox gbInfo;
    private app.common.controls.ImagePicker imagePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private app.common.controls.Selector selectorCategory;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    private app.common.controls.DecimalInput txtPrice;
    // End of variables declaration//GEN-END:variables

}
