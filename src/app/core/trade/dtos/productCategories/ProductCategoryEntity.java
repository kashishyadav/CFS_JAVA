package app.core.trade.dtos.productCategories;

import base.data.entities.FullAuditEntity;
import java.math.BigDecimal;

public class ProductCategoryEntity extends FullAuditEntity {
     public ProductCategoryEntity(){
        super();
     }
     
     private String code;
     private String name; 
     private String description;
    
}
