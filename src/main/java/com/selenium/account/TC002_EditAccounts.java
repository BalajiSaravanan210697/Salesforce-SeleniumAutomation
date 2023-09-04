package com.selenium.account;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import com.salesforce.genericmethods.BaseClass;
public class TC002_EditAccounts extends BaseClass{
    @Test
	public void EditAccount() throws InterruptedException {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
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
		Thread.sleep(2000);
        //Click on the displayed Account Dropdown icon and select Edit
		WebElement AccountActions=driver.findElement(By.xpath("(//span[text()='Show Actions'])/preceding-sibling::span"));
		wait.until(ExpectedConditions.elementToBeClickable(AccountActions));
		js.executeScript("arguments[0].click();", AccountActions);
		WebElement editlink= driver.findElement(By.xpath("//div[@title='Edit']"));
		editlink.click();
		//Select Type as Technology Partner
		driver.findElement(By.xpath("(//label[text()='Type'])/following-sibling::div")).click();
		waitForClickable(By.xpath("//span[contains(text(),'Technology')]")).click();
		/*
		 * driver.findElement(By.xpath(null)); driver.findElement(By.xpath(null));
		 * driver.findElement(By.xpath(null));
		 */
		

	}

}
