package base.configurations.constants;

import java.awt.*;
import java.nio.file.Paths;
import javax.swing.ImageIcon;

public class SystemConstants {

    public final static int DEFAULT_OFFSET = 0;
    public final static int DEFAULT_PAGESIZE = 5;
    public final static int DEFAULT_FIRSTROW = 0;
    public final static int DEFAULT_LASTROW = 0;
    public final static int DEFAULT_SCREEN_WIDTH = 1200;
    public final static int DEFAULT_SCREEN_HEIGHT = 900;
    public final static Dimension ClientSize = Toolkit.getDefaultToolkit().getScreenSize();
    public final static int CENTER_POSX = ClientSize.width / 2 - DEFAULT_SCREEN_WIDTH / 2;
    public final static int CENTER_POSY = ClientSize.height / 2 - DEFAULT_SCREEN_HEIGHT / 2;
    ;
    public final static String CURRENCY_FORMAT_STRING = "%,.2f";
    public final static String DATE_FORMAT_STRING = "dd/MM/yyyy";
    public final static String LANGUAGE_CODE_DEFAULT = "vi";
    public final static String COUNTRY_CODE_DEFAULT = "VN";
    public static final String DOMAIN_FOLDER = Paths.get("").toAbsolutePath().toString();
    public static final String DATA_SOURCE_FOLDER = new StringBuilder("/dataSource").toString();
    public static final String IMG_SOURCE_FOLDER = new StringBuilder("/dataSource/images").toString();
    public static final String EXCEL_SOURCE_FOLDER = new StringBuilder("/dataSource/excels").toString();
    public static final String HOME_FOLDER_PATH = new StringBuilder(System.getProperty("user.home")).toString();
    public static final String DESKTOP_FOLDER_PATH = new StringBuilder(HOME_FOLDER_PATH).append("/Desktop").toString();

    public static final String STR_EMPLOYEES = new StringBuilder("Employees").toString();
    public static final String STR_PRODUCTS = new StringBuilder("Products").toString();
    public static final String STR_SYSTEMS = new StringBuilder("Systems").toString();

    public static final String NOIMAGE_PATH
            = new StringBuilder(DOMAIN_FOLDER).append(IMG_SOURCE_FOLDER).append("/").append(STR_SYSTEMS).append("/no-image.png").toString();
    public static final int IMG_ICON_LG_WIDTH = 128;
    public static final int IMG_ICON_LG_HEIGHT = 128;
    public static final int IMG_ICON_MD_WIDTH = 64;
    public static final int IMG_ICON_MD_HEIGHT = 64;
    public static final int IMG_ICON_SM_WIDTH = 32;
    public static final int IMG_ICON_SM_HEIGHT = 32;
}
