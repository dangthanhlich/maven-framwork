package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.MyAccountPageUI;

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

}
