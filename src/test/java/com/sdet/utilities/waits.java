package com.sdet.utilities;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdet.main.TestMain;

public class waits extends TestMain {

	/*
	 * Functions that wait for an element to be visible
	 */

	public static void presenceOfElementLocated(String element) {
		if (element.endsWith("_C")) {
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OR.getProperty(element))));
		} else if (element.endsWith("_X")) {
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty(element))));
		}
	}

	public static void visibilityOfElementLocated(String element) {
		if (element.endsWith("_C")) {
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OR.getProperty(element))));
		} else if (element.endsWith("_X")) {
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(element))));
		}
	}

	public static void elementToBeClickable(String element) {
		if (element.endsWith("_C")) {
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty(element))));
		} else if (element.endsWith("_X")) {
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(element))));
		}
	}

}
