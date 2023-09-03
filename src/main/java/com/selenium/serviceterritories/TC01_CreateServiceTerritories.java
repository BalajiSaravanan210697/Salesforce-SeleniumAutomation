package com.selenium.serviceterritories;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.salesforce.genericmethods.BaseClass;

public class TC01_CreateServiceTerritories extends BaseClass{
	@Test
	public void createServiceTerritories() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(@class,'salesforceIdentityAppLauncherHeader')]")))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='View All']")))).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Service Territories");
		
		WebElement serviceTerritoriesElement = driver.findElement(By.xpath("//a[@data-label='Service Territories']"));		
		
		wait.until(ExpectedConditions.elementToBeClickable(serviceTerritoriesElement));
		
		driver.executeScript("arguments[0].click()", serviceTerritoriesElement);
		
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Srikanth Murugavel");
		
		driver.findElement(By.xpath("//input[@placeholder='Search Operating Hours...']")).click();
		
		driver.findElement(By.xpath("(//ul[@aria-label='Recent Operating Hours']/li)[2]")).click();
		
		WebElement activeCheckBoxElement = driver.findElement(By.xpath("//input[@type='checkbox' and @name='IsActive']"));
		driver.executeScript("arguments[0].click()", activeCheckBoxElement);
		driver.findElement(By.xpath("//label[text()='City']/..//input")).sendKeys("Chennai");
		
		driver.findElement(By.xpath("//label[text()='State/Province']/..//input")).sendKeys("Tamilnadu");
		
		driver.findElement(By.xpath("//label[text()='Country']/..//input")).sendKeys("India");
		
		driver.findElement(By.xpath("//label[text()='Zip/Postal Code']/..//input")).sendKeys("600078");
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		//wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")), "text()", "Srikanth"));
		
		String territoryConfirmationtext = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		
		Assert.assertTrue(territoryConfirmationtext.contains("Srikanth"));
		
	}

}
