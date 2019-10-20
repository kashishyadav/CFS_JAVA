package base.configurations.constants;

import java.awt.*;

public class SystemConstants {
    public final static int DEFAULT_OFFSET = 0;
    public final static int DEFAULT_PAGESIZE = 5;
    public final static int DEFAULT_FIRSTROW = 0;
    public final static int DEFAULT_LASTROW = 0;
    public final static int DEFAULT_SCREEN_WIDTH = 1200;
    public final static int DEFAULT_SCREEN_HEIGHT = 800;
    public final static Dimension ClientSize = Toolkit.getDefaultToolkit().getScreenSize();
    public final static int CENTER_POSX = ClientSize.width/2 - DEFAULT_SCREEN_WIDTH/2;
    public final static int CENTER_POSY =  ClientSize.height/2 - DEFAULT_SCREEN_HEIGHT/2;;
    public final static String CURRENCY_FORMAT_STRING =  "%,.2f";
    public final static String DATE_FORMAT_STRING =  "dd/MM/yyyy";
    public final static String LANGUAGE_CODE_DEFAULT=  "vi";
    public final static String COUNTRY_CODE_DEFAULT=  "VN";
}
