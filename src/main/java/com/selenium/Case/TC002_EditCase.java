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
public class TC002_EditCase extends BaseClass {
	@Test
	public void EditCase() throws InterruptedException {

		// toggle menu clicked based on the class name
		driver.findElement(By.className("slds-icon-waffle")).click();
		// clicking the view All button from the drop down
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		// click Sales from App Launcher using text
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		// Click on Global Actions SVG icon
		WebElement Cases = driver.findElement(By.xpath("//span[text()='Cases']"));
		driver.executeScript("arguments[0].click();", Cases);
		String caseOwneralias = driver.findElement(By.xpath("//span[@class='slds-truncate uiOutputText']")).getText();
		if (caseOwneralias.equals("BSara")) {
			driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']")).click();
			driver.findElement(By.xpath("//a[@title='Edit']")).click();
		}
		
        // Update Status as Working
		driver.findElement(By.xpath("(//label[text()='Status'])/following-sibling::div")).click();
		driver.findElement(By.xpath("//span[@title='Working']")).click();
		//setTimeout(function(){debugger;}, 5000)
		// Update Priority to low
		driver.findElement(By.xpath("(//label[text()='Priority'])/following-sibling::div")).click();
		driver.findElement(By.xpath("//span[text()='Low']")).click();
		// Update Case Origin as Phone
		driver.findElement(By.xpath("(//label[text()='Case Origin'])/following-sibling::div")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		// Update SLA violation to No
		WebElement SLAViolation = driver.findElement(By.xpath("(//label[text()='SLA Violation'])/following-sibling::div"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", SLAViolation);
		driver.findElement(By.xpath("//span[text()='No']")).click();
		// Click on Save and Verify Status as Working
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String status = driver.findElement(By.xpath("(//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell'])[3]")).getText();
		Assert.assertTrue(status.contains("Working"), "Test case passed");
	}

}
