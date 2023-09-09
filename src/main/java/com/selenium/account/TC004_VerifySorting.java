package com.selenium.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.salesforce.genericmethods.BaseClass;
public class TC004_VerifySorting extends BaseClass {
	@Test
	public void VerifySorting() throws InterruptedException {
		       // toggle menu clicked based on the class name
				driver.findElement(By.className("slds-icon-waffle")).click();
				// clicking the view All button from the drop down
				driver.findElement(By.xpath("//button[text()='View All']")).click();
				// click Sales from App Launcher using text
				driver.findElement(By.xpath("//p[text()='Sales']")).click();
				// Click on Accounts tab
				WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
				driver.executeScript("arguments[0].click();", account);
				Thread.sleep(1000);
	}
}
