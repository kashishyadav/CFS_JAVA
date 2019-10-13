package base.applications.intfs;

import base.data.dal.StoreProvider;
import base.data.entities.FullAuditEntity;

public interface IBaseService<T,TDisplay> extends ICrudService {
    void setInsAudit(FullAuditEntity entity);
    void setUpdAudit(FullAuditEntity entity);
    StoreProvider getStoreProvider();
}
