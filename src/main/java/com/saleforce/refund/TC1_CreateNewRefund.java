package com.saleforce.refund;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;
/*
 * "Test Steps:
1. Login to https://login.salesforce.com/?locale=in
2. Click on menu button from the Left corner
3. Click view All and click Service Console from App Launcher
4. Click on the drop down and select Refunds
5. Click on New
6. Select Account name
7. Select Status as Canceled
8. Give Amount as 50000 and select Referenced in Type
9. Select Processing Mode as External
10. Click Save"

 */
public class TC1_CreateNewRefund extends BaseClass{
	@Test
	public void TC3_DeleteDashboard() throws InterruptedException {

	driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
	waitForClickable(By.xpath("//button[text()=\"View All\"]")).click();


	waitForClickable(By.xpath("//input[@class=\"slds-input\"]")).sendKeys("Refunds");
	waitForClickable(By.xpath("//mark[text()='Refunds']")).click();
	waitForClickable(By.xpath("//a[@title=\"New\"]")).click();

	waitForClickable(By.xpath("(//input[@role=\"combobox\"])[1]")).click();
	waitForClickable(By.xpath("//div[@title=\"TestLeaf\"]")).click();
	
	waitForClickable(By.xpath("(//a[text()='--None--'])[1]")).click();
	
	waitForClickable(By.xpath("//a[text()='Canceled']")).click();
	driver.findElement(By.xpath("//input[@data-aura-class=\"uiInputSmartNumber\"]")).sendKeys("50000");
	driver.findElement(By.xpath("(//a[text()='--None--'])[1]")).click();

	driver.findElement(By.xpath("//a[text()='Referenced']")).click();
	
	driver.findElement(By.xpath("(//a[text()='--None--'])[1]")).click();
	driver.findElement(By.xpath("//a[text()='External']")).click();
	driver.findElement(By.xpath("//button[@title=\"Save\"]//span[text()=\"Save\"]")).click();

	}
}
