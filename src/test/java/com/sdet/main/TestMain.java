package com.sdet.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestMain {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;

	@BeforeSuite
	public void SetUp() {

		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {

				// WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver();
				// driver = new ChromeDriver();
				System.out.println("Firefox launched ");
			}
			if (config.getProperty("browser").equals("chrome")) {

				// WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				// driver = new ChromeDriver();
				System.out.println("Chrome launched ");
			}
			driver.get(config.getProperty("testsiteurl"));
			System.out.println("Navigated to: " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			XpresenceOfElementLocated("//img[@alt='Microsoft']");// Waits for webpage to be displayed
		}
	}

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

	@AfterSuite
	public void TearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

}
