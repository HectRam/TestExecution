package com.sdet.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.Status;
import com.sdet.extentlisteners.ExtentListeners;
import com.sdet.utilities.waits;

public class TestMain {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;
	protected static Logger log = LogManager.getLogger(TestMain.class.getName());

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
				log.info("Firefox launched ");
			}
			if (config.getProperty("browser").equals("chrome")) {

				// WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				// driver = new ChromeDriver();
				System.out.println("Chrome launched ");
				log.info("Chrome launched ");
			}
			driver.get(config.getProperty("testsiteurl"));
			System.out.println("Navigated to: " + config.getProperty("testsiteurl"));
			log.info("Navigated to: " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
			waits.presenceOfElementLocated("MainMenuBtn_X");
		}
	}

	public WebElement FindElement(String locator) {

		WebElement res = null;

		if (locator.endsWith("_X")) {
			res = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_C")) {
			res = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else {

			ExtentListeners.test.log(Status.INFO, "Element not found : " + locator);
			log.error("Element not found : " + locator);
			Assert.fail("Unable to find Element on FindElement Method");
		}
		ExtentListeners.test.log(Status.INFO, "Finding Element : " + locator);
		log.info("Finding Element : " + locator);
		return res;
	}

	public String getTxt(String element) {

		try {
			if (element.endsWith("_C")) {
				element = driver.findElement(By.cssSelector(OR.getProperty(element))).getText();
			} else if (element.endsWith("_X")) {
				element = driver.findElement(By.xpath(OR.getProperty(element))).getText();

			}

		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL,
					"Unable to find Element on getTxt Method : " + element + " error message : " + t.getMessage());
			log.error("Unable to find Element on getTxt Method : " + element + " error message : " + t.getMessage());
			Assert.fail("Unable to find Element on getTxt Method : " + t.getMessage());
		}
		ExtentListeners.test.log(Status.INFO, "Getting text on Element : " + element);
		log.info("Getting text on Element : " + element);
		return element;
	}

	@AfterSuite
	public void TearDown() {

		if (driver != null) {
			driver.quit();
			log.info("Test Execution Completed");
		}
	}

}
