package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcomerce.common.Common_01_Register_Cookie;
import com.nopcomerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.USerHomePageObject;
import pageObjects.nopCommerce.user.USerLoginPageObject;

public class Level_17_Share_dataC extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println(browserName);
		driver = getBrowserDriver(browserName);

		emailAddress = Common_01_Register_End_User.emailAddress;
		validPassword = Common_01_Register_End_User.password;

		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("pre-Condition 01: Navigate to login page");
		loginPage = homePage.openLoginPage();

		log.info("pre-Condition 02: Set cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.LoggedCookies);

		for (Cookie cookie : Common_01_Register_Cookie.LoggedCookies) {
			System.out.print("Cookie at common C class" + cookie);
		}

		// sau khi login, thì sẽ reload lị page
		loginPage.refereshCurrentPage(driver);

		log.info("pre-Condition 03: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

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
		// driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	private WebDriver driver;
	private USerHomePageObject homePage;
	private USerLoginPageObject loginPage;
	private String emailAddress, validPassword;

}
