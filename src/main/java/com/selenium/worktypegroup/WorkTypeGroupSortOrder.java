package com.selenium.worktypegroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

public class WorkTypeGroupSortOrder extends BaseClass{
	
	@Test
	public void verifyWorkTypeGroupSortOrder()
	{
		driver.findElement(By.xpath("//span[.='App Launcher']/..")).click();
		waitForClickable(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		jsDriver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[text()='Work Type Groups']")));
		Actions action = new Actions(driver);
		action.moveToElement(waitForClickable(By.xpath("//span[.='Work Type Group Name']"))).click().build().perform();
		//jsDriver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[.='Work Type Group Name']")));
		String script = "return window.getComputedStyle(document.querySelector('a[data-refid=\"recordId\"]'),'::after').getPropertyValue('content')";
		System.out.println(jsDriver.executeScript(script));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a[@data-refid='recordId']"),1));
		List<String> workTypeGroups = new ArrayList<String>();
		List<WebElement> findElements = driver.findElements(By.xpath("//a[@data-refid='recordId']"));
		System.out.println(findElements.size());
		for (WebElement webElement : findElements) {
			workTypeGroups.add(webElement.getText());
		}
		List<String> workTypeGroupSorted = new ArrayList<String>(workTypeGroups);
		Collections.sort(workTypeGroupSorted);
		Assert.assertEquals(workTypeGroups, workTypeGroupSorted);
	}

}
