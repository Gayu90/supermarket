package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	GeneralUtility utility;
	PageUtility pageutility;
	ExcelUtility excel=new ExcelUtility();
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-user-plus']")
	private WebElement manageDeliveryBoyButton;
	@FindBy(xpath="(//i[@class='fas fa-edit'])[7]")
	private WebElement editIcon;
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phoneNo;
	@FindBy(xpath="//input[@id='name']")
	private WebElement nameField;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement updateSuccessAlert;
	@FindBy (xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
	private WebElement cancelButton;
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	private WebElement ListDeliveryBoyPage;
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[6]")
	private WebElement deleteIcon;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement DeleteSuccessAlert;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void clickManageDeliveryBoy()
	{
		manageDeliveryBoyButton.click();
	}
	public void clickEdit()
	{
		editIcon.click();
	}
	public void clearPhoneField()
	{
		phoneNo.clear();
	}
	public void enternameField(String name)
	{
		nameField.sendKeys(name);
	}
	public void enterPhoneNumberField(String phoneNumber)
	{
		phoneNo.sendKeys(phoneNumber);
	}
	public void clickUpdateButton()
	{
		updateButton.click();
	}
	public void clickNewButton()
	{
		newButton.click();
	}
	public void clickCancelButton()
	{
		cancelButton.click();
	}
	public void clickDeleteButton()
	{
		deleteIcon.click();
	}
	
	public String updateDeliveryBoyDetails(String excelFile,String excelSheet)
	{
		utility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		excel.setExcelFile(excelFile, excelSheet);
		String phoneNumber = excel.getCellData(0, 0);
		clickManageDeliveryBoy();
		clickEdit();
		clearPhoneField();
		enterPhoneNumberField(phoneNumber);
		pageutility.scrollAndclick(updateButton);
		return utility.getTextOfElement(updateSuccessAlert);
		
	}
	public boolean IsCancelButtonFunctionalityOfAddDeliveryBoyWorkingAsExpected(String excelFile,String excelSheet)
	{
		utility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		excel.setExcelFile(excelFile, excelSheet);
		String name=excel.getCellData(0, 1);
		String phoneNumber = excel.getCellData(0, 0);
		clickManageDeliveryBoy();
		clickNewButton();
		enternameField(name);
		enterPhoneNumberField(phoneNumber);
		pageutility.scrollAndclick(cancelButton);
		return utility.isElementEnabled(cancelButton);
		
	}
	public String dismissDeleteAlert()
	{
		utility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		clickManageDeliveryBoy();
		clickDeleteButton();
		String alertText=pageutility.getAlertText();
		pageutility.dismissAlert();
		return alertText;
	}
	public boolean IsdeleteSuccessAlertAppearsForDeliveryBoydata()
	
	{
		utility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		clickManageDeliveryBoy();
		clickDeleteButton();
		pageutility.acceptAlert();
		return utility.isElementDisplayed(DeleteSuccessAlert);
		
	}
	
	
	
	
}
