package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.HomePageUI;
import pageUIs.nopCommercemvn.user.LoginPageUI;
import pageUIs.nopCommercemvn.user.MyAccountPageUI;
import pageUIs.nopCommercemvn.user.RegisterPageUI;
import pageUIs.wordpress.AdminPostAddNewPgeUI;

public class USerLoginPageObject extends BasePage {
    private WebDriver driver;

    public USerLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

//    public void clickToLoginButton() {
//        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
//        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
//    }

    public boolean isErrorMessageDisplayed(String message) {
        waitForElementVisible(driver, LoginPageUI.INPUTERRORMESSAE, message);
        return isElementDisplayed(driver, LoginPageUI.INPUTERRORMESSAE, message);
    }

    public void inputToEmailTextbox(String EmailAddress) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX,EmailAddress);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public boolean isErrorMessageNoAccountFoundDisplayed(String message1, String message2) {
        waitForElementVisible(driver, LoginPageUI.INCORRECT_MESSAGE,message1,message2);
        return isElementDisplayed(driver, LoginPageUI.INCORRECT_MESSAGE,message1,message2);
    }

    public USerHomePageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return  PageGeneratorManager.getUserHomePage(driver);
    }
}
