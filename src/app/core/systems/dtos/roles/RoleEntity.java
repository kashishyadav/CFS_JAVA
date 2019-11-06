/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.systems.dtos.roles;

import base.data.entities.FullAuditEntity;

/**
 *
 * @author Khang
 */
public class RoleEntity extends FullAuditEntity {

    public RoleEntity() {
        super();
    }
    private String code;
    private String name;
   

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
    
    
}
