package com.supermarket.pages;

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
	}

