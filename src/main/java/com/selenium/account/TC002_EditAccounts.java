package com.selenium.account;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import com.salesforce.genericmethods.BaseClass;
public class TC002_EditAccounts extends BaseClass{
    @Test
	public void EditAccount() {
		
        // toggle menu clicked based on the class name
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

		// Click on the displayed Account Dropdown icon and select Edit
		driver.findElement(By.xpath("//a[@title='Show 3 more actions']")).click();
		driver.findElement(By.xpath("//div[@title='Edit']")).click();


	}

}
