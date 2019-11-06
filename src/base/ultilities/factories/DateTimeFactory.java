package base.ultilities.factories;

import base.configurations.constants.SystemConstants;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import org.apache.commons.lang.time.DateUtils;
import base.ultilities.helpers.FormatHelper;

public class DateTimeFactory {

    private static DateTimeFactory _instance;

    public static DateTimeFactory Instance() {
        if (_instance != null) {

        } else {
            _instance = new DateTimeFactory();
        }
        return _instance;
    }

    private DateTimeFactory() {
        dateFormatter = (SimpleDateFormat) FormatHelper.getSimpleDateFormat();
        minDate = getMinDate();
        stringBuilder = new StringBuilder();
    }

    SimpleDateFormat dateFormatter;
    StringBuilder stringBuilder;
    Date minDate;

    public Date getCurrentDate() {
        Date date = new Date(System.currentTimeMillis());
        return date;
    }

    public java.sql.Date getMinDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(0 + -9999, 01, 01, 0, 0, 0);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    public String getFormatedDateString(Date date) {
        stringBuilder.setLength(0);
        stringBuilder.append(dateFormatter.format(date));
        return stringBuilder.toString();
    }

    public Timestamp convertDateToTimestamp(Date date) {
        Timestamp ts = new Timestamp(date.getTime());
        return ts;
    }

    public String getFormatedDateString(java.util.Date date) {
        stringBuilder.setLength(0);
        stringBuilder.append(dateFormatter.format(date));
        return stringBuilder.toString();
    }

    public SimpleDateFormat getDateFormatter() {
        return this.dateFormatter;
    }

    public Locale getDateLocale() {
        return new Locale(SystemConstants.LANGUAGE_CODE_DEFAULT,SystemConstants.COUNTRY_CODE_DEFAULT);
        //return Locale;
    }

    public boolean isMinDate(Date date) {
        boolean isMD = DateUtils.isSameDay(date, minDate);

        return isMD;
    }
}
