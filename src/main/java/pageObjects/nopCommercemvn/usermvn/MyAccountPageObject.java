package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.MyAccountPageUI;
import pageUIs.nopCommercemvn.user.MyProductReviewsPageUI;

public class MyAccountPageObject extends BasePage {
    private WebDriver driver;

    public MyAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public CustomerInforPageObject openListAccountPage(String customer_info) {
        waitForElementClickable(driver, MyAccountPageUI.ITEM_MENU_LIST,customer_info);
        clickToElement(driver, MyAccountPageUI.ITEM_MENU_LIST,customer_info);
        return PageGeneratorManager.getCustomerInforPage(driver);
    }

    public MyProductReviewsPageObject clickTMyProductReviewsLink(String my_product_reviews) {
        waitForElementClickable(driver, MyAccountPageUI.ITEM_MENU_LIST,my_product_reviews);
        clickToElement(driver, MyAccountPageUI.ITEM_MENU_LIST,my_product_reviews);
        return PageGeneratorManager.getMyProductReviewsPage(driver);
    }


    public OrderPageObject clickTMyProductLink(String orders) {
        waitForElementClickable(driver, MyAccountPageUI.ITEM_MENU_LIST,orders);
        clickToElement(driver, MyAccountPageUI.ITEM_MENU_LIST,orders);
        return PageGeneratorManager.getOrderPage(driver);
    }
}
