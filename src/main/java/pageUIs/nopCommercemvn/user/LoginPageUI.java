package pageUIs.nopCommercemvn.user;

public class LoginPageUI {
    public static final String EMAIL_TEXTBOX ="xpath=//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX ="xpath=//input[@id='Password']";
    public static final String LOGIN_BUTTON = "class=login-button";
    public static final String INPUTERRORMESSAE = "xpath=//span[@class='field-validation-error']/span[text()='%s']";
    public static final String INCORRECT_MESSAGE = "xpath=//div[contains(text(),'%s')]//li[contains(text(),'%s')]";
}
