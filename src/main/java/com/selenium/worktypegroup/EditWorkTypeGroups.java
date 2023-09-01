package com.selenium.worktypegroup;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;


public class EditWorkTypeGroups extends BaseClass {

	@Test(dependsOnMethods = "com.selenium.worktypegroup.CreateWorkTypeGroups.CreateWorkTypeGroup")
	public void EditWorkTypeGroup()
	{
		//driver.findElement(By.cssSelector("one-app-launcher-header[class]")).click();
		//waitForClickalbe(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		//jsDriver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[text()='Work Type Groups']")));
		driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
		driver.findElement(By.xpath("(//input[contains(@placeholder,'Search')])[2]")).sendKeys("Salesforce Automation by Vijaykannan"+Keys.ENTER);
		waitForClickalbe(By.xpath("//th[.='Salesforce Automation by Vijaykannan']/parent::tr//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']")).click();
		jsDriver.executeScript("arguments[0].click();",waitForClickalbe(By.cssSelector("div.forceActionLink")));
		driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following::input")).clear();
		driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following::input")).sendKeys("Automation");
		driver.findElement(By.xpath("//label[text()='Group Type']/..//button")).click();
		driver.findElement(By.xpath("//span[text()='Capacity']")).click();
		waitForClickalbe(By.xpath("//button[@name='SaveEdit']")).click();
		Assert.assertEquals("Work Type Group \"Automation\" was saved.", driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText());	
	}
}
