package com.nopcommerce.user_tc_nopcomerce;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class TC_02_Login extends BaseTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        //homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "Automation";
        lastName = "FC";
        emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
        validPassword = "123456";
    }

    @Test
    public void Register_user_01_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register to system");
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: open page");
        //registerPage = homePage.openRegisterPage();
    }

    @Test
    public void Register_user_02_Invalid_Email(Method method) {

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

    private WebDriver driver;
    String firstName, lastName, emailAddress, validPassword;
}
