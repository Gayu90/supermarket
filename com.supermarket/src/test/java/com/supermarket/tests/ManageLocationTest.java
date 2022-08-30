package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageLocationPage;

public class ManageLocationTest extends Base {
ManageLocationPage managelocationpage;
LoginPage loginpage;
@Test(groups="sanity")
	public void verifyTheTextOfSelectedCountryDropDown() {
		managelocationpage = new ManageLocationPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		String actualtext = managelocationpage.SelectCountryDropDown();
		System.out.println(actualtext);
		String expectedText =  "      United Kingdom";
		Assert.assertEquals(actualtext, expectedText);

	}
}
