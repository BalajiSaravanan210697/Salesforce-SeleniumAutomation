package com.selenium.task;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.salesforce.genericmethods.BaseClass;

public class TC04_CreateTaskWithoutMandatoryFields extends BaseClass{
	@Test
	public void createTaskWithoutMandatoryFields() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[contains(@class,'appLauncher')]")).click();
				
		WebElement viewAllElement = driver.findElement(By.xpath("//button[text()='View All']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(viewAllElement));
		
		viewAllElement.click();
		
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("tasks");
		
		WebElement tasksElement = driver.findElement(By.xpath("//a[@data-label='Tasks']"));		
		
		wait.until(ExpectedConditions.elementToBeClickable(tasksElement));
		
		driver.executeScript("arguments[0].click()", tasksElement);
		
		WebElement TasksTabElement = driver.findElement(By.xpath("//span[text()='Tasks List']/parent::a//*[@part='icon']/.."));
		
		driver.executeScript("arguments[0].click()", TasksTabElement);
		
		WebElement newTaskElement = driver.findElement(By.xpath("//span[text()='New Task']/ancestor::a"));
	
		driver.executeScript("arguments[0].click()", newTaskElement);
		
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		
		driver.findElement(By.xpath("//div[contains(@class,'result-text')]")).click();
		
		driver.findElement(By.xpath("//textarea")).sendKeys("SALES FORCE Automation using Selenium");
		
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		String errorText = driver.findElement(By.xpath("//div[contains(@id,'help-message')]")).getText();
		
		Assert.assertTrue(errorText.contains("Complete this field."));
		
	}

}
