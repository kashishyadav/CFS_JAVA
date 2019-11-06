/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.guis.products;

import app.core.trade.dtos.products.ProductEntity;
import base.configurations.constants.ColorConstants;
import base.configurations.constants.SystemConstants;
import base.infrastructures.systems.AppContext;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import base.ultilities.helpers.Helper;

/**
 *
 * @author Khang
 */
public class ProductCellRenderer extends JLabel implements ListCellRenderer {
  
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
            if (entry.getImage() != null && !entry.getImage().isEmpty()) {
                img = Helper.ResizeImage(new StringBuilder(SystemConstants.DOMAIN_FOLDER)
                        .append(entry.getImage()).toString(), SystemConstants.IMG_ICON_LG_WIDTH, SystemConstants.IMG_ICON_LG_HEIGHT);
                setIcon(Helper.convertImageToImageIcon(img));
            } else {
                
                setIcon(AppContext.getInstance().getNoImageIcon());
            }

            setText(title);

            if (isSelected) {
                setBackground(Color.decode(ColorConstants.HIGHLIGHT_COLOR));
                setForeground(Color.white);
            } else {
                setBackground(Color.white);
                setForeground(Color.black);
            }
        }

        return this;
    }

}
