/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.infrastructures.systems;

import app.core.systems.dtos.roles.RoleEntity;
import app.core.systems.dtos.users.UserEntity;
import base.configurations.constants.AppStringConstants;
import base.configurations.constants.SystemConstants;
import java.awt.Image;
import javax.swing.ImageIcon;
import base.ultilities.helpers.Helper;
import java.util.List;

/**
 *
 * @author Khang
 */
public class AppContext {

    private static AppContext _instance;
    
    private List<RoleEntity> appRoles;
    private UserEntity currentUser;

    public List<RoleEntity> getAppRoles() {
        return appRoles;
    }

    public void setAppRoles(List<RoleEntity> appRoles) {
        this.appRoles = appRoles;
    }

    public UserEntity getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserEntity currentUser) {
        this.currentUser = currentUser;
    }
    
    
    

    public static AppContext getInstance() {
        if (_instance == null) {
            _instance = new AppContext();
        }
        return _instance;
    }
    
    private AppContext() {

    }
    
    public Image getNoImage(){
        return Helper.ResizeImage(SystemConstants.NOIMAGE_PATH, SystemConstants.IMG_ICON_MD_WIDTH, SystemConstants.IMG_ICON_MD_HEIGHT);
    }
    
    public ImageIcon getNoImageIcon(){
        return Helper.convertImageToImageIcon(getNoImage());
    }
    
    public String getAddressBranch(){
        return AppStringConstants.STR_ADDRESS_DEFAULT;
    }
    
    public int getRequiredPasswordLength(){
        return AppStringConstants.PWD_LENGTH_REQUIRED;
    }
    
    public int getRequiredUserNameLength(){
        return AppStringConstants.USERNAME_LENGTH_REQUIRED;
    }
}
