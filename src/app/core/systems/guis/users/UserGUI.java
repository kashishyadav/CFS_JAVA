/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.systems.guis.users;

import app.common.controls.Selector;
import app.common.modules.constants.PageConstants;
import app.common.modules.constants.StoreConstants;
import app.core.systems.dtos.roles.RoleEntity;
import app.core.systems.dtos.users.UserDisplayDto;
import app.core.systems.dtos.users.UserEntity;
import app.core.trade.dtos.employees.EmployeeEntity;

import base.applications.imps.BaseService;
import base.configurations.constants.SystemStringConstants;
import base.data.dal.StoreProvider;

import base.guis.controls.BaseEditPanel;
import base.infrastructures.manipulations.ComponentRunnable;
import base.infrastructures.systems.AppContext;
import base.ultilities.helpers.FormatRenderHelper;
import base.ultilities.utils.RegexUtils;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Khang
 */
public class UserGUI extends BaseEditPanel {

    /**
     * Creates new form UserGUI
     */
    StoreProvider roleProvider;
    StoreProvider employeeProvider;

    public UserGUI() {
        super(new UserEntity(), new UserEntity(), new UserDisplayDto());
        initComponents();
        init();
    }

    private void init() {

        this.appService = new BaseService(UserEntity.class, UserDisplayDto.class);

        dataTable.setEditPanel(this);

        this.setIdControl(txtUserName);
        this.tableModel = (DefaultTableModel) dataTable.getTable().getModel();
        this.appCrudToolBar1.setEditPanelUI(this);
        this.setGroupInformation(this.gbInfo, PageConstants.USER);
        setTableColumns();
        this.setIdControl(txtUserName);
        //this.setIsAutoGenKey(true);

        // set store procedure names
        this.setStoreProcedureNames(
                StoreConstants.USER_SEARCH,
                StoreConstants.USER_INSORUPD,
                StoreConstants.USER_BYID);

        //COMBOBOX
        //Selector(combobox) StoreProvider
        this.roleProvider = new StoreProvider(RoleEntity.class);
        this.employeeProvider = new StoreProvider(EmployeeEntity.class);
        initSelector();
        //
        //
        this.dataTable.onResetSearch();

    }

    @Override
    public String strIsValid() {
        String strError = this.getEmptyText();
        UserEntity entity = ((UserEntity) this.getCurrentObj());
        if (!RegexUtils.isMatchCode(entity.getUserName())
                || entity.getUserName() != null && entity.getUserName().length() < AppContext.getInstance().getRequiredUserNameLength()) {
            strError = SystemStringConstants.STR_ERROR_USERNAME_INVALID;
        } else if (entity.getPassword()== null || entity.getPassword().length() < AppContext.getInstance().getRequiredPasswordLength()) {
            strError = SystemStringConstants.STR_ERROR_PASSWORD_INVALID;
        }
        return strError;
    }

    @Override
    public void setTableColumns() {

        String[] headers = new String[]{
            //0     1           2                3              4         5        6       7         8               
            "STT", "Id", "Tên đăng nhập ", "Mã quyền", "Tên quyền", "Mã NV", "Tên NV", "Ngày tạo", "Người tạo"};
        tableModel.setColumnIdentifiers(headers);

        TableColumnModel colModel = dataTable.getTable().getColumnModel();
        this.dataTable.hideColumnAt(1);
        //format cho các cột       
        colModel.getColumn(7).setCellRenderer(FormatRenderHelper.getDateRenderer());
    }

    @Override
    public void bindingModelToView() {
        //System.out.println(txtPrice.getValue());
        UserEntity entity = (UserEntity) this.getCurrentObj();
        txtUserName.setText(entity.getUserName());
        txtPassword.setText(entity.getPassword());
        selectorEmployee.setValue(entity.getEmployeeId());
        selectorRole.setValue(entity.getRoleId());
    }

    @Override
    public void bindingViewToModel() {
        UserEntity entity = (UserEntity) this.getCurrentObj();
        entity.setUserName(txtUserName.getText());
        entity.setPassword(new String(txtPassword.getPassword()));
        entity.setRoleId((int) selectorRole.getSelectedValue());
        entity.setEmployeeId((int) selectorEmployee.getSelectedValue());
    }

    public void initSelector() {
        this.getRoleSelector().setDisplayMember("name");
        Runnable runnableRole = new ComponentRunnable(this) {
            @Override
            public void run() {
                try {
                    RoleEntity roleEntity = new RoleEntity();
                    roleEntity.setOffset(-1);
                    List<Map<String, Object>> categories = roleProvider.executeToListMapProperties(
                            StoreConstants.ROLE_SEARCH, roleEntity);
                    ((UserGUI) this.getComponent()).getRoleSelector().setDataSource(categories);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                } finally {
                    System.gc();
                }
            }
        };
        Thread threadRole = new Thread(runnableRole);
        threadRole.start();

        this.getEmployeeSelector().setDisplayMember("name");
        Runnable runnableEmployee = new ComponentRunnable(this) {
            @Override
            public void run() {
                try {
                    EmployeeEntity employeeEntity = new EmployeeEntity();
                    employeeEntity.setOffset(-1);
                    List<Map<String, Object>> categories = employeeProvider.executeToListMapProperties(
                            StoreConstants.EMPLOYEE_SEARCH, employeeEntity);
                    ((UserGUI) this.getComponent()).getEmployeeSelector().setDataSource(categories);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                } finally {
                    System.gc();
                }
            }
        };
        Thread threadEmployee = new Thread(runnableEmployee);
        threadEmployee.start();
    }

    public Selector getRoleSelector() {
        return this.selectorRole;
    }

    public Selector getEmployeeSelector() {
        return this.selectorEmployee;
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
        txtUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        selectorEmployee = new app.common.controls.Selector();
        jLabel4 = new javax.swing.JLabel();
        selectorRole = new app.common.controls.Selector();
        appCrudToolBar1 = new app.common.controls.AppCrudToolBar();
        dataTable = new app.common.controls.DataTable();

        jLabel1.setText("Tên đăng nhập:");

        jLabel2.setText("Mật khẩu:");

        jLabel3.setText("Quyền:");

        jLabel4.setText("Nhân viên ( *):");

        javax.swing.GroupLayout gbInfoLayout = new javax.swing.GroupLayout(gbInfo);
        gbInfo.setLayout(gbInfoLayout);
        gbInfoLayout.setHorizontalGroup(
            gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtUserName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectorRole, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectorEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        gbInfoLayout.setVerticalGroup(
            gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(selectorEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gbInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(selectorRole, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(appCrudToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 39, Short.MAX_VALUE))
                    .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(appCrudToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addGap(80, 80, 80))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.common.controls.AppCrudToolBar appCrudToolBar1;
    private app.common.controls.DataTable dataTable;
    private app.common.controls.GroupBox gbInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private app.common.controls.Selector selectorEmployee;
    private app.common.controls.Selector selectorRole;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
