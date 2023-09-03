package com.selenium.contact;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

public class TC002_EditContact extends BaseClass{
   
	@Test
	public void editContact() throws InterruptedException {
		WebElement applaunch=driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(applaunch));
		applaunch.click();
		WebElement viewelement= driver.findElement(By.xpath("//button[text()='View All']"));
		wait.until(ExpectedConditions.visibilityOf(viewelement));
		viewelement.click();
		WebElement contacts= driver.findElement(By.xpath("//p[text()='Contacts']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", contacts);
		List<WebElement> countOfContacts=driver.findElements(By.xpath("//table[contains(@class,'uiVirtualDataTable')]/tbody/tr"));
		System.out.println("Count of Contacts Available in System is "+countOfContacts.size());
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Naveen");
		WebElement contactActions=driver.findElement(By.xpath("(//a[contains(@class,'rowActionsPlaceHolder')])[1]/span"));
		wait.until(ExpectedConditions.elementToBeClickable(contactActions));
		js.executeScript("arguments[0].click();", contactActions);
		WebElement editlink=driver.findElement(By.xpath("//a[@title='Edit']"));
		editlink.click();
		driver.findElement(By.xpath("//input[@name='Title']")).clear();
		driver.findElement(By.xpath("//input[@name='Title']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@name='Birthdate']")).clear();
		LocalDate dateObj = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    String date = dateObj.format(formatter);
		driver.findElement(By.xpath("//input[@name='Birthdate']")).sendKeys(date);
		driver.findElement(By.xpath("//input[@name='Phone']")).clear();
		driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys("9884388580");
		WebElement leadSource= driver.findElement(By.xpath("//button[contains(@aria-label,'Lead Source')]"));
		js.executeScript("arguments[0].click();", leadSource);
		driver.findElement(By.xpath("//span[text()='Purchased List']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Save']"))));
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[contains(@class,'uiVirtualDataTable')]/tbody/tr"))));
		System.out.println("Contact Number is "+driver.findElement(By.xpath("(//span[contains(@class,'OutputPhone')])[1]")).getText().trim());
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(@class,'OutputPhone')])[1]")).getText().trim().contains("9884388580"), "Test case is passed");
	}


}
