package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.DetailProductsPageUI;
import pageUIs.nopCommercemvn.user.HomePageUI;
import pageUIs.nopCommercemvn.user.OrderPageUI;

public class OrderPageObject extends BasePage {
    private WebDriver driver;

    public OrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public DetailProductsPageObject clickGoToEditCart() {
        waitForElementClickable(driver, OrderPageUI.EDIT_CART);
        clickToElement(driver, OrderPageUI.EDIT_CART);
        return PageGeneratorManager.getDetailProductsPage(driver);
    }


    public void clickToDetailButton() {
        waitForElementClickable(driver, OrderPageUI.DETAIL_BUTTON);
        clickToElement(driver, OrderPageUI.DETAIL_BUTTON);
    }

    public boolean isOrderstatusDisplay(String pending) {
        waitForElementVisible(driver, OrderPageUI.ORDER_STATUS);
        return isElementDisplayed(driver, OrderPageUI.ORDER_STATUS, pending);
    }

    public boolean isOrderTotalMessageDisplay(String totalmessage) {
        waitForElementVisible(driver, OrderPageUI.ORDER_TOTAL);
        return isElementDisplayed(driver, OrderPageUI.ORDER_TOTAL, totalmessage);
    }

    public boolean isEmailDisplay(String emailaddress) {
        waitForElementVisible(driver, OrderPageUI.EMAIL);
        return isElementDisplayed(driver, OrderPageUI.EMAIL, emailaddress);
    }

    public boolean isPaymentMethodDisplay(String paymentMethod) {
        waitForElementVisible(driver, OrderPageUI.PAYMENT_METHOD);
        return isElementDisplayed(driver, OrderPageUI.PAYMENT_METHOD, paymentMethod);
    }

    public boolean isShippingMethodDisplay(String shipingmethod) {
        waitForElementVisible(driver, OrderPageUI.SHIPPING_METHOD_ORDER);
        return isElementDisplayed(driver, OrderPageUI.SHIPPING_METHOD_ORDER, shipingmethod);
    }

    public boolean isSkuDisplay(String sku) {
        waitForElementVisible(driver, OrderPageUI.SKU_ORDER);
        return isElementDisplayed(driver, OrderPageUI.SKU_ORDER, sku);
    }

    public boolean isNameProductsDisplay(String nameProduct) {
        waitForElementVisible(driver, OrderPageUI.NAME_ORDER);
        return isElementDisplayed(driver, OrderPageUI.NAME_ORDER, nameProduct);
    }

    public boolean isPriceProductsDisplay(String priceproduct) {
        waitForElementVisible(driver, OrderPageUI.PRICE_ORDER);
        return isElementDisplayed(driver, OrderPageUI.PRICE_ORDER, priceproduct);
    }

    public boolean isQtyProductsDisplay(String qty) {
        waitForElementVisible(driver, OrderPageUI.QUANTITY_ORDER);
        return isElementDisplayed(driver, OrderPageUI.QUANTITY_ORDER, qty);
    }

    public boolean isTotalProductsDisplay(String totalProduct) {
        waitForElementVisible(driver, OrderPageUI.TOTAL_ORDER);
        return isElementDisplayed(driver, OrderPageUI.TOTAL_ORDER, totalProduct);
    }

    public boolean isGiftWrappingDisplay(String giftWrapping) {
        waitForElementVisible(driver, OrderPageUI.GIFT_WRAPING_ORDER);
        return isElementDisplayed(driver, OrderPageUI.GIFT_WRAPING_ORDER, giftWrapping);
    }

    public boolean isTotalShippingDisplay(String shipping, String total) {
        waitForElementVisible(driver, OrderPageUI.PAY_SHIPPING,shipping,total);
        return isElementDisplayed(driver, OrderPageUI.PAY_SHIPPING,shipping,total);
    }
    public boolean isTotalShoppingCartDisplay(String shipping, String total) {
        waitForElementVisible(driver, OrderPageUI.SUB_TOTAL_ORDERL,shipping,total);
        return isElementDisplayed(driver, OrderPageUI.SUB_TOTAL_ORDERL,shipping,total);
    }

    public ShoppingCartPageObject clickShoppingCart() {
        waitForElementClickable(driver, HomePageUI.SHOPPING_CART_LINK);
        clickToElement(driver, HomePageUI.SHOPPING_CART_LINK);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }
}
