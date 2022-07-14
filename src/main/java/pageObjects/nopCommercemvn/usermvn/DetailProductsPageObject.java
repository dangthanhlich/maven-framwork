package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.HomePageUI;

public class DetailProductsPageObject extends BasePage {
    private WebDriver driver;

    public DetailProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public SortDisplayPaingPageObject dropdownNotebooks(String submenuitem) {
        waitForElementClickable(driver, HomePageUI.MENU_COMPUTER_LINK);
        hoverMouseElement(driver, HomePageUI.MENU_COMPUTER_LINK);

        waitForElementClickable(driver, HomePageUI.MENU_NOTEBOOK_LINK);
        clickToElement(driver, HomePageUI.MENU_NOTEBOOK_LINK,submenuitem);
        return PageGeneratorManager.getSortDisplayPaingPage(driver);
    }
}
