package com.sdet.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sdet.main.TestMain;

public class searchBox extends TestMain{

	
@Test
	public void search() throws NumberFormatException, InterruptedException {
		
			System.out.println("Starting searchBox------------------------");
			//driver.get("https://www.microsoft.com/en-us/windows/?r=1");
		 Thread.sleep(7000);
		    driver.findElement(By.cssSelector("#search > span:nth-child(1)")).click();
		    driver.findElement(By.id("cli_shellHeaderSearchInput")).sendKeys("Visual Studio Professional 2026");//Sends Values
		    Thread.sleep(Long.parseLong("1000"));
		    List<WebElement> LIST = driver.findElements(By.cssSelector("#universal-header-search-auto-suggest-ul > li:nth-child(1) > a:nth-child(1) > div:nth-child(2)"));
		    

		    for (int i = 0; i < LIST.size(); i++)
		    {
		        //System.out.println(LIST.get(i).getText());
		        if (LIST.get(i).getText().contains("Visual Studio Professional 2026"))
		        {
		            LIST.get(i).click();
		           System.out.println("Visual Studio Professional 2026 Found and Clicked");
		        }
		    }
		    System.out.println("Finishing searchBox------------------------");
		    Thread.sleep(3000);
		
	}
	
}
