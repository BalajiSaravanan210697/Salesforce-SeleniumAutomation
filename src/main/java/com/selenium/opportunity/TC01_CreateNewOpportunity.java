package com.selenium.opportunity;

import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

public class TC01_CreateNewOpportunity extends BaseClass{
	@Test
	public void createNewOpportunity() throws InterruptedException {
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));		
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(@class,'salesforceIdentityAppLauncherHeader')]")))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='View All']")))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//p[text()='Sales']")))).click();
		
		WebElement OppTabElement = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		
		driver.executeScript("arguments[0].click()", OppTabElement);
		
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		String OppName = "Salesforce Automation By Srikanth";
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(OppName);
		
		Date clearDate = new Date();
		
		int date = clearDate.getDate();
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		
		driver.findElement(By.xpath("//div[contains(@class,'slds-datepicker')]//span[text()='"+date+"']")).click();
		
		WebElement stageDropDownElement = driver.findElement(By.xpath("//button[@role='combobox']"));
		driver.executeScript("arguments[0].click()", stageDropDownElement);
		
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		Thread.sleep(1000);
		
		String OppConfirmationText = driver.findElement(By.xpath("//div[text()='"+OppName+"']")).getText();
		
		Assert.assertEquals(OppName, OppConfirmationText);		
		
	}

}
