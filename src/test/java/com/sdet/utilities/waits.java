package com.sdet.utilities;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdet.main.TestMain;

public class waits extends TestMain{
	
	/*
	 * Functions that wait for an element to be visible
	 */
	public static void XpresenceOfElementLocated(String element) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
	}

	public static void CpresenceOfElementLocated(String element) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(element)));
	}

	public static void CvisibilityOfElementLocated(String element) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
	}

	public static void CelementToBeClickable(String element) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(element)));
	}

	public static void XelementToBeClickable(String element) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
	}

}
