package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

public class TCPageGeneratorManager {
    public static TCUSerHomePageObject getUserHomePage(WebDriver driver) {
        return new TCUSerHomePageObject(driver);
    }

    public static TCUSerRegisterPageObject getUserRegisterPage(WebDriver driver) {
        return new TCUSerRegisterPageObject(driver);
    }

    public static TCUSerLoginPageObject getUserLogiPage(WebDriver driver) {
        return new TCUSerLoginPageObject(driver);
    }

}
