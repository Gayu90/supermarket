package com.supermarket.tests;


import java.util.ArrayList;
import java.util.List;

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

		List<String>expectedStates=new ArrayList<String>();
		List<String>actualStates=new ArrayList<String>();
		managelocationpage = new ManageLocationPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
				
		expectedStates.add("Armagh");
		expectedStates.add("Armagh");
		expectedStates.add("Armagh");
		expectedStates.add("Armagh");
        actualStates=managelocationpage.getSearchLocation("United Kingdom", "Armagh");
        for(int i=0;i<expectedStates.size();i++)
        {
        	if(!expectedStates.get(i).equals(actualStates.get(i)))
        	{
        		Assert.assertTrue(false,"TestCase Failed");
        	}
        }

		
		

	}

	@Test
	public void verifyThatNewLocationIsAddedSuccessfully() {
		managelocationpage = new ManageLocationPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
	    boolean actual = managelocationpage.IsNewLocationAdded("United Kingdom", "Armagh", "Markethill", "75");
	
	    Assert.assertEquals(actual, true);

	}
}









