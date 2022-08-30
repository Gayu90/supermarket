package com.supermarket.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.Screenshot;
import com.supermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	Properties prop;
	FileInputStream ip;
	Screenshot screenshot=new Screenshot() ;
	public Base()
	{
		prop = new Properties();
		try {
			ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void initialise(String browser,String url)
	{
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(WaitUtility.IMPLICIT_WAIT,TimeUnit.SECONDS);
	}

	@BeforeMethod(enabled =true,alwaysRun=true)
	public void setUp() {

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		initialise(browser, url);
	}
	@Parameters("browser")
	@BeforeMethod(enabled = false,alwaysRun=true)
	public void setUp_crossBrowser(String browser)
	{
		String url = prop.getProperty("url");
		initialise(browser, url);
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			screenshot.takeScreenShot(driver, result.getName());
		}
		driver.close();
	}
}



