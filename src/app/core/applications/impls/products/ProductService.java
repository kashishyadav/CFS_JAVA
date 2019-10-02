package app.core.applications.impls.products;

import app.core.applications.infs.products.IProductService;
import app.core.data.dtos.products.ProductEntity;
import app.core.modules.constants.StoreConstants;
import base.applications.imps.BaseService;
import base.data.dal.StoreProvider;
import base.data.dtos.PagedDto;

import java.util.Map;

public class ProductService extends BaseService implements IProductService {
    private StoreProvider storeProvider;
    public  ProductService() throws IllegalAccessException, InstantiationException {
        storeProvider = new StoreProvider(ProductEntity.class);
    }

    @Override
    public Map<String, Object> InsOrUpd(ProductEntity entity) throws Exception {
        if(entity.getId()==0){
            SetInsAudit(entity);
        }else{
            SetUpdAudit(entity);
        }
        Map<String,Object> result = storeProvider.executeToMap(StoreConstants.PRODUCT_INSORUPD(),entity);
        return result;
    }

    @Override
    public PagedDto<ProductEntity> Search(ProductEntity entity) throws Exception {
        PagedDto<ProductEntity> result = storeProvider.executeToPagedDto(StoreConstants.PRODUCT_SEARCH(),entity);
        return result;
    }
}
