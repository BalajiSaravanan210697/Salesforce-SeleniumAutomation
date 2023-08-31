package com.selenium.account;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

public class TC001_CreateAccount extends BaseClass{
   
	@Test
	public void CreateAccount() {
		// toggle menu clicked based on the class name
		driver.findElement(By.className("slds-icon-waffle")).click();
		// clicking the view All button from the drop down
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		// click Sales from App Launcher using text
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		// Click on Accounts tab
		WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", account);
		// Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();
		// Enter 'your name' as account name
		WebElement accountname = driver.findElement(By.xpath("//input[@name='Name']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", accountname);
		accountname.sendKeys("Balaji Saravanan");

		// Select Ownership as Public
		driver.findElement(
				By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"))
				.click();
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		// Click save and verify Account name
		driver.findElement(By.xpath("//button[text()='Save']")).click();
     
		// Click save and verify Account name
		String toastmessage = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
				.getText();
		System.out.println("Account Creation Status:  " + toastmessage);	
	}

}
