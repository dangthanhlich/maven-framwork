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

public class TC_06_Order extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        emailAddress = Common_01_Register.emailAddress;
        validPassword = Common_01_Register.validPassword;
        firstName = Common_01_Register.firstName;
        lastName = Common_01_Register.lastName;
        city = Common_01_Register.city;
        address1 = Common_01_Register.address1;
        phoneNumber = Common_01_Register.phoneNumber;
        homePage = PageGeneratorManager.getUserHomePage(driver);
        numbercart = "2";
        ZipPostalCode="550000";
        nameProduct ="Lenovo IdeaCentre 600 All-in-One PC";
        priceProduct ="$500.00";
        cardhodername="02934546567";
        cardhodernumber="02934546599";
        cardCode="55000";

    }

    @Test
    public void Order_01_Login_User(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search to system");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: open page");
        loginPage = homePage.openLoginPage();
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02:  Enter to Email textbox with value is '" + emailAddress + "'");
        loginPage.inputToEmailTextbox(emailAddress);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03:  Enter to Password textbox with value is '" + validPassword + "'");
        loginPage.inputToPasswordTextbox(validPassword);
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to button Login");
        homePage = loginPage.clickToLoginButton();
    }

    @Test
    public void Order_02_Add_Product_To_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Product To Cart to system");
        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart - Step 01: open page");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 01: Click to dropdown menu notebooks");
        sortdisplaypaingPage = homePage.dropdowndesktops("Desktops ");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 03: Click to products name 1");
        detailProductsPage = sortdisplaypaingPage.clickToProductName("Build your own computer");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 04: Select 'processor' dropdown");
        detailProductsPage.dropdownProcessor("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 05: Select 'RAM' dropdown");
        detailProductsPage.dropdownRam("2 GB");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 06: Choose HDD Checkbox ");
        detailProductsPage.checkboxradiotoHdd("400 GB [+$100.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 07: Choose OS Checkbox ");
        detailProductsPage.checkboxradiotoOs("Vista Home [+$50.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 08: Choose software Checkbox ");
        detailProductsPage.checkSoftware("Microsoft Office [+$50.00]");


        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 09: Choose software Checkbox ");
        detailProductsPage.checkSoftware("Acrobat Reader [+$10.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step `10: Choose software Checkbox ");
        detailProductsPage.checkSoftware("Total Commander [+$5.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 11: Click to button Add to Cart ");
        detailProductsPage.clickToAddToCart("Add to cart");
        detailProductsPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 12: Verify  the product has been added to your shopping cart  message is displayed");
        verifyTrue(detailProductsPage.isAddToCartSuceessMessage("The product has been added to your "));

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 13: Click Shopping Cart");
        shoppingCartPage = detailProductsPage.clickShoppingCart("The product has been added to your ");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 14: Hover Shopping Cart ");
        shoppingCartPage.hoverToShoppingCart();

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 15: Verify  'Count item' is display");
        verifyTrue(shoppingCartPage.isItemShoppingMessage("1 item(s)"));

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 16: Verify  'name' is display");
        verifyTrue(shoppingCartPage.isNameDisplay("Build your own computer"));

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Cart  - Step 17: Verify  'price product' is display");
        verifyTrue(shoppingCartPage.isProducPricetDisplay("$1,330.00"));

    }

    @Test
    public void Order_03_Edit_Product_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Edit Cart to system");
        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 01: Click go to Cart");
        orderPage = shoppingCartPage.clickGoToCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 02: Click go to Edit Cart");
        detailProductsPage = orderPage.clickGoToEditCart();

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 03: Select 'processor' dropdown");
        detailProductsPage.dropdownProcessor("2.2 GHz Intel Pentium Dual-Core E2200");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 04: Select 'RAM' dropdown");
        detailProductsPage.dropdownRam("4GB [+$20.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 05: Choose HDD Checkbox ");
        detailProductsPage.checkboxradiotoHdd("320 GB");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 06: Choose OS Checkbox ");
        detailProductsPage.checkboxradiotoOs("Vista Premium [+$60.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 07: Choose software Checkbox ");
        detailProductsPage.checkSoftware("Microsoft Office [+$50.00]");


        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 08: Choose software Checkbox ");
        detailProductsPage.checkSoftware("Acrobat Reader [+$10.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step `9: Choose software Checkbox ");
        detailProductsPage.checkSoftware("Total Commander [+$5.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart - Step 10:  Enter to input number cart");
        detailProductsPage.inputToNumberCartTextbox(numbercart);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 11: Click to button Update ");
        detailProductsPage.clickToAddToCart("Update");

        detailProductsPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 13: Verify  the product has been added to your shopping cart  message is displayed");
        verifyTrue(detailProductsPage.isAddToCartSuceessMessage("The product has been added to your "));

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 14: Click Shopping Cart");
        shoppingCartPage = detailProductsPage.clickShoppingCart("The product has been added to your ");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 15: Hover Shopping Cart ");
        shoppingCartPage.hoverToShoppingCart();

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 16: Verify  'Count item' is display");
        verifyTrue(shoppingCartPage.isItemShoppingMessage("2 item(s)"));

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 17: Verify  'name' is display");
        verifyTrue(shoppingCartPage.isNameDisplay("Build your own computer"));

        ExtentTestManager.getTest().log(Status.INFO, "Edit Cart  - Step 18: Verify  'price product' is display");
        verifyTrue(shoppingCartPage.isProducPricetDisplay("$2,670.00"));

    }

    @Test
    public void Order_04_Remove_From_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Remove cart to system");
        ExtentTestManager.getTest().log(Status.INFO, "Remove cart - Step 01: remove Cart");
        shoppingCartPage.clickToRemoveCart();

        ExtentTestManager.getTest().log(Status.INFO, "Remove Cart  - Step 18: Verify empty message is display");
        verifyTrue(shoppingCartPage.isEmptyCartMessage("Your Shopping Cart is empty!"));


    }

    @Test
    public void Order_05_Update_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Update shopping cart to system");
        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart  - Step 01: Click to dropdown menu notebooks");
        sortdisplaypaingPage = shoppingCartPage.dropdowndesktops("Desktops ");

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart - Step 02: Click to products name ");
        detailProductsPage = sortdisplaypaingPage.clickToProductName(nameProduct);

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart  - Step 03: Click to button Add to Cart ");
        detailProductsPage.clickToAddToCart("Add to cart");
        detailProductsPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart - Step 04: Verify  the product has been added to your shopping cart  message is displayed");
        verifyTrue(detailProductsPage.isAddToCartSuceessMessage("The product has been added to your "));

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart  - Step 05: Click Shopping Cart");
        shoppingCartPage = detailProductsPage.clickShoppingCart("The product has been added to your ");

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart  - Step 06: Enter qty textbox ");
        shoppingCartPage.enterToQtyTextbox("2");

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart  - Step 07: Click to button Update shopping cart ");
        shoppingCartPage.clickToUpdateShoppingCart();

        ExtentTestManager.getTest().log(Status.INFO, "Update shopping cart - Step 08: Verify  'Total' is display");
        verifyTrue(shoppingCartPage.isTotalDisplay("$1,000.00"));
    }

    @Test
    public void Order_06_Checkout_Order(Method method) {
        ExtentTestManager.startTest(method.getName(), "Checkout order to system");
        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 01: click to ' Estimate shipping ' page");
        shoppingCartPage.clickToEstimateShippinCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 02: Select country dropdown");
        shoppingCartPage.selectCountryDropdown("Viet Nam");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 03: Enter to ZipPostalCode");
        shoppingCartPage.inputZipPostalCodeTextbox(ZipPostalCode);
        shoppingCartPage.sleepInSecond(4);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 04: Click to Apply");
        shoppingCartPage.clickToApply();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 05:  Verify Gift wrapping: No message is displayed");
        verifyTrue(shoppingCartPage.isGiftWrappingMessage("Gift wrapping: No"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 06: Checkbox input Agree ");
        shoppingCartPage.checkboxToCheckAgree();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 06: Click to check out ");
        shoppingCartPage.clickToCheckOut();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 07:  Enter to Firstname textbox with value is '" + firstName + "'");
        shoppingCartPage.inputToFirstnameTextbox(firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 07:  Enter to LastName textbox with value is '" + firstName + "'");
        shoppingCartPage.inputToLastnameTextbox(lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 08:  Enter to Email textbox with value is '" + emailAddress + "'");
        shoppingCartPage.inputToEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 09: Select country dropdown");
        shoppingCartPage.selectCountryDropdownCheckOut("Viet Nam");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 10:  Enter to City textbox with value is '" + city + "'");
        shoppingCartPage.inputToCityTextbox(city);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 11:  Enter to City textbox with value is '" + address1 + "'");
        shoppingCartPage.inputToAddress1Textbox(address1);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 12: Enter to ZipPostalCode Textbox is '" + ZipPostalCode + "'");
        shoppingCartPage.inputZipPostalCodeCheckOut(ZipPostalCode);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 13: Enter to PhoneNumber Textbox is'" + phoneNumber + "'");
        shoppingCartPage.inputPhoneNUmberCheckOut(phoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 14: Click to button continue");
        shoppingCartPage.clickToContinueButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 15: Click to radio Ground ($0.00) checkout  ");
        shoppingCartPage.clickToRadioGroup("Ground ($0.00)");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 16: Click to button continue checkout");
        shoppingCartPage.clickToContinueCheckoutButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 17: Click to radio Check / Money Order or Credit Card");
        shoppingCartPage.clickToRadioPayCart("Check / Money Order");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 18: Click to button continue checkout");
        shoppingCartPage.clickToContinuePayCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 19: Verify  'NOP SOLUTIONS' message is displayed");
        verifyTrue(shoppingCartPage.isNopSolutionMessage("NOP SOLUTIONS"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 20: Click to button continue checkout");
        shoppingCartPage.clickToContinueNoticeButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 21: Verify  'Email'  is displayed");
        verifyTrue(shoppingCartPage.isEmailDisplay("Email:"+emailAddress));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 22: Verify  'Email'  is displayed");
        verifyTrue(shoppingCartPage.isPhoneDisplay("Phone:"+phoneNumber));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 23: Verify  pay ment method check money order is displayed");
        verifyTrue(shoppingCartPage.isPaymentMethodDisplay("Payment Method: Check / Money Order"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 24: Verify shipping method group is displayed");
        verifyTrue(shoppingCartPage.isShippingMethodDisplay("Shipping Method: Ground"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 25: Verify Sku is displayed");
        verifyTrue(shoppingCartPage.isSkuDisplay("LE_IC_600"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 26: Verify products name is displayed");
        verifyTrue(shoppingCartPage.isNameProductsDisplay(nameProduct));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 27: Verify price  is displayed");
        verifyTrue(shoppingCartPage.isPriceProductsDisplay("$500.00"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 28: Verify qty  is displayed");
        verifyTrue(shoppingCartPage.isQtyProductsDisplay("2"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 29: Verify Total is displayed");
        verifyTrue(shoppingCartPage.isTotalProductsDisplay("$1,000.00"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 30: Verify 'Gift wrapping: No' message is displayed");
        verifyTrue(shoppingCartPage.isGiftWrappingDisplay("Gift wrapping: No"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 31: Verify total shipping is displayed");
        verifyTrue(shoppingCartPage.isTotalShippingDisplay("Sub-Total:","$1,000.00"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 32: Verify total shipping is displayed");
        verifyTrue(shoppingCartPage.isTotalShippingDisplay("Shipping:","$0.00"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 33: Verify total shipping is displayed");
        verifyTrue(shoppingCartPage.isTotalShippingDisplay("Total:","$1,000.00"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 34: Click to button confirm checkout");
        shoppingCartPage.clickToConfirmButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 35: Verify Thank you message is displayed");
        verifyTrue(shoppingCartPage.isthankyouMessageDisplay("Thank you"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 36: Verify 'Your order has been successfully processed!' message is displayed");
        verifyTrue(shoppingCartPage.issuccessfullyMessageDisplay("Your order has been successfully processed!"));


        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 38 : click to my Account link");
        myAccountPage = shoppingCartPage.clickToMyAccountLink();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 39 :click to Orders link");
        orderPage = myAccountPage.clickTMyProductLink("Orders");


        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 41: Click to detail button ");
        orderPage.clickToDetailButton();


//        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 43: Verify day Order current is displayed");
//        verifyTrue(orderPage.isOrderNumberDetailMessageDisplay("Order Date: Saturday, July 16, 2022"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 44: Verify day Order status is displayed");
        verifyTrue(orderPage.isOrderstatusDisplay("Order Status: Pending"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 45: Verify day Order total is displayed");
        //Order Total: + $500.00
        verifyTrue(orderPage.isOrderTotalMessageDisplay("Order Total: $1,000.00"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 46: Verify  'Email'  is displayed");
        verifyTrue(orderPage.isEmailDisplay("Email:"+emailAddress));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 47: Verify  pay ment method check money order is displayed");
        verifyTrue(orderPage.isPaymentMethodDisplay("Payment Method: Check / Money Order"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 48: Verify Shipping address 'Email'  is displayed");
        verifyTrue(orderPage.isEmailDisplay("Email:"+emailAddress));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 49: Verify shipping method group is displayed");
        verifyTrue(orderPage.isShippingMethodDisplay("Shipping Method: Ground "));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 50: Verify Sku is displayed");
        verifyTrue(orderPage.isSkuDisplay("LE_IC_600"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 51: Verify products name is displayed");
        verifyTrue(orderPage.isNameProductsDisplay(nameProduct));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 52: Verify price  is displayed");
        verifyTrue(orderPage.isPriceProductsDisplay("$1,000.00"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 53: Verify qty  is displayed");
        verifyTrue(orderPage.isQtyProductsDisplay("2"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 54: Verify Total is displayed");
        verifyTrue(orderPage.isTotalProductsDisplay("$1,000.00"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 55: Verify 'Gift wrapping: No' message is displayed");
        verifyTrue(orderPage.isGiftWrappingDisplay("Gift wrapping: No"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 56: Verify total shipping is displayed");
        verifyTrue(orderPage.isTotalShippingDisplay("Sub-Total:","$1,000.00"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 57: Verify total shipping is displayed");
        verifyTrue(orderPage.isTotalShippingDisplay("Shipping:","$0.00"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 58: Verify total shipping is displayed");
        verifyTrue(orderPage.isTotalShoppingCartDisplay("Order Total:","$1,000.00"));

    }


    public void Order_07_Checkout_Payment(Method method) {
        ExtentTestManager.startTest(method.getName(), "Checkout Payment to system");
        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment  - Step 01: Click Shopping Cart");
        shoppingCartPage = orderPage.clickShoppingCart();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment  - Step 04: Click to dropdown menu notebooks");
        sortdisplaypaingPage = shoppingCartPage.dropdowndesktops("Desktops ");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 05: Click to products name ");
        detailProductsPage = sortdisplaypaingPage.clickToProductName(nameProduct);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment  - Step 06: Click to button Add to Cart ");
        detailProductsPage.clickToAddToCart("Add to cart");
        detailProductsPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 07: Verify  the product has been added to your shopping cart  message is displayed");
        verifyTrue(detailProductsPage.isAddToCartSuceessMessage("The product has been added to your "));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment  - Step 08: Click Shopping Cart");
        shoppingCartPage = detailProductsPage.clickShoppingCart("The product has been added to your ");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment  - Step 09: Enter qty textbox ");
        shoppingCartPage.enterToQtyTextbox("2");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment  - Step 10: Click to button Update shopping cart ");
        shoppingCartPage.clickToUpdateShoppingCart();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 11: Verify  'Total' is display");
        verifyTrue(shoppingCartPage.isTotalDisplay("$1,000.00"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 12: click to ' Estimate shipping ' page");
        shoppingCartPage.clickToEstimateShippinCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 13: Select country dropdown");
        shoppingCartPage.selectCountryDropdown("Viet Nam");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 14: Enter to ZipPostalCode");
        shoppingCartPage.inputZipPostalCodeTextbox(ZipPostalCode);
        shoppingCartPage.sleepInSecond(4);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment- Step 15: Click to Apply");
        shoppingCartPage.clickToApply();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 16:  Verify Gift wrapping: No message is displayed");
        verifyTrue(shoppingCartPage.isGiftWrappingMessage("Gift wrapping: No"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 17: Checkbox input Agree ");
        shoppingCartPage.checkboxToCheckAgree();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 18: Click to check out ");
        shoppingCartPage.clickToCheckOut();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 19:  Enter to Firstname textbox with value is '" + firstName + "'");
        shoppingCartPage.inputToFirstnameTextbox(firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 20:  Enter to LastName textbox with value is '" + firstName + "'");
        shoppingCartPage.inputToLastnameTextbox(lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 21:  Enter to Email textbox with value is '" + emailAddress + "'");
        shoppingCartPage.inputToEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 22: Select country dropdown");
        shoppingCartPage.selectCountryDropdownCheckOut("Viet Nam");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 23:  Enter to City textbox with value is '" + city + "'");
        shoppingCartPage.inputToCityTextbox(city);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 24:  Enter to City textbox with value is '" + address1 + "'");
        shoppingCartPage.inputToAddress1Textbox(address1);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 25: Enter to ZipPostalCode Textbox is '" + ZipPostalCode + "'");
        shoppingCartPage.inputZipPostalCodeCheckOut(ZipPostalCode);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment- Step 26: Enter to PhoneNumber Textbox is'" + phoneNumber + "'");
        shoppingCartPage.inputPhoneNUmberCheckOut(phoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 27: Click to button continue");
        shoppingCartPage.clickToContinueButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 28: Click to radio Ground ($0.00) checkout  ");
        shoppingCartPage.clickToRadioGroup("Ground ($0.00)");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 29: Click to button continue checkout");
        shoppingCartPage.clickToContinueCheckoutButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment- Step 30: Click to radio Check / Money Order or Credit Card");
        shoppingCartPage.clickToRadioPayCart("Check / Money Order");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout Payment - Step 31: Click to button continue checkout");
        shoppingCartPage.clickToContinuePayCartButton();

//        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 18: select 'Select credit card' dropdown");
//        shoppingCartPage.dropdownCard("Visa");
//
//        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Enter toCardholder name textbox with value is '" + cardhodername + "'");
//        shoppingCartPage.inputToCardhoderNameTextbox(cardhodername);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Enter toCardholder name textbox with value is '" + cardhodernumber + "'");
//        shoppingCartPage.inputToCardhoderNumberTextbox(cardhodernumber);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 18: select 'Expiration date: month' dropdown");
//        shoppingCartPage.dropdownExpirationMonth("01");
//
//        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 18: select 'Expiration date:year' dropdown");
//        shoppingCartPage.dropdownExpirationYear("2022");
//
//        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Enter Card code:  textbox with value is '" + cardCode + "'");
//        shoppingCartPage.inputToCardCodeTextbox(cardCode);
//
//        ExtentTestManager.getTest().log(Status.INFO, "Checkout order - Step 18: Click to continue button ");
//        shoppingCartPage.clickToContinueCardButton();


    }

//    @Test
//    public void Order_08_Re_Order(Method method) {
//        ExtentTestManager.startTest(method.getName(), "Re order to system");
//        ExtentTestManager.getTest().log(Status.INFO, "Re order - Step 01: open page");
//        orderPage = myAccountPage.clickTMyProductLink("Orders");
//    }


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

    OrderPageObject orderPage;
    ProductBooksPageObject ProductBooksPage;
    MyAccountPageObject myAccountPage;

    WishListPageObject WishListPage;

    ComparePageObject ComparePage;

    SortDisplayPaingPageObject sortdisplaypaingPage;

    DetailProductsPageObject detailProductsPage;

    ShoppingCartPageObject shoppingCartPage;

    RecentlyViewedProductsPageObject recentlyViewedProductsPage;

    String  emailAddress, validPassword, numbercart,ZipPostalCode, nameProduct,priceProduct,
            firstName,lastName,city, address1, phoneNumber,cardhodername,cardhodernumber,cardCode;



}
