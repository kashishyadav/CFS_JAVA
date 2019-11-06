/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.reports.dtos;

import com.aspose.cells.ImportTableOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Khang
 */
public class ReportDto {

    public int sheetNumber = 0;
    public String sheetName = "Sheet1";
    public String rowOffSet = "A4";
    public int colOffsetIndex = 0;
    public int rowOffsetIndex = 4;
    public ImportTableOptions ITO = null;

    public List<String> verticalSumColums;
    public Map<String, Object> clientParamsMap;

    public ReportDto() {
        ITO = new ImportTableOptions();
        ITO.setFieldNameShown(Boolean.FALSE);
        ITO.setInsertRows(Boolean.TRUE);
        verticalSumColums = new ArrayList<String>();
        clientParamsMap = new HashMap<String, Object>();
    }

}
