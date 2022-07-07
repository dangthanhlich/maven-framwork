package pageUIs.nopCommercemvn.user;

public class LoginPageUI {
    public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
    public static final String LOGIN_BUTTON = " class=login-button";

    //id= Email-error
    //Please enter your email
    public static final String EMAIL_ERROR_MESSAGE = " xpath=//span[@id='Email-error']";
    //wrong email
    public static final String INVALID_EMAIL = " xpath=//span[@id='Email-error']";
    ////div[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]//li[contains(text(),'No customer account found')]
    public static final String EMAIL_UNSUCCESSFUL_ACCOUNT_FOUND_MESSAGE = " xpath=//div[contains(text(),'%s')]//li[contains(text(),'%s')]";
    ////div[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]//li[contains(text(),'The credentials provided are incorrect')]
    public static final String EMAIL_UNSUCCESSFUL_CREDENTIALS_INCORRECT_MESSAGE = "xpath=//div[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]//li[contains(text(),'The credentials provided are incorrect')]";
}
