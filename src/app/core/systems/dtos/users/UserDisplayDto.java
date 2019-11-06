/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.systems.dtos.users;

import java.sql.Date;

/**
 *
 * @author Khang
 */
public class UserDisplayDto {
    private int id;
    private String userName;
    private String roleCode;
    private String roleName;
    private String employeeCode;
    private String employeeName;    
    private Date createdDate;
    private String createdBy;
}
