/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultilities.helpers;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.SwingConstants;

/**
 *
 * @author Khang
 */
public class NumberRendererHelper extends FormatRenderHelper {
   
    public NumberRendererHelper(NumberFormat formatter)
	{
		super(formatter);
		setHorizontalAlignment( SwingConstants.RIGHT );              
	}

	/*
	 *  Use the default currency formatter for the default locale
	 */
	public static NumberRendererHelper getCurrencyRenderer()
	{
		//return new NumberRendererHelper( NumberFormat.getCurrencyInstance(new Locale("vi", "VN")) );
            return new NumberRendererHelper( FormatHelper.getCurrencyFormat());
	}

	/*
	 *  Use the default integer formatter for the default locale
	 */
	public static NumberRendererHelper getIntegerRenderer()
	{
		return new NumberRendererHelper( NumberFormat.getIntegerInstance() );
	}

	/*
	 *  Use the default percent formatter for the default locale
	 */
	public static NumberRendererHelper getPercentRenderer()
	{
		return new NumberRendererHelper( NumberFormat.getPercentInstance() );
	}
}
