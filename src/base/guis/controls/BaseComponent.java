package base.guis.controls;


import javax.swing.JPanel;

public class BaseComponent extends JPanel {
    public BaseComponent(){
        stringBuilder = new StringBuilder();
    }
    StringBuilder stringBuilder;
    
    public String getEmptyText(){
        stringBuilder.setLength(0);
        return stringBuilder.toString();
    }
    
    public boolean isNull(Object obj){
        if(obj == null)
            return true;
        if(obj.getClass() == String.class){
            if(((String)(obj)).equals(getEmptyText())){
                return true;
            }
        }
        
        return false;
    }
    

}
