package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;

	@FindBy(id = "LastName")
	private WebElement LastNameTextbox;

	@FindBy(id = "Email")
	private WebElement EmailTextbox;

	@FindBy(id = "Password")
	private WebElement PasswordTextbox;

	@FindBy(id = "ConfirmPassword")
	private WebElement ConfirmPasswordTextbox;

	@FindBy(id = "register-button")
	private WebElement RegisterButton;

	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement FirstNameErrorMessage;

	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement LastNameErrorMessage;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement EmailErrorMessage;

	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement PasswordErrorMessage;

	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement ConfirmPasswordErrorMessage;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//div[contains(@class,'message-error')]//li")
	private WebElement existingEmailErrorMessage;

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterButton);
		clickToElement(driver, RegisterButton);

	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, FirstNameErrorMessage);
		return getElementText(driver, FirstNameErrorMessage);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, LastNameErrorMessage);
		return getElementText(driver, LastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, EmailErrorMessage);
		return getElementText(driver, EmailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, PasswordErrorMessage);
		return getElementText(driver, PasswordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, ConfirmPasswordErrorMessage);
		return getElementText(driver, ConfirmPasswordErrorMessage);
	}

	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, LastNameTextbox);
		sendkeyToElement(driver, LastNameTextbox, lastName);
	}

	// public void loginToSystem(String username, String password) {
	// inputToFirstnameTextbox(username);
	// inputToLastNameTextbox(password);
	// clickToRegisterButton();
	// }

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, EmailTextbox);
		sendkeyToElement(driver, EmailTextbox, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, PasswordTextbox);
		sendkeyToElement(driver, PasswordTextbox, password);

	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, ConfirmPasswordTextbox);
		sendkeyToElement(driver, ConfirmPasswordTextbox, confirmPassword);

	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}

}
