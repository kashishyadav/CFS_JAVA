package ultilities.factories;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class DateTimeFactory {
    private static DateTimeFactory _instance;
    public static DateTimeFactory Instance(){
        if(_instance!=null){

        }else{
            _instance = new DateTimeFactory();
        }
        return _instance;
    }
    private DateTimeFactory(){
        dateFormatter  = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dateSqlFormatter  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        stringBuilder=new StringBuilder();
    }

    SimpleDateFormat dateFormatter;
    SimpleDateFormat dateSqlFormatter;
    StringBuilder stringBuilder;


    public Date getCurrentDate(){
        Date date = new Date(System.currentTimeMillis());
        return date;
    }



    public String getFormatedDateString(Date date){
        stringBuilder.setLength(0);
        stringBuilder.append(dateFormatter.format(date));
        return stringBuilder.toString();
    }

    public Timestamp convertDateToTimestamp(Date date){
        Timestamp ts = new Timestamp(date.getTime());
        return ts;
    }

    public String getFormatedDateString(java.util.Date date){
        stringBuilder.setLength(0);
        stringBuilder.append(dateFormatter.format(date));
        return stringBuilder.toString();
    }

}
