package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageLocationPage {
	WebDriver driver;
	GeneralUtility utility;
	PageUtility pageutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-map-marker']")
	private WebElement manageLocation;
	@FindBy(xpath="//i[@class=' fa fa-search']")
	private WebElement searchButton;
	@FindBy(xpath="//select[@id='country_id']/option[2]")
	private WebElement DropDownText;
	@FindBy(xpath="//select[@id='country_id']")
	private WebElement countryDropDown;
	public void ClickOnManageLocation()
	{
		manageLocation.click();
	}
	public void ClickOnSearchButton()
	{
		searchButton.click();
	}
	public String SelectCountryDropDown()
	{
		utility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		ClickOnManageLocation();
		ClickOnSearchButton();
		pageutility.select_selectByVisibleText(countryDropDown, "United Kingdom");
		return utility.getTextOfElement(DropDownText);
	}
	

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
