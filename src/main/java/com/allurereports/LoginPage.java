package com.allurereports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class LoginPage extends TestBase {

//Page Factory-Object Repository:

	@FindBy(xpath = "//span[text()='Log In']")
	WebElement loginBtn;

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailid;

	@FindBy(xpath = "//input[@name='password']")
	WebElement pwd;

	@FindBy(xpath = "//div[contains(@class,'ui fluid large blue submit button')]")
	WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUp;

//    initializing the page objects
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//Actions
	@Step("getting login page title step.......")
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	@Step("getting login functionality with emailaddress:{0} and password:{1} step.......")
	public HomePage login(String emailaddress, String password) throws InterruptedException {
		loginBtn.click();
		Thread.sleep(5000);
		emailid.sendKeys(emailaddress);
		pwd.sendKeys(password);
		loginButton.click();

		return new HomePage(driver);

	}

	@Step("getting sign up page link step.......")
	public SignUpPage signUpBtn() {
		signUp.click();
		return new SignUpPage(driver);
	}
}
