package com.sdet.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sdet.main.TestMain;
import com.sdet.utilities.waits;

public class printAllElements extends TestMain {

	@Test
	public void printAll() throws InterruptedException {

		System.out.println("Starting printAllElements------------------------");
		driver.findElement(By.xpath("//div[@class='uhf-overflow-menu-items']/a[4]")).click();// On Url https://www.microsoft.com/en-us/ clicks on windows
															// button
		// driver.get("https://www.microsoft.com/en-us/windows/");
		waits.XpresenceOfElementLocated("//a[@id='uhfCatLogo']");

		driver.findElement(By.cssSelector("div.c-uhf-menu.js-nav-menu")).click();
		Thread.sleep(3000);
		WebElement liElements = driver.findElement(By.cssSelector("div.c-uhf-menu.js-nav-menu"));

		List<WebElement> ListItems = liElements.findElements(By.tagName("li"));

		System.out.println(ListItems.size());
		for (WebElement e : ListItems) {
			System.out.println("List Item Text : " + e.getText());
		}

		System.out.println("Finishing printAllElements------------------------");
	}

}
