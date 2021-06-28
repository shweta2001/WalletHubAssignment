package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.TestBase.TestBase;
import com.qa.TestConfig.testConfig;

public class fbPostPage extends TestBase{
	
	
	
	public  fbPostPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[contains(@class,'oajrlxb2 b3i9ofy5')]")
	WebElement postBox;
	
	@FindBy(xpath="//div[contains(@aria-label,\"What's on your mind\")]//div[@class='_1mf _1mj']")
	WebElement postTextField;
	
	@FindBy(xpath="//div[contains(@class,'d1544ag0 tw6a2znq s1i5eluu tv7at329')]")
	WebElement postButton;
	
	@FindBy(xpath="//*[@id=\"jsc_c_14\"]/div/div")
	private WebElement post;
	
	
	public void sendPost(String post) {
		
		postBox.click();		
		String win=driver.getWindowHandle();
		driver.switchTo().window(win);		
		postTextField.sendKeys(post);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		postButton.click();
		try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	
	}
	
	public boolean isPost() {
		return post.isDisplayed();
	}
}
