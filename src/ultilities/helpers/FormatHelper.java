package ultilities.helpers;


import java.text.DateFormat;
import static java.text.DateFormat.DEFAULT;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khang
 */
public class FormatHelper {
    public static NumberFormat getCurrencyUnitFormat(){
        return NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    }
     public static NumberFormat getNumberFormat(){
        return  NumberFormat.getInstance();
    }
   public static NumberFormat getIntegerFormat(){
        return (NumberFormat) NumberFormat.getIntegerInstance();
    }

    public static DateFormat getSimpleDateFormat(){
        return  SimpleDateFormat.getDateInstance(DEFAULT,new Locale("vi","VN"));
    }
    
    public static DecimalFormat getCurrencyFormat(){
        return (DecimalFormat) DecimalFormat.getInstance();
    }
}
