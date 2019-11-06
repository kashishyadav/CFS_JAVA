/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.common.controls;

import base.configurations.constants.ColorConstants;
import base.configurations.constants.SystemStringConstants;
import base.guis.controls.core.BaseCombobox;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import base.ultilities.utils.TextUtils;

/**
 *
 * @author Khang
 */
public class Selector extends BaseCombobox implements ItemListener {

    /**
     * Creates new form Selector
     */
    protected DefaultComboBoxModel model;
    protected Object _value = null;
    protected String _strDisplayMember = "id";
    protected String _strValueMember = "id";

    protected Class<?> _valueType = int.class;

    protected boolean isNullableDisplay = false;

    protected List<Map<String, Object>> dataSource;

    public Selector() {
        super();
        initComponents();
        init();
    }

    private void init() {
        model = new DefaultComboBoxModel();

        this.setModel(model);
        this.addItemListener(this);
        setOpaque(true);
        //setFont(TextUtils.getSelectorFont());
        setBackground(Color.decode(ColorConstants.APP_COLOR));
//        setForeground(Color.WHITE);
    }

    public void setDisplayMember(String displayName) {
        this._strDisplayMember = displayName;
    }

    public void setValueMember(String valueName) {
        this._strValueMember = valueName;
    }

    public String getDisplayMember() {
        return _strDisplayMember;
    }

    public String getValueMember() {
        return _strValueMember;
    }
    
    
    public void setNullableDisplay(boolean isNullableDisplay) {
        this.isNullableDisplay = isNullableDisplay;
    }

    public void setValueType(Class<?> type) {
        this._valueType = type;;
    }

    public void setValue(Object value) {
        if (value == null) {
//            if (!this.isNullableDisplay) {
//                this.isNullableDisplay = true;
//            } else {
//
//            }
//            this._value = value;
//            this.setSelectedIndex(0);
        } else {
            boolean isFound = false;
            for (int i = 0; i < this.dataSource.size(); i++) {
                Object compareValue = this.dataSource.get(i).get(this._strValueMember);
                if (compareValue instanceof String) {
                    if (compareValue.equals(value)) {
                        isFound = true;
                        this._value = compareValue;
                        this.setSelectedIndex(i);
                        break;
                    }
                } else {
                    if (compareValue == (value)) {
                        isFound = true;
                        this._value = compareValue;
                        this.setSelectedIndex(i);
                        break;
                    }
                }
            }

            if (!isFound) {
                this._value = null;
                this.setSelectedIndex(0);
            }
        }
    }

    public void setDataSource(List<Map<String, Object>> dataSource) {
        this.dataSource = dataSource;
        try {

            this.model.removeAllElements();
            if (isNullableDisplay) {
                Map<String, Object> mapFirst = new HashMap<String, Object>();
                mapFirst.put(this._strValueMember, null);
                this.dataSource.add(0, mapFirst);

            }
            for (int i = 0; i < this.dataSource.size(); i++) {
                if (i == 0 && this.isNullableDisplay) {
                    this.model.addElement(SystemStringConstants.STR_NULL);
                } else {
                    this.model.addElement(this.dataSource.get(i).get(_strDisplayMember));
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(Selector.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.gc();
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
           this._value = this.dataSource.get(this.getSelectedIndex()).get(this._strValueMember);
        }
    }

    public Object getSelectedValue() {
        Object rsValue = this._value;
        int curIndex = this.getSelectedIndex();
        try {
            if (isNullableDisplay && curIndex == 0) {
                if (this._valueType == int.class || this._valueType == Integer.class) {
                    rsValue = 0;
                }
            } 

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return rsValue;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
