package com.inetbanking.utilities;

import org.testng.ITestListener;

import org.testng.ITestResult;
import org.testng.ITestContext;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.inetbanking.testcases.Baseclass;
import org.openqa.selenium.WebDriver;


public class TestListener extends Baseclass implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
        	WebDriver driver = ((Baseclass) result.getInstance()).driver;
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
            test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
