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
	@Test(dependsOnMethods = "com.selenium.opportunity.TC02_EditOpportunity.editOpportunity")
	public void deleteOppurtunity() throws InterruptedException {		

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[contains(@class,'appLauncher')]")).click();
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement OppTabElement = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		
		driver.executeScript("arguments[0].click()", OppTabElement);
		
		String OppName = "Salesforce Automation By Srikanth";		
		
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(OppName);
		
		driver.findElement(By.xpath("//div[contains(@class,'highlights-icon-container')]/img")).click();
		Thread.sleep(1000);
		WebElement actionDropdownElement = driver.findElement(By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]"));
		wait.until(ExpectedConditions.elementToBeClickable(actionDropdownElement));
		actionDropdownElement.click();
		
		WebElement deleteDropdownElement = driver.findElement(By.xpath("//a[@title='Delete']"));
		wait.until(ExpectedConditions.elementToBeClickable(deleteDropdownElement));		
		deleteDropdownElement.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Delete']/..")));
		
		driver.findElement(By.xpath("//span[text()='Delete']/..")).click();
		Thread.sleep(2000);
		
		String delConfirmText = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
	
		Assert.assertTrue(delConfirmText.contains(OppName));		
		
	}

}
