/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.dtos.orders;

import app.core.trade.dtos.products.ProductEntity;
import base.data.entities.FullAuditEntity;
import base.ultilities.utils.MathUtils;
import java.math.BigDecimal;
import java.util.Vector;

/**
 *
 * @author Khang
 */
public class OrderDetailEntity extends FullAuditEntity {

    public OrderDetailEntity() {
        super();
    }
    private int orderId;
    private int productId;
    private String productCode;
    private String productName;
    private BigDecimal price;
    private int quantity;
    private BigDecimal totalPrice;
    private String note;
    private String status;

    public void setDataFromProduct(ProductEntity pd) {
        setProductId(pd.getId());
        setProductCode(pd.getCode());
        setProductName(pd.getName());
        setPrice(pd.getPrice());
        setQuantity(1);
        calTotalPrice();
    }

    public void convertDataToVectorRowVector(Vector vec) {
        vec.add(getProductCode());
        vec.add(getProductName());
        vec.add(getPrice());
        vec.add(getQuantity());
        vec.add(getTotalPrice());
    }

    public void calTotalPrice() {
        setTotalPrice(getPrice().multiply(MathUtils.getBigDecimal(getQuantity())));
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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
}
