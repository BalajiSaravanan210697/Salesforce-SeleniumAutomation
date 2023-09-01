package com.salesforce.genericmethods;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public ChromeDriver driver;
	public Properties configProp;

	@BeforeClass  
	public Properties readProperties() throws IOException {

		FileReader reader=new FileReader("./src/main/java/utils/config.properties");  	    
		configProp=new Properties();  
		configProp.load(reader);  	    
		return configProp;

	}

	@BeforeMethod
	public void Setup() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.setBrowserVersion("116");
		// set up browser
		driver = new ChromeDriver(options);
		// Maximize the browser
		driver.manage().window().maximize();
		// Global time wait to handle all slowness over application
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

		// launch the URL
		driver.get(configProp.getProperty("url"));

		// user name entered using id locator
		driver.findElement(By.id("username")).sendKeys(configProp.getProperty("username"));
		// password entered using id locator
		driver.findElement(By.id("password")).sendKeys(configProp.getProperty("password"));
		// Login clicked using id locator
		driver.findElement(By.id("Login")).click();
	}
	
	@AfterMethod
	public void close() {
		// closing the browser
		driver.close();
	}

	public WebElement waitForClickable(By Locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.elementToBeClickable(Locator));
	}


}
