package com.inetbanking.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class DatePickerUtils {

    // Keep the name consistent with your test class
    public static void selectDate(WebDriver driver, By dobField, String dob) {
        String[] parts = dob.split("-");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        // Click DOB field
        WebElement dobElement = driver.findElement(dobField);
        dobElement.click();

        // Select year
        WebElement yearDropdown = driver.findElement(By.className("ui-datepicker-year"));
        new Select(yearDropdown).selectByVisibleText(year);

        // Select month
        WebElement monthDropdown = driver.findElement(By.className("ui-datepicker-month"));
        int monthIndex = Integer.parseInt(month) - 1; // Jan=0
        new Select(monthDropdown).selectByIndex(monthIndex);

        // Select day
        for (WebElement d : driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td/a"))) {
            if (d.getText().equals(day)) {
                d.click();
                break;
            }
        }
    }
}
