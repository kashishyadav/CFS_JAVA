/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.guis.controls;

import base.applications.imps.ReportService;
import base.data.dal.StoreProvider;
import javax.swing.JFileChooser;

/**
 *
 * @author Khang
 */
public abstract class BaseReportPanel extends BaseComponent {

    private JFileChooser chooser;
    protected ReportService reportService;
    protected String choosertitle = "Select Directory";

    public BaseReportPanel() {
        super();
        reportService = new ReportService();
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
    }

    public void setChooserTitle(String title) {
        this.choosertitle = title;
    }

    public String getFolderPathFromDialog() {
        String strResult = "";
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            strResult = chooser.getCurrentDirectory().getPath();
        } else {
            System.out.println("No Selection ");
        }
        return strResult;
    }

    public abstract String strIsValid();
    public abstract void onExportExcel();
    public abstract void bindingViewToModel();
}
