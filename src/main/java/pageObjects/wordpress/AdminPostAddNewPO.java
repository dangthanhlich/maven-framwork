package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewPgeUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAddNewPostTitle(String postTitleValue) {
		waitForElementVisible(driver, AdminPostAddNewPgeUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPgeUI.TITLE_TEXTBOX, postTitleValue);
	}

	public void enterToAddNewPostBody(String postBodyValue) {
		waitForElementClickable(driver, AdminPostAddNewPgeUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPgeUI.BODY_BUTTON);

		waitForElementVisible(driver, AdminPostAddNewPgeUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPgeUI.BODY_TEXTBOX, postBodyValue);
	}

	public void enterToEditPostBody(String postBodyValue) {
		waitForElementClickable(driver, AdminPostAddNewPgeUI.BODY_TEXTBOX);
		clickToElement(driver, AdminPostAddNewPgeUI.BODY_TEXTBOX);

		waitForElementVisible(driver, AdminPostAddNewPgeUI.BODY_TEXTBOX);
		clearValueInElementByPressKey(driver, AdminPostAddNewPgeUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPgeUI.BODY_TEXTBOX, postBodyValue);
	}

	public void clickToPublishOrUpdatehButton() {
		waitForElementClickable(driver, AdminPostAddNewPgeUI.PUBLISH_OR_UDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPgeUI.PUBLISH_OR_UDATE_BUTTON);
	}

	public void clickToPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPgeUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPgeUI.PRE_PUBLISH_BUTTON);
	}

	public boolean isPostPublishMessageDisplayed(String postPublishMessage) {
		waitForElementVisible(driver, AdminPostAddNewPgeUI.PUBLISHED_OR_UPDATE_MESSAGE, postPublishMessage);
		return isElementDisplayed(driver, AdminPostAddNewPgeUI.PUBLISHED_OR_UPDATE_MESSAGE, postPublishMessage);
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);

		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}

}
