/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.guis.products;

import app.core.trade.dtos.products.ProductEntity;
import base.configurations.constants.SystemConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import ultilities.helpers.Helper;

/**
 *
 * @author Khang
 */
public class ProductCellRenderer extends JLabel implements ListCellRenderer {

    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

    public ProductCellRenderer() {
        setOpaque(true);
        setIconTextGap(12);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        ProductEntity entry = (ProductEntity) value;
        if (entry != null) {
            String code = entry.getCode() == null ? "NULL" : entry.getCode();
            String name = entry.getName() == null ? "NULL" : entry.getName();
            String title = new StringBuilder(code).append(" - ").append(name).toString();

            Image img = null;
            if (entry.getImage() != null) {
                img = Helper.ResizeImage(new StringBuilder(SystemConstants.DOMAIN_FOLDER).append(entry.getImage()).toString(), 400, 400);
            }

            setText(title);
            setIcon(Helper.convertImageToImageIcon(img));
            if (isSelected) {
                setBackground(HIGHLIGHT_COLOR);
                setForeground(Color.white);
            } else {
                setBackground(Color.white);
                setForeground(Color.black);
            }
        }

        return this;
    }

}
