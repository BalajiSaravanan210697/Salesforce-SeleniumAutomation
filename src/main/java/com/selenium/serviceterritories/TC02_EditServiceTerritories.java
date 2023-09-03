package com.selenium.serviceterritories;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.salesforce.genericmethods.BaseClass;

public class TC02_EditServiceTerritories extends BaseClass{
	@Test
	public void editServiceTerritories() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[contains(@class,'appLauncher')]")).click();
				
		WebElement viewAllElement = driver.findElement(By.xpath("//button[text()='View All']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(viewAllElement));
		
		viewAllElement.click();
		
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Service Territories");
		
		WebElement serviceTerritoriesElement = driver.findElement(By.xpath("//a[@data-label='Service Territories']"));		
		
		wait.until(ExpectedConditions.elementToBeClickable(serviceTerritoriesElement));
		
		driver.executeScript("arguments[0].click()", serviceTerritoriesElement);
		
		//Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();		
		
		
		WebElement countryElement = driver.findElement(By.xpath("//label[text()='Country']/..//input"));
		
		countryElement.clear();
		
		countryElement.sendKeys("North America");
		
		String ownerText = driver.findElement(By.xpath("//span[text()='Owner']/../following-sibling::div//span[@class='displayLabel']")).getText();
		
		
		
		
	}
	
}
