package base.applications.intfs;

import base.data.entities.FullAuditEntity;

public interface IBaseService {
    void SetInsAudit(FullAuditEntity entity);
    void SetUpdAudit(FullAuditEntity entity);
}
