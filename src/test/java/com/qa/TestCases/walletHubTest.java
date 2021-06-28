package com.qa.TestCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Pages.ReviewPage;
import com.qa.Pages.facebookLogin;
import com.qa.Pages.walletHubLogin;
import com.qa.TestBase.TestBase;

public class walletHubTest extends TestBase {

	public String username = "sates1994@gmail.com";
	public String password = "Samsung@13";
	public String browser = "chrome";

	walletHubLogin walletLogin;
	ReviewPage insurance;
	SoftAssert softassert;

	@BeforeTest
	public void launchFb() {
		initialization(browser, walletLogin.PAGE_URL);
	}

	@BeforeMethod
	public void loginWalletHub() {
		walletLogin = new walletHubLogin();
		softassert = new SoftAssert();
		insurance = walletLogin.walletHubLogin(username, password);
	}

	@Test
	public void ReviewStatus() {
		insurance.navigateToReview();
		insurance.clickReviewTab();
		insurance.clickStar();
		insurance.switchToChildWindow();
		insurance.clickHealthInsurance();
		insurance.enterTextInReview(100);
		insurance.enterTextInReview(100);
		insurance.clickSubmitButton();
		insurance.waitforConfirmationForm();
		String str = insurance.ReviewFeedConfirm();
		softassert.assertEquals(str, "Your review has been posted.");
		insurance.gotoProfileLink();
		softassert.assertTrue(insurance.IsReviewFeed());
		softassert.assertAll();

	}

	@AfterMethod
	public void teardown(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {

			try {

				// To create reference of TakesScreenshot
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				// Call method to capture screenshot
				File src = screenshot.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location
				// result.getName() will return name of test case so that screenshot name will
				// be same as test case name
				FileUtils.copyFile(src, new File("screenshots\\" + result.getName() + ".png"));
				System.out.println("Successfully captured a screenshot");

			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
		driver.quit();

	}

}
