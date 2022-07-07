package pageUIs.nopCommercemvn.user;

public class RegisterPageUI {
    public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@id='FirstName']";
    public static final String LAST_NAME_TEXTBOX = "xpath=//input[@id='LastName']";
    public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";

    public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
    public static final String CONFIRM_PASSWORD_TEXTBOX="xpath=//input[@id='ConfirmPassword']";
    public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";

    public static final String EMAIL_ERROR_MESSAGE_EXISTS = "xpath=//div[@class='message-error validation-summary-errors']//ul//li[text()='%s']";
    public static final String INPUT_ERROR_MESSAGE = "xpath=//span[@class='field-validation-error']//span[text()='%s']";
    public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//div[@class='result' and text()='%s']";
    public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
    public static final String PASSWORD_RULES_ERROR_MESSAGE = "xpath=//span[@id='Password-error']//p[contains(text(),'%s')]//parent::span//ul/li[contains(text(),'%s')]";

}
