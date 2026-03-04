package com.sdet.testcases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;



import com.sdet.main.TestMain;

public class priceComparison extends TestMain{

	
	@Test
	public void priceCompare() {
		
		System.out.println("Starting priceComparison------------------------");
		
		driver.get("https://www.microsoft.com/en-us/d/visual-studio-professional-2026/dg7gmgf0d3sj?activetab=pivot:overviewtab");
		wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#emailSup-modal")))); //Waits for pop up to appear 
		
			wait.until((ExpectedConditions.elementToBeClickable(By.cssSelector("#emailSup-modal"))));
		driver.findElement(By.cssSelector("#emailSup-modal")).click();//button.close:nth-child(1) Close Pop Up
		
		
		wait.until((ExpectedConditions.elementToBeClickable(By.cssSelector("button.close:nth-child(3)"))));
		driver.findElement(By.cssSelector("button.close:nth-child(3)")).click();
		
		String price1 = driver.findElement(By.cssSelector("p.h3 > span:nth-child(1)")).getText();
		System.out.println("Price 1: "+price1);
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#emailSup-modal")));//Waits for pop up to disappear 
			wait.until((ExpectedConditions.elementToBeClickable(By.id("buybox-cta-proper"))));
		driver.findElement(By.id("buybox-cta-proper")).click();//add it to the cart
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Home']")));//waits for the element to be displayed
		
		driver.findElement(By.id("uhf-shopping-cart")).click();//click into cart button next to search and is sent into checkout page
		
		
		driver.switchTo().frame("purchase-frame"); //switching the frame by ID
		System.out.println("switching the frame by ID");
		String price2 = driver.findElement(By.xpath("//div[@class='cartco-cart-item-price']/div/div/div[2]/span[contains(text(),'$499.00')]")).getText();
		System.out.println("Price 2: "+price2);
			 prices(price1,price2); 
			
		System.out.println("Finishing priceComparison------------------------");	
			
	}
	
	public static void prices(String price,String price2) {

		
		String pricecorr = price.substring(0, 5);
		String pricecorr2 = price2.substring(0, 5);

		boolean result = pricecorr.equals(pricecorr2);

		if (result == true) {
			System.out.println("Same price");
		} else {
			System.out.println("Different price");
		}
		Assert.assertEquals(true,result);
		
	}
	
	
	
	
}
