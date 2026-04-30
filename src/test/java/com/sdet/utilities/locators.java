package com.sdet.utilities;

import org.openqa.selenium.By;


import com.sdet.main.TestMain;

public class locators extends TestMain {

	public static boolean Locate(By by) {

		if (!driver.findElements(by).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void Click(String element) {
		if (element.endsWith("_X")) {
			driver.findElement(By.xpath(OR.getProperty(element))).click();
		} else if (element.endsWith("_C")) {
			driver.findElement(By.cssSelector(OR.getProperty(element))).click();
		} else if (element.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(element))).click();
		}
	}

}
