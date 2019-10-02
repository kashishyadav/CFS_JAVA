package base.configurations.constants;

import java.awt.*;

public class SystemConstants {
    public final static int DEFAULT_OFFSET = 0;
    public final static int DEFAULT_PAGESIZE = 20;
    public final static int DEFAULT_SCREEN_WIDTH = 800;
    public final static int DEFAULT_SCREEN_HEIGHT = 600;
    public final static Dimension ClientSize = Toolkit.getDefaultToolkit().getScreenSize();
    public final static int CENTER_POSX = ClientSize.width/2 - DEFAULT_SCREEN_WIDTH/2;
    public final static int CENTER_POSY =  ClientSize.height/2 - DEFAULT_SCREEN_HEIGHT/2;;
    public final static String CURRENCY_FORMAT_STRING =  "%,.2f";
    public final static String DATE_FORMAT_STRING =  "dd-MM-yyyy";
}
