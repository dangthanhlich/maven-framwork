package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.*;

public class ShoppingCartPageObject extends BasePage {
    private WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WishListPageObject clickToWishList() {
        waitForElementClickable(driver, HomePageUI.WISHLIST_LINK);
        clickToElement(driver, HomePageUI.WISHLIST_LINK);
        return PageGeneratorManager.getWishListPage(driver);
    }

    public void hoverToShoppingCart() {
        waitForElementClickable(driver, HomePageUI.SHOPPING_CART_LINK);
        hoverMouseElement(driver, HomePageUI.SHOPPING_CART_LINK);
    }

    public boolean isItemShoppingMessage(String numberitem) {
        waitForElementVisible(driver, OrderPageUI.ITEM_YOUR_CART, numberitem);
        return isElementDisplayed(driver, OrderPageUI.ITEM_YOUR_CART,numberitem);
    }


    public boolean isNameDisplay(String nameproduct) {
        waitForElementVisible(driver, OrderPageUI.NAME_CART,nameproduct);
        return isElementDisplayed(driver, OrderPageUI.NAME_CART,nameproduct);
    }


    public boolean isProducPricetDisplay(String price) {
        waitForElementVisible(driver, OrderPageUI.PRICE_CART,price);
        return isElementDisplayed(driver, OrderPageUI.PRICE_CART,price);
    }


    public OrderPageObject clickGoToCartButton() {
        waitForElementClickable(driver, OrderPageUI.GO_TO_CART_BUTTON);
        clickToElement(driver, OrderPageUI.GO_TO_CART_BUTTON);
        return PageGeneratorManager.getOrderPage(driver);
    }

    public void clickToRemoveCart() {
        waitForElementClickable(driver, OrderPageUI.REMOVE_CART);
        clickToElement(driver, OrderPageUI.REMOVE_CART);
    }

    public boolean isEmptyCartMessage(String message) {
        waitForElementVisible(driver, OrderPageUI.CART_EMPTY_MESSAGE);
        return isElementDisplayed(driver, OrderPageUI.CART_EMPTY_MESSAGE,message);
    }

    public SortDisplayPaingPageObject dropdowndesktops(String submenuitem) {
        waitForElementClickable(driver, HomePageUI.MENU_COMPUTER_LINK);
        hoverMouseElement(driver, HomePageUI.MENU_COMPUTER_LINK);

        waitForElementClickable(driver, HomePageUI.MENU_DESKTOPS_LINK);
        clickToElement(driver, HomePageUI.MENU_DESKTOPS_LINK,submenuitem);
        return PageGeneratorManager.getSortDisplayPaingPage(driver);
    }


    public void enterToQtyTextbox(String number) {
        waitForElementVisible(driver, OrderPageUI.QTY_CART);
        sendkeyToElement(driver,OrderPageUI.QTY_CART, number);
    }

    public void clickToUpdateShoppingCart() {
        waitForElementClickable(driver, OrderPageUI.UPDATE_CART);
        clickToElement(driver, OrderPageUI.UPDATE_CART);
    }

    public boolean isTotalDisplay(String total) {
        waitForElementVisible(driver, OrderPageUI.TOTAL_CART);
        return isElementDisplayed(driver, OrderPageUI.TOTAL_CART, total);
    }


    public void clickToEstimateShippinCartButton() {
        waitForElementClickable(driver, OrderPageUI.ESTIMATE_SHIPPING);
        clickToElement(driver, OrderPageUI.ESTIMATE_SHIPPING);
    }

    public void selectCountryDropdown(String viet_nam) {
        waitForElementClickable(driver, OrderPageUI.SELECT_COUNTRY);
        selectItemDefaultDropdown(driver, OrderPageUI.SELECT_COUNTRY ,viet_nam);
    }

    public void inputZipPostalCodeTextbox(String zipPostalCode) {
        waitForElementVisible(driver, OrderPageUI.ZIP_POSTAL_CODE);
        sendkeyToElement(driver,OrderPageUI.ZIP_POSTAL_CODE,zipPostalCode);
    }

    public void clickToApply() {
        waitForElementClickable(driver, OrderPageUI.APPLY_BUTTON);
        clickToElement(driver, OrderPageUI.APPLY_BUTTON);
    }

    public boolean isGiftWrappingMessage(String message) {
        waitForElementVisible(driver, OrderPageUI.GIFT_WRAPPING_NO);
        return isElementDisplayed(driver, OrderPageUI.GIFT_WRAPPING_NO, message);
    }

    public void checkboxToCheckAgree() {
        waitForElementClickable(driver, OrderPageUI.AGREE_CART);
        checkToDefaultCheckboxOrRadio(driver, OrderPageUI.AGREE_CART);
    }

    public void clickToCheckOut() {
        waitForElementClickable(driver, OrderPageUI.CHECK_OUT_CART);
        clickToElement(driver, OrderPageUI.CHECK_OUT_CART);
    }

    public void inputToFirstnameTextbox(String firstName) {
        waitForElementVisible(driver, OrderPageUI.INPUT_FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver,OrderPageUI.INPUT_FIRST_NAME_TEXTBOX,firstName);
    }

    public void inputToLastnameTextbox(String lastName) {
        waitForElementVisible(driver, OrderPageUI.INPUT_LAST_NAME_TEXTBOX);
        sendkeyToElement(driver,OrderPageUI.INPUT_LAST_NAME_TEXTBOX,lastName);
    }

    public void inputToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, OrderPageUI.INPUT_ADDRESS_EMAIL_TEXTBOX);
        sendkeyToElement(driver,OrderPageUI.INPUT_ADDRESS_EMAIL_TEXTBOX,emailAddress);
    }

    public void selectCountryDropdownCheckOut(String viet_nam) {
        waitForElementClickable(driver, OrderPageUI.INPUT_ADDRESS_COUNTRY_TEXTBOX);
        selectItemDefaultDropdown(driver, OrderPageUI.INPUT_ADDRESS_COUNTRY_TEXTBOX ,viet_nam);
    }

    public void inputToCityTextbox(String city) {
        waitForElementVisible(driver, OrderPageUI.INPUT_CITY_TEXTBOX);
        sendkeyToElement(driver,OrderPageUI.INPUT_CITY_TEXTBOX,city);
    }

    public void inputToAddress1Textbox(String address1) {
        waitForElementVisible(driver, OrderPageUI.INPUT_ADDRESS1_TEXTBOX);
        sendkeyToElement(driver,OrderPageUI.INPUT_ADDRESS1_TEXTBOX,address1);
    }

    public void inputZipPostalCodeCheckOut(String zipPostalCode) {
        waitForElementVisible(driver, OrderPageUI.INPUT_ZIPPOSTAL_CODE_TEXTBOX);
        sendkeyToElement(driver,OrderPageUI.INPUT_ZIPPOSTAL_CODE_TEXTBOX,zipPostalCode);
    }

    public void inputPhoneNUmberCheckOut(String phoneNumber) {
        waitForElementVisible(driver, OrderPageUI.INPUT_PHONE_NUMBER_TEXTBOX);
        sendkeyToElement(driver,OrderPageUI.INPUT_PHONE_NUMBER_TEXTBOX,phoneNumber);
    }

    public void clickToContinueButton() {
        waitForElementClickable(driver, OrderPageUI.CONTINUE_BUTTON);
        clickToElement(driver, OrderPageUI.CONTINUE_BUTTON);
    }

    public void clickToRadioGroup(String shipping) {
        waitForElementClickable(driver, OrderPageUI.SHOPPING_METHOD_RADIO,shipping);
        checkToDefaultCheckboxOrRadio(driver, OrderPageUI.SHOPPING_METHOD_RADIO,shipping);
    }

    public void clickToContinueCheckoutButton() {
        waitForElementClickable(driver, OrderPageUI.CONTINUE_2_BUTTON);
        clickToElement(driver, OrderPageUI.CONTINUE_2_BUTTON);
    }

    public void clickToRadioPayCart(String card) {
        waitForElementClickable(driver, OrderPageUI.CHECK_CART,card);
        checkToDefaultCheckboxOrRadio(driver, OrderPageUI.CHECK_CART,card);
    }

    public void clickToContinuePayCartButton() {
        waitForElementClickable(driver, OrderPageUI.CONTINUE_3_BUTTON);
        clickToElement(driver, OrderPageUI.CONTINUE_3_BUTTON);
    }

    public boolean isNopSolutionMessage(String nop_solutions) {
        waitForElementVisible(driver, OrderPageUI.NOP_SOLUTION);
        return isElementDisplayed(driver, OrderPageUI.NOP_SOLUTION, nop_solutions);
    }

    public void clickToContinueNoticeButton() {
        waitForElementClickable(driver, OrderPageUI.CONTINUE_4_BUTTON);
        clickToElement(driver, OrderPageUI.CONTINUE_4_BUTTON);
    }

    public boolean isEmailDisplay(String emailAddress) {
        waitForElementVisible(driver, OrderPageUI.EMAIL_ADDRESS);
        return isElementDisplayed(driver, OrderPageUI.EMAIL_ADDRESS, emailAddress);
    }

    public boolean isPhoneDisplay(String phoneNumber) {
        waitForElementVisible(driver, OrderPageUI.PHONE);
        return isElementDisplayed(driver, OrderPageUI.PHONE, phoneNumber);
    }

    public boolean isPaymentMethodDisplay(String payment) {
        waitForElementVisible(driver, OrderPageUI.PAY_MENT_METHOD);
        return isElementDisplayed(driver, OrderPageUI.PAY_MENT_METHOD, payment);
    }

    public boolean isShippingMethodDisplay(String shipping_method) {
        waitForElementVisible(driver, OrderPageUI.SHIPPING_METHOD);
        return isElementDisplayed(driver, OrderPageUI.SHIPPING_METHOD, shipping_method);
    }

    public boolean isSkuDisplay(String le_ic_600) {
        waitForElementVisible(driver, OrderPageUI.SKU);
        return isElementDisplayed(driver, OrderPageUI.SKU, le_ic_600);
    }


    public boolean isNameProductsDisplay(String nameProduct) {
        waitForElementVisible(driver, OrderPageUI.NAME_PRODUCT);
        return isElementDisplayed(driver, OrderPageUI.NAME_PRODUCT, nameProduct);
    }

    public boolean isPriceProductsDisplay(String priceProduct) {
        waitForElementVisible(driver, OrderPageUI.PRICE);
        return isElementDisplayed(driver, OrderPageUI.PRICE, priceProduct);
    }

    public boolean isQtyProductsDisplay(String qtyProduct) {
        waitForElementVisible(driver, OrderPageUI.QTY);
        return isElementDisplayed(driver, OrderPageUI.QTY, qtyProduct);
    }

    public boolean isTotalProductsDisplay(String totalProduct) {
        waitForElementVisible(driver, OrderPageUI.TOTAL);
        return isElementDisplayed(driver, OrderPageUI.TOTAL, totalProduct);
    }

    public boolean isGiftWrappingDisplay(String giftWraping) {
        waitForElementVisible(driver, OrderPageUI.GIFT_WRAPPING);
        return isElementDisplayed(driver, OrderPageUI.GIFT_WRAPPING, giftWraping);
    }

    public boolean isTotalShippingDisplay(String shipping, String total) {
        waitForElementVisible(driver, OrderPageUI.PAY_SHIPPING,shipping,total);
        return isElementDisplayed(driver, OrderPageUI.PAY_SHIPPING,shipping,total);
    }

    public void clickToConfirmButton() {
        waitForElementClickable(driver, OrderPageUI.CONFIRM);
        clickToElement(driver, OrderPageUI.CONFIRM);
    }

    public boolean isthankyouMessageDisplay(String thank_you) {
        waitForElementVisible(driver, OrderPageUI.THANK_YOU_MESSAGE);
        return isElementDisplayed(driver, OrderPageUI.THANK_YOU_MESSAGE, thank_you);
    }

    public boolean issuccessfullyMessageDisplay(String sucessmessage) {
        waitForElementVisible(driver, OrderPageUI.ORDER_SUCESSFULLY_MESSAGE);
        return isElementDisplayed(driver, OrderPageUI.ORDER_SUCESSFULLY_MESSAGE, sucessmessage);
    }


    public MyAccountPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getMyAccountPage(driver);
    }
}
