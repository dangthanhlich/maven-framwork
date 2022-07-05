package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.data.nopcommerce.UserData;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.USerAddressPageObject;
import pageObjects.nopCommerce.user.USerCustomerInforPageObject;
import pageObjects.nopCommerce.user.USerHomePageObject;
import pageObjects.nopCommerce.user.USerLoginPageObject;
import pageObjects.nopCommerce.user.USerMyProductReviewPageObject;
import pageObjects.nopCommerce.user.USerRegisterPageObject;
import pageObjects.nopCommerce.user.USerRewardPointPageObject;
import utilities.DataHelper;

public class Level_20_manager_Data extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println(browserName);
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);
		dataFaker = DataHelper.getDataHelper();

		// firstName = UserData.Register.FIRST_NAME;
		// lastName = UserData.Register.LAST_NAME;
		emailAddress = UserData.Register.EMAIL_ADDRESS + generateFakeNumber() + "@gmail.vn";
		// validPassword = UserData.Register.PASSWORD;

	}

	@Test
	public void User_01_Register() {

		log.info("Register - step 01: Navigate to 'register' page");
		registerPage = homePage.openRegisterPage();

		log.info(
				"Register - step 02 : enter to firstname textbox with value is '" + UserData.Register.FIRST_NAME + "'");
		registerPage.inputToFirstnameTextbox(UserData.Register.FIRST_NAME);

		log.info("Register - step 03 : enter to lastName textbox with value is '" + UserData.Register.LAST_NAME + "'");
		registerPage.inputToLastNameTextbox(UserData.Register.LAST_NAME);

		log.info("Register - step 04 : enter to emailAddress textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Register - step 05 : enter to validPassword textbox with value is '" + UserData.Register.PASSWORD
				+ "'");
		registerPage.inputToPasswordTextbox(UserData.Register.PASSWORD);

		log.info("Register - step 06 : enter to confirmPassword textbox with value is '" + UserData.Register.PASSWORD
				+ "'");
		registerPage.inputToConfirmPasswordTextbox(UserData.Register.PASSWORD);

		log.info("Register - step 07 : click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register - step 08 : Verify register sucess message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - step 09 : click to logout link");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void User_02_Login() {
		log.info("Login - step 01: Navigate to login page");
		loginPage = homePage.openLoginPage();

		log.info("Login - step 02: Enter to Email textbox with values is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Login - step 03: Enter to password textbox with values is '" + UserData.Register.PASSWORD + "'");
		loginPage.inputToPasswordTextbox(UserData.Register.PASSWORD);

		log.info("Login - step 04: Click to login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - step 05: Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login - step 06: Navigate to 'My account' page");
		customerInforPage = homePage.openMyAccountPage();

		log.info("Login - step 07: Verify 'Customer Infor' page is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
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
	private DataHelper dataFaker;
	private USerHomePageObject homePage;
	private USerRegisterPageObject registerPage;
	private USerLoginPageObject loginPage;
	private USerCustomerInforPageObject customerInforPage;
	private USerAddressPageObject addressPage;
	private USerMyProductReviewPageObject myProductReviewPage;
	private USerRewardPointPageObject rewardPointPage;
	private String firstName, lastName, emailAddress, validPassword;

}
