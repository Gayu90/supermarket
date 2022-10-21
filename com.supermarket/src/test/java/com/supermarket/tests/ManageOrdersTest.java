package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageOrdersPage;

public class ManageOrdersTest extends Base {
ManageOrdersPage manageorderspage;
LoginPage loginpage;

	@Test
	public void verifyThePriceOfTheItem() {
		manageorderspage = new ManageOrdersPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		String actual = manageorderspage.PriceOfAnItem();
		String expected = "£ 10.55";
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void verifyThatStatusOfOrderCanBeChanged()
	{
		manageorderspage = new ManageOrdersPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		manageorderspage.ClickOnManageOrders();
		manageorderspage.changeStatusOfOrder("436");
	}
}
