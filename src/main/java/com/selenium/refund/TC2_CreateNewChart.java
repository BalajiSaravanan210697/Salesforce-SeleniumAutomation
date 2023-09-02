package com.selenium.refund;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;
/*
 * "Test Steps:
1. Login to https://login.salesforce.com/?locale=in
2. Click on menu button from the Left corner
3. Click view All and click Service Console from App Launcher
4. Click on the drop down and select Refunds
5.Click on drop down near Recently viewed and change into 'All'.
6. Click on Chart icon under New Button
7. Click New Chart
8. Give Chart Name and Select Chart Type
9. Select Aggregate Type as Average and ggregate Field as Amount
10. Select Grouping Field as Account and click Save
11. Click on settings icon and change the Chart Type"

 */
public class TC2_CreateNewChart extends BaseClass {
	
	@Test
	public void TC2_CreateNewChart() throws InterruptedException {

		/*
		 * "Test Steps:
			1. Login to https://login.salesforce.com/?locale=in
			2. Click on menu button from the Left corner
			3. Click view All and click Service Console from App Launcher
			4. Click on the drop down and select Refunds
			5. Click on drop down near Recently viewed and change into 'All'.
			6. Click on Chart icon under New Button
			7. Click New Chart
			8. Give Chart Name and Select Chart Type
			9. Select Aggregate Type as Average and ggregate Field as Amount
			10. Select Grouping Field as Account and click Save
			11. Click on settings icon and change the Chart Type"

		 */

		driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		waitForClickable(By.xpath("//button[text()=\"View All\"]")).click();
		waitForClickable(By.xpath("//input[@class=\"slds-input\"]")).sendKeys("Service Console");
		driver.findElement(By.xpath("//mark[text()='Service Console']")).click();
		Thread.sleep(1000);
		waitForClickable(By.xpath("//button[@title=\"Show Navigation Menu\"]")).click();
		waitForClickable(By.xpath("//a[@href=\"/lightning/o/Refund/home\"]")).click();
		waitForClickable(By.xpath("//button[@title=\"Select a List View: Refunds\"]")).click();
		Thread.sleep(1000);
		waitForClickable(By.xpath("(//li[@data-aura-class=\"forceVirtualAutocompleteMenuOption\"])[2]")).click();
		waitForClickable(By.xpath("//button[@title=\"Show charts\"]")).click();
		waitForClickable(By.xpath("//lightning-icon[@icon-name=\"utility:settings\"]//lightning-primitive-icon")).click();
		waitForClickable(By.xpath("//a[@title=\"New Chart\"]")).click();
		
		Thread.sleep(1000);
		WebElement chartName = driver.findElement(By.xpath("//input[@class=\"slds-input\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", chartName);
		chartName.sendKeys("GayathriChart");
		
//		driver.findElement(By.xpath("//input[@class=\"slds-input\"]")).sendKeys("GayathriChart");
		driver.findElement(By.xpath("//button[@title=\"Save\"]")).click();
		
		driver.findElement(By.xpath("//div[@class=\"chartInput forceRecordLayout\"][4]")).click();
		driver.findElement(By.xpath("//a[text()=\"Amount\"][2]")).click();
	}

}
