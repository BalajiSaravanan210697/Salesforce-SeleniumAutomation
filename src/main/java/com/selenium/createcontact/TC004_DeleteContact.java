package com.selenium.createcontact;

import java.time.Duration;
import java.util.List;

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

public class TC004_DeleteContact extends BaseClass{
   
	@Test
	public void CreateIndividual() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		WebElement viewelement= driver.findElement(By.xpath("//button[text()='View All']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(viewelement));
		viewelement.click();
		WebElement contacts= driver.findElement(By.xpath("//p[text()='Contacts']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", contacts);
		List<WebElement> countOfContacts=driver.findElements(By.xpath("//table[contains(@class,'uiVirtualDataTable')]/tbody/tr"));
		System.out.println("Count of Contacts Available in System is "+countOfContacts.size());
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Naveen",Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]")).click();
		WebElement deletebutton = driver.findElement(By.xpath("//div[text()='Delete']"));
		js.executeScript("arguments[0].click();", deletebutton);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		String verificationMessage=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();	
		Assert.assertTrue(verificationMessage.contains("Contact") && verificationMessage.contains("was deleted"), "Test case passed");
		
	}


}
