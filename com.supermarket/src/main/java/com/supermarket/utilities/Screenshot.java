package com.supermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
TakesScreenshot scrShot;

public void takeScreenShot(WebDriver driver,String ImageName)

{
	try {
		scrShot=(TakesScreenshot) driver;
		File screenshot=scrShot.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"//ScreenShots//"+"ImageName"+"timeStamp"+".png";
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		File finalDestination = new File(destination);
		FileHandler.copy(screenshot, finalDestination);
	} catch (Exception e) {
		e.printStackTrace();
		
	}
}
}
