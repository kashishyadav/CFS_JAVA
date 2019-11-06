/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mains.navigations;

import app.common.modules.constants.StoreConstants;
import app.core.systems.dtos.users.UserEntity;
import app.mains.MainWindow;
import app.mains.guis.logins.LoginFrame;
import base.data.dal.StoreProvider;
import base.infrastructures.systems.AppContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;

/**
 *
 * @author Khang
 */
public class AppNavigator {

    private static AppNavigator _instance;

    StoreProvider userProvider;

    public static AppNavigator getInstance() {
        if (_instance == null) {
            _instance = new AppNavigator();
        }
        return _instance;
    }

    private AppNavigator() {
        userProvider = new StoreProvider(UserEntity.class);
        init();
    }

    private void init() {

    }

    public UserEntity getUserSignIn(String userName, String password) {
        try {
            UserEntity entity = new UserEntity();
            entity.setUserName(userName);
            entity.setPassword(password);
            entity = (UserEntity)userProvider.executeToObject(StoreConstants.USER_LOGIN, entity);
            return entity;
        } catch (Exception ex) {
            Logger.getLogger(AppNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void setEnableToggleMenu(boolean isEnable, JMenu... menus) {
        if (menus != null && menus.length > 0) {
            for (JMenu menu : menus) {
                menu.setEnabled(isEnable);
            }
        }
    }

    public void setAuthenticationScreen() {
        MainWindow.getInstance().setVisible(true);
        MainWindow.getInstance().setAuthentication(AppContext.getInstance().getCurrentUser());
    }

    public void initScreen() {
        MainWindow.getInstance().setVisible(false);
        LoginFrame loginFrame = new LoginFrame(this);
        loginFrame.setVisible(true);
    }
}
