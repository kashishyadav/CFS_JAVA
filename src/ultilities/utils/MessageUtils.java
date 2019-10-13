/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultilities.utils;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Khang
 */
public class MessageUtils {
        public  static void showSuccessMessage(JComponent component, String title){
        JOptionPane.showMessageDialog(component,title);
    }
     public static void showWarningMessage(JComponent component,String title){
        JOptionPane.showMessageDialog(component,title,"Cảnh báo", JOptionPane.WARNING_MESSAGE);
    }
      public static void showErrorMessage(JComponent component,String title){
         JOptionPane.showMessageDialog(component,title,"Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}
