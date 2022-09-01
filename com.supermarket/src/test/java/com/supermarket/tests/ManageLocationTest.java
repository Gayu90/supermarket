package com.supermarket.tests;







import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageLocationPage;

public class ManageLocationTest extends Base {
ManageLocationPage managelocationpage;
LoginPage loginpage;

	@Test(groups = "sanity")
	public void verifyTheTextOfSelectedCountryDropDown() {
		managelocationpage = new ManageLocationPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		String actualtext = managelocationpage.selectCountryDropDown("United Kingdom");
		String expectedText = "United Kingdom";
		Assert.assertEquals(actualtext, expectedText);

	}

	@Test
	public void verifyThatAdminCanGetListsOfLocationAsPerTheState() {

		managelocationpage = new ManageLocationPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		managelocationpage.getSearchLocation("United Kingdom", "Armagh");
		

	}

	@Test
	public void verifyThatNewLocationIsAddedSuccessfully() {
		managelocationpage = new ManageLocationPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		String actual = managelocationpage.addNewLocation("United Kingdom", "Armagh", "Markethill", "75");
		String expected = "×\n" + "Alert!\n" + "Location Created Successfully";
		Assert.assertEquals(actual, expected);

	}
}









