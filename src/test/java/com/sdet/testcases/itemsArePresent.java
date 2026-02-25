package com.sdet.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.sdet.main.TestMain;

public class itemsArePresent extends TestMain{

	
	@Test
	public void itemspresent() throws InterruptedException {
		
			System.out.println("Starting itemsArePresent--------------");
		if(driver.findElements(By.id("m365btn_id"))!= null){
			System.out.println("Microsoft 365 is Present");
			}else{
			System.out.println("Microsoft 365 is Absent");
			}
		
		if(driver.findElements(By.id("teams_id"))!= null){
			System.out.println("Teams is Present");
			}else{
			System.out.println("Teams is Absent");
			}
		if(driver.findElements(By.id("copilot_id"))!= null){
			System.out.println("Copilot is Present");
			}else{
			System.out.println("Copilot is Absent");
			}
		if(driver.findElements(By.id("windows_id"))!= null){
			System.out.println("Windows is Present");
			}else{
			System.out.println("Windows is Absent");
			}
		if(driver.findElements(By.id("surface_id"))!= null){
			System.out.println("Surface is Present");
			}else{
			System.out.println("Surface is Absent");
			}
		if(driver.findElements(By.id("xbox_id"))!= null){
			System.out.println("Xbox is Present");
			}else{
			System.out.println("Xbox is Absent");
			}
		if(driver.findElements(By.id("deals_id"))!= null){
			System.out.println("Deals is Present");
			}else{
			System.out.println("Deals is Absent");
			}
		if(driver.findElements(By.id("small_bussines_id_"))!= null){
			System.out.println("Small Bussiness is Present");
			}else{
			System.out.println("Small Bussiness is Absent");
			}
		if(driver.findElements(By.id("support_id"))!= null){
			System.out.println("Support is Present");
			}else{
			System.out.println("Support is Absent");
			}
		
		System.out.println("Finishing itemsArePresent------------------------");
		//Thread.sleep(3000);
		
		
	}
}
