package com.selenium.opportunity;

import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

public class TC02_EditOpportunity extends BaseClass{
	@Test(dependsOnMethods = "com.selenium.opportunity.TC01_CreateNewOpportunity.createNewOpportunity")
	public void editOpportunity() throws InterruptedException {		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[contains(@class,'appLauncher')]")).click();
		
		WebElement viewAllElement = driver.findElement(By.xpath("//button[text()='View All']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(viewAllElement));
		
		viewAllElement.click();
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement OppTabElement = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		
		driver.executeScript("arguments[0].click()", OppTabElement);
		
		String OppName = "Salesforce Automation By Srikanth";		
		
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(OppName,Keys.ENTER);
		
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]")))).click();
		WebElement editDropdownElement = driver.findElement(By.xpath("//a[@title='Edit']"));
		wait.until(ExpectedConditions.elementToBeClickable(editDropdownElement));		
		editDropdownElement.click();
		
		Date clearDate = new Date();
		
		int date = clearDate.getDate();
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		
		driver.findElement(By.xpath("//div[contains(@class,'slds-datepicker')]//span[text()='"+(date+1)+"']")).click();
		
		WebElement stageDropDownElement = driver.findElement(By.xpath("(//button[@role='combobox'])[2]"));
		driver.executeScript("arguments[0].click()", stageDropDownElement);
		
		String stageStatusUpdate="Perception Analysis";
		driver.findElement(By.xpath("//span[@title='"+stageStatusUpdate+"']")).click();
		
		driver.findElement(By.xpath("//textarea")).sendKeys("SalesForce");
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(1000);		
		WebElement stageStatusElement = driver.findElement(By.xpath("(//table//tr/td)[5]//span[@class='slds-truncate']"));
		
		//wait.until(ExpectedConditions.textToBePresentInElementValue(stageStatusElement, stageStatusUpdate));		
		
		Assert.assertEquals(stageStatusElement.getText(),stageStatusUpdate);
		
		
	}
}
