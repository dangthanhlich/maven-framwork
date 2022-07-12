package pageObjects.nopCommercemvn.usermvn;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommercemvn.user.HomePageUI;
import pageUIs.nopCommercemvn.user.RegisterPageUI;

public class USerRegisterPageObject extends BasePage {
	private WebDriver driver;

	public USerRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isErrorMessageDisplayed(String message) {
		waitForElementVisible(driver, RegisterPageUI.INPUT_ERROR_MESSAGE, message);
		return isElementDisplayed(driver, RegisterPageUI.INPUT_ERROR_MESSAGE, message);
	}

	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.FIRST_NAME_TEXTBOX,firstName);
	}

	public void inputToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.LAST_NAME_TEXTBOX,lastName);
	}

	public void inputToEmailTextbox(String EmailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,EmailAddress);
	}

	public void inputToPasswordTextbox(String validPassword) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX,validPassword);
	}

	public void inputToConfirmPasswordTextbox(String validPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,validPassword);
	}

	public boolean isRegisterSuccessMessage(String message) {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE, message);
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE, message);
	}

	public USerHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public boolean isErrorMessageEmailExistsDisplayed(String message) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE_EXISTS, message);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE_EXISTS, message);
	}

	public boolean isErrorPasswordMessageDisplayed(String message1,String message2) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_RULES_ERROR_MESSAGE,message1,message2);
		return isElementDisplayed(driver, RegisterPageUI.PASSWORD_RULES_ERROR_MESSAGE,message1,message2);
	}

	public MyAccountPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

    public SearchPageObject clickToSearchLink() {
		waitForElementClickable(driver,HomePageUI.SEARCH_FOOTER_LINK);
		clickToElement(driver, HomePageUI.SEARCH_FOOTER_LINK);
		return PageGeneratorManager.getSearchPage(driver);
    }
}
