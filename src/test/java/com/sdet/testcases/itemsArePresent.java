package com.sdet.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sdet.main.TestMain;

public class itemsArePresent extends TestMain {

	@Test
	public void itemspresent() {

		System.out.println("Starting itemsArePresent--------------");
		
		
		if (!driver.findElements(By.xpath("//div[@class='uhf-overflow-menu-items']/a[1]")).isEmpty()) {
			System.out.println("Microsoft 365 is Present");
		} else {
			Assert.fail("Microsoft 365 is Absent");
		}

		if (!driver.findElements(By.xpath("//div[@class='uhf-overflow-menu-items']/a[2]")).isEmpty()) {
			System.out.println("Teams is Present");
		} else {
			Assert.fail("Teams is Absent");
			
		}
		if (!driver.findElements(By.xpath("//div[@class='uhf-overflow-menu-items']/a[3]")).isEmpty()) {
			System.out.println("Copilot is Present");
		} else {
			Assert.fail("Copilot is Absent");
		}
		if (!driver.findElements(By.xpath("//div[@class='uhf-overflow-menu-items']/a[4]")).isEmpty()) {
			System.out.println("Windows is Present");
		} else {
			Assert.fail("Windows is Absent");
		}
		if (!driver.findElements(By.xpath("//div[@class='uhf-overflow-menu-items']/a[5]")).isEmpty()) {
			System.out.println("Surface is Present");
		} else {
			Assert.fail("Surface is Absent");
		}
		if (!driver.findElements(By.xpath("//div[@class='uhf-overflow-menu-items']/a[6]")).isEmpty()) {
			System.out.println("Xbox is Present");
		} else {
			Assert.fail("Xbox is Absent");
		}
		if (!driver.findElements(By.xpath("//div[@class='uhf-overflow-menu-items']/a[7]")).isEmpty()) {
			System.out.println("Deals is Present");
		} else {
			Assert.fail("Deals is Absent");
		}
		if (!driver.findElements(By.xpath("//div[@class='uhf-overflow-menu-items']/a[8]")).isEmpty()) {
			System.out.println("Small Bussiness is Present");
		} else {
			Assert.fail("Small Bussiness is Absent");
		}
		if (!driver.findElements(By.xpath("//div[@class='uhf-overflow-menu-items']/a[9]")).isEmpty()) {
			System.out.println("Support is Present");
		} else {
			Assert.fail("Support is Absent");
		}

		System.out.println("Finishing itemsArePresent------------------------");

	}
}
