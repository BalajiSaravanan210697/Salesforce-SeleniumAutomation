package com.selenium.worktypegroup;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;


public class CreateWorkTypeGroupCheckMandatoryField extends BaseClass{
	
	@Test
	public void createWorkTypeGroupsCheckMandatoryField()
	{
		driver.findElement(By.xpath("//span[.='App Launcher']/..")).click();
		waitForClickalbe(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		jsDriver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[text()='Work Type Groups']")));
		driver.findElement(By.xpath("//div[@title='New']/parent::a")).click();
		driver.findElement(By.xpath("//div/textarea")).sendKeys("Automation");
		driver.findElement(By.xpath("//label[text()='Group Type']/..//button")).click();
		driver.findElement(By.xpath("//span[text()='Capacity']")).click();
		waitForClickalbe(By.xpath("//button[@name='SaveEdit']")).click();
		Assert.assertEquals("Work Type Group Name", driver.findElement(By.xpath("//h2[text()='We hit a snag.']/ancestor::div[@class='container']//a")).getText());
		waitForClickalbe(By.xpath("//button[@name='CancelEdit']")).click();
	}

}
