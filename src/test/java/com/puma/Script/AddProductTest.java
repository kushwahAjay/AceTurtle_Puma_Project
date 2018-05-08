package com.puma.Script;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.puma.Generic.BaseTest;
import com.puma.POM.HomePage;
import com.puma.POM.Ignite_shoesPage;

public class AddProductTest extends BaseTest {
	@Test
	public void addProduct() throws InterruptedException
	{
		//Title matching
		Assert.assertEquals(driver.getTitle(),"Buy Sports T-Shirts, Tracks, Running Shoes and Accessories Online - in.puma.com");
		Reporter.log("Titles are same",true);
		
		//Creating object for HomePage
		HomePage hp=new HomePage(driver);
		hp.menShoe(2);
		
		//Switching between tabs
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		
		for(String wh:allWindows)
		{
			driver.switchTo().window(wh);
			
		}
		
		//Creating object for IGNITEevoKNITPage
		Ignite_shoesPage ip=new Ignite_shoesPage(driver);
		ip.addToCart();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.titleContains("Shopping Cart"));
		
		String productName=driver.findElement(By.xpath("//table[@id='shopping-cart-table']//h2/a")).getText();
		System.out.println(productName);
		
		//Verifying text using assert
		Assert.assertEquals(productName,"IGNITE EvoKNIT Lo 2 Men's Running Shoes");
		Reporter.log("text IGNITE EvoKNIT Lo 2 Men's Running Shoes is present",true);
		
		String value1 = driver.findElement(By.xpath("//td//select/option[@selected='selected']")).getText();
		//System.out.println(value1);
		Assert.assertEquals(value1, "1");
		Reporter.log("Quantity is present:one",true);
		
	}
}
