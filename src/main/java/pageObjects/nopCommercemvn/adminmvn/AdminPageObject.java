package pageObjects.nopCommercemvn.adminmvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommercemvn.adminmvn.PageGeneratorManager;
import pageUIs.nopCommercemvn.admin.AdminPageUI;

public class AdminPageObject extends BasePage {
    private WebDriver driver;

    public AdminPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, AdminPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver,AdminPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,AdminPageUI.PASSWORD_TEXTBOX,password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, AdminPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminPageUI.LOGIN_BUTTON);
    }

    public ProductsPageObject clickToDropdown(String products) {
        waitForElementClickable(driver, AdminPageUI.CLICK_TO_ICON_PRODUCT);
        clickToElement(driver, AdminPageUI.CLICK_TO_ICON_PRODUCT);
        waitForElementClickable(driver, AdminPageUI.CLICK_TO_PRODUCT,products);
        clickToElement(driver, AdminPageUI.CLICK_TO_PRODUCT,products);
        return PageGeneratorManager.getProductsPage(driver);
    }
}
