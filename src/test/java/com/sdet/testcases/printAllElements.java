package com.sdet.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sdet.extentlisteners.ExtentListeners;
import com.sdet.main.TestMain;
import com.sdet.utilities.locators;
import com.sdet.utilities.waits;

public class printAllElements extends TestMain {

	@Test
	public void printAll() throws InterruptedException {

		System.out.println("Starting printAllElements------------------------");
		log.info("Starting printAllElements");
		locators.Click("Windows_X");// clicks on windows button
		// driver.get("https://www.microsoft.com/en-us/windows/");
		// waits.presenceOfElementLocated("WaitCatLogo_X");

		locators.Click("AboutWindows_C");
		Thread.sleep(3000);
		WebElement liElements = FindElement("AboutWindows_C");

		List<WebElement> ListItems = liElements.findElements(By.tagName("li"));

		System.out.println(ListItems.size());
		log.info(ListItems.size());
		if (ListItems.size() > 0 && ListItems.size() <= 12) {
			for (WebElement e : ListItems) {
				System.out.println("List Item Text : " + e.getText());
				log.info("List Item Text : " + e.getText());
				ExtentListeners.test.log(Status.INFO, "List Item Text : : " + e.getText());
			}
			ExtentListeners.test.log(Status.PASS, "About Windows Items were listed successfuly");
			log.info("About Windows Items were listed successfuly");
		} else {
			ExtentListeners.test.log(Status.FAIL,
					"There are 0 or more tha 12 Items listed. Actual: " + ListItems.size());
			log.error("There are 0 or more tha 12 Items listed. Actual: " + ListItems.size());
			Assert.fail("There are 0 or more tha 12 Items listed. Actual: " + ListItems.size());
		}
		log.info("Finishing printAllElements");
		System.out.println("Finishing printAllElements------------------------");
	}

}
