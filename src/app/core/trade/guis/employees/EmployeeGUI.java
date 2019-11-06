/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.guis.employees;

import app.core.modules.constants.PageConstants;
import app.core.modules.constants.StoreConstants;
import app.core.trade.dtos.employees.EmployeeDisplayDto;
import app.core.trade.dtos.employees.EmployeeEntity;
import base.applications.imps.BaseService;
import base.configurations.constants.SystemConstants;
import base.guis.controls.BaseEditPanel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import base.ultilities.helpers.FormatRenderHelper;
/**
 *
 * @author Khang
 */
public class EmployeeGUI extends BaseEditPanel {

    /**
     * Creates new form EmployeeGUI
     */
   public EmployeeGUI() {
        //current obj, search obj, display obj
        super(new EmployeeEntity(), new EmployeeEntity(), new EmployeeDisplayDto());
        initComponents();
       
        try {
            init();
        } catch (InstantiationException ex) {
            Logger.getLogger(EmployeeGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EmployeeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init() throws InstantiationException, IllegalAccessException {
        this.appService = new BaseService(EmployeeEntity.class, EmployeeDisplayDto.class);
        dataTable.setEditPanel(this);
        
        this.setIsAutoGenKey(true);
        this.setIdControl(txtCode);
        
        this.tableModel = (DefaultTableModel) dataTable.getTable().getModel();
        this.appCrudToolBar.setEditPanelUI(this);
        this.setGroupInformation(this.groupInformation, PageConstants.EMPLOYEE);
        setTableColumns();

        //image picker folder
        this.imagePicker.setCategoryFolderName(new StringBuilder(SystemConstants.STR_EMPLOYEES).toString().toLowerCase());
        
        // set store procedure names
        this.setStoreProcedureNames(
                StoreConstants.EMPLOYEE_SEARCH,
                StoreConstants.EMPLOYEE_INSORUPD,
                StoreConstants.EMPLOYEE_BYID);

        this.dataTable.onResetSearch();
    }

    @Override
    public void setTableColumns() {

        String[] headers = new String[]{"STT", "Id", "Mã số", "Họ tên", "Ngày sinh", "SDT", "Địa chỉ"};
        tableModel.setColumnIdentifiers(headers);
        dataTable.hideColumnAt(1);
        TableColumnModel colModel = dataTable.getTable().getColumnModel();
        colModel.getColumn(4).setCellRenderer(FormatRenderHelper.getDateRenderer());

    }

    @Override
    public void bindingModelToView() {
        //System.out.println(txtPrice.getValue());
        EmployeeEntity entity = (EmployeeEntity) this.getCurrentObj();
        txtCode.setText(entity.getCode());
        txtName.setText(entity.getName());
        txtPhoneNumber.setText(entity.getPhoneNumber());
        txtAddress.setText(entity.getAddress());
        dpBirthday.setValue(entity.getBirthday());
        imagePicker.setValue(entity.getImage());
    }

    @Override
    public void bindingViewToModel() {
        EmployeeEntity entity = (EmployeeEntity) this.getCurrentObj();
        entity.setCode(txtCode.getText());    
        entity.setName(txtName.getText());
        entity.setPhoneNumber(txtPhoneNumber.getText());
        entity.setAddress(txtAddress.getText());
        entity.setBirthday(dpBirthday.getValue());
        entity.setImage(imagePicker.getValue());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupInformation = new app.common.controls.GroupBox();
        txtCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dpBirthday = new app.common.controls.DatePickerControl();
        imagePicker = new app.common.controls.ImagePicker();
        appCrudToolBar = new app.common.controls.AppCrudToolBar();
        dataTable = new app.common.controls.DataTable();

        jLabel1.setText("Mã nhân viên:");

        jLabel2.setText("Địa chỉ");

        jLabel3.setText("Ngày sinh:");

        jLabel4.setText("SDT:");

        jLabel5.setText("Họ tên:");

        javax.swing.GroupLayout groupInformationLayout = new javax.swing.GroupLayout(groupInformation);
        groupInformation.setLayout(groupInformationLayout);
        groupInformationLayout.setHorizontalGroup(
            groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAddress)
                    .addComponent(dpBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(txtPhoneNumber)
                    .addComponent(txtName)
                    .addComponent(txtCode))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        groupInformationLayout.setVerticalGroup(
            groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(groupInformationLayout.createSequentialGroup()
                        .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)
                        .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(dpBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(appCrudToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(groupInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groupInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(appCrudToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.common.controls.AppCrudToolBar appCrudToolBar;
    private app.common.controls.DataTable dataTable;
    private app.common.controls.DatePickerControl dpBirthday;
    private app.common.controls.GroupBox groupInformation;
    private app.common.controls.ImagePicker imagePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}