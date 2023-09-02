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

public class TC002_EditIndividual extends BaseClass{
   
	@Test
	public void CreateIndividual() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		WebElement viewelement= driver.findElement(By.xpath("//button[text()='View All']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(viewelement));
		viewelement.click();
		WebElement indivduals= driver.findElement(By.xpath("//p[text()='Individuals']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", indivduals);
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Kumars",Keys.ENTER);
		waitForClickable(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]"));
		driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]")).click();
		WebElement editbutton = driver.findElement(By.xpath("//div[text()='Edit']"));
		js.executeScript("arguments[0].click();", editbutton);
		driver.findElement(By.xpath("//div[contains(@class,'salutation')]")).click();
		driver.findElement(By.linkText("Dr.")).click();
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("dinesh");
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		String verificationMessage=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		Assert.assertTrue(verificationMessage.contains("dinesh") && verificationMessage.contains("was saved")&& verificationMessage.contains("Individual"), "Test case passed");
	
	}
}
