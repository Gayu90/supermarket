package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

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
	@FindBy(xpath="//select[@id='st_id']")
	private WebElement stateDropDown;
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchLocationButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath="//tbody//td[3]")
	private List<WebElement>states;
	@FindBy(xpath="//input[@id='location']")
	private WebElement locationField;
	@FindBy(xpath="//input[@id='delivery']")
	private WebElement deliveryChargeField;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;
	
	public void clickOnManageLocation()
	{
		manageLocation.click();
	}
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	public void clickOnSearchLocationButton()
	{
		searchLocationButton.click();
	}
	public void clickOnNewButton() {
		newButton.click();
	}
	public void clickOnsaveButton() {
		saveButton.click();
	}
	
	public void enterLocationField(String location)
	{
		locationField.sendKeys(location);
	}
	public void enterDeliveryChargeField(String deliveryFee)
	{
		deliveryChargeField.sendKeys(deliveryFee);
	}
	
	public String selectCountryDropDown(String country)
	{
		utility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		clickOnManageLocation();
		clickOnSearchButton();
		pageutility.select_selectByVisibleText(countryDropDown, country);
		return utility.getTextOfElement(DropDownText);
	}

	public List<String> getSearchLocation(String country, String state) {
		List<String> locations = new ArrayList<String>();
		utility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		clickOnManageLocation();
		clickOnSearchButton();
		pageutility.select_selectByVisibleText(countryDropDown, country);
		pageutility.select_selectByVisibleText(stateDropDown, state);
		clickOnSearchLocationButton();
		locations=utility.getTextOfElements("//tbody//td[3]");
		return locations;
		

	}
	public String addNewLocation(String country, String state,String location,String deliveryFee) {
		utility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		clickOnManageLocation();
		clickOnNewButton();
		pageutility.select_selectByVisibleText(countryDropDown, country);
		pageutility.select_selectByVisibleText(stateDropDown, state);
		enterLocationField(location);
		enterDeliveryChargeField(deliveryFee);
		clickOnsaveButton();
		return utility.getTextOfElement(successAlert);
	}

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
