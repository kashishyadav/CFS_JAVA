package base.applications.intfs;
import base.data.dtos.PagedDto;

import java.util.Map;

public interface ICrudService<T> {
     Map<String,Object> InsOrUpd(T entity) throws Exception;
     PagedDto<T> Search(T entity) throws Exception;
}
