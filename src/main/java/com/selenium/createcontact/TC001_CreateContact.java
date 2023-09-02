package com.selenium.createcontact;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

public class TC001_CreateContact extends BaseClass{
   
	@Test
	public void CreateIndividual() {
		WebElement addElement=driver.findElement(By.xpath("//div[contains(@class,'oneGlobalCreate')]//div//a/div"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(addElement));
		addElement.click();
		driver.findElement(By.xpath("//span[text()='New Contact']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'salutation')]")).click();
		driver.findElement(By.linkText("Dr.")).click();
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys("Naveen");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Elumalai");
		driver.findElement(By.xpath("//input[@inputmode='email']")).sendKeys("naveen@test.com");
		driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']")).sendKeys("New Account");
		driver.findElement(By.xpath("//span[text()='New Account']")).click();
		//To create account
		String accountName="Credits";
		driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Account.Name']//div//input")).sendKeys(accountName);
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
	
		WebElement save = driver.findElement(By.xpath("//span[text()='Save']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", save);
		String toastMessageAccount=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		Assert.assertTrue(toastMessageAccount.contains("Contact"), "Test case passed");	
		
	}


}
