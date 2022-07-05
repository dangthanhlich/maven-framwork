package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.USerAddressPageObject;
import pageObjects.nopCommerce.user.USerCustomerInforPageObject;
import pageObjects.nopCommerce.user.USerHomePageObject;
import pageObjects.nopCommerce.user.USerLoginPageObject;
import pageObjects.nopCommerce.user.USerMyProductReviewPageObject;
import pageObjects.nopCommerce.user.USerRegisterPageObject;
import pageObjects.nopCommerce.user.USerRewardPointPageObject;

public class Level_18_Pattern_Object extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		validPassword = "123456";
		date = "10";
		month = "August";
		year = "1998";

	}

	// log 4j | 1 forder Log04J | TestNGAppender

	@Test
	public void User_01_Register() {

		log.info("Register - step 01: Navigate to 'register' page");
		registerPage = homePage.openRegisterPage();

		registerPage.clickToRadioButtonByLabel(driver, "Female");

		log.info("Register - step 02 : enter to firstname textbox with value is '" + firstName + "'");
		// registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register - step 03 : enter to lastName textbox with value is '" + lastName + "'");
		// registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToTextboxByID(driver, "Lastname", lastName);

		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", date);
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register - step 04 : enter to emailAddress textbox with value is '" + emailAddress + "'");
		// registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register - step 05 : enter to validPassword textbox with value is '" + validPassword + "'");
		// registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Register - step 06 : enter to confirmPassword textbox with value is '" + validPassword + "'");
		// registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Register - step 07 : click to Register button");
		// registerPage.clickToRegisterButton();
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register - step 08 : Verify register sucess message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void User_02_Login() {
		log.info("Register - step 09 : click to logout link");
		homePage = registerPage.clickToLogoutLink();

		log.info("Login - step 01: Navigate to login page");
		loginPage = homePage.openLoginPage();

		log.info("Login - step 02: Enter to Email textbox with values is '" + emailAddress + "'");
		// loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Login - step 03: Enter to password textbox with values is '" + validPassword + "'");
		// loginPage.inputToPasswordTextbox(validPassword);
		loginPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Login - step 04: Click to login button");
		// homePage = loginPage.clickToLoginButton();
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - step 05: Verify 'My Account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login - step 06: Navigate to 'My account' page");
		customerInforPage = homePage.openMyAccountPage();

		log.info("Login - step 07: Verify 'Customer Infor' page is displayed");
		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_03_My_Account() {
		log.info("My account - step 01 : Navigate to 'My account' page");
		customerInforPage = homePage.openMyAccountPage();

		log.info("My account - step 02 : verify 'Customer infor' page is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());

		log.info("My account - step 03 : verify 'First Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), firstName);

		log.info("My account - step 04 : verify 'Last Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), lastName);

		log.info("My account - step 05 : verify 'Email Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Email"), emailAddress);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	private WebDriver driver;
	private USerHomePageObject homePage;
	private USerRegisterPageObject registerPage;
	private USerLoginPageObject loginPage;
	private USerCustomerInforPageObject customerInforPage;
	private USerAddressPageObject addressPage;
	private USerMyProductReviewPageObject myProductReviewPage;
	private USerRewardPointPageObject rewardPointPage;
	private String firstName, lastName, emailAddress, validPassword;
	private String date, month, year;
}
