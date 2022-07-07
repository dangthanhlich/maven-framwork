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
		validPassword = "123456";
	}

	@Test
	public void Register_user_01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: open page");
		registerPage = homePage.openRegisterPage();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to button Register");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify register error message is requied");
		verifyTrue(registerPage.isErrorMessageDisplayed("First name is required."));
		verifyTrue(registerPage.isErrorMessageDisplayed("Last name is required."));
		verifyTrue(registerPage.isErrorMessageDisplayed("Email is required."));
		verifyTrue(registerPage.isErrorMessageDisplayed("Password is required."));
		verifyTrue(registerPage.isErrorMessageDisplayed("Password is required."));

	}

	@Test
	public void Register_user_02_Invalid_Email(Method method) {
		// homePage.refereshCurrentPage(driver);
	}

	@Test
	public void Register_user_03_Valid_Data(Method method) {

	}

	@Test
	public void Register_user_04_Email_Data_Exists(Method method) {

	}

	@Test
	public void Register_user_05_Password_less_than_6_characters(Method method) {

	}

	@Test
	public void Register_user_06_confirm_password(Method method) {

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
	String firstName, lastName, emailAddress, validPassword;
}
