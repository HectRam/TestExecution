package com.sdet.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sdet.main.TestMain;
import com.sdet.utilities.locators;
import com.sdet.utilities.waits;

public class printAllElements extends TestMain {

	@Test
	public void printAll() throws InterruptedException {

		System.out.println("Starting printAllElements------------------------");
		locators.Click("Windows_X");// clicks on windows button
		// driver.get("https://www.microsoft.com/en-us/windows/");
		waits.presenceOfElementLocated("WaitCatLogo_X");

		locators.Click("AboutWindows_C");
		Thread.sleep(3000);
		WebElement liElements = FindElement("AboutWindows_C");

		List<WebElement> ListItems = liElements.findElements(By.tagName("li"));

		System.out.println(ListItems.size());
		for (WebElement e : ListItems) {
			System.out.println("List Item Text : " + e.getText());
		}

		System.out.println("Finishing printAllElements------------------------");
	}

}
