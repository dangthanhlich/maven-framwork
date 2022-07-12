package com.nopcommercemvn.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommercemvn.usermvn.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Random;

public class TC_03_My_Account extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        emailAddress = Common_01_Register.emailAddress;
        validPassword = Common_01_Register.validPassword;
        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "dao";
        lastName = "dang";
        validNewPassword = "123456789";
        invalidPassword = "456789";
        editFirstName = "Automation";
        editLastName = "FC";
        editEmailAddress = "edit" + generateFakeNumber() + "@gmail.vn";
        inemailAddress = "auto" + generateFakeNumber() + "@gmail.vn";
        inValidEmailAddress = "#123";
        date = "10";
        month = "October";
        year = "2000";
        companyAddress = "Automation FC company";
        address1 = "ha noi" + generateFakeNumber();
        address2 = "da nang" + generateFakeNumber();
        city = "ha noi";
        ZipPostalCode = "55000000";
        PhoneNumber = "0123456789";
        Fax_Number = "0987654320";
        reviewTitle="review product";
        reviewText="review product books good";



    }


    @Test
    public void My_Account_01_Customer_Infor(Method method) {
        ExtentTestManager.startTest(method.getName(), "My Account to system");

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 01: open page login");

        loginPage = homePage.openLoginPage();
        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 02:enter to email is value");
        loginPage.inputToEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 03: enter to password is value");
        loginPage.inputToPasswordTextbox(validPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 04: click to logout buttont");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 05: open page My Account");
        myAccountPage = homePage.clickToMyAccountLink();

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 06: open page Customer Infor");
        CustomerInforPage = myAccountPage.openListAccountPage("Customer info");

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 07:choose to male or Female");
        CustomerInforPage.genderMaleOrFemale("male");


        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 08:  Enter to Firstname textbox with value is '" + editFirstName + "'");
        CustomerInforPage.inputToFirstnameTextbox(editFirstName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 09:  Enter to LastName textbox with value is '" + editLastName + "'");
        CustomerInforPage.inputToLastnameTextbox(editLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 10: Select 'DAY' item in dropdown");
        CustomerInforPage.dropdownItemDay(date);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 11: Select 'MONTH' item in dropdown");
        CustomerInforPage.dropdownItemMonth(month);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 12: Select 'YEAR' item in dropdown");
        CustomerInforPage.dropdownItemYear(year);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 13:  Enter to Email textbox with value is '" + editEmailAddress + "'");
        CustomerInforPage.inputToEmailTextbox(editEmailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 14:  Enter to Email textbox with value is '" + companyAddress + "'");
        CustomerInforPage.inputToCompanyTextbox(companyAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 15: Click to button Save");
        CustomerInforPage.clickToSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor -step 16: Verify gender is requied");
        verifyTrue(CustomerInforPage.isGenderDisplayed("male"));
    }

   @Test
    public void My_Account_02_Addresses(Method method) {
        ExtentTestManager.startTest(method.getName(), "Addresses to system");

        ExtentTestManager.getTest().log(Status.INFO,"Addresses to system TC 02");
        AddressesPage = CustomerInforPage.openAddressAddNewPage("Addresses");

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 01: Add new button");
        AddressesPage.clickToAddNewButton();

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 02: Enter to Firstname textbox with value '" + firstName + "'");
        AddressesPage.inputToFirstNameTextbox(firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 03: Enter to lastName textbox with value '" + lastName + "'");
        AddressesPage.inputToLastNameTextbox(lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 04: Enter to Email textbox with value '" + emailAddress + "'");
        AddressesPage.inputToEmailAddressTextBox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 05: Enter to company textbox with value '" + companyAddress + "'");
        AddressesPage.inputToCompanyAddressTextbox(companyAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 06: Select 'country' item in dropdown");
        AddressesPage.dropdownCountry("Viet Nam");

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 07: Select 'State / province' item in dropdown");
        AddressesPage.dropdownStateProvince("Other");

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 08: Enter to City textbox with value '" + city + "'");
        AddressesPage.inputToCityTextbox(city);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 09: Enter to Address 1:  textbox with value '" + address1 + "'");
        AddressesPage.inputToAddress1Textbox(address1);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 10: Enter to Address 2:  textbox with value '" + address2 + "'");
        AddressesPage.inputToAddress2Textbox(address2);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 11: Enter to Zip / postal code:  textbox with value '" + ZipPostalCode + "'");
        AddressesPage.inputToZipPostalTextbox(ZipPostalCode);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 12: Enter to Phone number code:  textbox with value '" + PhoneNumber + "'");
        AddressesPage.inputToPhoneNumberTextbox(PhoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 13: Enter to Fax number: code:  textbox with value '" + Fax_Number + "'");
        AddressesPage.inputToFaxNumberTextbox(Fax_Number);

        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 14: Save button");
        AddressesPage.clickToSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor -step 15: Verify Name is requied");
        verifyTrue(AddressesPage.isGenderDisplayed(firstName, lastName));
    }


    @Test
    public void My_Account_03_Change_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Change Password to system");

        ExtentTestManager.getTest().log(Status.INFO, "Change Password to system");
        ChangePasswordPage = AddressesPage.openAddressAddNewPage("Change password");

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 01: Enter to old Password '" + validPassword + "'");
        ChangePasswordPage.inputToPasswordTextbox(validPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 02: Enter to New Password '" + validNewPassword + "'");
        ChangePasswordPage.inputToNewPasswordTextbox(validNewPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 03: Enter to Confirm Password '" + validNewPassword + "'");
        ChangePasswordPage.inputToConfirmNewPasswordTextbox(validNewPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 04: Click to button change password");
        ChangePasswordPage.clickToChanePasswordButton();

        ExtentTestManager.getTest().log(Status.INFO, "Change Password -step 05: Verify Name is requied");
        verifyTrue(ChangePasswordPage.isGenderDisplayed("Password was changed"));

        ExtentTestManager.getTest().log(Status.INFO, "Change Password -step 06: Close sucess message change password");
        ChangePasswordPage.clickToClose();

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 07: Click to button logout");
        homePage = ChangePasswordPage.clickToLogoutLink();

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 08: open page");
        loginPage = homePage.openLoginPage();

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 09:  Enter to Email textbox with value is '" + editEmailAddress + "'");
        loginPage.inputToEmailTextbox(editEmailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 10:  Enter to Password textbox with value is '" + validPassword + "'");
        loginPage.inputToPasswordTextbox(validPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 11: Click to button Login");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 12: Verify Wrong password message is requied");
        verifyTrue(loginPage.isErrorMessageNoAccountFoundDisplayed("Login was unsuccessful. Please correct the errors and try again.", "The credentials provided are incorrect"));

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 14:  Enter to Email textbox with value is '" + editEmailAddress + "'");
        loginPage.inputToEmailTextbox(editEmailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 15:  Enter to Password textbox with value is '" + validNewPassword + "'");
        loginPage.inputToPasswordTextbox(validNewPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 16: Click to button Login");
        homePage = loginPage.clickToLoginButton();
    }



   @Test
    public void My_Account_04_My_Product_reviews(Method method) {
        ExtentTestManager.startTest(method.getName(), "My Account product review");
        ExtentTestManager.getTest().log(Status.INFO, "My product reviews - Step 01:Open books product");
        ProductBooksPage = homePage.openAddressAddNewPage("Books ");

        ExtentTestManager.getTest().log(Status.INFO, "My product reviews - Step 02 :Click to name book link");
        ProductBooksPage.clickToBookLink("Fahrenheit 451 by Ray Bradbury");

        ExtentTestManager.getTest().log(Status.INFO, "My product reviews - Step 03 : click to 'Add your review' ");
        ProductBooksPage.clickToAddReview();

        ExtentTestManager.getTest().log(Status.INFO, "My product reviews - Step 04 : Enter to reviewTitle textbox with value is '" + reviewTitle + "'");
        ProductBooksPage.inputToRivewTitleTextbox(reviewTitle);

        ExtentTestManager.getTest().log(Status.INFO, "My product reviews - Step 05 : Enter to reviewTitle textbox with value is '" + reviewText + "'");
        ProductBooksPage.textareaToRivewTextTextbox(reviewText);

        ExtentTestManager.getTest().log(Status.INFO, "My product reviews - Step 06 : click to Ratting radio ");
        ProductBooksPage.rattingRadio("1");

        ExtentTestManager.getTest().log(Status.INFO, "My product reviews - Step 07 : click to Submit review button");
        ProductBooksPage.clickToSubmitReviewButton();

        ExtentTestManager.getTest().log(Status.INFO, "My product reviews - Step 08 : click to my Account link");
        myAccountPage = ProductBooksPage.clickToMyAccountLink();

        ExtentTestManager.getTest().log(Status.INFO, "My product reviews - Step 09 :click to My product reviews link");
        MyProductReviewsPage = myAccountPage.clickTMyProductReviewsLink("My product reviews");

        ExtentTestManager.getTest().log(Status.INFO, "My product reviews - Step 10 :Verify name product");
        verifyTrue(MyProductReviewsPage.isGenderDisplayed("Fahrenheit 451 by Ray Bradbury"));
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
    AddressesPageObject AddressesPage;
    ChangePasswordPageObject ChangePasswordPage;
    USerRegisterPageObject registerPage;
    CustomerInforPageObject CustomerInforPage;
    MyAccountPageObject myAccountPage;
    MyProductReviewsPageObject MyProductReviewsPage;
    ProductBooksPageObject ProductBooksPage;
    String date, month, year, companyAddress, firstName, lastName, emailAddress,
            validPassword, inemailAddress, invalidPassword, inValidEmailAddress,
            editFirstName, editLastName, editEmailAddress, validNewPassword, reviewTitle, reviewText,
            address1, address2, city, ZipPostalCode, PhoneNumber, Fax_Number;

}
