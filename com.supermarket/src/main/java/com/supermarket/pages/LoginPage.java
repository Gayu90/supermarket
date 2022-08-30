package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtility;

public class LoginPage {
WebDriver driver;
ExcelUtility excel=new ExcelUtility();
GeneralUtility utility;
@FindBy(xpath = "//input[@name='username']")
 private WebElement usernameField;
@FindBy(xpath = "//input[@name='password']")
 private WebElement passwordField;
@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
private WebElement signinButton;
@FindBy(xpath="//span[text()='7rmart supermarket']")
private WebElement profileImage;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
private WebElement invalidAlertMessage;
@FindBy(xpath="(//img[@alt='User Image'])[1]")
private WebElement UserImage;
public void enterUserName(String UserName)
{
	usernameField.sendKeys(UserName);
}
public void enterPassWord(String passWord)
{
	passwordField.sendKeys(passWord);
}
public void clickOnLoginButton() {
	signinButton.click();
}
public void login(String userName, String password) {

	enterUserName(userName);
	enterPassWord(password);
	clickOnLoginButton();
}

public void login() {
	utility=new GeneralUtility(driver);
	excel.setExcelFile("LoginData", "ValidLoginCredentials");
	String userName = excel.getCellData(1, 0);
	String password = excel.getCellData(1, 1);
	enterUserName(userName);
	enterPassWord(password);
	clickOnLoginButton();
	
	
	
}
public String getInvalidLoginErrorMessage()
{
	utility=new GeneralUtility(driver);
	excel.setExcelFile("LoginData", "InvalidLoginCredentials");
	String userName = excel.getCellData(0, 0);
	String password = excel.getCellData(0, 1);
	login(userName, password);
	clickOnLoginButton();
	return utility.getTextOfElement(invalidAlertMessage);
}
	

	public boolean getLoginStatus() {
		utility = new GeneralUtility(driver);
		return utility.isElementDisplayed(profileImage);

	}

public LoginPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements( driver,this);
}

}
