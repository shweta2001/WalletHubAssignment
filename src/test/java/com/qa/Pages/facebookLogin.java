package com.qa.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class facebookLogin extends TestBase {
	
	public static final String PAGE_URL="https://www.facebook.com";
	
	public facebookLogin() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement username;

	@FindBy(xpath = "//*[@id='pass']")
	private WebElement password;

	@FindBy(xpath = "//button[contains(@name, 'login')]")
	private WebElement loginButton;

	
	
	public fbPostPage fbLoginMethod(String user, String pwd) {
		username.sendKeys(user);
		password.sendKeys(pwd);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 loginButton.click();
		 return new fbPostPage();
	}
}
