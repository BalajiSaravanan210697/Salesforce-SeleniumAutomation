package com.selenium.worktype;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;


public class CreateNewWorkType  extends BaseClass{
	
	@Test
	public void CreateWorkType()
	{
		driver.findElement(By.xpath("//span[.='App Launcher']/..")).click();
		waitForClickalbe(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		jsDriver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[text()='Work Types']")));
		driver.findElement(By.xpath("//div[@title='New']/parent::a")).click();
		driver.findElement(By.xpath("//h3[.='Description']/..//span[text()='Work Type Name']/following::input")).sendKeys("Salesforce Project");
		driver.findElement(By.xpath("//div/textarea")).sendKeys("Specimen");
		driver.findElement(By.xpath("//input[@role='combobox' and contains(@placeholder,'Search')]")).click();
		driver.findElement(By.xpath("//span[text()='New Operating Hours']")).click();
		driver.findElement(By.xpath("//span[text()='Name']/following::input")).sendKeys("UK Shift");
		driver.findElement(By.xpath("//h2[text()='New Operating Hours']/../../div//button[@title='Save']")).click();
		driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]/ancestor::div[@role='alertdialog']//button")).click();
		driver.findElement(By.xpath("//span[text()='Estimated Duration']/../parent::div[contains(@class,'uiInput')]/input")).sendKeys("7");
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Assert.assertEquals("Work Type \"Salesforce Project\" was created.", driver.findElement(By.xpath("(//div[contains(@id,'toastDescription')])[1]")).getText());
	}

}
