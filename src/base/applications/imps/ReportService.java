/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.applications.imps;

import app.core.reports.dtos.ReportDto;
import base.configurations.constants.SystemConstants;
import base.data.dal.StoreProvider;
import com.aspose.cells.Cell;
import com.aspose.cells.ImportTableOptions;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khang
 */
public class ReportService {

    public ReportDto reportDto;
    private StoreProvider reportProvider;
    private String spName;

    public ReportService() {
        reportDto = new ReportDto();
    }

    public StoreProvider getReportProvider() {
        return this.reportProvider;
    }

    public void setReportProvider(StoreProvider reportProvider) {
        this.reportProvider = reportProvider;
    }

    public ReportDto getReportDto() {
        return reportDto;
    }

    public void setReportDto(ReportDto reportDto) {
        this.reportDto = reportDto;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public boolean exportExcelFromResultSet(Object parameters, String fileTemplatePath, String outFolder, String strReportName) {
        boolean isSuccess = true;
        String fileSavedName = "reportFile";
        String folderSavedName = new StringBuilder(SystemConstants.DESKTOP_FOLDER_PATH).toString();

        try {
            if (!strReportName.isEmpty()) {
                fileSavedName = strReportName;
            }
            if (!outFolder.isEmpty()) {
                folderSavedName = outFolder;
            }
            Workbook workbook = null;
            if (!fileTemplatePath.isEmpty()) {
                workbook = new Workbook(fileTemplatePath);
            } else {
                workbook = new Workbook();
            }

            Worksheet ws = workbook.getWorksheets().get(this.reportDto.sheetName);
            reportProvider.excuteToWorksheet(spName, parameters, ws, reportDto);

            setVerticalSumColumns(ws, reportDto);
            setClientParameters(ws, reportDto.clientParamsMap);
            // ws.getCells().importResultSet(rs, reportDto.rowOffSet, reportDto.ITO);
            File file = new File(folderSavedName, fileSavedName);
            if (file.createNewFile()) {
                workbook.save(file.getAbsolutePath(), SaveFormat.XLSX);
            }

        } catch (Exception ex) {
            Logger.getLogger(ReportService.class.getName()).log(Level.SEVERE, null, ex);
            isSuccess = false;
        }
        return isSuccess;
    }

    private void setVerticalSumColumns(Worksheet ws, ReportDto reportDto) {
        if (reportDto.verticalSumColums.size() > 0) {
            int dataRowTotal = ws.getCells().getMaxDataRow() + 1;
            for (String colName : reportDto.verticalSumColums) {
                String colSumName = new StringBuilder(colName).append(dataRowTotal + 1).toString();
                Cell cell = ws.getCells().get(colSumName);
                String sumFormular = String.format("=SUM(%s%s:%s%s)", colName, reportDto.rowOffsetIndex, colName, dataRowTotal);
                cell.setFormula(sumFormular);               
            }
             Cell sumCellTitle = ws.getCells().get(new StringBuilder("A").append(dataRowTotal+1).toString());
             sumCellTitle.setValue("Tổng cộng");
        }
    }

    private void setClientParameters(Worksheet ws, Map<String, Object> parameters) {
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();
            Cell cell = ws.getCells().get(k);
            cell.setValue(v);
        }
    }

}
