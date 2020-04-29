package com.allurereports.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.allurelistener.TestAllureListener;
import com.allurereports.HomePage;
import com.allurereports.LoginPage;
import com.allurereports.SignUpPage;
import com.allurereports.TestBase;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;





@Listeners({TestAllureListener.class})
public class LoginPageTest extends TestBase{

	public TestBase testBase;
	public WebDriver driver;
	public Properties prop;
	
	
	
public LoginPage loginPage;
public HomePage homePage;
public SignUpPage signUpPage;



	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		prop =testBase.initialize_Properties();
		driver = testBase.initialize_driver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
	}
	@Test(priority = 1,description="verifying login page title test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case Desciption:verify login page title")
	@Story("Story Name:to check login page title")
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small123");

	}

	@Test(priority = 2,description="verifying login functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Desciption:verify login functionality")
	@Story("Story Name:to check login functionality")
	public void loginTest() throws InterruptedException {
		loginPage.login(prop.getProperty("emailaddress"), prop.getProperty("password"));
	}

	@Test(priority = 3,description="verify sign page link test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test case Desciption:verify sign up page link test")
	@Story("Story Name:to check sign up page link")
	
	public void signUpPageTest() {
		loginPage.signUpBtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}






























}
