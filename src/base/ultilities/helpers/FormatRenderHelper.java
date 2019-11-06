/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.ultilities.helpers;

import base.configurations.constants.SystemConstants;
import java.text.DateFormat;
import static java.text.DateFormat.DEFAULT;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Khang
 */
public class FormatRenderHelper extends DefaultTableCellRenderer {
       private Format formatter;
       
	/*
	 *   Use the specified formatter to format the Object
	 */
	public FormatRenderHelper(Format formatter)
	{
		this.formatter = formatter;              
	}

	public void setValue(Object value)
	{
		//  Format the Object before setting its value in the renderer

		try
		{
			if (value != null)
				value = formatter.format(value);
		}
		catch(IllegalArgumentException e) {}

		super.setValue(value);
	}

	/*
	 *  Use the default date/time formatter for the default locale
	 */
	public static FormatRenderHelper getDateTimeRenderer()
	{
		return new FormatRenderHelper( DateFormat.getDateTimeInstance() );
	}

        public static FormatRenderHelper getDateRenderer()
	{
		//return new FormatRenderHelper( SimpleDateFormat.getDateInstance(DEFAULT,new Locale("vi","VN"))  );
            return new FormatRenderHelper( FormatHelper.getSimpleDateFormat());
	}
	/*
	 *  Use the default time formatter for the default locale
	 */
	public static FormatRenderHelper getTimeRenderer()
	{
		return new FormatRenderHelper( DateFormat.getTimeInstance() );
	}
}
