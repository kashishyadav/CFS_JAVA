package base.guis.controls;


import base.applications.intfs.IBaseService;
import base.data.entities.EntityBase;
import base.guis.controls.core.GroupBox;
import base.guis.infs.IEditPanelUI;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




public abstract class BaseEditPanel<T,TDisplay> extends BaseComponent implements IEditPanelUI  {

    public BaseEditPanel(T currentObj, T filterObj, TDisplay displayObj){
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
    
    protected DefaultTableModel tableModel;
    
    private IBaseService<T,TDisplay> appService;
    
    
    private GroupBox groupInfomation;
    
    public void setGroupInformation(GroupBox groupInfomation){
        this.groupInfomation=groupInfomation;
    }

    public T getCurrentObj() {
        return currentObj;
    }

    public void setCurrentObj(T currentObj) {
        this.currentObj = currentObj;
    }

    public TDisplay getDisplayObj() {
        return displayObj;
    }

    public void setDisplayObj(TDisplay displayObj) {
        this.displayObj = displayObj;
    }

    public T getFilterObj() {
        return filterObj;
    }

    public void setFilterObj(T searchObj) {
        this.filterObj = searchObj;
    }

     public void refreshEditForm(){
         ((EntityBase) this.getCurrentObj()).setId(0);
         Component[] components = this.groupInfomation.getComponents();
         for(Component c: components ){
           if (c instanceof JTextField){
               JTextField textfield = (JTextField) c;
               textfield.setText(this.getEmptyText());
           }
         }
     }
     
     public  void setTableModel(DefaultTableModel tableModel){
         this.tableModel= tableModel;
     }
     public void setStoreProcedureNames(String sp_search, String sp_insOrUpd, String sp_getById){
         this.sp_search = sp_search;
         this.sp_insOrUpd = sp_insOrUpd;
         this.sp_getById = sp_getById;
     }
     
      public abstract void setTableColumns();
     public abstract void bindingModelToView();
     public abstract void bindingViewToModel();    
     public void search(){
        this.appService.search(sp_search, this.getFilterObj(), this.getDisplayObj(), this.tableModel);
     }
     
     public void save(){
         this.appService.save(this.sp_insOrUpd,this.currentObj);
     }
     
     public  void delete(){     
      this.appService.delete(this.sp_insOrUpd,this.currentObj);
     }
     
     public T getById(int id){
         return (T) appService.getById(sp_getById, this.currentObj);
     }
}
