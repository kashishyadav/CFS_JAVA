/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.guis.controls;

import base.configurations.constants.ColorConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;

/**
 *
 * @author Khang
 */
public class BaseTable extends BaseComponent {

    public void initLayoutTable(JTable jtable) {
        //  jtable.getTableHeader().setFont(new Font("Segoe UI", FONT.BOLD, 12));
        jtable.getTableHeader().setOpaque(true);
        jtable.getTableHeader().setBackground(Color.decode(ColorConstants.TABLE_HEADER_BACKGROUND));
        jtable.getTableHeader().setForeground(Color.black);
        jtable.setRowHeight(25);
    }
}
