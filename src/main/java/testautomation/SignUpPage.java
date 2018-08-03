package testautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class SignUpPage extends TestBase {
	    protected WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    ///////// Elements////////////////
	@FindBy(xpath = "//*[@id=\"signUpDialogcontentWrapper\"]")
	private WebElement signup_frame;

	@FindBy(xpath = "//*[@id=\"signUpDialogoklink\"]")
	private WebElement go_button;

	@FindBy(xpath = "//*[@id=\"signUpDialogemailInputinput\"]")
	private WebElement email_field;

	@FindBy(xpath = "//*[@id=\"signUpDialogpasswordInputinput\"]")
	private WebElement password_field;

	@FindBy(xpath = "//*[@id=\"signUpDialogretypePasswordInputinput\"]")
	private WebElement retype_password;

	@FindBy(xpath = "//*[@id=\"signUpDialogxButton\"]")
	private WebElement x_button;

	////////////// Actions ///////////
	public SignUpPage clickGo() {
		click(go_button);
		return this;
	}

	public SignUpPage driverSwitchlsign() {
		driver_Switch(signup_frame);
		return this;
	}

	public SignUpPage clickForgotPass() {
		click(retype_password);
		return this;
	}

	public SignUpPage click_Xbutton() {
		click(x_button);
		return this;
	}

	public SignUpPage sendEmail(String value) {
		sendKeys(email_field, value);
		status(INFO, "Email Value:" + value);
		return this;
	}

	public SignUpPage sendPassword(String value) {
		sendKeys(password_field, value);
		status(INFO, "Password Value:" + value);
		return this;
	}

	public SignUpPage sendRetypePass(String value) {
		sendKeys(retype_password, value);
		status(INFO, "Retype Password Value:" + value);
		return this;
	}
}
