package com.nopcommercemvn.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObjects.nopCommercemvn.usermvn.PageGeneratorManager;
import pageObjects.nopCommercemvn.usermvn.USerHomePageObject;
import pageObjects.nopCommercemvn.usermvn.USerLoginPageObject;
import pageObjects.nopCommercemvn.usermvn.USerRegisterPageObject;
import reportConfig.ExtentTestManager;

public class TC_01_Register extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		invalidEmailAddress = "##!@#" + generateFakeNumber();
		validPassword = "123456";
		inValidPassword = "123";
	}

	@Test
	public void Register_user_01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: open page");
		registerPage = homePage.openRegisterPage();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to button Register");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify register First name error message is requied");
		verifyTrue(registerPage.isErrorMessageDisplayed("First name is required."));

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Verify register Last name error message is requied");
		verifyTrue(registerPage.isErrorMessageDisplayed("Last name is required."));

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Verify register Email error message is requied");
		verifyTrue(registerPage.isErrorMessageDisplayed("Email is required."));

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Verify register Password error message is requied");
		verifyTrue(registerPage.isErrorMessageDisplayed("Password is required."));

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Verify register Password error message is requied");
		verifyTrue(registerPage.isErrorMessageDisplayed("Password is required."));

	}


	public void Register_user_02_Invalid_Email(Method method) {
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01:  refresh page");
		registerPage.refereshCurrentPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02:  Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03:  Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04:  Enter to Email textbox with value is '" + invalidEmailAddress + "'");
		registerPage.inputToEmailTextbox(invalidEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05:  Enter to validPassword textbox with value is '" + validPassword + "'");
		registerPage.inputToPasswordTextbox(validPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06:  Enter to validPassword textbox with value is '" + validPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to button Register");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify Wrong Email error message is required");
		verifyTrue(registerPage.isErrorMessageDisplayed("Wrong email"));
	}

	@Test
	public void Register_user_03_Valid_Data(Method method) {
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01:  refresh page");
		registerPage.refereshCurrentPage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02:  Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03:  Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04:  Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05:  Enter to validPassword textbox with value is '" + validPassword + "'");
		registerPage.inputToPasswordTextbox(validPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06:  Enter to validPassword textbox with value is '" + validPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to button Register");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08:  Verify register success message is displayed");
		verifyTrue(registerPage.isRegisterSuccessMessage("Your registration completed"));

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to button logout");
		homePage = registerPage.clickToLogoutLink();


	}

	@Test
	public void Register_user_04_Email_Data_Exists(Method method) {
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: open page");
		registerPage = homePage.openRegisterPage();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to button Register");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03:  Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04:  Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05:  Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06:  Enter to validPassword textbox with value is '" + validPassword + "'");
		registerPage.inputToPasswordTextbox(validPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07:  Enter to validPassword textbox with value is '" + validPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Click to button Register");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 09: Verify The specified email already exists  message is requied");
		verifyTrue(registerPage.isErrorMessageEmailExistsDisplayed("The specified email already exists"));
	}


	public void Register_user_05_Password_less_than_6_characters(Method method) {
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01:  refresh page");
		registerPage.refereshCurrentPage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02:  Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03:  Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04:  Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05:  Enter to inValidPassword textbox with value is '" + inValidPassword + "'");
		registerPage.inputToPasswordTextbox(inValidPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06:  Enter to inValidPassword textbox with value is '" + inValidPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(inValidPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to button Register");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08:  Verify register success message is displayed");
		verifyTrue(registerPage.isErrorPasswordMessageDisplayed("Password must meet the following rules:"," must have at least 6 characters"));
	}

	@Test
	public void Register_user_06_confirm_password(Method method) {
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01:  refresh page");
		registerPage.refereshCurrentPage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02:  Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03:  Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04:  Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05:  Enter to inValidPassword textbox with value is '" + validPassword + "'");
		registerPage.inputToPasswordTextbox(validPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06:  Enter to inValidPassword textbox with value is '" + inValidPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(inValidPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to button Register");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08:  Verify register password and confirmation password do not match message is displayed");
		verifyTrue(registerPage.isErrorMessageDisplayed("The password and confirmation password do not match."));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	private WebDriver driver;
	USerHomePageObject homePage;
	USerRegisterPageObject registerPage;
	USerLoginPageObject loginPage;
	String firstName, lastName, emailAddress, validPassword,invalidEmailAddress,inValidPassword;
}
