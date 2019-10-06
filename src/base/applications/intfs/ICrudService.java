package base.applications.intfs;
import base.data.dtos.PagedDto;

import java.util.Map;
import javax.swing.table.DefaultTableModel;

public interface ICrudService<T,TDisplay> {
     Map<String,Object> save(String sp_name,T entity);
     T getById(String sp_name, Object paramsObject) ;
     void search(String sp_name, Object parametersObj,TDisplay dislayDto,DefaultTableModel tableModel);     
     Map<String,Object> delete(String sp_name,T entity);
}
