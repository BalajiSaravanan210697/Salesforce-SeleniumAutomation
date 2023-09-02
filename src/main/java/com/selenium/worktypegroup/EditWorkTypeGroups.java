package com.selenium.worktypegroup;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;


public class EditWorkTypeGroups extends BaseClass {

	@Test
	public void EditWorkTypeGroup() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[.='App Launcher']/..")).click();
		waitForClickable(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		jsDriver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[text()='Work Type Groups']")));
		waitForClickable(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).click();
		waitForClickable(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys("Salesforce Automation by Vijaykannan"+Keys.ENTER);
		Thread.sleep(1000);
		jsDriver.executeScript("arguments[0].click();",waitForClickable(By.xpath("//a[.='Salesforce Automation by Vijaykannan']/ancestor::tr//span[@class='slds-icon_container slds-icon-utility-down']")));
		jsDriver.executeScript("arguments[0].click();",waitForClickable(By.cssSelector("div.forceActionLink")));
		driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following::input")).clear();
		driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following::input")).sendKeys("Automation");
		waitForClickable(By.xpath("//label[text()='Group Type']/..//button/span")).click();
		waitForClickable(By.xpath("//label[text()='Group Type']/..//button/span")).click();
		driver.findElement(By.xpath("//span[text()='Capacity']")).click();
		waitForClickable(By.xpath("//button[@name='SaveEdit']")).click();
		Assert.assertEquals("Work Type Group \"Automation\" was saved.", driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText());	
	}
}
