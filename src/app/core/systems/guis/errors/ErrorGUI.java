/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.systems.guis.errors;

import app.common.modules.constants.StoreConstants;
import app.core.systems.dtos.errors.ErrorDisplayDto;
import app.core.systems.dtos.errors.ErrorEntity;
import base.applications.imps.BaseService;
import base.guis.controls.BaseEditPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khang
 */
public class ErrorGUI extends BaseEditPanel{

    /**
     * Creates new form ErrorGUI
     */
    public ErrorGUI() {
         super(new ErrorEntity(),new ErrorEntity(),new ErrorDisplayDto());
        initComponents();
        init();
    }
    
    private void init(){
        this.appService = new BaseService(ErrorEntity.class, ErrorDisplayDto.class);

        dataTable1.setEditPanel(this);
        
        this.tableModel = (DefaultTableModel) dataTable1.getTable().getModel();
         setTableColumns();
        this.dataTable1.setEnableRowClick(false);
        
         // set store procedure names
        this.setStoreProcedureNames(
                StoreConstants.ERROR_SEARCH,
                StoreConstants.ERROR_INSORUPD,
                StoreConstants.ERROR_BYID);
        
        this.dataTable1.onResetSearch();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dataTable1 = new app.common.controls.DataTable();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Các lỗi hệ thống");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(dataTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.common.controls.DataTable dataTable1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setTableColumns() {
        String[] headers = new String[]{
            //0         1       2             
            "STT", "Mã lỗi", "Mô tả"};
        tableModel.setColumnIdentifiers(headers);
       
    }

    @Override
    public void bindingModelToView() {
    }

    @Override
    public void bindingViewToModel() {
    }
}
