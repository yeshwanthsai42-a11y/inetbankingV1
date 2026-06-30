package com.inetbanking.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws Exception {

	    ExcelUtils.loadExcel("./test-data/LoginData.xlsx");

	    int rowCount = ExcelUtils.getRowCount("Sheet1");

	    Object[][] data = new Object[rowCount - 1][2];

	    for (int i = 1; i < rowCount; i++) {
	        data[i - 1][0] = ExcelUtils.getCellData("Sheet1", i, 0);
	        data[i - 1][1] = ExcelUtils.getCellData("Sheet1", i, 1);
	    }

	    return data;
	}
    
    @DataProvider(name = "orgData")
    public Object[][] getOrgData() throws Exception {
        ExcelUtils.loadExcel("./test-data/LoginData.xlsx");
        int rowCount = ExcelUtils.getRowCount("Sheet1");
        int colCount = ExcelUtils.getColCount("Sheet1");

        // Skip header row → start from row 1
        // Skip first 2 columns (Username + Password)
        Object[][] data = new Object[rowCount - 1][colCount - 2];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 2; j < colCount; j++) { // start from col 2
                data[i - 1][j - 2] = ExcelUtils.getCellData("Sheet1", i, j);
            }
        }
        return data;
    }
}
