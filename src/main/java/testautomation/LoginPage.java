package testautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
	protected WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

///////// Elements////////////////
	@FindBy(xpath = "//*[@id=\"memberLoginDialogtitle\"]")
	private WebElement login_title;

	@FindBy(xpath = "//*[@id=\"memberLoginDialogcontentWrapper\"]")
	private WebElement login_frame;

	@FindBy(id = "memberLoginDialogoklabel")
	private WebElement login;

	@FindBy(id = "memberLoginDialogswitchDialogLink")
	private WebElement signup;

	@FindBy(xpath = "//input [@id='memberLoginDialogemailInputinput']")
	private WebElement email_field;

	@FindBy(xpath = "//*[@id=\"memberLoginDialogpasswordInputinput\"]")
	private WebElement password_field;

	@FindBy(xpath = "//*[@id=\"memberLoginDialogforgotYourPasswordLink\"]")
	private WebElement forgot_password;

	@FindBy(xpath = "//*[@id=\"memberLoginDialogxButton\"")
	private WebElement x_button;

	@FindBy(xpath = "//*[@id=\"memberLoginDialogrememberMeCheckboxLabel\"]")
	private WebElement remember_button;

	@FindBy(xpath = "TPASection_jj67gdexiframe")
	private WebElement frame;

	@FindBy(xpath = "//*[@id=\"memberLoginDialogpasswordInputerrorMessage\"]")
	private WebElement error_message;

	@FindBy(xpath = "//*[@id=\"requestResetPasswordDialogtitle\"]")
	private WebElement reset;

	@FindBy(xpath = "	//*[@id=\"requestResetPasswordDialogemailInputinput\"]")
	private WebElement reset_email;

	@FindBy(xpath = "//*[@id=\"requestResetPasswordDialogoklink\"]")
	private WebElement reset_go;

	@FindBy(xpath = "//*[@id=\"notificationDialogdialogTitle\"]")
	private WebElement email_validation;

	@FindBy(xpath = "//*[@id=\"notificationDialogoklink\"]")
	private WebElement ok_button;

	////////////// Actions ///////////
	public LoginPage clickLogIn() {
		click(login);
		return this;
	}

	public LoginPage driverSwitchlog() {
		driver_Switch(login_frame);
		return this;
	}

	public LoginPage clickForgotPass() {
		click(forgot_password);
		return this;
	}

	public LoginPage click_Xbutton() {
		click(x_button);
		return this;
	}

	public LoginPage clickRemember() {
		click(remember_button);
		return this;
	}

	public LoginPage clickSignUp() {
		click(signup);
		return this;
	}

	public LoginPage switchFrame() {
		driver_Switch(frame);
		return this;
	}

	public LoginPage Wait() {
		waitt(signup);
		return this;
	}

	public LoginPage sendEmail(String value) {
		sendKeys(email_field, value);
		status(INFO, "Email Value:" + value);
		return this;
	}

	public LoginPage sendPassword(String value) {
		sendKeys(password_field, value);
		status(INFO, "Password Value:" + value);
		return this;
	}

	public LoginPage loginErorrMessage(String value) {
		sendKeys(password_field, value);
		status(INFO, "Password Value:" + value);
		return this;
	}

	public String getErrorMessage() {
		String text = error_message.getText();
		return text;
	}

	public String getResetTitle() {
		String text = reset.getText();
		return text;
	}

	public LoginPage sendEmailreset(String value) {
		sendKeys(reset_email, value);
		status(INFO, "Email Value:" + value);
		return this;
	}

	public LoginPage clickGobutton() {
		click(reset_go);
		return this;
	}

	public String getValidationMessage() {
		String text = email_validation.getText();
		return text;
	}

	public LoginPage clickOK_button() {
		click(ok_button);
		return this;
	}
}
