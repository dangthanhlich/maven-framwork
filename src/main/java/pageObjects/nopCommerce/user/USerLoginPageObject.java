package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.LoginPageUI;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class USerLoginPageObject extends BasePage {
	private WebDriver driver;
	private WebDriverWait expliciWait;

	public USerLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click login button")
	public USerHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	@Step("Enter to Email textbox with values is {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementClickable(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	@Step("Enter to password textbox with values is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementClickable(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
	}

	public USerHomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

	
	

//	public USerHomePageObject clickToLoginButton() {
//		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
//		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
//		return PageGeneratorManager.getUserHomePage(driver);
//
//	}
//
//	public void inputToEmailTextbox(String emailAddress) {
//		waitForElementClickable(driver, LoginPageUI.EMAIL_TEXTBOX);
//		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
//
//	}
//
//	public void inputToPasswordTextbox(String password) {
//		waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
//		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
//
//	}
//
//	public String getErrorMessageAtEmailTextbox() {
//		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
//		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
//	}
//
//	public String getErrorMessageUnsuccessfull() {
//		waitForElementClickable(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
//		return getElementText(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
//	}
//
//	public USerHomePageObject loginAsUser(String emailAddress, String password) {
//		inputToEmailTextbox(emailAddress);
//		inputToPasswordTextbox(password);
//		return clickToLoginButton();
//	}

}
