package com.sdet.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.sdet.main.TestMain;

public class printAllElements extends TestMain {

	@Test
	public void printAll() throws InterruptedException {
		
		System.out.println("Starting printAllElements------------------------");
		driver.findElement(By.id("shellmenu_3")).click();//On Url https://www.microsoft.com/en-us/ clicks on windows button 
		//driver.get("https://www.microsoft.com/en-us/windows/");
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='uhfCatLogo']")));
		
		
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
