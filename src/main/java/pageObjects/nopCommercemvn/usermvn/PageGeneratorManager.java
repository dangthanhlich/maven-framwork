package pageObjects.nopCommercemvn.usermvn;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static USerHomePageObject getUserHomePage(WebDriver driver) {
        return new USerHomePageObject(driver);
    }

    public static USerRegisterPageObject getUserRegisterPage(WebDriver driver) {
        return new USerRegisterPageObject(driver);
    }

    public static USerLoginPageObject getUserLogiPage(WebDriver driver) {
        return new USerLoginPageObject(driver);
    }

}
