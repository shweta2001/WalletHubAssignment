package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class walletHubLogin extends TestBase{

	
	public static final String PAGE_URL=" https://wallethub.com/join/light";
	
	public static final String PAGE_navi=": http://wallethub.com/profile/test_insurance_company/";
	
	public walletHubLogin() {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement loginTab;

	@FindBy(xpath = "//input[@id='em-ipt']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='pw1-ipt']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='button']")
	private WebElement loginButton;

	
	
	public ReviewPage walletHubLogin(String user, String pwd) {
		username.sendKeys(user);
		password.sendKeys(pwd);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 loginButton.click();
		 
		 driver.navigate().to(PAGE_navi);
		 return new ReviewPage();
	}

}
