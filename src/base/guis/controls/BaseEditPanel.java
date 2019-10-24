package base.guis.controls;

import app.common.controls.DatePickerControl;
import base.applications.intfs.IBaseService;
import base.data.entities.EntityBase;
import app.common.controls.GroupBox;
import app.common.controls.ImagePicker;
import base.applications.imps.BaseService;
import base.applications.intfs.IDataTableDisplayMethod;
import base.configurations.constants.SystemStringConstants;
import base.data.entities.EntitySearchBase;
import base.guis.infs.IEditPanelUI;
import base.infrastructures.ComponentRunnable;
import java.awt.Component;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import ultilities.utils.MessageUtils;

public abstract class BaseEditPanel<T, TDisplay> extends BaseComponent implements IEditPanelUI {

    public BaseEditPanel(T currentObj, T filterObj, TDisplay displayObj) {
        this.setCurrentObj(currentObj);
        this.setFilterObj(filterObj);
        this.setDisplayObj(displayObj);

    }

    private T filterObj;
    private T currentObj;
    private TDisplay displayObj;

    private String sp_search;
    private String sp_insOrUpd;
    private String sp_getById;
    private JComponent idControl;
    private IDataTableDisplayMethod dtDisplayMethod;

    protected DefaultTableModel tableModel;
    protected boolean isAutoGenKey = false;

    protected IBaseService<T, TDisplay> appService;

    private GroupBox groupInfomation;

    public void setIsAutoGenKey(boolean isAutoGenKey) {
        this.isAutoGenKey = isAutoGenKey;
    }

    public boolean getIsAutoGenKey() {
        return this.isAutoGenKey;
    }

    public void setEnableIdControl(boolean isEnable) {
        if (this.idControl != null) {
            this.idControl.setEnabled(isEnable);
        }
    }

    public void setGroupInformation(GroupBox groupInfomation, String title) {
        this.groupInfomation = groupInfomation;
        this.groupInfomation.setTittle(title);
    }

    public String getStoredProcedureSearch() {
        return this.sp_search;
    }

    public String getStoredProcedureById() {
        return this.sp_getById;
    }

    public String getStoredProcedureInsOrUpd() {
        return this.sp_insOrUpd;
    }

    public IBaseService<T, TDisplay> getAppService() {
        return this.appService;
    }

    public JComponent getIdControl() {
        return this.idControl;
    }

    public T getCurrentObj() {
        return currentObj;
    }

    public void setCurrentObj(T currentObj) {
        this.currentObj = currentObj;
    }

    public void setIdControl(JComponent idControl) {
        this.idControl = idControl;
    }

    public TDisplay getDisplayObj() {
        return displayObj;
    }

    public void setDisplayObj(TDisplay displayObj) {
        this.displayObj = displayObj;
        System.gc();
    }

    public T getFilterObj() {
        return filterObj;
    }

    public void setFilterObj(T searchObj) {
        this.filterObj = searchObj;
        System.gc();
    }

    public void setDataTableDisplayMethod(IDataTableDisplayMethod dtDisplayMethod) {
        this.dtDisplayMethod = dtDisplayMethod;
    }

    public GroupBox getGroupInformation() {
        return this.groupInfomation;
    }

    public void refreshEditForm() {
        ((EntityBase) this.getCurrentObj()).setId(0);
        if (!this.isAutoGenKey) {
            this.setEnableIdControl(true);
        } else {
            this.setEnableIdControl(false);
        }
        this.groupInfomation.setEditStatusTitle(SystemStringConstants.STR_ADD);
        Component[] components = this.groupInfomation.getComponents();
        for (Component c : components) {
            if (c instanceof JTextComponent) {
                JTextComponent textfield = (JTextComponent) c;
                textfield.setText(this.getEmptyText());
            } else if (c instanceof DatePickerControl) {                
                ((DatePickerControl)c).setValue(null);
            } else if (c instanceof ImagePicker){
                ((ImagePicker) c).setValue(null);
            }
        }
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
        System.gc();
    }

    public void setStoreProcedureNames(String sp_search, String sp_insOrUpd, String sp_getById) {
        this.sp_search = sp_search;
        this.sp_insOrUpd = sp_insOrUpd;
        this.sp_getById = sp_getById;
    }

    public abstract void setTableColumns();

    public abstract void bindingModelToView();

    public abstract void bindingViewToModel();

    public void search() {
        new Thread(new ComponentRunnable(this) {
            @Override
            public void run() {
                try {
                    BaseEditPanel tmpComponent = (BaseEditPanel) this.getComponent();
                    tmpComponent.appService.search(sp_search, tmpComponent.getFilterObj(), tmpComponent.getDisplayObj(), tmpComponent.tableModel);
                    if (tmpComponent.dtDisplayMethod != null) {
                        EntitySearchBase searchDto = ((EntitySearchBase) tmpComponent.getFilterObj());
                        tmpComponent.dtDisplayMethod.setPageNumberLabel(searchDto.getOffset(), searchDto.getPageCount());
                        tmpComponent.dtDisplayMethod.setTotalCountLabel(searchDto.getTotalCount());
                        tmpComponent.dtDisplayMethod.setEnableSearchButton(true);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }).start();
    }

    public void save() {
        Map<String, Object> result = this.appService.save(this.sp_insOrUpd, this.currentObj);
        if (!result.get("Result").equals("1")) {
            MessageUtils.showErrorMessage(this, (String) result.get("ErrorDesc"));
        } else {
            MessageUtils.showSuccessMessage(this, SystemStringConstants.STR_SAVE_SUCCESS);
        }
    }

    public void delete() {
        Map<String, Object> result = this.appService.delete(this.sp_insOrUpd, this.currentObj);
        if (!result.get("Result").equals("1")) {
            MessageUtils.showErrorMessage(this, (String) result.get("ErrorDesc"));
        } else {
            MessageUtils.showSuccessMessage(this, SystemStringConstants.STR_DEL_SUCCESS);
        }
    }

    public T getById(int id) {
        ((EntityBase) this.getCurrentObj()).setId(id);
        return (T) appService.getById(sp_getById, this.currentObj);
    }
}
