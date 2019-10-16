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
     private String image;
     private String thumbnail;

     public String getCode() {
          return code;
     }

     public void setCode(String code) {
          this.code = code;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getImage() {
          return image;
     }

     public void setImage(String image) {
          this.image = image;
     }

     public String getThumbnail() {
          return thumbnail;
     }

     public void setThumbnail(String thumbnail) {
          this.thumbnail = thumbnail;
     }
}
