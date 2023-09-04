package com.selenium.Case;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.salesforce.genericmethods.BaseClass;

public class TC004_CreateCaseWithoutMandatoryFields extends BaseClass {
	@Test
	public void CreateCaseWithoutMandatoryFields() throws InterruptedException {

		// toggle menu clicked based on the class name
		driver.findElement(By.className("slds-icon-waffle")).click();
		// clicking the view All button from the drop down
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		// click Sales from App Launcher using text
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		// Click on Global Actions SVG icon
		WebElement Cases = driver.findElement(By.xpath("//span[text()='Cases']"));
		driver.executeScript("arguments[0].click();", Cases);
		// Click on New Case
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		// Choose Contact Name from the dropdown
		WebElement ContactSearch = driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']"));
		ContactSearch.click();
		ContactSearch.sendKeys("Balaji S");
		Thread.sleep(1000);
		waitForClickable(By.xpath("//lightning-base-combobox-formatted-text[@title='Balaji S']")).click();
		
		// Select status as None
		driver.findElement(By.xpath("(//label[text()='Status'])/following-sibling::div")).click();
		driver.findElement(By.xpath("//span[@title='--None--']")).click();

		//  Enter Subject as 'Testing' and description as 'Automation testing'
		WebElement subject = driver.findElement(By.xpath("(//label[text()='Subject'])/following-sibling::div/input"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", subject);
		subject.sendKeys("Testing");
		driver.findElement(By.xpath("(//label[text()='Description'])/following-sibling::div/textarea"))
				.sendKeys("Automation testing");
		// Click 'Save' 
		driver.findElement(By.xpath("//button[	text()='Save']")).click();
		
		// Get the text of Error message Displayed and Verify the message
		String snagmessage = driver.findElement(By.xpath("//h2[@title='We hit a snag.']")).getText();
		String reviewmessage = driver.findElement(By.xpath("//div[@class='genericNotification']")).getText();
		Assert.assertTrue(snagmessage.contains("We hit a snag") &&reviewmessage.contains("Review the following fields"), "Test case passed");
		

	}

}
