package com.sdet.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.sdet.main.TestMain;

public class priceComparison extends TestMain{

	
	@Test
	public void priceCompare() throws InterruptedException {
		
		
		System.out.println("Starting priceComparison------------------------");
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//driver.get("https://www.microsoft.com/en-us/d/visual-studio-professional-2026/dg7gmgf0d3sj?activetab=pivot:overviewtab");
		Thread.sleep(7000);
		driver.findElement(By.cssSelector(".modal.fade.renderModalOnPageLoad")).click();//button.close:nth-child(1) Close Pop Up
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.close:nth-child(3)")).click();
		String price1 = driver.findElement(By.cssSelector("p.h3 > span:nth-child(1)")).getText();
		System.out.println("Price 1: "+price1);
		Thread.sleep(1000);
		driver.findElement(By.id("buybox-cta-proper")).click();//add it to the cart
		Thread.sleep(6000);
		driver.findElement(By.id("uhf-shopping-cart")).click();//click into cart button next to search and is sent into checkout page
		Thread.sleep(6000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Home']")));//waits for the element to be displayed
		driver.switchTo().frame("purchase-frame"); //switching the frame by ID
		String price2 = driver.findElement(By.xpath("//div[@class='cartco-cart-item-price']/div/div/div[2]/span[contains(text(),'$499.00')]")).getText();
		System.out.println("Price 2: "+price2);
			 prices(price1,price2);
			
			
			
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
		System.out.println("Finishing priceComparison------------------------");
	}
	
	
	
	
}
