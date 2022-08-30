package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageProductPage;

public class ManageProductTest extends Base {
	ManageProductPage manageproductpage;
	LoginPage loginpage;

	@Test(priority = 1)
	public void verifyThatWeightradioButtonIsselected() {
		manageproductpage = new ManageProductPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		manageproductpage.SelectWeightRadioButton();
		Assert.assertTrue(manageproductpage.SelectWeightRadioButton());
	}

	@Test(priority=-1)
	public void verifyTheAttributeValueOfSearchButton() {
		manageproductpage = new ManageProductPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		String actual = manageproductpage.attributeOfSearchButton();
		System.out.println(actual);
		String expected = " fa fa-search";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void verifyBackgroundColorOfSearchButton() {
		manageproductpage = new ManageProductPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		String actual = manageproductpage.backgroundColorOfSearchButton();
		String expected = "rgba(0, 0, 0, 0)";
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void verifyProductImageUploadedIsDisplayed() {
		manageproductpage = new ManageProductPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		manageproductpage.uploadProductImage();
		Assert.assertTrue(manageproductpage.uploadProductImage());
		
}

}
