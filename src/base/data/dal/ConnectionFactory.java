package base.data.dal;

import base.data.dtos.CallableParameter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import base.ultilities.factories.DateTimeFactory;

public class ConnectionFactory {

    private static ConnectionFactory _instance;

    public static ConnectionFactory Instance() {
        if (_instance == null) {
            _instance = new ConnectionFactory();
        }
        _instance.IsTransaction = false;
        return _instance;
    }

    private ConnectionFactory() {
        simpleDateFormat = DateTimeFactory.Instance().getDateFormatter();
        minDate = DateTimeFactory.Instance().getMinDate();
    }

    private final String DB_URL = "jdbc:mysql://localhost:3306/coffeeshopdb?characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER_NAME = "root";
    private final String PASSWORD = "";

    private java.sql.Date minDate;
    private SimpleDateFormat simpleDateFormat;

    //Connection conn = null;
    boolean IsTransaction = false;

    public Connection getConnection() {
        Connection conn = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");

        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    /**
     * **********************************************************
     * Call Procedure(One only Out Parameter)
     * **********************************************************
     */
    public CallableStatement buildProcedureCallableStatement(Connection conn, String sql, Map<String, Object> pmap) {
        CallableStatement cs = null;
        try {
            Map<String, Object> paramMap = new LinkedHashMap<String, Object>();
            List<CallableParameter> outParams = new ArrayList<CallableParameter>();
            int leftParnPos = sql.indexOf("(");
            int rightParnPos = sql.indexOf(")");
            String paramStr = "";
            if (leftParnPos > -1 && rightParnPos > -1) {
                paramStr = sql.substring(leftParnPos + 1, rightParnPos);
            }
            int oracleCursorIndex = -1, paramIndex = 0;

            String[] str = paramStr.split(",");
            for (String param : str) {
                paramIndex++;
                param = param.trim();
                if (param.toLowerCase().startsWith("!")) {
                    sql = sql.replaceFirst(param, "?");
                    oracleCursorIndex = paramIndex;
                    String paramName = param.substring(1, param.length());
                    if (paramName.substring(0, 1) != "p") {
                        paramName = String.format("p_%s", paramName.substring(0, 1).toUpperCase() + paramName.substring(1));
                    }
                    CallableParameter cp = new CallableParameter(paramName, pmap.get(paramName), true);
                    outParams.add(cp);
                    continue;
                } else if (!param.startsWith(":")) {
                    continue;
                }
                sql = sql.replaceFirst(param, "?");
                String paramName = param.substring(1, param.length());
                if (paramName.substring(0, 1) != "p") {
                    paramName = String.format("p_%s", paramName.substring(0, 1).toUpperCase() + paramName.substring(1));
                }
                Object paramValue = pmap.get(paramName);
                paramMap.put(paramName, (paramValue == null ? "" : paramValue));
                //System.out.println(paramName+" - "+ paramValue);
            }
            String procedure = "{" + sql + "}";
            cs = conn.prepareCall(procedure);
            int index = 1;
            for (String name : paramMap.keySet()) {
                Object value = paramMap.get(name);
                if (value == null) {
                    cs.setObject(index, null);
                } else {
                    if (value instanceof String) {
                        if (((String) value).isEmpty()) {
                            if (name.contains("date") || (name.contains("day"))) {
                                cs.setObject(index, null);
                            } else {
                                cs.setString(index, (String) value);
                            }
                        } else {
                            cs.setString(index, (String) value);
                        }
                    } else if (value instanceof Date) {
                        Date date = (Date) value;
                        if (date != null && DateTimeFactory.Instance().isMinDate(date) || date == null) {
                            cs.setObject(index, null);
                        } else {
                            cs.setDate(index, new java.sql.Date(date.getTime()));
                        }

                    } else if (value instanceof Integer) {
                        if ((Integer) value == 0) {
                            cs.setObject(index, null);
                        } else {
                            cs.setInt(index, (Integer) value);
                        }
                    } else if (value instanceof Float) {
                        cs.setFloat(index, (Float) value);
                    } else if (value instanceof Double) {
                        cs.setDouble(index, (Double) value);
                    } else {
                        cs.setObject(index, value);
                    }
                }

                index++;
            }
            if (outParams.size() > 0) {
                for (CallableParameter cp : outParams) {
                    cs.registerOutParameter(cp.getName(), cp.getOutValueType());
                }
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            return cs;
        }
    }

    public void closeConn(Connection conn) {
        try {

            if (conn != null) {
                conn.close();
                conn = null;
                System.out.println("Close Connection Successfully");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void closeCStmt(CallableStatement cStmt) {
        try {

            if (cStmt != null) {
                cStmt.close();
                cStmt = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    public void closeConn(CallableStatement cStmt, Connection conn) {
        try {
            if (cStmt != null) {
                cStmt.close();
                cStmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
}
