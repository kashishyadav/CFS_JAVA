/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.purchases.dtos.goods;

import base.data.entities.FullAuditEntity;
import java.math.BigDecimal;

/**
 *
 * @author Khang
 */
public class GoodsEntity extends FullAuditEntity {
    public GoodsEntity(){
        super();
        price = new BigDecimal("0");  
    }

    private String code;
    private String name;
    private BigDecimal price;
    private int categoryId;
    private String description;
    private String note;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
