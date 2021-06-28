package com.qa.TestCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Pages.facebookLogin;
import com.qa.Pages.fbPostPage;
import com.qa.TestBase.TestBase;

import junit.framework.Assert;

public class fbPostPageTest extends TestBase {
	
	
	public String username="";
	public String password="";
	public String browser="chrome";
	public String post= "Hello World";
	
	
	 facebookLogin fbLogin;
	fbPostPage fbPost;
	SoftAssert softassert;
	
	
	@BeforeTest
	public void launchFb() {
		initialization(browser,facebookLogin.PAGE_URL);
	}

	
	@BeforeMethod
	public void loginFb() {
		softassert=new SoftAssert();
		fbLogin=new facebookLogin();
		fbPost=fbLogin.fbLoginMethod(username, password);
	}
	
	@Test
	public void postStatus() {		
		fbPost.sendPost(post);
		softassert.assertTrue(driver.getPageSource().contains(post));
		softassert.assertAll();
	}
	
	
	@AfterMethod
	public void teardown(ITestResult result){
		
		if(ITestResult.FAILURE==result.getStatus()){
			
			try{
				
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				// Call method to capture screenshot
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				
				// Copy files to specific location 
				// result.getName() will return name of test case so that screenshot name will be same as test case name
				FileUtils.copyFile(src, new File("screenshots\\"+result.getName()+".png"));
				System.out.println("Successfully captured a screenshot");
				
			}catch (Exception e){
				
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
	}
		driver.quit();
		
	}
}
