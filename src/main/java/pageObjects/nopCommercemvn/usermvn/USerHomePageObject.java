package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.HomePageUI;
import pageUIs.nopCommercemvn.user.SearchPageUI;

public class USerHomePageObject  extends BasePage {
    private WebDriver driver;

    public USerHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public USerRegisterPageObject openRegisterPage() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getUserRegisterPage(driver);
    }

    public USerLoginPageObject openLoginPage() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getUserLogiPage(driver);
    }


    public ProductBooksPageObject openAddressAddNewPage(String menulinkproduct) {
        waitForElementClickable(driver, HomePageUI.MENU_LINK,menulinkproduct);
        clickToElement(driver, HomePageUI.MENU_LINK,menulinkproduct);
        return PageGeneratorManager.getProductBooksPage(driver);
    }

    public MyAccountPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getMyAccountPage(driver);
    }

    public SortDisplayPaingPageObject dropdownNotebooks(String submenuitem) {
        waitForElementClickable(driver, HomePageUI.MENU_COMPUTER_LINK);
        hoverMouseElement(driver, HomePageUI.MENU_COMPUTER_LINK);

        waitForElementClickable(driver, HomePageUI.MENU_NOTEBOOK_LINK);
        clickToElement(driver, HomePageUI.MENU_NOTEBOOK_LINK,submenuitem);
        return PageGeneratorManager.getSortDisplayPaingPage(driver);
    }


    public SortDisplayPaingPageObject dropdowndesktops(String submenuitem) {
        waitForElementClickable(driver, HomePageUI.MENU_COMPUTER_LINK);
        hoverMouseElement(driver, HomePageUI.MENU_COMPUTER_LINK);

        waitForElementClickable(driver, HomePageUI.MENU_DESKTOPS_LINK);
        clickToElement(driver, HomePageUI.MENU_DESKTOPS_LINK,submenuitem);
        return PageGeneratorManager.getSortDisplayPaingPage(driver);
    }




}
