/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.dtos.orders;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Khang
 */
public class OrderDisplayDto {
    private int id;
    private String code;
    private String name;
    private BigDecimal fee;
    private String discountPercent;
    private String totalPrice;
    private Date createdDate;
    private String createdBy;
}
