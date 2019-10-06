package base.applications.intfs;

import base.data.entities.FullAuditEntity;

public interface IBaseService<T,TDisplay> extends ICrudService {
    void setInsAudit(FullAuditEntity entity);
    void setUpdAudit(FullAuditEntity entity);
}
