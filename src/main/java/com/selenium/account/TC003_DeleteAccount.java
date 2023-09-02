package com.selenium.account;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.salesforce.genericmethods.BaseClass;
public class TC003_DeleteAccount extends BaseClass {
	@Test
	public void DeleteAccount() {
		// toggle menu clicked based on the class name
		        JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
				driver.findElement(By.className("slds-icon-waffle")).click();
				// clicking the view All button from the drop down
				driver.findElement(By.xpath("//button[text()='View All']")).click();
				// click Sales from App Launcher using text
				driver.findElement(By.xpath("//p[text()='Sales']")).click();
				// Click on Accounts tab
				WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
				driver.executeScript("arguments[0].click();", account);
				// Search for the Account Using the unique account name created by you
				driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Balaji Saravanan");
				
				waitForClickable(By.xpath("//a[@title='Show 3 more actions']")).click();
				jsDriver.executeScript("arguments[0].click();",waitForClickable(By.xpath("//a[@title='Delete']")));
				
				/*
				 * waitForClickable(By.xpath("//a[@title='Show 3 more actions']")).click();
				 * driver.findElement(By.xpath("//a[@title='Delete']")).click();
				 */
				driver.findElement(By.xpath("//span[text()='Delete']")).click();
				String DeleteMessage = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
				System.out.println("Deleted Account is: " +DeleteMessage);
	}
}
