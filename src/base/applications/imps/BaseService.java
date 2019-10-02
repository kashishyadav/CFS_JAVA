package base.applications.imps;

import base.applications.intfs.IBaseService;
import base.data.entities.FullAuditEntity;
import ultilities.factories.DateTimeFactory;

import java.sql.Date;

public class BaseService implements IBaseService {
    @Override
    public void SetInsAudit(FullAuditEntity entity) {
        Date curDate = DateTimeFactory.Instance().getCurrentDate();
        entity.setCreatedDate(curDate);
        entity.setUpdatedDate(curDate);
    }

    @Override
    public void SetUpdAudit(FullAuditEntity entity) {
        Date curDate = DateTimeFactory.Instance().getCurrentDate();
        entity.setUpdatedDate(curDate);
    }
}
