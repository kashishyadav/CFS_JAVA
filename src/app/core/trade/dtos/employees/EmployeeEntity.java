/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.dtos.employees;

import base.data.entities.FullAuditEntity;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Khang
 */
public class EmployeeEntity extends FullAuditEntity {
     public EmployeeEntity(){
        super();
        birthday = Date.valueOf(LocalDate.MIN);
     }
     
     private String code;
     private String name;
     private String image;
     private Date birthday;
     private String phoneNumber; 
     private String address;

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

     public String getImage() {
          return image;
     }

     public void setImage(String image) {
          this.image = image;
     }
     
     public Date getBirthday() {
          return birthday;
     }

     public void setBirthday(Date birthday) {
          this.birthday = birthday;
     }

     public String getPhoneNumber() {
          return phoneNumber;
     }

     public void setPhoneNumber(String phoneNumber) {
          this.phoneNumber = phoneNumber;
     }

     public String getAddress() {
          return address;
     }

     public void setAddress(String address) {
          this.address = address;
     }
}
