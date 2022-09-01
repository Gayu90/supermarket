package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.DataProviders;



public class LoginTest extends Base {
	LoginPage loginpage;

	@Test
	public void verifyThatUserCanLoginSuccessfully() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		

	}

	@Test
	public void verifyInvalidCredentialWarningmessage() {
		loginpage=new LoginPage(driver);
		String actualAlertmessage=loginpage.getInvalidLoginErrorMessage();
		String expectedAlertmessage="×\n" + 
				"Alert!\n" + 
				"Invalid Username/Password";
			Assert.assertEquals(actualAlertmessage, expectedAlertmessage);
		
	}
	
	
	@Test(dataProvider="adminUser",dataProviderClass = DataProviders.class)
	public void verifyCreatedAdminLogin(String userName,String password)
	{
			loginpage=new LoginPage(driver);
			loginpage.login( userName,password);
			Assert.assertTrue(loginpage.getLoginStatus());
			
			
	}
	}
	

	


