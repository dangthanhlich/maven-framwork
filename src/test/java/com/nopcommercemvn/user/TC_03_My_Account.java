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
        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "dao";
        editFirstName = "Automation";
        lastName = "dang";
        editLastName = "FC";
        emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
        editEmailAddress = "edit" + generateFakeNumber() + "@gmail.vn";
        inemailAddress = "auto" + generateFakeNumber() + "@gmail.vn";
        inValidEmailAddress = "#123";
        validPassword = "123456";
        invalidPassword = "456789";
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

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 01: open page My Account");
        myAccountPage = registerPage.clickToMyAccountLink();

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 02: open page Customer Infor");
        CustomerInforPage = myAccountPage.openListAccountPage("Customer info");
//
//        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 03:choose to male or Female");
//        CustomerInforPage.genderMaleOrFemale("male");
//
//
//        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 04:  Enter to Firstname textbox with value is '" + editFirstName + "'");
//        CustomerInforPage.inputToFirstnameTextbox(editFirstName);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 05:  Enter to LastName textbox with value is '" + editLastName + "'");
//        CustomerInforPage.inputToLastnameTextbox(editLastName);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 05: Select 'DAY' item in dropdown");
//        CustomerInforPage.dropdownItemDay(date);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 06: Select 'MONTH' item in dropdown");
//        CustomerInforPage.dropdownItemMonth(month);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 07: Select 'YEAR' item in dropdown");
//        CustomerInforPage.dropdownItemYear(year);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 08:  Enter to Email textbox with value is '" + editEmailAddress + "'");
//        CustomerInforPage.inputToEmailTextbox(editEmailAddress);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 09:  Enter to Email textbox with value is '" + companyAddress + "'");
//        CustomerInforPage.inputToCompanyTextbox(companyAddress);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 10: Click to button Save");
//        CustomerInforPage.clickToSaveButton();
//
//        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor -step 11: Verify gender is requied");
//        verifyTrue(CustomerInforPage.isGenderDisplayed("male"));
//        CustomerInforPage.sleepInSecond(5);

//        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 0: open page Addresses");
//        AddressesPage = CustomerInforPage.openAddressAddNewPage("Addresses");
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 01: Add new button");
//        AddressesPage.clickToAddNewButton();
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 02: Enter to Firstname textbox with value '" + firstName + "'");
//        AddressesPage.inputToFirstNameTextbox(firstName);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 03: Enter to lastName textbox with value '" + lastName + "'");
//        AddressesPage.inputToLastNameTextbox(lastName);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 04: Enter to Email textbox with value '" + emailAddress + "'");
//        AddressesPage.inputToEmailAddressTextBox(emailAddress);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 05: Enter to company textbox with value '" + companyAddress + "'");
//        AddressesPage.inputToCompanyAddressTextbox(companyAddress);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 06: Select 'country' item in dropdown");
//        AddressesPage.dropdownCountry("Viet Nam");
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 07: Select 'State / province' item in dropdown");
//        AddressesPage.dropdownStateProvince("Other");
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 08: Enter to City textbox with value '" + city + "'");
//        AddressesPage.inputToCityTextbox(city);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 09: Enter to Address 1:  textbox with value '" + address1 + "'");
//        AddressesPage.inputToAddress1Textbox(address1);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 10: Enter to Address 2:  textbox with value '" + address2 + "'");
//        AddressesPage.inputToAddress2Textbox(address2);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 11: Enter to Zip / postal code:  textbox with value '" + ZipPostalCode + "'");
//        AddressesPage.inputToZipPostalTextbox(ZipPostalCode);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 12: Enter to Phone number code:  textbox with value '" + PhoneNumber + "'");
//        AddressesPage.inputToPhoneNumberTextbox(PhoneNumber);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 13: Enter to Fax number: code:  textbox with value '" + Fax_Number + "'");
//        AddressesPage.inputToFaxNumberTextbox(Fax_Number);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Addresses - Step 14: Save button");
//        AddressesPage.clickToSaveButton();
//
//        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor -step 11: Verify Name is requied");
//        verifyTrue(AddressesPage.isGenderDisplayed(firstName,lastName));
//        AddressesPage.sleepInSecond(5);

    }

    public void My_Account_01_Customer_Infor(Method method) {
        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 01: open page My Account");
        myAccountPage = registerPage.clickToMyAccountLink();

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 02: open page Customer Infor");
        CustomerInforPage = myAccountPage.openListAccountPage("Customer info");

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 03:choose to male or Female");
        CustomerInforPage.genderMaleOrFemale("male");


        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 04:  Enter to Firstname textbox with value is '" + editFirstName + "'");
        CustomerInforPage.inputToFirstnameTextbox(editFirstName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 05:  Enter to LastName textbox with value is '" + editLastName + "'");
        CustomerInforPage.inputToLastnameTextbox(editLastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 05: Select 'DAY' item in dropdown");
        CustomerInforPage.dropdownItemDay(date);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 06: Select 'MONTH' item in dropdown");
        CustomerInforPage.dropdownItemMonth(month);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 07: Select 'YEAR' item in dropdown");
        CustomerInforPage.dropdownItemYear(year);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 08:  Enter to Email textbox with value is '" + editEmailAddress + "'");
        CustomerInforPage.inputToEmailTextbox(editEmailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 09:  Enter to Email textbox with value is '" + companyAddress + "'");
        CustomerInforPage.inputToCompanyTextbox(companyAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 10: Click to button Save");
        CustomerInforPage.clickToSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer Infor -step 11: Verify gender is requied");
        verifyTrue(CustomerInforPage.isGenderDisplayed("male"));
        CustomerInforPage.sleepInSecond(5);
    }


    public void My_Account_02_Addresses(Method method) {

        ExtentTestManager.startTest(method.getName(), "Addresses to system TC 02");
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
        verifyTrue(AddressesPage.isGenderDisplayed(firstName,lastName));
        AddressesPage.sleepInSecond(5);
    }


    public void My_Account_03_Change_Password(Method method) {

    }


    public void My_Account_04_My_Product_reviews(Method method) {

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
    AddressesPageObject AddressesPage;
    ChangePasswordPageObject ChangePasswordPage;
    USerRegisterPageObject registerPage;
    CustomerInforPageObject CustomerInforPage;
    MyAccountPageObject myAccountPage;
    MyProductReviewsPageObject MyProductReviewsPage;
    ProductBooksPageObject ProductBooksPage;
    String date, month, year, companyAddress, firstName, lastName, emailAddress,
            validPassword, inemailAddress, invalidPassword, inValidEmailAddress,
            editFirstName, editLastName, editEmailAddress,
            address1, address2, city, ZipPostalCode, PhoneNumber, Fax_Number;

}
