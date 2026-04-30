package com.sdet.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.sdet.main.TestMain;
import com.sdet.utilities.locators;
import com.sdet.utilities.waits;

public class priceComparison extends TestMain {

	@Test
	public void priceCompare() throws InterruptedException {

		System.out.println("Starting priceComparison------------------------");

		//driver.get("https://www.microsoft.com/en-us/d/visual-studio-professional-2026/dg7gmgf0d3sj?activetab=pivot:overviewtab");
		waits.visibilityOfElementLocated("PopUp_C");// Waits for pop up to appear

		waits.elementToBeClickable("PopUp_C");
		Thread.sleep(4000);
		locators.Click("PopUp_C");// button.close:nth-child(1) Close Pop Up

		waits.elementToBeClickable("PopUpXBtn_C");
		locators.Click("PopUpXBtn_C");

		String price1 = getTxt("GetPrice1_C");
		System.out.println("Price 1: " + price1);

		Thread.sleep(1000);
		waits.elementToBeClickable("BuyBox_X");
		locators.Click("BuyBox_ID");// add it to the cart

		waits.presenceOfElementLocated("WaitforHomeBtn_X");// waits for the element to be displayed

		locators.Click("CartBtn_X");// click into cart button next to search and
																			// is sent into checkout page
		driver.switchTo().frame("purchase-frame"); // switching the frame by ID
		System.out.println("switching the frame by ID");
		String price2 = getTxt("GetPrice2_X");
		System.out.println("Price 2: " + price2);
		prices(price1, price2);

		System.out.println("Finishing priceComparison------------------------");

	}

	public static void prices(String price, String price2) {

		if (price.substring(0, 5).equals(price2.substring(0, 5))) {
			System.out.println("Same price");

		} else {
			// Assert.assertEquals(true, pricecorr.equals(pricecorr2));
			Assert.fail("Different price");
		}

	}

}
