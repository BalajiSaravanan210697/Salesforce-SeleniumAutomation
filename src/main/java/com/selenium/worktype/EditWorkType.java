package com.selenium.worktype;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

public class EditWorkType extends BaseClass{
	
	@Test
	public void editExistingWorkType()
	{
		driver.findElement(By.xpath("//span[.='App Launcher']/..")).click();
		waitForClickable(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		jsDriver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[text()='Work Types']")));
		waitForClickable(By.xpath("//*[.='Salesforce Project']/ancestor::tr//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']")).click();
		jsDriver.executeScript("arguments[0].click();",waitForClickable(By.cssSelector("div.forceActionLink")));
		driver.findElement(By.xpath("//span[text()='Timeframe Start']/following::input")).sendKeys("9");
		driver.findElement(By.xpath("//span[text()='Timeframe End']/following::input")).sendKeys("18");
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		waitForClickable(By.xpath("//div[contains(@id,'toastDescription')]/span"));
		Assert.assertEquals("Work Type \"Salesforce Project\" was saved.", driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]/span")).getText());
		
	}

}
