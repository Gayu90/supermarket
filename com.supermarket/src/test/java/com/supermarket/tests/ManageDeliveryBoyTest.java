package com.supermarket.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTest extends Base {
ManageDeliveryBoyPage managedeliveryboypage;
LoginPage loginpage;

	@Test
	public void verifyThatDeliveryBoyDetailsGetUpdatedSuccessfully() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		String actual = managedeliveryboypage.updateDeliveryBoyDetails("ProductData", "DeliveryBoy");
		String expected = "×\n" + "Alert!\n" + "Delivery Boy Informations Updated Successfully";
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void verifyTheFunctionalityOfCancelButtonInAddingNewDeliveryBoy() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		managedeliveryboypage.IsCancelButtonFunctionalityOfAddDeliveryBoyWorkingAsExpected("ProductData",
				"DeliveryBoy");
		Assert.assertTrue(managedeliveryboypage
				.IsCancelButtonFunctionalityOfAddDeliveryBoyWorkingAsExpected("ProductData", "DeliveryBoy"));

	}

	@Test
	public void verifyThatUserCanDismissDeletePopAlertOfDeliveryBoyData() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		String actual = managedeliveryboypage.dismissDeleteAlert();
		String expected = "Do you want to delete this Delivery Boy Details?";
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void verifyThatDeliveryBoyDetailsGotDeletedSuccessfully() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		managedeliveryboypage.IsdeleteSuccessAlertAppearsForDeliveryBoydata();
		Assert.assertTrue(managedeliveryboypage.IsdeleteSuccessAlertAppearsForDeliveryBoydata());
	}
}
