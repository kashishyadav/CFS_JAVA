/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.guis.infs;

/**
 *
 * @author Khang
 */
public interface IEditPanelUI {
   void search();
   void save();
   void delete();
   void bindingModelToView();
   void bindingViewToModel();
   void refreshEditForm();
}
