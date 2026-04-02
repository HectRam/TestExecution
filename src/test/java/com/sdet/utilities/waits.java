package com.sdet.utilities;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdet.main.TestMain;

public class waits extends TestMain{
	
	/*
	 * Function that wait for an element to be visible
	 */
	public static void waitFor(String element) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
		//new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));//system waits 30 seconds
	}

}
