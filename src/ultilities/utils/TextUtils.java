/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultilities.utils;

import java.awt.Font;

/**
 *
 * @author Khang
 */
public class TextUtils {    
    public static Font getDefaultFont(){
       return new Font("Arial", Font.BOLD | Font.ITALIC, 14);
    }
    
     public static Font getSelectorFont(){
       return new Font("Arial", Font.BOLD | Font.ITALIC, 14);
    }
}
