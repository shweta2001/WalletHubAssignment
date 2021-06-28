package com.qa.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.TestBase.TestBase;
import com.qa.TestConfig.testConfig;
import com.qa.TestUtility.common;

public class ReviewPage extends TestBase {
	
	public static String Profile_URL="https://wallethub.com/profile/67430782i";
	public static String review_URL="http://wallethub.com/profile/test_insurance_company/";

	public ReviewPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(@class,'wh-rating rating_5')]")
	private WebElement reviewTab;

	@FindAll({ @FindBy(xpath = "//review-star[@class='rvs-svg']//*[local-name()='svg']") })
	private List<WebElement> star;

	@FindBy(xpath = "//review-star[@class='rvs-svg']//*[local-name()='svg']")
	private WebElement starSurface;

	@FindBy(xpath = "//span[normalize-space()='Select...']")
	private WebElement selectDropDown;

	@FindBy(xpath = "//li[normalize-space()='Health Insurance']")
	private WebElement selectHealthIns;

	@FindBy(xpath = "//textarea[@placeholder='Write your review...']")
	private WebElement reviewTextField;

	@FindBy(xpath = "//div[contains(@class,'sbn-action')]")
	private WebElement submitButton;

	@FindBy(xpath = "//span[normalize-space()='Your Review']")
	private WebElement yourReview;

	@FindBy(xpath = "//h4[normalize-space()='Your review has been posted.']")
	private WebElement reviewconfirmation;

	@FindBy(xpath = "//div[@class='btn rvc-continue-btn']")
	private WebElement continueButton;

	@FindBy(xpath = "//h2[normalize-space()='I RECOMMEND']")
	private WebElement recommendedFeed;
	
	
	
	//public void navigate to Review URL
	public void navigateToReview() {
		driver.navigate().to(review_URL);
	}


	//Click on Review Tab
	public void clickReviewTab() {
		reviewTab.click();
	}
	
	//Hover and click into star
	public void clickStar() {
		// Hover Mouse on 4 star
				Actions action = new Actions(driver);
				action.moveToElement(star.get(2)).build().perform();
				action.moveToElement(star.get(3)).click().perform();
	}
	
	//Next window display
	public void switchToChildWindow() {
		driver.switchTo().window(driver.getWindowHandle());
	}
	
	
	//Click on Health Insurance from select dropdown
	public void clickHealthInsurance() {
		selectDropDown.click();
		selectHealthIns.click();
	}
	
	//Enter min 200 text in text field
	public void enterTextInReview(int textlimit) {
		reviewTextField.sendKeys(common.randomAlphaNumeric(textlimit));
	}
	
	//Click on submit button
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	//Review feed confirmation window
	public String ReviewFeedConfirm() {
		return reviewconfirmation.getText();
	}
	
	public void waitforConfirmationForm() {
		WebDriverWait wait=new WebDriverWait(driver, testConfig.explicit_wait);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
	}

public void gotoProfileLink() {
	driver.navigate().to(Profile_URL);
}

public boolean IsReviewFeed() {
	return recommendedFeed.isDisplayed();
}
}
