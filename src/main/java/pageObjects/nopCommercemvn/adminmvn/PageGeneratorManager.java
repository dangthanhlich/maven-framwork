package pageObjects.nopCommercemvn.adminmvn;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommercemvn.usermvn.*;

public class PageGeneratorManager {

    public static AdminPageObject getAdminPage(WebDriver driver) {
        return new AdminPageObject(driver);
    }
    public static ProductsPageObject getProductsPage(WebDriver driver) {
        return new ProductsPageObject(driver);
    }

    public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
        return new ProductDetailPageObject(driver);
    }

    public static CustomerPageObject getCustomerPage(WebDriver driver) {
        return new CustomerPageObject(driver);
    }

}
