package com.nopcommercemvn.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.nopCommercemvn.usermvn.PageGeneratorManager;
import pageObjects.nopCommercemvn.usermvn.USerHomePageObject;
import pageObjects.nopCommercemvn.usermvn.USerLoginPageObject;
import pageObjects.nopCommercemvn.usermvn.USerRegisterPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Random;

public class Common_01_Register extends BaseTest {


    @Parameters("browser")
    @BeforeTest(description = "Create new common user for all classes Test")
    public void Register_user(Method method, String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "Automation";
        lastName = "FC";
        emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
        inemailAddress = "auto" + generateFakeNumber() + "@gmail.vn";
        inValidEmailAddress = "#123";
        validPassword = "123456";
        invalidPassword = "456789";


        registerPage = homePage.openRegisterPage();

        registerPage.inputToFirstnameTextbox(firstName);

        registerPage.inputToLastnameTextbox(lastName);

        registerPage.inputToEmailTextbox(emailAddress);

        registerPage.inputToPasswordTextbox(validPassword);

        registerPage.inputToConfirmPasswordTextbox(validPassword);

        registerPage.clickToRegisterButton();

        verifyTrue(registerPage.isRegisterSuccessMessage("Your registration completed"));



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
    String firstName, lastName, inemailAddress, invalidPassword, inValidEmailAddress;
    public static String emailAddress, validPassword;
}
