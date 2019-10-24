package base.data.dal;

import base.data.dtos.PagedDto;
import base.data.dtos.ResultDto;
import base.data.entities.EntitySearchBase;
import ultilities.helpers.ReflectionExHelper;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

public class StoreProvider<T> {

    private T tObject;
    private Class<T> tclass;

    private StoreProvider() {

    }

    public StoreProvider(Class<T> tclass)
            throws InstantiationException, IllegalAccessException {
        try {
            this.tclass = tclass;
            this.tObject = (T) tclass.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public Map<String, Object> executeToMap(String sp_name, Object parametersObj) throws Exception {
        Map<String, Object> mapResult = new HashMap<String, Object>();
        try (Connection conn = ConnectionFactory.Instance().getConnection()) {
            Map<String, Object> map = ReflectionExHelper.reflectObjectToMap(parametersObj);
            try (CallableStatement cstmt = ConnectionFactory.Instance().buildProcedureCallableStatement(conn, sp_name, map)) {
                ResultSet resultSet = cstmt.executeQuery();
                while (resultSet.next()) {
                    ResultDto obj = new ResultDto();
                    ReflectionExHelper.loadResultSetIntoObject(resultSet, obj);
                    ReflectionExHelper.loadObjectIntoMap(obj, mapResult);
                }
                ConnectionFactory.Instance().closeCStmt(cstmt);
            }
            ConnectionFactory.Instance().closeConn(conn);
            System.gc();
        }
        return mapResult;
    }

    public T executeToObject(String sp_name, Object parametersObj) throws Exception {
        T objResult = (T) this.tObject.getClass().getDeclaredConstructor().newInstance();
        try (Connection conn = ConnectionFactory.Instance().getConnection()) {
            Map<String, Object> map = ReflectionExHelper.reflectObjectToMap(parametersObj);
            try (CallableStatement cstmt = ConnectionFactory.Instance().buildProcedureCallableStatement(conn, sp_name, map)) {
                ResultSet resultSet = cstmt.executeQuery();
                while (resultSet.next()) {
                    ReflectionExHelper.loadResultSetIntoObject(resultSet, objResult);
                }
                ConnectionFactory.Instance().closeCStmt(cstmt);
            }
            ConnectionFactory.Instance().closeConn(conn);
            System.gc();
        }
        return objResult;
    }

    public List<T> executeToList(String sp_name, Object parametersObj) throws Exception {
        List<T> list = new ArrayList<T>();
        try (Connection conn = ConnectionFactory.Instance().getConnection()) {
            Map<String, Object> map = ReflectionExHelper.reflectObjectToMap(parametersObj);
            try (CallableStatement cstmt = ConnectionFactory.Instance().buildProcedureCallableStatement(conn, sp_name, map)) {
                ResultSet resultSet = cstmt.executeQuery();
                while (resultSet.next()) {
                    T item = (T) this.tObject.getClass().getDeclaredConstructor().newInstance();
                    ReflectionExHelper.loadResultSetIntoObject(resultSet, item);
                    list.add(item);
                }
                ConnectionFactory.Instance().closeCStmt(cstmt);
            }
            ConnectionFactory.Instance().closeConn(conn);
            System.gc();
        }
        return list;
    }

    public List<Map<String, Object>> executeToListMapProperties(String sp_name, Object parametersObj) throws Exception {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try (Connection conn = ConnectionFactory.Instance().getConnection()) {
            Map<String, Object> map = ReflectionExHelper.reflectObjectToMap(parametersObj);
            try (CallableStatement cstmt = ConnectionFactory.Instance().buildProcedureCallableStatement(conn, sp_name, map)) {
                ResultSet resultSet = cstmt.executeQuery();
                T item = (T) this.tObject.getClass().getDeclaredConstructor().newInstance();
                while (resultSet.next()) {
                    Map<String, Object> mapProperties = new HashMap<String, Object>();
                    ReflectionExHelper.loadResultSetIntoMapProperties(resultSet, item, mapProperties);
                    list.add(mapProperties);
                }
                ConnectionFactory.Instance().closeCStmt(cstmt);
            }
            ConnectionFactory.Instance().closeConn(conn);
            System.gc();
        }
        return list;
    }

    public ResultSet executeToResultSet(String sp_name, Object parametersObj) throws Exception {
        ResultSet resultSet = null;
        try (Connection conn = ConnectionFactory.Instance().getConnection()) {
            Map<String, Object> map = ReflectionExHelper.reflectObjectToMap(parametersObj);
            try (CallableStatement cstmt = ConnectionFactory.Instance().buildProcedureCallableStatement(conn, sp_name, map)) {
                resultSet = cstmt.executeQuery();
                ConnectionFactory.Instance().closeCStmt(cstmt);
            }
            ConnectionFactory.Instance().closeConn(conn);
            System.gc();
        }

        return resultSet;
    }

    public PagedDto<T> executeToPagedDto(String sp_name, Object parametersObj) throws Exception {
        PagedDto<T> pagedDto = new PagedDto<T>();
        try (Connection conn = ConnectionFactory.Instance().getConnection()) {
            Map<String, Object> map = ReflectionExHelper.reflectObjectToMap(parametersObj);
            try (CallableStatement cstmt = ConnectionFactory.Instance().buildProcedureCallableStatement(conn, sp_name, map)) {
                ResultSet resultSet = cstmt.executeQuery();
                int counter = 0;
                while (resultSet.next()) {
                    T item = (T) this.tObject.getClass().getDeclaredConstructor().newInstance();
                    ReflectionExHelper.loadResultSetIntoObject(resultSet, item);
                    pagedDto.getItems().add(item);
                    counter++;
                }
                pagedDto.setRowCount(counter);
                ConnectionFactory.Instance().closeCStmt(cstmt);

            }
            ConnectionFactory.Instance().closeConn(conn);
            System.gc();
        }
        return pagedDto;
    }

    //storeName, filterParams, ObjectDislayInJTable, tableModel
    public void executeIntoDataTablePaging(String sp_name, Object parametersObj, Object dislayDto, DefaultTableModel tableModel) throws Exception {
        try (Connection conn = ConnectionFactory.Instance().getConnection()) {
            if (tableModel.getRowCount() > 0) {
                for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
                    tableModel.removeRow(i);
                }
            }

            Map<String, Object> map = ReflectionExHelper.reflectObjectToMap(parametersObj);
            try (CallableStatement cstmt = ConnectionFactory.Instance().buildProcedureCallableStatement(conn, sp_name, map)) {
                ResultSet resultSet = cstmt.executeQuery();

                EntitySearchBase searchDto = (EntitySearchBase) parametersObj;
                searchDto.setTotalCount(cstmt.getInt("p_TotalCount"));

                int curPage = searchDto.getOffset();
                int counter = 0;
                while (resultSet.next()) {
                    List rowData = new ArrayList();
                    rowData.add((counter + 1) + curPage);
                    ReflectionExHelper.loadResultSetIntoRowData(resultSet, dislayDto, rowData);
                    tableModel.addRow(rowData.toArray());
                    counter++;
                }

                ConnectionFactory.Instance().closeCStmt(cstmt);

            }
            ConnectionFactory.Instance().closeConn(conn);
            System.gc();
        }
    }
}
