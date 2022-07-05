package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcomerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.USerAddressPageObject;
import pageObjects.nopCommerce.user.USerCustomerInforPageObject;
import pageObjects.nopCommerce.user.USerHomePageObject;
import pageObjects.nopCommerce.user.USerLoginPageObject;
import pageObjects.nopCommerce.user.USerMyProductReviewPageObject;
import pageObjects.nopCommerce.user.USerRegisterPageObject;
import pageObjects.nopCommerce.user.USerRewardPointPageObject;

public class Level_17_Share_dataB extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Pre-condition - step 01: Navigate to 'register' page");
		registerPage = homePage.openRegisterPage();
		
		log.info("Pre-condition - step 02 : enter to firstname textbox with value is '"+firstName+"'");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Pre-condition - step 03 : enter to lastName textbox with value is '"+lastName+"'");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Pre-condition - step 04 : enter to emailAddress textbox with value is '"+emailAddress+"'");
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre-condition - step 05 : enter to validPassword textbox with value is '"+validPassword+"'");
		registerPage.inputToPasswordTextbox(validPassword);
		
		log.info("Pre-condition - step 06 : enter to confirmPassword textbox with value is '"+validPassword+"'");
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		log.info("Pre-condition - step 07 : click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Pre-condition - step 08 : Verify register sucess message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-condition - step 09 : click to logout link");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("Pre-condition - step 10: Navigate to login page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - step 11: Enter to Email textbox with values is '"+emailAddress+"'");
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre-condition - step 12: Enter to password textbox with values is '"+validPassword+"'");
		loginPage.inputToPasswordTextbox(validPassword);
		
		log.info("Pre-condition - step 13: Click to login button");
		
		homePage = loginPage.clickToLoginButton();
		
	}
		@Test
		public void Search_01_Empty_Data() {
		
		}
		
		@Test
		public void Search_02_Relative_Product_Name() {
		
		}
		
		@Test
		public void Search_03_Absolute_Product_Name() {
		
		}
		
		@Test
		public void Search_04_Parent_Category() {
		
		}
		
		@Test
		public void Search_05_Incorrect_Manufacturer() {
		
		}
		
		@Test
		public void Search_05_Correct_Manufacturer() {
		
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
	private USerHomePageObject homePage;
	private USerRegisterPageObject registerPage;
	private USerLoginPageObject loginPage;
	private USerCustomerInforPageObject customerInforPage;
	private String firstName, lastName;
	public static String  emailAddress, validPassword;

}
