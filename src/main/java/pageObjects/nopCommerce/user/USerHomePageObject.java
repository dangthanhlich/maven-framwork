package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.HomePageUI;

public class USerHomePageObject extends BasePage {

	private WebDriver driver;

	public USerHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	// public RegisterPageObject clickToRegisterLink() {
		// waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		// clickToElement(driver, HomePageUI.REGISTER_LINK);
		// return PageGeneratorManager.getRegisterPage(driver);
		// }
		
		@Step("Navigate to Register page")
		public USerRegisterPageObject openRegisterPage() {
			waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
			clickToElement(driver, HomePageUI.REGISTER_LINK);
			return PageGeneratorManager.getUserRegisterPage(driver);
		}

		// public LoginPageObject clickToLoginLink() {
		// waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		// clickToElement(driver, HomePageUI.LOGIN_LINK);
		// return PageGeneratorManager.getLoginPage(driver);
		//
		// }
		
		@Step("Navigate to Login page")
		public USerLoginPageObject openLoginPage() {
			waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
			clickToElement(driver, HomePageUI.LOGIN_LINK);
			return PageGeneratorManager.getUserLoginPage(driver);

		}

		@Step("Verify 'My Account' link to displayed")
		public boolean isMyAccountLinkDisplayed() {
			waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
			return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
		}

		// public CustomerInforPageObject clickToMyAccountLink() {
		// waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		// clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		// return PageGeneratorManager.getMyAccountPage(driver);
		// }
		
		@Step("Navigate to My Account page")
		public USerCustomerInforPageObject openMyAccountPage() {
			waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
			clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
			return PageGeneratorManager.getUserMyAccountPage(driver);
		}
		
		

//	// public RegisterPageObject clickToRegisterLink() {
//	// waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
//	// clickToElement(driver, HomePageUI.REGISTER_LINK);
//	// return PageGeneratorManager.getRegisterPage(driver);
//	// }
//	public USerRegisterPageObject openRegisterPage() {
//		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
//		clickToElement(driver, HomePageUI.REGISTER_LINK);
//		return PageGeneratorManager.getUserRegisterPage(driver);
//	}
//
//	// public LoginPageObject clickToLoginLink() {
//	// waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
//	// clickToElement(driver, HomePageUI.LOGIN_LINK);
//	// return PageGeneratorManager.getLoginPage(driver);
//	//
//	// }
//	public USerLoginPageObject openLoginPage() {
//		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
//		clickToElement(driver, HomePageUI.LOGIN_LINK);
//		return PageGeneratorManager.getUserLoginPage(driver);
//
//	}
//
//	public boolean isMyAccountLinkDisplayed() {
//		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
//		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
//	}
//
//	// public CustomerInforPageObject clickToMyAccountLink() {
//	// waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
//	// clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
//	// return PageGeneratorManager.getMyAccountPage(driver);
//	// }
//	public USerCustomerInforPageObject openMyAccountPage() {
//		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
//		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
//		return PageGeneratorManager.getUserMyAccountPage(driver);
//	}

}
