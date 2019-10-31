/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.dtos.orders;

import java.math.BigDecimal;

/**
 *
 * @author Khang
 */
public class OrderDetailDisplayDto {
    private String productCode;
    private String productName;
    private BigDecimal price;
    private int quantity;
    private BigDecimal totalPrice;
}
