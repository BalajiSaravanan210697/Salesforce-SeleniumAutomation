package com.selenium.Case;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import com.salesforce.genericmethods.BaseClass;
public class TC003_DeleteCase extends BaseClass{
    @Test
	public void DeleteCase() {
		
		// toggle menu clicked based on the class name
		driver.findElement(By.className("slds-icon-waffle")).click();
		// clicking the view All button from the drop down
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		// click Sales from App Launcher using text
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		// Click on Global Actions SVG icon
		WebElement Cases = driver.findElement(By.xpath("//span[text()='Cases']"));
		driver.executeScript("arguments[0].click();", Cases);
	    String caseOwneralias =  driver.findElement(By.xpath("//span[@class='slds-truncate uiOutputText']")).getText();
	    if(caseOwneralias.equals("BSara")) {
	    	driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']")).click();
	    	driver.findElement(By.xpath("//a[@title='Delete']")).click();
	    	driver.findElement(By.xpath("//span[text()='Delete']")).click();
	    	String Deletecase = driver.findElement(By.xpath("//div[contains(@class,'forceToastMessage')]")).getText();
	    	System.out.println("The Deleted Case:" +Deletecase);
	    }

	}

}
