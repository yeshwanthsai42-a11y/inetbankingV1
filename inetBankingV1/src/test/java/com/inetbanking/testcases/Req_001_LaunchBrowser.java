package com.inetbanking.testcases;
import org.testng.annotations.Test;

public class Req_001_LaunchBrowser extends Baseclass {

	@Test
	public void launchBrowser() {
	System.out.println(driver.getCurrentUrl());	
	}
	
}
