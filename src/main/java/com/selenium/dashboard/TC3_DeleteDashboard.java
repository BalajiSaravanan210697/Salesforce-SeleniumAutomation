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
6. Click on the Dropdown icon and Select Delete
7.Click on the Delete option in the displayed popup window.
8. Verify Whether Dashboard is Deleted using Dashboard Name"

 */
public class TC3_DeleteDashboard extends BaseClass{

	@Test
	public void TC3_DeleteDashboard() throws InterruptedException {

		waitForClickable(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		waitForClickable(By.xpath("//button[text()=\"View All\"]")).click();
		waitForClickable(By.xpath("//input[@class=\"slds-input\"]")).sendKeys("Dashboard");
		waitForClickable(By.xpath("//mark[text()='Dashboard']")).click();
		waitForClickable(By.xpath("//input[@placeholder=\"Search recent dashboards...\"]")).click();

		driver.findElement(By.xpath("//input[@placeholder=\"Search recent dashboards...\"]")).sendKeys("Salesforce Automation By");
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor)driver;		
		WebElement account = driver.findElement(By.xpath("(//lightning-button-menu[@class=\"slds-dropdown-trigger slds-dropdown-trigger_click\"])[1]"));
		js.executeScript("arguments[0].click();", account);
		
		waitForClickable(By.xpath("//span[text()='Delete']")).click();
		waitForClickable(By.xpath("//button[@title=\"Delete\"]")).click();
		
		Thread.sleep(1000);
		String toastMessage = driver.findElement(By.xpath("//span[@data-aura-class=\"forceActionsText\"]")).getText();
		Assert.assertEquals(toastMessage, "Dashboard was deleted.");
	}

}
