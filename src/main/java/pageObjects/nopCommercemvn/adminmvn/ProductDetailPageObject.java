package pageObjects.nopCommercemvn.adminmvn;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommercemvn.admin.AdminPageUI;

public class ProductDetailPageObject extends BasePage {
    private WebDriver driver;

    public ProductDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
