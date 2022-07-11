package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.*;

public class ProductBooksPageObject extends BasePage {
    private WebDriver driver;

    public ProductBooksPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToBookLink(String productname) {
        waitForElementClickable(driver, ProductBooksPageUI.PRODUCT_BOOKS,productname);
        clickToElement(driver, ProductBooksPageUI.PRODUCT_BOOKS,productname);
    }

    public void clickToAddReview() {
        waitForElementClickable(driver, ProductBooksPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, ProductBooksPageUI.ADD_YOUR_REVIEW_LINK);
    }

    public void inputToRivewTitleTextbox(String reviewTitle) {
        waitForElementVisible(driver, ProductBooksPageUI.ADD_PRODUCT_TITLE_TEXTBOX);
        sendkeyToElement(driver, ProductBooksPageUI.ADD_PRODUCT_TITLE_TEXTBOX, reviewTitle);
    }

    public void textareaToRivewTextTextbox(String reviewText) {
        waitForElementVisible(driver, ProductBooksPageUI.REVIEW_TEXT_TEXTBOX);
        sendkeyToElement(driver, ProductBooksPageUI.REVIEW_TEXT_TEXTBOX, reviewText);
    }

    public void rattingRadio(String rating) {
        waitForElementClickable(driver, ProductBooksPageUI.INPUT_RATING_RADIO, rating);
        checkToDefaultCheckboxOrRadio(driver, ProductBooksPageUI.INPUT_RATING_RADIO, rating);
    }

    public void clickToSubmitReviewButton() {
        waitForElementClickable(driver, ProductBooksPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, ProductBooksPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public MyAccountPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getMyAccountPage(driver);
    }
}
