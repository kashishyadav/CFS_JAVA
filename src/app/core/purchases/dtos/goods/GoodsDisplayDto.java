/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.purchases.dtos.goods;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Khang
 */
public class GoodsDisplayDto {
    private int id;
    private String code;
    private String name;
    private BigDecimal price;
    private String description;
    private Date createdDate;
    private String createdBy;
}
