package com.selenium.dashboard;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;
/*
 * "Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Dashboards from App Launcher
4. Click on the Dashboards tab 
5. Click the sort arrow in the Dashboard Name.
6. Verify the Dashboard displayed in ascending order by Dashboard name."

 */
public class TC4_SortDashboard extends BaseClass {
	
	@Test
	public void TC4_SortDashboard() throws InterruptedException {
		
		waitForClickable(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		waitForClickable(By.xpath("//button[text()=\"View All\"]")).click();
		waitForClickable(By.xpath("//input[@class=\"slds-input\"]")).sendKeys("Dashboard");
		waitForClickable(By.xpath("//mark[text()='Dashboard']")).click();
		
		waitForClickable(By.xpath("(//span[@class=\"slds-cell-fixed slds-has-button-menu\"])[1]")).click();
		List<WebElement> dashboardNameActual = driver.findElements(By.xpath("//table//tr//th[@data-label=\"Dashboard Name\"]//a"));
		ArrayList<String> obtainedList = new ArrayList<String>(); 
		for(WebElement we:dashboardNameActual){
			   obtainedList.add(we.getText());
			}
		
		ArrayList<String> sortedList = new ArrayList<String>();   
		for(String s:obtainedList){
		sortedList.add(s);
		}
		Collections.sort(obtainedList);
		System.out.println(obtainedList);
		System.out.println(sortedList);
		if(sortedList.equals(obtainedList)){
			System.out.println("The List of Dashboard is sorted");
		}else {
			System.out.println("The List of Dashboard is not sorted");
		}

	}

}
