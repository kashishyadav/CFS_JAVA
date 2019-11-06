/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.ultilities.helpers;

import java.text.ParseException;
import java.util.Calendar;
import javax.swing.JFormattedTextField.AbstractFormatter;

/**
 *
 * @author Khang
 */
public class FormatDateLabelHepler extends AbstractFormatter {

    @Override
    public Object stringToValue(String text) throws ParseException {
        return FormatHelper.getSimpleDateFormat().parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return FormatHelper.getSimpleDateFormat().format(cal.getTime());
        }

        return "";
    }
}
