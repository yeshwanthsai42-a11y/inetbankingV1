package com.inetbanking.pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By username = By.xpath("//input[@name='username']");
    By password = By.xpath("//input[@name='password']");
    By loginBtn = By.xpath("//button[normalize-space()='Login']");
    By dashboard= By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module') and normalize-space()='Dashboard']");

    public void setUserName(String uname) {
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        userField.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passField.sendKeys(pwd);
    }

    public void clickLoginBtn() {
        // Wait for button before clicking
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginButton.click();

        // ✅ After clicking, wait for Manager page element
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
    }
 
    public void validateDashboard() {
    
    WebElement Dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
    String dashBoardText = Dashboard.getText();
    Assert.assertEquals(("Dashboard"), dashBoardText);
    
    }
}
