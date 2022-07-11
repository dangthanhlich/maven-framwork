package com.nopcommercemvn.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommercemvn.usermvn.PageGeneratorManager;
import pageObjects.nopCommercemvn.usermvn.USerHomePageObject;
import pageObjects.nopCommercemvn.usermvn.USerLoginPageObject;
import pageObjects.nopCommercemvn.usermvn.USerRegisterPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Random;

public class TC_00_Register_login extends BaseTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "Automation";
        lastName = "FC";
        emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
        inemailAddress = "auto" + generateFakeNumber() + "@gmail.vn";
        inValidEmailAddress = "#123";
        validPassword = "123456";
        invalidPassword = "456789";
    }
    @Test
    public void Register_user(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register to system");

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: open page");
        registerPage = homePage.openRegisterPage();

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
    public void Login_User(Method method) {
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01:  refresh page");
        loginPage.refereshCurrentPage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02:  Enter to Email textbox with value is '" + emailAddress + "'");
        loginPage.inputToEmailTextbox(emailAddress);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03:  Enter to Password textbox with value is '" + validPassword + "'");
        loginPage.inputToPasswordTextbox(validPassword);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to button Login");
        loginPage.clickToLoginButton();
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
    String firstName, lastName, emailAddress, validPassword,inemailAddress,invalidPassword,inValidEmailAddress;
}
