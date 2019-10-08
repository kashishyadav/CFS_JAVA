package base.data.dal;

import base.data.dtos.PagedDto;
import base.data.dtos.ResultDto;
import ultilities.helpers.ReflectionExHelper;


import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class StoreProvider<T> {
    private T tObject;
    private StoreProvider(){

    }
    public StoreProvider(Class<T> tclass)
            throws InstantiationException, IllegalAccessException {
        try {           
            this.tObject = (T) tclass.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public Map<String,Object> executeToMap(String sp_name, Object parametersObj) throws Exception{
       Map<String,Object> mapResult = new HashMap<String,Object>();
        Map<String,Object> map = ReflectionExHelper.reflectObjectToMap(parametersObj);
        CallableStatement cstmt = ConnectionFactory.Instance().buildProcedureCallableStatement(sp_name,map);
        ResultSet resultSet = cstmt.executeQuery();
        while (resultSet.next()){
            ResultDto obj =new ResultDto();
            ReflectionExHelper.loadResultSetIntoObject(resultSet,obj);
            ReflectionExHelper.loadObjectIntoMap(obj,mapResult);
        }
        ConnectionFactory.Instance().closeConn(cstmt);
         System.gc();
        return mapResult;
    }

    public T executeToObject(String sp_name, Object parametersObj) throws Exception{
        T objResult =(T) this.tObject.getClass().getDeclaredConstructor().newInstance();
        Map<String,Object> map = ReflectionExHelper.reflectObjectToMap(parametersObj);
        CallableStatement cstmt = ConnectionFactory.Instance().buildProcedureCallableStatement(sp_name,map);
        ResultSet resultSet = cstmt.executeQuery();
        while (resultSet.next()){
            ReflectionExHelper.loadResultSetIntoObject(resultSet,objResult);
        }
        ConnectionFactory.Instance().closeConn(cstmt);
         System.gc();
        return objResult;
    }


    public List<T> executeToList(String sp_name, Object parametersObj) throws Exception{
        List<T> list = new ArrayList<T>();
        Map<String,Object> map = ReflectionExHelper.reflectObjectToMap(parametersObj);
        CallableStatement cstmt = ConnectionFactory.Instance().buildProcedureCallableStatement(sp_name,map);
       ResultSet resultSet = cstmt.executeQuery();
       while (resultSet.next()){
           T item = (T) this.tObject.getClass().getDeclaredConstructor().newInstance();
           ReflectionExHelper.loadResultSetIntoObject(resultSet,item);
           list.add(item);
       }
       ConnectionFactory.Instance().closeConn(cstmt);
        System.gc();
        return list;
    }

    public PagedDto<T> executeToPagedDto(String sp_name, Object parametersObj) throws Exception{
        PagedDto<T> pagedDto = new PagedDto<T>();
        Map<String,Object> map = ReflectionExHelper.reflectObjectToMap(parametersObj);
        CallableStatement cstmt = ConnectionFactory.Instance().buildProcedureCallableStatement(sp_name,map);
        ResultSet resultSet = cstmt.executeQuery();
        int counter =0;
        while (resultSet.next()){
            T item = (T) this.tObject.getClass().getDeclaredConstructor().newInstance();
            ReflectionExHelper.loadResultSetIntoObject(resultSet,item);
            pagedDto.getItems().add(item);
            counter++;
        }
        pagedDto.setRowCount(counter);
        ConnectionFactory.Instance().closeConn(cstmt);
        System.gc();
        return pagedDto;
    }

    //storeName, filterParams, ObjectDislayInJTable, tableModel
    public void executeIntoDataTable(String sp_name, Object parametersObj,Object dislayDto,DefaultTableModel tableModel) throws Exception{
       if (tableModel.getRowCount() > 0) {
                    for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
                        tableModel.removeRow(i);
                    }
        }       
        
        Map<String,Object> map = ReflectionExHelper.reflectObjectToMap(parametersObj);
        CallableStatement cstmt = ConnectionFactory.Instance().buildProcedureCallableStatement(sp_name,map);
        ResultSet resultSet = cstmt.executeQuery();
         
        int counter =0;
        while (resultSet.next()){
            List rowData = new ArrayList();
            rowData.add(counter+1);
            ReflectionExHelper.loadResultSetIntoRowData(resultSet,dislayDto,rowData);            
            tableModel.addRow(rowData.toArray());
            counter++;
        }
                  
        ConnectionFactory.Instance().closeConn(cstmt);
        System.gc();
    }

    

}
