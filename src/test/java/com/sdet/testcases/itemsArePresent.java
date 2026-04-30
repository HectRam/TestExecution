package com.sdet.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sdet.main.TestMain;

public class itemsArePresent extends TestMain {

	private static int n = 0;
	private static List<String> names = list();

	@Test
	public void itemspresent() {

		System.out.println("Starting itemsArePresent--------------");

		WebElement liElements = FindElement("SelectMenuItems_X");
		
		List<WebElement> ListItems = liElements.findElements(By.xpath(OR.getProperty("SearchOnAllItems_X")));

		System.out.println(ListItems.size());
		if (ListItems.size() <= 9) {

			for (WebElement e : ListItems) {

				if (e.getText().equals(names.get(n))) {
					System.out.println(e.getText() + " is Present");
				} else {
					Assert.fail(names.get(n) + " is Absent");
				}
				n++;
			}
		} else {
			Assert.fail("There are more Menu Items than expected. Actual: " + ListItems.size());
		}

		System.out.println("Finishing itemsArePresent------------------------");

	}

	public static List<String> list() {

		List<String> names = new ArrayList<>();
		Collections.addAll(names, "Microsoft 365", "Azure", "Copilot", "Windows", "Surface", "Xbox", "Deals",
				"Small Business", "Support");
		return names;
	}

}
