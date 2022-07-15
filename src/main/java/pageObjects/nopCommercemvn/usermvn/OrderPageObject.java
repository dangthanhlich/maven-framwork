package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
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
}
