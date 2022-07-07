package pageObjects.nopCommercemvn.usermvn;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
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
}
