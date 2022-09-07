package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpensePage;

public class ManageExpenseTest extends Base {
	ManageExpensePage manageexpensepage;
	LoginPage loginpage;
	@Test(groups="smoke")
	public void verifyThatExpensecategoryRadioButtonIsSelected()
	{
		manageexpensepage=new ManageExpensePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageexpensepage.IsExpensecategoryRadioButtonSelected();
		Assert.assertTrue(manageexpensepage.IsExpensecategoryRadioButtonSelected());
		
	
	}
	@Test
	public void verifyTheAlertMessageForAlreadyExistCategory()
	{
		manageexpensepage=new ManageExpensePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		String actualAlertmessage=manageexpensepage.getDuplicateTitleAlertMessage();
		String expectedAlertMessage="×\n" + 
				"Alert!\n" + 
				"Category already exists.";
		Assert.assertEquals(actualAlertmessage, expectedAlertMessage);
		
	}
	@Test
	public void verifyThatAdminCanCreateAlreadyExistCategoryTitleWithTimeStamp()
	{
		manageexpensepage=new ManageExpensePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		String actualAlertmessage=manageexpensepage.getTextOfSuccessAlert();
		String expectedAlertMessage="×\n" + 
				"Alert!\n" + 
				"Expense Category Created Successfully";
		Assert.assertEquals(actualAlertmessage, expectedAlertMessage);
	}
	@Test
	public void verifyBackgroundColorOfAlertmessage() {
		manageexpensepage=new ManageExpensePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		String actual=manageexpensepage.getBackgroundColorOfDeleteAlert();
		String expected="rgba(40, 167, 69, 1)";
		Assert.assertEquals(actual, expected);
		
	}
	
	}

