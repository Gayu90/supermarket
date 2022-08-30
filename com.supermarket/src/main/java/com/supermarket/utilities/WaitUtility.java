package com.supermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
public static final long PAGE_LOAD_WAIT=20;
public static final long IMPLICIT_WAIT=10;
public static final long EXPLICIT_WAIT=20;


public void waitForElementToBeVisible(String xpath,WebDriver driver)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
}
public void waitForElementToBeClickable(String xpath,WebDriver driver)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
}
public void waitandClick(String xpath,WebDriver driver)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	driver.findElement(By.xpath(xpath)).click();
	
}

}
