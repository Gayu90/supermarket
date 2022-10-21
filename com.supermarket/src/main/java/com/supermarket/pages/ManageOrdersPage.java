package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageOrdersPage {
	WebDriver driver;
	GeneralUtility utility;
	PageUtility pageutility;
	@FindBy(xpath="//i[@class='nav-icon fas fa-shopping-basket']")
	private WebElement manageOrderIcon; 
	@FindBy(xpath="//tbody//tr[1]//td[4]")
	private WebElement price; 
	@FindBy(xpath="(//a[@class='btn btn-block btn-outline-info btn-sm'])[1]")
	private WebElement viewToolTip;
	@FindBy(xpath="//select[@id='pt']")
	private WebElement selectStatus;
	public ManageOrdersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOnManageOrders() {
		manageOrderIcon.click();
	}

	public void ClickOnViewToolTip() {
		viewToolTip.click();
	}

	public String PriceOfAnItem() {
		utility = new GeneralUtility(driver);
		ClickOnManageOrders();
		ClickOnViewToolTip();
		String Price=utility.getTextOfElement(price);
		return Price;
	}
	public void changeStatusOfOrder(String orderno) {
		int j = 0;
		List<String> orderID = new ArrayList<String>();
		utility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		orderID=utility.getTextOfElements("//tr//td[1]");
		for (j = 0; j <orderID.size(); j++) {
			if (orderID.get(j).equals(orderno)) {
				j++;
				break;
			}
		}
		WebElement changeStatusButton=driver.findElement(By.xpath("//tbody//tr[\"+j+\"]//td[6]//a[text()='Change Status']"));
		pageutility.scrollAndclick(changeStatusButton);
		pageutility.select_selectByVisibleText(selectStatus, "Out For Delivery");
		
	}
	
	}
	

