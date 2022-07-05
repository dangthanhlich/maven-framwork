package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import PageFactory.HomePageObject;
import PageFactory.LoginPageObject;
import PageFactory.RegisterPageObject;

public class Level_05_page_Factory extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, inValidEmail, notFoundEmail, existingEmail, incorrectPassword, validPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = new HomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		inValidEmail = "afc@afc.com@.vn";
		notFoundEmail = "afc" + generateFakeNumber() + "@gmail.com";
		existingEmail = "afc" + generateFakeNumber() + "@gmail.vn";
		validPassword = "123456";
		incorrectPassword = "9999999";

		homePage = new HomePageObject(driver);

		System.out.println("Pre-Condition - step 01 : click to register link");
		homePage.clickToRegisterLink();

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Pre-Condition -  03- step 2 : input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		// registerPage.inputToCompanyTextbox("ABC");
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("Pre-Condition - step 03 : Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition - step 04:verify success mssage displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-Condition - step 05:click to logout link");
		registerPage.clickToLogoutLink();

		// Click logout thì business quay về trang HomePage
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();
		// từ trang Home -click login link -> qua trang login
		loginPage = new LoginPageObject(driver);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {

		homePage.clickToLoginLink();
		// từ trang Home -click login link -> qua trang login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(inValidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginLink();
		// từ trang Home -click login link -> qua trang login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Existng_Email_Empty_Password() {
		homePage.clickToLoginLink();
		// từ trang Home -click login link -> qua trang login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		homePage.clickToLoginLink();
		// từ trang Home -click login link -> qua trang login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		homePage.clickToLoginLink();
		// từ trang Home -click login link -> qua trang login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);

		loginPage.clickToLoginButton();

		loginPage = new LoginPageObject(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
