/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.ultilities.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Khang
 */
public class RegexUtils {

    //private static final String codeRexPattern = "^[A-Za-z][A-Za-z0-9.\\-]*$";

    private static boolean isMatch(String strInput, String strRexPattern) {
        if (strInput == null || strInput != null && strInput.isEmpty()
                || strRexPattern == null || strRexPattern != null && strRexPattern.isEmpty()) {
            return false; 
        }
        Pattern  pattern = Pattern.compile(strRexPattern);
        Matcher m = pattern.matcher(strInput);
        if (m.matches()) {
            return true;
        }
        
        return false;
    }

    public static boolean isMatchCode(String strInput) {
        return isMatch(strInput,"^[A-Za-z][A-Za-z0-9.\\-]*$");
    }
}
