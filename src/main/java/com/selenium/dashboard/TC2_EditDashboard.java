package com.selenium.dashboard;

import java.time.Duration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;
/*
 * "Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Dashboards from App Launcher
4. Click on the Dashboards tab 
5. Search the Dashboard 'Salesforce Automation by *Your Name*'
6. Click on the Dropdown icon and Select Edit
7.Click on the Edit Dashboard Properties icon
8. Enter Description as 'SalesForce' and click on save.
9. Click on Done and  Click on save in the popup window displayed.
10. Verify the Description."

 */
public class TC2_EditDashboard extends BaseClass{
	@Test(dependsOnMethods = "com.selenium.dashboard.TC1_CreateNewDashboard.createNewDashboard")
	public void editDashboard() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		waitForClickable(By.xpath("//button[text()=\"View All\"]")).click();
		waitForClickable(By.xpath("//input[@class=\"slds-input\"]")).sendKeys("Dashboard");
		waitForClickable(By.xpath("//mark[text()='Dashboard']")).click();

		waitForClickable(By.xpath("//div[@data-aura-class=\"forceSearchAssistant\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Search recent dashboards...\"]")).sendKeys("Salesforce Automation By Gayathri",Keys.ENTER);
		Thread.sleep(1000);
		waitForClickable(By.xpath("(//lightning-primitive-cell-actions[@data-action-triggers=\"enter,space\"])[1]")).click();
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		WebElement account = driver.findElement(By.xpath("//a[@role=\"menuitem\"]//span[text()=\"Edit\"]"));
		js.executeScript("arguments[0].click();", account);

		
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@title=\"dashboard\"]"));
		driver.switchTo().frame(frame1);
		Thread.sleep(2000);
		waitForClickable(By.xpath("//div[@class=\"commandControls\"]//button[@title=\"Edit Dashboard Properties\"]")).click();
	
		driver.findElement(By.xpath("//*[@id=\"dashboardNameInput\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"dashboardNameInput\"]")).sendKeys("Salesforce");
		driver.findElement(By.xpath("//input[@id=\"dashboardDescriptionInput\"]")).sendKeys("Salesforce");
		driver.findElement(By.xpath("//button[@id=\"submitBtn\"]")).click();

		waitForClickable(By.xpath("//button[text()='Save']")).click();
		waitForClickable(By.xpath("//button[@type=\"button\" and text()='Done']")).click();
		WebElement save = driver.findElement(By.xpath("(//button[text()='Save'])[2]"));
		driver.executeScript("arguments[0].click();", save);
		String text = driver.findElement(By.xpath("//p[text()='Salesforce']")).getText();
		driver.switchTo().defaultContent();
		Assert.assertEquals(text, "Salesforce");
	}	
}
