package com.salesforce.genericmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ChromeDriver driver;
  
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
		driver.get("https://login.salesforce.com");

		// user name entered using id locator
		driver.findElement(By.id("username")).sendKeys("balajisara1997@gmail.com");
		// password entered using id locator
		driver.findElement(By.id("password")).sendKeys("Balaji@008");
		// Login clicked using id locator
		driver.findElement(By.id("Login")).click();
	}
    
    @AfterMethod
    public void close() {
    	// closing the browser
    			driver.close();
    }

}
