package com.selenium.individual;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

public class TC001_CreateIndividual extends BaseClass{
   
	@Test
	public void CreateIndividual() {
		//Click on Toggle menu
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Click on view all button
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Click on Individuals
		WebElement indivduals= driver.findElement(By.xpath("//p[text()='Individuals']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", indivduals);
		driver.findElement(By.xpath("//a[@title='Individuals']/following-sibling::one-app-nav-bar-item-dropdown//one-app-nav-bar-menu-button")).click();
		WebElement newindivdual=driver.findElement(By.xpath("//span[text()='New Individual']"));
		js.executeScript("arguments[0].click();", newindivdual);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		String verificationMessage=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();	
		Assert.assertTrue(verificationMessage.contains("Kumar") && verificationMessage.contains("Individual"), "Test case passed");
	}


}
