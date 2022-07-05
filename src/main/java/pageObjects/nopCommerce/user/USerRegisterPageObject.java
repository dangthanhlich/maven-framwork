package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class USerRegisterPageObject extends BasePage {
	private WebDriver driver;

	public USerRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to register button")
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_MESSAGE);
	}

	@Step("Enter to firstname textbox with value is {0}")
	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	@Step("Enter to lastName textbox with value is {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void loginToSystem(String username, String password) {
		inputToFirstnameTextbox(username);
		inputToLastNameTextbox(password);
		clickToRegisterButton();
	}

	@Step("Enter to emailAddress textbox with value is {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	@Step("Enter to password textbox with value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	@Step("Enter to confirmPassword textbox with value is {0}")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);

	}

	@Step("Verify register success message is displayed")
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public USerHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

	


	


//	public void clickToRegisterButton() {
//		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
//		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
//
//	}
//
//	public String getErrorMessageAtFirstnameTextbox() {
//		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
//		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
//	}
//
//	public String getErrorMessageAtLastNameTextbox() {
//		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
//		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
//	}
//
//	public String getErrorMessageAtEmailTextbox() {
//		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
//		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
//	}
//
//	public String getErrorMessageAtPasswordTextbox() {
//		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
//		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
//	}
//
//	public String getErrorMessageAtConfirmPasswordTextbox() {
//		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_MESSAGE);
//		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_MESSAGE);
//	}
//
//	
//	public void inputToFirstnameTextbox(String firstName) {
//		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
//		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
//	}
//
//	public void inputToLastNameTextbox(String lastName) {
//		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
//		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
//	}
//
//	public void loginToSystem(String username, String password) {
//		inputToFirstnameTextbox(username);
//		inputToLastNameTextbox(password);
//		clickToRegisterButton();
//	}
//
//	public void inputToEmailTextbox(String emailAddress) {
//		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
//		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
//	}
//
//	public void inputToPasswordTextbox(String password) {
//		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
//		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
//
//	}
//
//	public void inputToConfirmPasswordTextbox(String confirmPassword) {
//		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
//		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
//
//	}
//
//	public String getRegisterSuccessMessage() {
//		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
//		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
//	}
//
//	public USerHomePageObject clickToLogoutLink() {
//		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
//		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
//		return PageGeneratorManager.getUserHomePage(driver);
//	}
//
//	public String getErrorExistingEmailMessage() {
//		waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
//		return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
//	}

}
