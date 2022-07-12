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
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Random;

public class TC_04_Sort_Display_Paging extends BaseTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        emailAddress = Common_01_Register.emailAddress;
        validPassword = Common_01_Register.validPassword;

        homePage = PageGeneratorManager.getUserHomePage(driver);

    }

    @Test
    public void Sort_Display_Paging_01_Login_User(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search to system");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: open page");
        loginPage = homePage.openLoginPage();
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02:  Enter to Email textbox with value is '" + emailAddress + "'");
        loginPage.inputToEmailTextbox(emailAddress);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03:  Enter to Password textbox with value is '" + validPassword + "'");
        loginPage.inputToPasswordTextbox(validPassword);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to button Login");
        loginPage.clickToLoginButton();
    }

    @Test
    public void Sort_Display_Paging_02_Sort_A_To_Z(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search to system");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Enter to Search textbox with value is ");

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
    USerLoginPageObject loginPage;
    String firstName, lastName, emailAddress, validPassword,inemailAddress,invalidPassword,inValidEmailAddress;
}
