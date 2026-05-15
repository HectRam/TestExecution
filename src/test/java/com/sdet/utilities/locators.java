package com.sdet.utilities;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.sdet.extentlisteners.ExtentListeners;
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
		
		try {
		if (element.endsWith("_X")) {
			driver.findElement(By.xpath(OR.getProperty(element))).click();
		} else if (element.endsWith("_C")) {
			driver.findElement(By.cssSelector(OR.getProperty(element))).click();
		} else if (element.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(element))).click();
		}
		}catch(Throwable t){
			log.error("Error Clicking on an Element : " + element + " error message : " + t.getMessage());
			ExtentListeners.test.log(Status.FAIL,
					"Error Clicking on an Element : " + element + " error message : " + t.getMessage());
			Assert.fail("Error Clicking on an Element : "+ element+" error message : "+t.getMessage());
		}
	}
	
	public static void Write(String element, String value) {
		try {
			if (element.endsWith("_X")) {
				driver.findElement(By.xpath(OR.getProperty(element))).sendKeys(value);
			} else if (element.endsWith("_C")) {
				driver.findElement(By.cssSelector(OR.getProperty(element))).sendKeys(value);
			} else if (element.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(element))).sendKeys(value);
			}
			log.info("typing in an Element : " + element + " entered the value as : " + value);
			ExtentListeners.test.log(Status.INFO,
					"typing in an Element : " + element + " entered the value as : " + value);
		} catch (Throwable t) {

			log.error("Error while typing in Element : " + element + " error message : " + t.getMessage());
			ExtentListeners.test.log(Status.FAIL,
					"Error while typing in Element : " + element + " error message : " + t.getMessage());
			Assert.fail(t.getMessage());

		}

	}
}
