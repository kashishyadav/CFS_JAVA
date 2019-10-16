/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.systems.dtos.allcodes;

import base.data.entities.FullAuditEntity;

/**
 *
 * @author Khang
 */
public class AllCodeEntity extends FullAuditEntity{
   public AllCodeEntity(){
       super();
   }  
    
   private String cdName;
   private String cdValue;
   private String content;
   private String cdType;
   private int priority;

   public String getCdName() {
      return cdName;
   }

   public void setCdName(String cdName) {
      this.cdName = cdName;
   }

   public String getCdValue() {
      return cdValue;
   }

   public void setCdValue(String cdValue) {
      this.cdValue = cdValue;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String getCdType() {
      return cdType;
   }

   public void setCdType(String cdType) {
      this.cdType = cdType;
   }

   public int getPriority() {
      return priority;
   }

   public void setPriority(int priority) {
      this.priority = priority;
   }
}
