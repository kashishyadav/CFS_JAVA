/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.guis.controls.core;

import base.configurations.constants.RegexConstants;
import java.text.Format;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatter;

/**
 *
 * @author Khang
 */
public class BaseFormattedField extends JFormattedTextField  {
   public BaseFormattedField(){
        super();
   }
   public BaseFormattedField(Format formatter){
        super(formatter);
   }
   public BaseFormattedField(DefaultFormatter formatter){
       super(formatter);
   }
    public  boolean isNumeric(String strNum) {
        return strNum.matches(RegexConstants.RegxNumber());
    }
}
