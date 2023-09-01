package com.salesforce.dashboard;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

/*
 * "Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Dashboards from App Launcher
4. Click on the New Dashboard option
5. Enter Name as 'Salesforce Automation by *Your Name* ' and Click on Create.
6.Click on Save and Verify Dashboard name."

 */
public class TC1_CreateNewDashboard extends BaseClass{
	@Test
	public void TC1_CreateNewDashboard() {

		waitForClickable(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		waitForClickable(By.xpath("//button[text()=\"View All\"]")).click();
		driver.findElement(By.xpath("//input[@class=\"slds-input\"]")).sendKeys("Dashboard");
		waitForClickable(By.xpath("//mark[text()='Dashboard']")).click();

		waitForClickable(By.xpath("//div[@title=\"New Dashboard\"]")).click();
		
		WebElement Frame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(Frame);
		
		waitForClickable(By.xpath("//input[@id=\"dashboardNameInput\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"dashboardNameInput\"]")).sendKeys("Salesforce Automation By Gayathri");
		waitForClickable(By.xpath("//button[@id=\"submitBtn\"]")).click();

		waitForClickable(By.xpath("//button[text()='Save']")).click();
		
		String strDashboardMessage = (driver.findElement(By.xpath("(//div[@class=\"slds-form-element editTitle\"]//span)[1]")).getText().split("Edit"))[0];
		if(strDashboardMessage.contains("Salesforce Automation By Gayathri")) {
			System.out.println("Dashboard "+strDashboardMessage+" has been created");
		}
	}

}
