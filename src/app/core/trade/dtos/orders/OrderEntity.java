/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.dtos.orders;

import base.data.entities.FullAuditEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khang
 */
public class OrderEntity extends FullAuditEntity {

    public OrderEntity() {
        super();
        this.price = BigDecimal.ZERO;
        this.totalPrice = BigDecimal.ZERO;
        this.discountPercent = BigDecimal.ZERO;
        this.fee = BigDecimal.ZERO;
        details = new ArrayList<OrderDetailEntity>();
        
        this.status = "D";
    }
    private String code;
    private String name;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private BigDecimal discountPercent;
    private BigDecimal fee;
    private String strOrderDetails;
    private String note;
    private String status;
    private List<OrderDetailEntity> details;
    
    
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getStrOrderDetails() {
        return strOrderDetails;
    }

    public void setStrOrderDetails(String strOrderDetails) {
        this.strOrderDetails = strOrderDetails;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetailEntity> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetailEntity> details) {
        this.details = details;
    }
    
    
    
}
