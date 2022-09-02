package com.supermarket.tests;

import java.net.HttpURLConnection;
import java.net.URL;

public class DashboardTest {
	int responseCode=0;
	HttpURLConnection huc = null;
	
	public int getResponseCode(String url) {
		
		try {
			huc = (HttpURLConnection)(new URL(url).openConnection());
			huc.setRequestMethod("HEAD");

			huc.connect();
			responseCode=huc.getResponseCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseCode;
		}	
		
		
		
		
	}

