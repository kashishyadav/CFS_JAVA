package base.data.dal;

import base.data.dtos.CallableParameter;
import base.data.enums.CallableType;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConnectionFactory {
    private static ConnectionFactory _instance;
    public static ConnectionFactory Instance(){
        if(_instance==null)
            _instance = new ConnectionFactory();
        _instance.IsTransaction = false;
        return _instance;
    }

    private final  String DB_URL = "jdbc:mysql://localhost:3306/coffeeshopdb";
    private final  String USER_NAME = "root";
    private final  String PASSWORD = "";

    Connection conn = null;
    boolean IsTransaction = false;

    public  Connection getConnection() {
        try {
            if(conn==null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
                System.out.println("connect successfully!");
            }
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }


    /************************************************************
     * Call Procedure(One only Out Parameter)
     ************************************************************/
//    public int CallProcedure(String sql, List<CallableParameter> binds) throws Exception{
//        CallableStatement cStmt = null;
//        try{
//            if (conn == null) {
//                conn = getConnection();
//            }
//
//            cStmt = conn.prepareCall(sql);
//            int retIdx = 0;
//            if (binds != null) {
//                for (int i = 1; i<= binds.size(); i++) {
//                    if (binds.get(i - 1).getType() == CallableType.IN){
//                        cStmt.setObject(i, binds.get(i - 1).getValue());
//                    }else{
//                        retIdx = i;
//                        cStmt.registerOutParameter(i, binds.get(i - 1).getOutValueType());
//                    }
//
//                }
//            }
//
//            int ret = cStmt.executeUpdate();
//
//            if (conn != null && IsTransaction == false) {
//                conn.commit();
//            }
//
//            if (retIdx != 0){
//                binds.get(retIdx).setValue(cStmt.getObject(retIdx));
//            }
//
//            return ret;
//        }catch(SQLException e){
//            System.out.println(e.toString());
//            throw e;
//        }finally {
//            CloseConn(cStmt);
//        }
//    }

    public  CallableStatement buildProcedureCallableStatement(String sql,Map<String, Object> pmap){
        CallableStatement cs = null;
        try {
            Map<String,Object> paramMap=new LinkedHashMap<String,Object>();
            int leftParnPos=sql.indexOf("(");
            int rightParnPos=sql.indexOf(")");
            String paramStr="";
            if(leftParnPos>-1 && rightParnPos>-1){
                paramStr=sql.substring(leftParnPos+1,rightParnPos);
            }
            int oracleCursorIndex=-1,paramIndex=0;
            String[] str=paramStr.split(",");
            for(String param:str){
                paramIndex++;
                param=param.trim();
                if(param.toLowerCase().equals("oracle")){
                    sql=sql.replaceFirst(param, "?");
                    oracleCursorIndex=paramIndex;
                    continue;
                }else if(!param.startsWith(":")){
                    continue;
                }
                sql=sql.replaceFirst(param, "?");
                String paramName=param.substring(1,param.length());
                if(paramName.substring(0,1)!="p"){
                    paramName =  String.format("p_%s",paramName.substring(0, 1).toUpperCase() + paramName.substring(1));
                }
                Object paramValue = pmap.get(paramName);
                paramMap.put(paramName, (paramValue==null ? "" : paramValue));
                //System.out.println(paramName+" - "+ paramValue);
            }
            String procedure="{"+sql+"}";
           cs= getConnection().prepareCall(procedure);
            int index=1;
            for(String name:paramMap.keySet()){
                Object value=paramMap.get(name);
                if(value instanceof String){
                    cs.setString(index,(String)value);
                }else if(value instanceof Date){
                    Date date=(Date)value;
                    cs.setDate(index, new java.sql.Date(date.getTime()));
                }else if(value instanceof Integer){
                    cs.setInt(index, (Integer)value);
                }else if(value instanceof Float){
                    cs.setFloat(index, (Float)value);
                }else if(value instanceof Double){
                    cs.setDouble(index, (Double)value);
                }else{
                    cs.setObject(index, value);
                }
                index++;
            }
            if(oracleCursorIndex>-1){
                cs.registerOutParameter(oracleCursorIndex, -10);
            }

        } catch (SQLException e) {
           System.out.println(e.toString());
        }finally {
            return cs;
    }
}
//    private  void PreparedStmtSetValue(PreparedStatement pStmt, int idx, Object obj) throws SQLException{
//        if (obj instanceof String) {
//            pStmt.setString(idx, (String) obj);
//        } else if(obj instanceof Integer){
//            pStmt.setInt(idx, (Integer) obj);
//        } else if(obj instanceof BigDecimal){
//            pStmt.setBigDecimal(idx, (BigDecimal) obj);
//        } else if(obj instanceof Double){
//            pStmt.setDouble(idx, (Double) obj);
//        } else if(obj instanceof Date){
//            pStmt.setDate(idx, (Date) obj);
//        } else if(obj instanceof byte[]){
//            pStmt.setBytes(idx, (byte[]) obj);
//        } else{
//            pStmt.setObject(idx, obj);
//        }
//    }

//    private  void PreparedStmtSetValue(CallableStatement cStmt, int idx, Object obj) throws SQLException {
//        if (obj instanceof String) {
//            callableStatement.setString(idx, (String) obj);
//        } else if(obj instanceof Integer){
//            callableStatement.setInt(idx, (Integer) obj);
//        } else if(obj instanceof BigDecimal){
//            callableStatement.setBigDecimal(idx, (BigDecimal) obj);
//        } else if(obj instanceof Double){
//            callableStatement.setDouble(idx, (Double) obj);
//        } else if(obj instanceof Date){
//            callableStatement.setDate(idx, (Date) obj);
//        } else if(obj instanceof byte[]){
//            callableStatement.setBytes(idx, (byte[]) obj);
//        } else{
//            callableStatement.setObject(idx, obj);
//        }
//    }

//    public void CloseConn(PreparedStatement pStmt) {
//        try{
//            if(pStmt != null) {
//                pStmt.close();
//            }
//            if (conn != null && IsTransaction == false) {
//                conn.commit();
//                conn.close();
//                conn = null;
//            }
//        }catch(Exception e){
//            System.out.println(e.toString());
//        }
//    }

    public void closeConn(CallableStatement cStmt) {
        try{
            if(cStmt != null) {
                cStmt.close();
                cStmt=null;
            }
            if (conn != null ) {
                conn.close();
                conn = null;
                System.out.println("Close Connection Successfully");
            }
        }catch(Exception e){
           System.out.println(e.toString());
        }
    }

}
