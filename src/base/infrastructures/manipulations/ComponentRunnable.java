/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.infrastructures.manipulations;

import javax.swing.JComponent;

/**
 *
 * @author Khang
 */
public class ComponentRunnable implements Runnable{
    JComponent component;
    public ComponentRunnable(JComponent component){
        this.component = component;
    }
    public JComponent getComponent(){
        return this.component;
    }
    @Override
    public  void run(){
        
    }
    
}
