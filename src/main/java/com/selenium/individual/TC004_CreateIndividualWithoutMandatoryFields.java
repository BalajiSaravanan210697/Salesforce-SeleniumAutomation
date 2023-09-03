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

public class TC004_CreateIndividualWithoutMandatoryFields extends BaseClass{
   
	@Test
	public void createIndividualWithoutMandatoryFields() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		WebElement viewelement= driver.findElement(By.xpath("//button[text()='View All']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(viewelement));
		viewelement.click();
		WebElement indivduals= driver.findElement(By.xpath("//p[text()='Individuals']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", indivduals);
		driver.findElement(By.xpath("//a[@title='Individuals']/following-sibling::one-app-nav-bar-item-dropdown//one-app-nav-bar-menu-button")).click();
		WebElement newindivdual=driver.findElement(By.xpath("//span[text()='New Individual']"));
		js.executeScript("arguments[0].click();", newindivdual);
		driver.findElement(By.xpath("//div[contains(@class,'salutation')]")).click();
		driver.findElement(By.linkText("Mr.")).click();
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys("Ganesh");
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		WebElement mandatoryErrorMessage=driver.findElement(By.xpath("//li[text()='Complete this field.']"));
		Assert.assertTrue(mandatoryErrorMessage.isDisplayed(), "Test case Passed");
	
	}
}
