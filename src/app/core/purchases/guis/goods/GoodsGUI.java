/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.purchases.guis.goods;

import app.common.controls.Selector;
import app.common.modules.constants.PageConstants;
import app.common.modules.constants.StoreConstants;
import app.core.purchases.dtos.goodsCategories.GoodsCategoryEntity;
import app.core.purchases.dtos.goods.GoodsDisplayDto;
import app.core.purchases.dtos.goods.GoodsEntity;
import base.applications.imps.BaseService;
import base.data.dal.StoreProvider;

import base.guis.controls.BaseEditPanel;
import base.infrastructures.manipulations.ComponentRunnable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import base.ultilities.utils.MathUtils;
import base.ultilities.helpers.FormatRenderHelper;
import base.ultilities.helpers.NumberRendererHelper;

/**
 *
 * @author Khang
 */
public class GoodsGUI extends BaseEditPanel {

    /**
     * Creates new form GoodsGUI
     */
    StoreProvider<GoodsCategoryEntity> categoryProvider;

    public GoodsGUI() {
        super(new GoodsEntity(), new GoodsEntity(), new GoodsDisplayDto());
        initComponents();
        init();
    }

    private void init() {

        this.appService = new BaseService(GoodsEntity.class, GoodsDisplayDto.class);

        dataTable.setEditPanel(this);

        this.setIdControl(txtCode);
        this.tableModel = (DefaultTableModel) dataTable.getTable().getModel();
        this.appCrudToolBar.setEditPanelUI(this);
        this.setGroupInformation(this.gbInfo, PageConstants.GOODS);
        this.setIdControl(this.txtCode);
        this.setIsAutoGenKey(true);
        setTableColumns();

        // set store procedure names
        this.setStoreProcedureNames(
                StoreConstants.GOODS_SEARCH,
                StoreConstants.GOODS_INSORUPD,
                StoreConstants.GOODS_BYID);

        //COMBOBOX
        //Selector(combobox) StoreProvider
        this.categoryProvider = new StoreProvider(GoodsCategoryEntity.class);
        initSelector();
        //
        //
        this.dataTable.onResetSearch();

    }

    @Override
    public void setTableColumns() {

        String[] headers = new String[]{
            //0     1       2           3       4       5           6
            "STT", "Id", "Mã hàng hóa", "Tên hàng hóa", "Gía", "Mô tả", "Ngày tạo", "Người tạo"};
        tableModel.setColumnIdentifiers(headers);

        TableColumnModel colModel = dataTable.getTable().getColumnModel();
        dataTable.hideColumnAt(1);

        //format cho các cột
        colModel.getColumn(4).setCellRenderer(NumberRendererHelper.getCurrencyRenderer());
        colModel.getColumn(6).setCellRenderer(FormatRenderHelper.getDateRenderer());
    }

    @Override
    public void bindingModelToView() {
        //System.out.println(txtPrice.getValue());
        GoodsEntity entity = (GoodsEntity) this.getCurrentObj();
        txtCode.setText(entity.getCode());
        txtName.setText(entity.getName());
        txtPrice.setValue(entity.getPrice());
        txtDescription.setText(entity.getDescription());
        selectorCategory.setValue(entity.getCategoryId());
    }

    @Override
    public void bindingViewToModel() {
        GoodsEntity entity = (GoodsEntity) this.getCurrentObj();
        entity.setCode(txtCode.getText());
        entity.setName(txtName.getText());
        entity.setPrice(MathUtils.getBigDecimal(txtPrice.getValue()));
        entity.setDescription(txtDescription.getText());
        entity.setCategoryId((int) selectorCategory.getSelectedValue());
    }

    public void initSelector() {
        //default display member = id
        this.getGoodsCategorySelector().setDisplayMember("name");
        Runnable runnableCategories = new ComponentRunnable(this) {

            @Override
            public void run() {
                try {
                    GoodsCategoryEntity categorySearchEntity = new GoodsCategoryEntity();
                    categorySearchEntity.setOffset(-1);
                    List<Map<String, Object>> categories = categoryProvider.executeToListMapProperties(
                            StoreConstants.GOODSCATEGORY_SEARCH, categorySearchEntity);
                    ((GoodsGUI) this.getComponent()).getGoodsCategorySelector().setDataSource(categories);

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
    }

    public Selector getGoodsCategorySelector() {
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
        selectorCategory = new app.common.controls.Selector();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();

        jLabel2.setText("Tên hàng hóa:");

        jLabel3.setText("Gía bán:");

        jLabel1.setText("Mã hàng hóa:");

        jLabel5.setText("Mô tả:");

        jLabel4.setText("Loại:");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        javax.swing.GroupLayout gbInfoLayout = new javax.swing.GroupLayout(gbInfo);
        gbInfo.setLayout(gbInfoLayout);
        gbInfoLayout.setHorizontalGroup(
            gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(53, 53, 53)
                        .addComponent(selectorCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gbInfoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleName("Mã hàng hóa:");

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
                            .addComponent(gbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(appCrudToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appCrudToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.common.controls.AppCrudToolBar appCrudToolBar;
    private app.common.controls.DataTable dataTable;
    private app.common.controls.GroupBox gbInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private app.common.controls.Selector selectorCategory;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    private app.common.controls.DecimalInput txtPrice;
    // End of variables declaration//GEN-END:variables
}
