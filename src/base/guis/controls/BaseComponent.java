package base.guis.controls;


import app.core.modules.constants.PageConstants;
import app.core.trade.guis.orders.OrderDetailEditPanel;
import app.mains.MainWindow;
import base.configurations.constants.SystemConstants;
import java.awt.Component;
import java.time.LocalDate;
import javax.swing.JDialog;
import javax.swing.JPanel;
import base.ultilities.factories.DateTimeFactory;

public class BaseComponent extends JPanel {
    public BaseComponent(){
        stringBuilder = new StringBuilder();
    }
    StringBuilder stringBuilder;
    
    public String getEmptyText(){
        stringBuilder.setLength(0);
        return stringBuilder.toString();
    }
    
    public java.sql.Date getMinDate(){
        return DateTimeFactory.Instance().getMinDate();
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
      public void initComponentDialog(Component component,JDialog jd){
       // JDialog jd = new JDialog(MainWindow.getInstance(), PageConstants.EDIT_DETAIL);
            jd.add(component);
            jd.setModal(true);
            jd.setResizable(false);
            jd.setBounds(SystemConstants.CENTER_POSX + SystemConstants.ClientSize.width / 4,
                    SystemConstants.CENTER_POSY + SystemConstants.ClientSize.height / 4, 479, 329);
            jd.setVisible(false);
    }
    
    public void showComponentDialog(Component component,JDialog jd){
       // JDialog jd = new JDialog(MainWindow.getInstance(), PageConstants.EDIT_DETAIL);
            jd.add(component);
            jd.setModal(true);
            jd.setResizable(false);
            jd.setBounds(SystemConstants.CENTER_POSX + MainWindow.getInstance().getWidth() / 4,
                    SystemConstants.CENTER_POSY + +MainWindow.getInstance().getHeight() / 4, 479, 329);
            jd.setVisible(true);
    }
    

}
