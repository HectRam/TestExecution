package com.sdet.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sdet.main.TestMain;
import com.sdet.utilities.waits;

public class priceComparison extends TestMain {

	@Test
	public void priceCompare() throws InterruptedException {

		System.out.println("Starting priceComparison------------------------");

		//driver.get("https://www.microsoft.com/en-us/d/visual-studio-professional-2026/dg7gmgf0d3sj?activetab=pivot:overviewtab");
		waits.CvisibilityOfElementLocated("#emailSup-modal");// Waits for pop up to appear

		waits.CelementToBeClickable("#emailSup-modal");
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#emailSup-modal")).click();// button.close:nth-child(1) Close Pop Up

		waits.CelementToBeClickable("button.close:nth-child(3)");
		driver.findElement(By.cssSelector("button.close:nth-child(3)")).click();

		String price1 = driver.findElement(By.cssSelector("p.h3 > span:nth-child(1)")).getText();
		System.out.println("Price 1: " + price1);

		waits.CvisibilityOfElementLocated("#emailSup-modal");//Waits for pop up to disappear
		Thread.sleep(1000);
		waits.XelementToBeClickable("//button[@id='buybox-cta-proper']");
		driver.findElement(By.id("buybox-cta-proper")).click();// add it to the cart

		waits.XpresenceOfElementLocated("//span[text()='Home']");//waits for the element to be displayed
									 
		driver.findElement(By.xpath("//span[@class='uhf-cart-text']")).click();// click into cart button next to search and is sent into checkout page
		driver.switchTo().frame("purchase-frame"); // switching the frame by ID
		System.out.println("switching the frame by ID");
		String price2 = driver
				.findElement(By.xpath(
						"//div[@class='cartco-cart-item-price']/div/div/div[2]/span[contains(text(),'$499.00')]"))
				.getText();
		System.out.println("Price 2: " + price2);
		prices(price1, price2);

		System.out.println("Finishing priceComparison------------------------");
		
	}

	public static void prices(String price, String price2) {

		String pricecorr = price.substring(0, 5);
		String pricecorr2 = price2.substring(0, 5);

		

		if (pricecorr.equals(pricecorr2)) {
			System.out.println("Same price");
			
		} else {
			//Assert.assertEquals(true, pricecorr.equals(pricecorr2));
			Assert.fail("Different price");
		}
		

	}

}
