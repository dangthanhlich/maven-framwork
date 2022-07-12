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

public class TC_02_Login extends BaseTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        emailAddress = Common_01_Register.emailAddress;
        validPassword = Common_01_Register.validPassword;
        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "Automation";
        lastName = "FC";
        inemailAddress = "auto" + generateFakeNumber() + "@gmail.vn";
        inValidEmailAddress = "#123";
        invalidPassword = "456789";
    }

    @Test
    public void Login_user_01_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login to system");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: open page");
        loginPage = homePage.openLoginPage();
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Click to button Login");
        loginPage.clickToLoginButton();
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Verify Please enter your email message is requied");
        verifyTrue(loginPage.isErrorMessageDisplayed("Please enter your email"));
    }

    @Test
    public void Login_user_02_Invalid_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login to system");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01:  refresh page");
        loginPage.refereshCurrentPage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02:  Enter to Email textbox with value is '" + inValidEmailAddress + "'");
        loginPage.inputToEmailTextbox(inValidEmailAddress);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Click to button Login");
        loginPage.clickToLoginButton();
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Verify Wrong email message is requied");
        verifyTrue(loginPage.isErrorMessageDisplayed("Wrong email"));
    }

    @Test
    public void Login_user_03_Valid_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login to system");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01:  refresh page");
        loginPage.refereshCurrentPage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02:  Enter to Email textbox with value is '" + inemailAddress + "'");
        loginPage.inputToEmailTextbox(inemailAddress);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03:  Enter to Password textbox with value is '" + validPassword + "'");
        loginPage.inputToPasswordTextbox(validPassword);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to button Login");
        loginPage.clickToLoginButton();
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify Wrong email No customer account found message is requied");
        verifyTrue(loginPage.isErrorMessageNoAccountFoundDisplayed("Login was unsuccessful. Please correct the errors and try again.","No customer account found"));
    }

    @Test
    public void Login_user_04_Email_Data_Exists(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login to system");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01:  refresh page");
        loginPage.refereshCurrentPage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02:  Enter to Email textbox with value is '" + emailAddress + "'");
        loginPage.inputToEmailTextbox(emailAddress);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to button Login");
        loginPage.clickToLoginButton();
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify password empty message is requied");
        verifyTrue(loginPage.isErrorMessageNoAccountFoundDisplayed("Login was unsuccessful. Please correct the errors and try again.","The credentials provided are incorrect"));

    }

    @Test
    public void Login_user_05_Password_less_than_6_characters(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login to system");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01:  refresh page");
        loginPage.refereshCurrentPage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02:  Enter to Email textbox with value is '" + emailAddress + "'");
        loginPage.inputToEmailTextbox(emailAddress);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03:  Enter to Password textbox with value is '" + invalidPassword + "'");
        loginPage.inputToPasswordTextbox(invalidPassword);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to button Login");
        loginPage.clickToLoginButton();
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify Wrong password message is requied");
        verifyTrue(loginPage.isErrorMessageNoAccountFoundDisplayed("Login was unsuccessful. Please correct the errors and try again.","The credentials provided are incorrect"));

    }

    @Test
    public void Login_user_06_confirm_password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login to system");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01:  refresh page");
        loginPage.refereshCurrentPage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02:  Enter to Email textbox with value is '" + emailAddress + "'");
        loginPage.inputToEmailTextbox(emailAddress);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03:  Enter to Password textbox with value is '" + validPassword + "'");
        loginPage.inputToPasswordTextbox(validPassword);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to button Login");
        homePage = loginPage.clickToLoginButton();
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
