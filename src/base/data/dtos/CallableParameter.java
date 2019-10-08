package base.data.dtos;

import base.data.enums.CallableType;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLType;
import java.sql.Types;

public class CallableParameter {
    private final CallableType type;
    private  Integer outtype;
    private SQLType sqlType;
    private Object value;
    private String name;

    public CallableParameter(Object value){
        this.type = CallableType.IN;
        this.outtype = null;
        this.value = value;
    }

    public CallableParameter(int outtype){
        this.type = CallableType.OUT;
        this.outtype = outtype;
        this.value = null;
    }
       public CallableParameter(String name, Object value,boolean isOutputType ){
         if(isOutputType){
                this.type = CallableType.OUT;  
                genOutputType(value);
         }else{
            this.type = CallableType.IN; 
         }
             
        this.value = value;
        this.name = name;
      
    }

     private void genOutputType(Object value){
          if(value instanceof String){
                    this.outtype = Types.NVARCHAR;
                }else if(value instanceof Date){
                    Date date=(Date)value;
                  this.outtype = Types.DATE;
                }else if(value instanceof Integer){
                   this.outtype = Types.INTEGER;
                }else if(value instanceof Float){
                   this.outtype = Types.FLOAT;
                }else if(value instanceof Double){
                    this.outtype = Types.DOUBLE;
                } else if(value instanceof BigDecimal){
                    this.outtype = Types.DECIMAL;
                }else{
                   this.outtype = Types.INTEGER;
                }
     }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public CallableType getType(){
        return type;
    }

    public Object getValue(){
        return value;
    }

    public int getOutValueType(){
        return outtype;
    }

    public void setValue(Object value){
        this.value = value;
    }
}
