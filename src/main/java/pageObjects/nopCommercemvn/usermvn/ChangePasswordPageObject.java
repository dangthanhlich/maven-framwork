package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.AddressesPageUI;
import pageUIs.nopCommercemvn.user.ChangePasswordPageUI;
import pageUIs.nopCommercemvn.user.RegisterPageUI;

public class ChangePasswordPageObject extends BasePage {
    private WebDriver driver;

    public ChangePasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToPasswordTextbox(String validPassword) {
        waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, validPassword);
    }

    public void inputToNewPasswordTextbox(String validNewPassword) {
        waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, validNewPassword);
    }

    public void inputToConfirmNewPasswordTextbox(String validNewPassword) {
        waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, validNewPassword);
    }

    public void clickToChanePasswordButton() {
        waitForElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
    }

    public boolean isGenderDisplayed(String password_was_changed) {
        waitForElementVisible(driver, ChangePasswordPageUI.CHANGE_PASSWORD_SUCESS_MESSAGE, password_was_changed);
        return isElementDisplayed(driver, ChangePasswordPageUI.CHANGE_PASSWORD_SUCESS_MESSAGE, password_was_changed);
    }

    public void clickToClose() {
        waitForElementClickable(driver, ChangePasswordPageUI.CLOSE_SPAN);
        clickToElement(driver, ChangePasswordPageUI.CLOSE_SPAN);
    }

    public USerHomePageObject clickToLogoutLink() {
        waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getUserHomePage(driver);
    }
}