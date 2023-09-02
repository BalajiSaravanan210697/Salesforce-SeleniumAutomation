package com.selenium.task;

import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.salesforce.genericmethods.BaseClass;

public class TC02_EditTask extends BaseClass{
	@Test(dependsOnMethods = "com.selenium.task.TC01_CreateTask.createTask")
	public void editTask() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[contains(@class,'appLauncher')]")).click();		
				
		WebElement viewAllElement = driver.findElement(By.xpath("//button[text()='View All']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(viewAllElement));
		
		viewAllElement.click();
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement OppTabElement = driver.findElement(By.xpath("//a[@title='Tasks']"));
		
		driver.executeScript("arguments[0].click()", OppTabElement);
		
		driver.findElement(By.xpath("//button[@title='Select a List View: Tasks']")).click();
		
		driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]/..")).click();
		
		driver.findElement(By.xpath("//a[@title='Show 5 more actions']")).click();
		
		driver.findElement(By.xpath("//div[@title='Edit']/..")).click();
		
		Date clearDate = new Date();
		
		int date = clearDate.getDate();
		
		WebElement dueDateElement = driver.findElement(By.xpath("//button[@title='Select a date for Due Date']"));
		
		driver.executeScript("arguments[0].click()", dueDateElement);
		
		driver.findElement(By.xpath("//div[contains(@class,'slds-datepicker')]//span[text()='"+date+"']")).click();
		
		driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
		
		driver.findElement(By.xpath("//a[@title='Low']")).click();
		
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		String taskSubjecttext = driver.findElement(By.xpath("(//span[text()='Subject']/../following-sibling::div//span)[2]")).getText();
		
		Assert.assertTrue(taskSubjecttext.contains("Bootcamp"));
		
	}

}
