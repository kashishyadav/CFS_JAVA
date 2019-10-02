package base.guis.controls;




public abstract class BaseEditPanel<T,TDisplay> extends BaseComponent {

    public BaseEditPanel(T currentObj, T filterObj, TDisplay displayObj){
        this.setCurrentObj(currentObj);
        this.setFilterObj(filterObj);
        this.setDisplayObj(displayObj);
    }

    private T filterObj;
    private T currentObj;
    private TDisplay displayObj;

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

     public abstract void setTableModel();
     public abstract void Search();
}
