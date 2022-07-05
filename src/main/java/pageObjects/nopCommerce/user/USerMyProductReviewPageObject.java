package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInforPageUI;
import pageUIs.nopCommerce.user.MyProductPageUI;

public class USerMyProductReviewPageObject extends BasePage {
	private WebDriver driver;

	public USerMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	// public AddressPageObject openAddressPage() {
	// waitForElementClickable(driver, MyProductPageUI.ADDRESS_PAGE);
	// clickToElement(driver, MyProductPageUI.ADDRESS_PAGE);
	// return PageGeneratorManager.getAddressPage(driver);
	// }
}
