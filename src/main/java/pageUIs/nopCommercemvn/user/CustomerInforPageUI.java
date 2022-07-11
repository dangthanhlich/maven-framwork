package pageUIs.nopCommercemvn.user;

public class CustomerInforPageUI {
    //div[@class='gender']//span[@class='female']
    public static final String RADIO_GENDER ="xpath=//div[@class='gender']//span[@class='%s']";
    //div[@class='inputs']//input[@id='LastName']
    public static final String INPUT_FIRST_NAME_TEXTBOX="xpath=//div[@class='inputs']//input[@id='FirstName']";
    public static final String INPUT_LAST_NAME_TEXTBOX="xpath=//div[@class='inputs']//input[@id='LastName']";
    public static final String INPUT_EMAIL_TEXTBOX="xpath=//div[@class='inputs']//input[@id='Email']";
    public static final String INPUT_COMPANY_TEXTBOX="xpath=//div[@class='inputs']//input[@id='Company']";

    //select[@name='DateOfBirthDay']
    public static final String ACTION_DROPDOWN_DAY ="xpath=//select[@name='DateOfBirthDay']";
    public static final String ACTION_DROPDOWN_MONTH ="xpath=//select[@name='DateOfBirthMonth']";
    public static final String ACTION_DROPDOWN_YEAR ="xpath=//select[@name='DateOfBirthYear']";
    public static final String SAVE_BUTTON="css=button#save-info-button";
}
