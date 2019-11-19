package base.applications.imps;

import base.applications.intfs.IBaseService;
import base.data.dal.StoreProvider;
import base.data.entities.FullAuditEntity;
import base.infrastructures.systems.AppContext;
import base.ultilities.factories.DateTimeFactory;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class BaseService<T, TDisplay> implements IBaseService {

    private StoreProvider<T> storeProvider;
    private Class<T> tClazz;
    Class<TDisplay> tDisplayClazz;

    public BaseService(Class<T> tClazz, Class<TDisplay> tDisplayClazz) {
        super();
        this.tClazz = tClazz;
        this.tDisplayClazz = tDisplayClazz;
        init();
    }

    private void init() {
        try {
            storeProvider = new StoreProvider(this.tClazz);
        } catch (Exception ex) {
            Logger.getLogger(tClazz.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setInsAudit(FullAuditEntity entity) {
        Date curDate = DateTimeFactory.Instance().getCurrentDate();
        entity.setCreatedDate(curDate);
        entity.setUpdatedDate(curDate);
        entity.setCreatedBy(AppContext.getInstance().getCurrentUser().getUserName());
        entity.setUpdatedBy(AppContext.getInstance().getCurrentUser().getUserName());
    }

    @Override
    public void setUpdAudit(FullAuditEntity entity) {
        Date curDate = DateTimeFactory.Instance().getCurrentDate();
        entity.setUpdatedDate(curDate);
        entity.setUpdatedBy(AppContext.getInstance().getCurrentUser().getUserName());
    }

    @Override
    public Map save(String sp_name, Object entity) {
        FullAuditEntity ent = (FullAuditEntity) entity;
        if (ent.getId() == 0) {
            this.setInsAudit(ent);
        } else {
            this.setUpdAudit(ent);
        }

        //execute
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            result = storeProvider.executeToMap(sp_name, ent);
        } catch (Exception ex) {
            Logger.getLogger(tClazz.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Map delete(String sp_name, Object entity) {
        FullAuditEntity ent = (FullAuditEntity) entity;
        ent.setDeleted(true);
        return this.save(sp_name, ent);
    }

    @Override
    public StoreProvider getStoreProvider() {
        return this.storeProvider;
    }

    @Override
    public T getById(String sp_name, Object paramsObject) {
        try {
            T tResultObj = (T) storeProvider.executeToObject(sp_name, paramsObject);
            return tResultObj;
        } catch (Exception ex) {
            Logger.getLogger(tClazz.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void search(String sp_name, Object parametersObj, Object dislayDto, DefaultTableModel tableModel) {

        try {
            storeProvider.executeIntoDataTablePaging(sp_name, parametersObj, dislayDto, tableModel);
        } catch (Exception ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
