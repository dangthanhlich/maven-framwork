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

public class Level_17_Share_data extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println(browserName);
		driver = getBrowserDriver(browserName);
		
		emailAddress = Common_01_Register_End_User.emailAddress;
		validPassword = Common_01_Register_End_User.password;
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Login - step 01: Navigate to login page");
		loginPage = homePage.openLoginPage();

		log.info("Login - step 02: Enter to Email textbox with values is '"+emailAddress+"'");
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Login - step 03: Enter to password textbox with values is '"+validPassword+"'");
		loginPage.inputToPasswordTextbox(validPassword);
		
		log.info("Login - step 04: Click to login button");
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
	private USerAddressPageObject addressPage;
	private USerMyProductReviewPageObject myProductReviewPage;
	private USerRewardPointPageObject rewardPointPage;
	private String emailAddress, validPassword;

}
