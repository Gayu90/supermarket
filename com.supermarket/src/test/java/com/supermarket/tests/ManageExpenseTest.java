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
		manageexpensepage.ExpensecategoryPage();
		Assert.assertTrue(manageexpensepage.ExpensecategoryPage());
		System.out.println("Expense category Button is selected");
	
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
		System.out.println(actualAlertmessage);
	}
	@Test
	public void verifyThatAdminCanCreateAlreadyExistCategoryTitle()
	{
		manageexpensepage=new ManageExpensePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		String actualAlertmessage=manageexpensepage.getTextOfSuccessAlert();
		System.out.println(actualAlertmessage);
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
		String actual=manageexpensepage.getbackgroundcolorOfDeleteAlert();
		String expected="rgba(40, 167, 69, 1)";
		Assert.assertEquals(actual, expected);
		
	}
	
	}

