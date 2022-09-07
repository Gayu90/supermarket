package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.LoginPage;

public class AdminUsersTest extends Base {
	AdminUsersPage adminuserspage;
	LoginPage loginpage;

	
	@Test
	public void verifyThatNewAdminUserCanBeCreated()
	{
		adminuserspage=new AdminUsersPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		String actual=adminuserspage.createNewAdminUser("AdminUsers", "Staff");
		String expected="×\n" + 
				"Alert!\n" + 
				"User Created Successfully";
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void verifyThatAdminUserDetailsCanBeUpdated()
	{
		adminuserspage=new AdminUsersPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		String actual=adminuserspage.updateUserprofile("AdminUsers", "Staff");
		String expected="×\n" + 
				"Alert!\n" + 
				"User Updated Successfully";
		Assert.assertEquals(actual, expected);
	}
}
