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

public class searchBox extends TestMain {

	@Test
	public void search() throws NumberFormatException, InterruptedException {

		System.out.println("Starting searchBox------------------------");
		log.info("Starting searchBox");
		// driver.get("https://www.microsoft.com/en-us/windows/?r=1");

		// waits.presenceOfElementLocated("SearchBox_C");

		locators.Click("SearchBox_C");

		// driver.findElement(By.cssSelector(OR.getProperty("SearchInput_C"))).sendKeys("Visual
		// Studio Professional 2026");// SendsValues
		locators.Write("SearchInput_C", "Visual Studio Professional 2026");
		Thread.sleep(Long.parseLong("1000"));
		List<WebElement> LIST = driver.findElements(By.cssSelector(OR.getProperty("ListArticles_C")));

		for (int i = 0; i < LIST.size(); i++) {
			// System.out.println(LIST.get(i).getText());
			if (LIST.get(i).getText().contains("Visual Studio Professional 2026")) {
				LIST.get(i).click();
				System.out.println("Visual Studio Professional 2026 Found and Clicked");
				log.info("Visual Studio Professional 2026 Found and Clicked");
				ExtentListeners.test.log(Status.PASS, "Visual Studio Professional 2026 Found and Clicked");
			} else {
				ExtentListeners.test.log(Status.FAIL, "Visual Studio Professional 2026 was not Found");
				log.error("Visual Studio Professional 2026 was not Found");
				Assert.fail("Visual Studio Professional 2026 was not Found");
			}
		}
		log.info("Finishing searchBox");
		System.out.println("Finishing searchBox------------------------");

	}

}
