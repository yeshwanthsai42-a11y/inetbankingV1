package com.inetbanking.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.inetbanking.utilities.ReadConfig;

public class Baseclass {

	public static WebDriver driver;
	public static WebDriverWait wait;
    ReadConfig readConfig = new ReadConfig();

    @BeforeSuite
    public void setup() {
        String browser = readConfig.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(readConfig.getImplicitWait()));
        driver.get(readConfig.getApplicationURL());
    
        
    }

   // @AfterClass
   // public void tearDown() {
     //   if (driver != null) {
       //     driver.quit();
       // }
//    }
}
