package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageProductPage {
	WebDriver driver;
	GeneralUtility utility;
	PageUtility pageutility;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']")
	private WebElement manageproducts;
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newToolTip;
	@FindBy(xpath="//input[@id='purpose']")
	private WebElement weightradioButton;
	@FindBy (xpath="//i[@class=' fa fa-search']")
	private WebElement searchButton;
	@FindBy(xpath="//input[@id='main_img']")
	private WebElement choseFileButton;
	@FindBy(xpath="//div[@id='imagePreview']")
	private WebElement imagePreview;
	public void ClickOnManageProduct() {
		manageproducts.click();
	}
	public void ClickOnNewToolTip()
	{
		newToolTip.click();
	}
	public void ClickOnSearchIcon()
	{
		searchButton.click();
	}
	public boolean SelectWeightRadioButton()
	{
		utility = new GeneralUtility(driver);
		ClickOnManageProduct();
		ClickOnNewToolTip();
		weightradioButton.click();
		return utility.isElementSelected(weightradioButton);
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
	
	
	
	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
