/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.infrastructures.systems;

import base.configurations.constants.SystemConstants;
import java.awt.Image;
import javax.swing.ImageIcon;
import ultilities.helpers.Helper;

/**
 *
 * @author Khang
 */
public class AppContext {

    private static AppContext _instance;

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
    
}
