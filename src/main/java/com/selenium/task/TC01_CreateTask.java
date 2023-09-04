package com.selenium.task;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.salesforce.genericmethods.BaseClass;

public class TC01_CreateTask extends BaseClass{
	@Test
	public void createTask() throws InterruptedException {		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(@class,'salesforceIdentityAppLauncherHeader')]")))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='View All']")))).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("tasks");
		
		WebElement tasksElement = driver.findElement(By.xpath("//a[@data-label='Tasks']"));		
		
		wait.until(ExpectedConditions.elementToBeClickable(tasksElement));
		
		driver.executeScript("arguments[0].click()", tasksElement);
		
		WebElement TasksTabElement = driver.findElement(By.xpath("//span[text()='Tasks List']/parent::a//*[@part='icon']/.."));
		
		driver.executeScript("arguments[0].click()", TasksTabElement);
		
		WebElement newTaskElement = driver.findElement(By.xpath("//span[text()='New Task']/ancestor::a"));
	
		driver.executeScript("arguments[0].click()", newTaskElement);
		
		driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys("Bootcamp");
		
		driver.findElement(By.xpath("//a[@role='button' and @class='select']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Waiting on someone else')]")).click();
		
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		Thread.sleep(1000);
		String taskCreationConfirmation = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		
		Assert.assertTrue(taskCreationConfirmation.contains("Bootcamp"));
		
	}

}
