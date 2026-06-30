package com.inetbanking.testcases;

import java.time.Duration;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TablePractise {
	
public static WebDriver driver;
public static WebDriverWait wait;


@Parameters("url")
@Test
public void setUp(String url) {
//WebDriverManager.edgedriver().setup();
//driver = new EdgeDriver();
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();

	
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.get(url);
driver.manage().window().maximize();
wait= new WebDriverWait(driver,Duration.ofSeconds(10));	
}
	
@Test
public void tablePractise() {
    // Example: check if table is displayed
//    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='courses_table']/tbody/tr"));
//    int rowsCount = rows.size();
//    System.out.println(rowsCount +  "Total rows");
//    
//    List<WebElement> cols = driver.findElements(By.xpath("//table[@id='courses_table']//tr/th"));
//    int colsCount=cols.size();
//    System.out.println(colsCount +  "Total Columns");
//    
//    
//    for(int r=1; r<=rowsCount;r++) {
//    
//    for(int c=1;c<colsCount;c++) {
//    	
//    List<WebElement> tabledata = driver.findElements(By.xpath("//table[@id='courses_table']/tbody/tr["+r+"]/td["+c+"]"));
//    
//    for(WebElement data : tabledata) {
//    	
//    System.out.println(data.getText());
    
//    WebElement selectedText = driver.findElement(By.xpath("//table[@id='courses_table']/tbody/tr[2]/td[6]"));
//    selectedText.click();
//    
//    String parentWindowHandle = driver.getWindowHandle();
//    Set<String> windowHandles = driver.getWindowHandles();
//    
//    wait.until(driver -> driver.getWindowHandles().size() > 1);
//    
//    for(String handles : windowHandles) {
//    
//    if(handles!=parentWindowHandle) {
//    
//    driver.switchTo().window(handles);
//    
//   
//    }
//    }
//    }
//    }
    
    
    
//    }
//
//    driver.findElement(By.xpath("//span[normalize-space(text())='TestNG']")).click();    
//    

//      WebElement sort= driver.findElement(By.id("sortBy"));
//      
//      Select sortDD = new Select(sort);
//      List<WebElement> sortDDOptions = sortDD.getOptions();
//      for(WebElement Options : sortDDOptions) {
//
//     System.out.println(Options.getText());
//     
//     sortDD.selectByValue("Language");
//    	  
//      }

	WebElement clickMe= driver.findElement(By.xpath("//button[@id='alertButton'][3]"));
	clickMe.click();
	
	driver.switchTo().alert().accept();



}
}





	
	

	

