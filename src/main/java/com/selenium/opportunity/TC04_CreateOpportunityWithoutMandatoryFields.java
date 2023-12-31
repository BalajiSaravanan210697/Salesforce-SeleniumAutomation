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

public class TC04_CreateOpportunityWithoutMandatoryFields extends BaseClass{
	@Test
	public void createOpportunityWithoutMandatoryFields() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(@class,'salesforceIdentityAppLauncherHeader')]")))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='View All']")))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//p[text()='Sales']")))).click();
		
		WebElement OppTabElement = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		
		driver.executeScript("arguments[0].click()", OppTabElement);
		
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		Date clearDate = new Date();
		
		int date = clearDate.getDate();
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		
		driver.findElement(By.xpath("//div[contains(@class,'slds-datepicker')]//span[text()='"+(date+1)+"']")).click();
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		WebElement alertMsgWebElement = driver.findElement(By.xpath("//div[@class='genericNotification']/strong"));
		
		wait.until(ExpectedConditions.visibilityOf(alertMsgWebElement));
		
		String alertMsg1 =alertMsgWebElement.getText();
		
		String alertMsg2 = driver.findElement(By.xpath("(//div[@class='genericNotification']/following-sibling::ul//a)[1]")).getText();
		
		String alertMsg3 = driver.findElement(By.xpath("(//div[@class='genericNotification']/following-sibling::ul//a)[2]")).getText();
	
		Assert.assertEquals("Review the following fields", alertMsg1);
		
		Assert.assertEquals("Opportunity Name", alertMsg2);
		
		Assert.assertEquals("Stage", alertMsg3);
		
	}

}
