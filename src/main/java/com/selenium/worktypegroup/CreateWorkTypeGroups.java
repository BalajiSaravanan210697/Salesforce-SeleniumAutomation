package com.selenium.worktypegroup;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;


public class CreateWorkTypeGroups extends BaseClass {

	@Test
	public void CreateWorkTypeGroup()
	{
		driver.findElement(By.cssSelector("button.slds-button.slds-icon-waffle_container.slds-context-bar__button.slds-button.forceHeaderButton.salesforceIdentityAppLauncherHeader")).click();
		waitForClickalbe(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		jsDriver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[text()='Work Type Groups']")));
		driver.findElement(By.xpath("//div[@title='New']/parent::a")).click();
		driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following::input")).sendKeys("Salesforce Automation by Vijaykannan");
		waitForClickalbe(By.xpath("//button[@name='SaveEdit']")).click();
		Assert.assertEquals("Work Type Group \"Salesforce Automation by Vijaykannan\" was created.", driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText());
	}
}
