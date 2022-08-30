package com.supermarket.tests;

import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUsersPage;

public class ManageUsersTest extends Base {
ManageUsersPage manageuserspage;
LoginPage loginpage;
@Test
public void verifyAdminUserDeactivation()
{
	loginpage=new LoginPage(driver);
	manageuserspage=new ManageUsersPage(driver);
	loginpage.login();
	manageuserspage.clickOnManageUser();
	manageuserspage.clickOnUsersDeactivateButton("Sree Parvathy");
}
}
