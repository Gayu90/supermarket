package com.supermarket.utilities;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	Select select;
	Actions actions;
	
	public PageUtility(WebDriver driver) {
		this.driver = driver;
}
	public void clearTextField(WebElement element)
	{
		element.clear();
	}
	public void select_selectByIndex(WebElement element,int index)
	{
		select=new Select(element);
		select.selectByIndex(index);
	}
	public void select_selectByVisibleText(WebElement element,String text)
	{
		select=new Select(element);
		select.selectByVisibleText(text);
	}
	public void select_selectByValue(WebElement element,String value)
	{
		select=new Select(element);
		select.selectByValue(value);
	}
	public void select_selectAllOptions(WebElement element,String value)
	{
		select=new Select(element);
		select.getAllSelectedOptions();
	}
	
	public void moveToElement(WebElement element)
	{
		actions=new Actions(driver);
		actions.moveToElement(element);
		actions.build().perform();
		
	}
	public void rightClick(WebElement element)
	{
		actions=new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	public void doubleclick(WebElement element)
	{
		actions=new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	public void DragandDrop(WebElement source, WebElement target) {
		actions = new Actions(driver);
		actions.dragAndDrop(source, target);
	}
	public void handleAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	public String popupText()
	{
		driver.switchTo().alert().getText();
		return popupText();
	}
	public void switch_To_Frame_by_Name(String name) {
		driver.switchTo().frame(name);
	}
	public void fileUpload(WebElement element, String path) {

		element.sendKeys(path);
	}
	public void scroll_By(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}
	public void scroll_into_View(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void pageRefresh()
	{
		driver.navigate().refresh();
	}
	public boolean checkClickstatus(WebElement element) {
		try {
		element.click();
		return false;

		} catch (Exception e) {

		return true;
		}

		}

		public void scrollAndclick(WebElement element) {
		int x = 0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while(checkClickstatus(element))
		{
		js.executeScript("window.scrollBy(0," + x + ")");
		x=x+50;
		}
		}
		}


