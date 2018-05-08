package com.puma.Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoconst {
	public WebDriver driver;
	//Opening Application
	
	@BeforeMethod
	public void openApp()
	{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		driver=new FirefoxDriver();
		driver.get("https://in.puma.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	//Closing Application
	
	@AfterMethod
	public void closeApp()
	{
		driver.quit();
	}
}
