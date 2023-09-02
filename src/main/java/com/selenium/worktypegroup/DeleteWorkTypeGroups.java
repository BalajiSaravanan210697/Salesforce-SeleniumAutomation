package com.selenium.worktypegroup;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

public class DeleteWorkTypeGroups extends BaseClass{
	
	@Test
	public void DeleteWorkTypeGroup() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[.='App Launcher']/..")).click();
		waitForClickable(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		jsDriver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[text()='Work Type Groups']")));
		waitForClickable(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).click();
		waitForClickable(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys("Salesforce Automation by Vijaykannan"+Keys.ENTER);
		Thread.sleep(1000);
		jsDriver.executeScript("arguments[0].click();",waitForClickable(By.xpath("//a[.='Salesforce Automation by Vijaykannan']/ancestor::tr//span[@class='slds-icon_container slds-icon-utility-down']")));
		jsDriver.executeScript("arguments[0].click();",waitForClickable(By.xpath("//div[@class='forceActionLink' and text()='Delete']")));
		waitForClickable(By.xpath("//span[text()='Delete']")).click();
		Assert.assertEquals("Work Type Group \"Salesforce Automation by Vijaykannan\" was deleted. Undo", driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText());
		//Work Type Group was deleted.
	}

}
