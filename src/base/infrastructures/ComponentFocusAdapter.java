/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.infrastructures;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;

/**
 *
 * @author Khang
 */
public class ComponentFocusAdapter extends FocusAdapter {

    JComponent component;

    public ComponentFocusAdapter(JComponent component) {
        this.component = component;
    }

    public JComponent getComponent() {
        return this.component;
    }

    @Override
    public void focusLost(FocusEvent e) {
      
    }
}
