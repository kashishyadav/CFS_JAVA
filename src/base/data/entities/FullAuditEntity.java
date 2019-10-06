package base.data.entities;

import base.configurations.constants.SystemConstants;

import java.sql.Date;

public class FullAuditEntity extends EntitySearchBase{
    public  FullAuditEntity(){
        super();
        isDeleted = false;
        createdDate = new Date(System.currentTimeMillis());
        updatedDate = new Date(System.currentTimeMillis());
    }


    protected boolean isDeleted;
    protected Date createdDate;
    protected String createdBy;
    protected Date updatedDate;
    protected String updatedBy;



    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
