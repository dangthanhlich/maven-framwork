package pageObjects.nopCommercemvn.usermvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.user.MyProductReviewsPageUI;

public class MyProductReviewsPageObject extends BasePage {
    private WebDriver driver;

    public MyProductReviewsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isGenderDisplayed(String productname) {
        waitForElementVisible(driver, MyProductReviewsPageUI.PRODUCT_REVIEW, productname);
        return isElementDisplayed(driver, MyProductReviewsPageUI.PRODUCT_REVIEW, productname);
    }
}
