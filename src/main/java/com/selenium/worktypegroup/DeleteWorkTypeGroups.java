package com.selenium.worktypegroup;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

public class DeleteWorkTypeGroups extends BaseClass{
	
	@Test(dependsOnMethods = "com.selenium.worktypegroup.CreateWorkTypeGroups.CreateWorkTypeGroup")
	public void DeleteWorkTypeGroup()
	{
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		//jsDriver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[text()='Work Type Groups']")));
		driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
		driver.findElement(By.xpath("(//input[contains(@placeholder,'Search')])[2]")).sendKeys("Salesforce Automation by Vijaykannan"+Keys.ENTER);
		waitForClickalbe(By.xpath("//th[.='Salesforce Automation by Vijaykannan']/parent::tr//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']")).click();
		jsDriver.executeScript("arguments[0].click();",waitForClickalbe(By.xpath("//div[@class='forceActionLink' and text()='Delete']")));
		waitForClickalbe(By.xpath("//span[text()='Delete']")).click();
		Assert.assertEquals("Work Type Group \"Salesforce Automation by Vijaykannan\" was deleted. Undo", driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText());
		//Work Type Group was deleted.
	}

}
