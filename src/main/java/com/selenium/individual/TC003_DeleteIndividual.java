package com.selenium.individual;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

public class TC003_DeleteIndividual extends BaseClass{
   
	@Test
	public void CreateIndividual() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement indivduals= driver.findElement(By.xpath("//p[text()='Individuals']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", indivduals);
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Kumars",Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]")).click();
		WebElement deletebutton= driver.findElement(By.xpath("//div[text()='Delete']"));
		js.executeScript("arguments[0].click();", deletebutton);
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		String verificationMessage=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		Assert.assertTrue(verificationMessage.contains("Individual")&& verificationMessage.contains("was deleted"), "Test case passed");
	
	}
}
