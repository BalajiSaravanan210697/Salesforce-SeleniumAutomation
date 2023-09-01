package com.selenium.worktypegroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

public class WorkTypeGroupSortOrder extends BaseClass{
	
	@Test
	public void verifyWorkTypeGroupSortOrder()
	{
		driver.findElement(By.xpath("//span[.='App Launcher']/..")).click();
		waitForClickalbe(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		jsDriver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[text()='Work Type Groups']")));
		jsDriver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[.='Work Type Group Name']")));
		waitForClickalbe(By.xpath("//a[@data-refid='recordId']"));
		List<WebElement> findElements = driver.findElements(By.xpath("//a[@data-refid='recordId']"));
		List<String> workTypeGroups = new ArrayList<>();
		for (WebElement webElement : findElements) {
			workTypeGroups.add(webElement.getText());
		}
		List<String> workTypeGroupSorted = new ArrayList<>(workTypeGroups);
		Collections.sort(workTypeGroupSorted);
		Assert.assertEquals(workTypeGroups, workTypeGroupSorted);
	}

}
