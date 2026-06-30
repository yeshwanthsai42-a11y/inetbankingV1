package com.inetbanking.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin {
	 WebDriver driver;
	    WebDriverWait wait;
	
	public Admin(WebDriver driver,WebDriverWait wait) {
	    this.driver = driver;
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

By Admin = By.xpath("//span[contains(@class,'oxd-text oxd-text--span oxd-main-menu-item--name') and normalize-space()='Admin']");
By organizationDD= By.xpath("//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Organization']");
By generalInformation = By.xpath("//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='General Information']");
By editToggle = By.xpath("//span[contains(@class,'oxd-switch-input')]");
By organizationName = By.xpath("//label[normalize-space()='Organization Name']/../following-sibling::div//input");
By registrationNum = By.xpath("//label[normalize-space()='Registration Number']/../following-sibling::div//input");
By taxId= By.xpath("//label[normalize-space()='Tax ID']/../following-sibling::div//input");
By phnNum=By.xpath("//label[normalize-space()='Phone']/../following-sibling::div//input");
By Fax = By.xpath("//label[normalize-space()='Fax']/../following-sibling::div//input");

public void clickAdmin() {
WebElement AdminClick = wait.until(ExpectedConditions.elementToBeClickable(Admin));
AdminClick.click();
}

public void selectOrganizationDD() {
WebElement orgDD= wait.until(ExpectedConditions.elementToBeClickable(organizationDD));
	orgDD.click();
WebElement generalInfo = wait.until(ExpectedConditions.elementToBeClickable(generalInformation));
generalInfo.click();
}

public void enableEditMode() {
    WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(editToggle));
    Actions actions = new Actions(driver);
    actions.moveToElement(toggle).click().perform();
}


public void orgInfo(String orgname) {

	WebElement orgName = wait.until(ExpectedConditions.elementToBeClickable(organizationName));
	orgName.clear();
	orgName.sendKeys(orgname);
}


public void regNum(String regnum) {

	WebElement regNo = wait.until(ExpectedConditions.elementToBeClickable(organizationName));
	regNo.clear();
	regNo.sendKeys(regnum);
}


public void taxId(String taxid) {

	WebElement taxId = wait.until(ExpectedConditions.elementToBeClickable(organizationName));
	taxId.clear();
	taxId.sendKeys(taxid);
}


public void phnnum(String phnno) {

	WebElement phnNo = wait.until(ExpectedConditions.elementToBeClickable(phnNum));
	phnNo.clear();
	phnNo.sendKeys(phnno);
}


public void fax(String Fx) {

	WebElement phnNo = wait.until(ExpectedConditions.elementToBeClickable(Fax));
	phnNo.clear();
	phnNo.sendKeys(Fx);
}

}






