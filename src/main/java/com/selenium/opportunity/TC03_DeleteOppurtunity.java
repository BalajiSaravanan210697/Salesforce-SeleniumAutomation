package com.selenium.opportunity;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.salesforce.genericmethods.BaseClass;

public class TC03_DeleteOppurtunity extends BaseClass{
	@Test
	public void deleteOppurtunity() throws InterruptedException {		

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(@class,'salesforceIdentityAppLauncherHeader')]")))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='View All']")))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//p[text()='Sales']")))).click();

		WebElement OppTabElement = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		
		driver.executeScript("arguments[0].click()", OppTabElement);
		
		String OppName = "Salesforce Automation By Srikanth";		
		
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(OppName);
		
		driver.findElement(By.xpath("//div[contains(@class,'highlights-icon-container')]/img")).click();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]")))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@title='Delete']")))).click();	
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Delete']/..")))).click();	
		
		Thread.sleep(2000);
		
		String delConfirmText = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
	
		Assert.assertTrue(delConfirmText.contains(OppName));		
		
	}

}
