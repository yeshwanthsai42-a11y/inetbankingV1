package com.inetbanking.testcases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.Admin;
import com.inetbanking.utilities.DataProviderUtil;


public class Req_003_AdminOptions extends Baseclass {

	
	@Test(dependsOnMethods = "loginTest",dataProvider = "orgData",dataProviderClass = DataProviderUtil.class)
public void AdminOptions(String orgname,String regnum,String taxid,String phnno,String Fx)  {	
Admin admin = new Admin(driver,wait);
admin.clickAdmin();
admin.selectOrganizationDD();
admin.enableEditMode();
admin.orgInfo(orgname);
admin.regNum(regnum);
admin.taxId(taxid);
admin.phnnum(phnno);
admin.fax(Fx);

}
}
