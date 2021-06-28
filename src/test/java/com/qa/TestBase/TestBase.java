package com.qa.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.TestConfig.testConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public WebDriverWait wait;

	
	public void initialization(String browser, String url) {

		if(driver==null) {
			
		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			driver=new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("IE")) {

			WebDriverManager.iedriver().setup();
			
			driver=new InternetExplorerDriver();

		}

		else if (browser.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			
			driver=new FirefoxDriver();

		}
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(testConfig.implicit_wait, TimeUnit.SECONDS);
		
		driver.get(url);

	}
		
	}
	
	

	public void tearDown() {
		driver=null;
		driver.quit();
		
	}
}
