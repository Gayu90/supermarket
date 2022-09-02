package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageProductPage {
	WebDriver driver;
	GeneralUtility utility;
	PageUtility pageutility;
	ExcelUtility excel=new ExcelUtility();
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']")
	private WebElement manageproducts;
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newToolTip;
	@FindBy(xpath="//input[@id='title']")
	private WebElement titleField;
	@FindBy(xpath="//input[@value='Nonveg']")
	private WebElement nonvegRadioButton;
	@FindBy(xpath="//input[@id='purpose']")
	private WebElement weightradioButton;
	@FindBy (xpath="//i[@class=' fa fa-search']")
	private WebElement searchButton;
	@FindBy (xpath="//button[@class='btn btn-danger']")
	private WebElement saveButton;
	@FindBy(xpath="//input[@id='main_img']")
	private WebElement choseFileButton;
	@FindBy(xpath="//div[@id='imagePreview']")
	private WebElement imagePreview;
	
	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOnManageProduct() {
		manageproducts.click();
	}

	public void ClickOnNewToolTip() {
		newToolTip.click();
	}

	public void ClickOnSearchIcon() {
		searchButton.click();

	}

	public void enterTitle(String title) {
		titleField.sendKeys(title);
	}

	public void ClickOnNonVegRadioButton() {
		 nonvegRadioButton.click();
	}
	public void ClickOnWeightRadioButton()
	{
		weightradioButton.click();
	}
	public void ClickOnSaveButton() {
		 saveButton.click();
	}
	public String getWarningMessageForMissedField(String excelFile,String excelSheet)
	{
		utility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		excel.setExcelFile(excelFile, excelSheet);
		String title = excel.getCellData(0, 0);
		ClickOnManageProduct();
		ClickOnNewToolTip();
		enterTitle(title);
		ClickOnNonVegRadioButton();
		ClickOnWeightRadioButton();
		pageutility.scrollAndclick(saveButton);
		String alert= pageutility.getAlertText();
		pageutility.acceptAlert();
		return alert;	
	}
	public String attributeOfSearchButton()
	{
		utility = new GeneralUtility(driver);
		ClickOnManageProduct();
		ClickOnSearchIcon();
		String onclick=utility.get_AttributeOfElement("class", searchButton);
		return onclick;
	}
	public String backgroundColorOfSearchButton()
	{
		utility = new GeneralUtility(driver);
		ClickOnManageProduct();
		ClickOnSearchIcon();
		String backgroundColor=utility.getCssSelectorValue(searchButton, "background-color");
		return backgroundColor;
	}
	public boolean uploadProductImage()
	{
		utility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		ClickOnManageProduct();
		
		
		
		
		
		
		ClickOnNewToolTip();
		pageutility.fileUpload(choseFileButton, System.getProperty("user.dir")+"//productimages//"+"AVT"+".jfif");
		pageutility.scroll_into_View(choseFileButton);
		return utility.isElementDisplayed(imagePreview);
	}
	
	
	
	
}
