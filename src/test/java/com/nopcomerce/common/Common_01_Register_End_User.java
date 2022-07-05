package com.nopcomerce.common;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.USerAddressPageObject;
import pageObjects.nopCommerce.user.USerCustomerInforPageObject;
import pageObjects.nopCommerce.user.USerHomePageObject;
import pageObjects.nopCommerce.user.USerLoginPageObject;
import pageObjects.nopCommerce.user.USerMyProductReviewPageObject;
import pageObjects.nopCommerce.user.USerRegisterPageObject;
import pageObjects.nopCommerce.user.USerRewardPointPageObject;

public class Common_01_Register_End_User extends BaseTest {

	@Parameters("browser")
	@BeforeTest(description = "Create new common user for all classes Test")
	public void Register(String browserName) {
			
			System.out.println(browserName);
			driver = getBrowserDriver(browserName);
			
			homePage = PageGeneratorManager.getUserHomePage(driver);

			firstName = "Automation";
			lastName = "FC";
			emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
			password = "123456";
			
			log.info("Pre-Condition - step 01: Navigate to 'register' page");
			registerPage = homePage.openRegisterPage();
			
			log.info("Pre-Condition - step 02 : enter to firstname textbox with value is '"+firstName+"'");
			registerPage.inputToFirstnameTextbox(firstName);
			
			log.info("Pre-Condition - step 03 : enter to lastName textbox with value is '"+lastName+"'");
			registerPage.inputToLastNameTextbox(lastName);
			
			log.info("Pre-Condition - step 04 : enter to emailAddress textbox with value is '"+emailAddress+"'");
			registerPage.inputToEmailTextbox(emailAddress);
			
			log.info("Pre-Condition - step 05 : enter to validPassword textbox with value is '"+password+"'");
			registerPage.inputToPasswordTextbox(password);
			
			log.info("Pre-Condition - step 06 : enter to confirmPassword textbox with value is '"+password+"'");
			registerPage.inputToConfirmPasswordTextbox(password);
			
			log.info("Pre-Condition - step 07 : click to Register button");
			registerPage.clickToRegisterButton();

			log.info("Pre-Condition - step 08 : Verify register sucess message is displayed");
			Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

			log.info("Pre-Condition - step 09 : click to logout link");
			homePage = registerPage.clickToLogoutLink();
			driver.quit();
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
	private String firstName, lastName;
	public static String  emailAddress, password;

}
