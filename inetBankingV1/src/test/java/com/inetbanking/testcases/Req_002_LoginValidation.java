package com.inetbanking.testcases;
import org.testng.annotations.Test;
import com.inetbanking.testcases.Baseclass;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.DataProviderUtil;

public class Req_002_LoginValidation extends Baseclass {

	@Test(groups = "login", dataProvider = "loginData", dataProviderClass = com.inetbanking.utilities.DataProviderUtil.class)
	    public void loginTest(String username, String password) {
	        LoginPage lp = new LoginPage(driver);
	        lp.setUserName(username);   // from DataProvider
	        lp.setPassword(password);   // from DataProvider
	        lp.clickLoginBtn();
	        lp.validateDashboard();

	        System.out.println("Login attempted with: " + username + " / " + password);
	    }
	
//	    public void validateManagerPage() {
//	        // ✅ Wait for Manager Id element
//	        wait.until(ExpectedConditions.visibilityOfElementLocated(
//	            By.xpath("//td[contains(text(),'Manger Id')]")));
//
//	        // ✅ Assert Manager page is displayed
//	        Assert.assertTrue(driver.getPageSource().contains("Manger Id"),
//	            "Manager page not displayed after login!");
//}
}




