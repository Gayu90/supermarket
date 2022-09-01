package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageExpensePage {
	WebDriver driver;
	GeneralUtility utility;
	PageUtility pageutility;
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
	private WebElement manageExpenseTab;
	@FindBy(xpath="(//i[@class='far fa-circle nav-icon'])[1]")
	private WebElement expenseCategoryButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newtoolTip;
	@FindBy(xpath="//input[@id='name']")
	private WebElement titleField;
	@FindBy(xpath="//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertForAlreadyExist;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;
	@FindBy(xpath="(//i[@class='far fa-circle nav-icon'])[2]")
	private WebElement manageExpenseButton;
	@FindBy(xpath="(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
	private WebElement deleteToolTip;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteSuccessfulAlert;
	
	public void clickOnManageExpense() {
		manageExpenseTab.click();
	}

	public void clickOnExpensecategory() {
		expenseCategoryButton.click();
	}

	public void clickOnManageExpenseButton() {
		manageExpenseButton.click();
	}
	

	public boolean ExpensecategoryPage() {
		utility = new GeneralUtility(driver);
		clickOnManageExpense();
		clickOnExpensecategory();
		return utility.isElementSelected(expenseCategoryButton);
	}

	public String getDuplicateTitleAlertMessage() {
		utility = new GeneralUtility(driver);
		clickOnManageExpense();
		clickOnExpensecategory();
		newtoolTip.click();
		titleField.sendKeys("vegetables");
		saveButton.click();
		return utility.getTextOfElement(alertForAlreadyExist);
}

	public String getTextOfSuccessAlert() {
		utility = new GeneralUtility(driver);
		clickOnManageExpense();
		clickOnExpensecategory();
		newtoolTip.click();
		titleField.sendKeys("Icecream_" + utility.get_TimeStamp());
		saveButton.click();
		return utility.getTextOfElement(successAlert);
	}

	public String getBackgroundColorOfDeleteAlert() {
		utility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		clickOnManageExpense();
		clickOnManageExpenseButton();
		deleteToolTip.click();
		pageutility.acceptAlert();
		String backgroundColor=utility.getCssSelectorValue(deleteSuccessfulAlert,"background-color");
		return backgroundColor;
		
		
	}
	

public ManageExpensePage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements( driver,this);
}
}
