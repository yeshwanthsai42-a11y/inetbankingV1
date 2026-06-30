package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {
    private static Workbook workbook;

    // Load Excel file
    public static void loadExcel(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = WorkbookFactory.create(fis);
    }

    // Get cell data
    public static String getCellData(String sheetName, int rowNum, int colNum) {
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getRow(rowNum).getCell(colNum).toString();
    }

    // Get total row count
    public static int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getLastRowNum() + 1; // +1 because index starts at 0
    }

    // Get total column count
    public static int getColCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getRow(0).getLastCellNum(); // first row defines column count
    }
}
