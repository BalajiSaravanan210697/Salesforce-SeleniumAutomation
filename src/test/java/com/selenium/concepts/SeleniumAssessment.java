package com.selenium.concepts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumAssessment {

	

	
	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		/* Step1: Load application url https://api-training.atlassian.net/ */
		driver.get("https://api-training.atlassian.net/");
		// Step2: Enter your email hari.radhakrishnan@testleaf.com and click on Continue
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("hari.radhakrishnan@testleaf.com");
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		// Step3: Enter password “India@123” and click Log in
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("India@123");
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		// Step4: Select SDET-5 project
        driver.findElement(By.xpath("//p[text()='SDET-5']")).click();
        Thread.sleep(1000);
        //Step6: Click on Create button
        driver.findElement(By.xpath("//span[text()='Create']")).click();
        //Step7: Enter Summary which is mandatory
        driver.findElement(By.xpath("//input[@name='summary']")).sendKeys("Story Created By Balaji S");
        //Step8: Click on Create button
        driver.findElement(By.xpath("(//span[text()='Create'])[2]")).click();
        //Step9: Click on Backlog on the left panel
        driver.findElement(By.xpath("//span[text()='Backlog']")).click();
        //Step10: Search for the story we created in the search field and verify the newly created story
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Story Created By Balaji S");
        Thread.sleep(1000);
        String text= driver.findElement(By.xpath("//mark")).getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("Balaji"));
	

	}


}
