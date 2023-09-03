package com.selenium.opportunity;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.genericmethods.BaseClass;

public class TC05_VerifyOpportunitiesSortOrderByCloseDate extends BaseClass{
	@Test
	public void verifyOpportunitiesSortOrderByCloseDate() throws InterruptedException {		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[contains(@class,'appLauncher')]")).click();
		
		WebElement viewAllElement = driver.findElement(By.xpath("//button[text()='View All']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(viewAllElement));
		
		viewAllElement.click();
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement OppTabElement = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		
		driver.executeScript("arguments[0].click()", OppTabElement);
		
		List<WebElement> closeDateBeforeSort = driver.findElements(By.xpath("//span[@class='uiOutputDate']"));
		
		List<String> dateBfSort = new ArrayList<String>();
		
		for (WebElement webElement : closeDateBeforeSort) {
			dateBfSort.add(webElement.getText());
		}
		
		driver.findElement(By.xpath("//span[text()='Display as Table']/ancestor::button")).click();
		
		driver.findElement(By.xpath("//li[@title='Table']/a")).click();
		
		WebElement closeDateLinkElement = driver.findElement(By.xpath("//span[text()='Close Date']/.."));
		
		closeDateLinkElement.click();	
		
		closeDateLinkElement.click();
		
		WebElement sortingElementStatus = driver.findElement(By.xpath("//span[text()='Close Date']/parent::a/following-sibling::span"));
		
		wait.until(ExpectedConditions.textToBePresentInElement(sortingElementStatus, "Sorted Ascending"));
		
		String closeDateOrderStatusText = sortingElementStatus.getText();
		
		Assert.assertEquals(closeDateOrderStatusText,"Sorted Ascending");
		
		Thread.sleep(1000);
		
		List<WebElement> claseDateAfterSort = driver.findElements(By.xpath("//span[@class='uiOutputDate']"));
		
		List<String> dateAfSort = new ArrayList<String>();
		
		for (WebElement webElement : claseDateAfterSort) {
			dateAfSort.add(webElement.getText());
		}
		
		Assert.assertTrue(!dateBfSort.equals(dateAfSort));
		
		
	}

}
