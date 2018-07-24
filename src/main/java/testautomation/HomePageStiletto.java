package testautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageStiletto extends TestBase {
	protected WebDriver driver;
	
	public  HomePageStiletto( WebDriver driver ) {
		this.driver= driver;
		PageFactory.initElements(driver, this); 	
		
	}
	///////// Elements////////////////
	
	@FindBy(xpath="//*[@id='field1']")
	private WebElement name; 
	
	@FindBy(xpath="//*[@id='field2']")
	private WebElement email; 
	
	@FindBy(xpath="//*[@id='field3']")
	private WebElement subject; 
	
	@FindBy(xpath="//*[@id='field4']")
	private WebElement phone; 
	
	@FindBy(xpath="//*[@id='field5']")
	private WebElement address; 
	
	@FindBy(xpath="//*[@id='comp-jj67gh16fieldMessage']")
	private WebElement message; 
	
	@FindBy(xpath="//*[@id='comp-jj67gh16submit']")
	private WebElement send; 
	
	@FindBy(id="comp-jj67gh0riframe")
	private WebElement pantof_frame;
	
	@FindBy(xpath="/html/body/mini-gallery/div/section/slick/div/div/div[5]/product-item/a/div[1]/div/product-image/img")
	private WebElement pantofi; 
	
	@FindBy(xpath="comp-jj67gh0riframe")
	private WebElement frame_meniu; 
	
	@FindBy(xpath="comp-jj67gh0riframe")
	private WebElement size; 
	
	@FindBy(xpath="//*[@id='comp-jj67gh16notifications']")
	private WebElement checkmessage; 
	
	
	
	//////////////  Actions ///////////
	public HomePageStiletto sendName( String value) {
		sendKeys(name, value);
		return this;
	}
	
	public WebElement getCheckMessage() {
		return this.checkmessage;
	}
	
	public HomePageStiletto  sendEmail( String value) {
		sendKeys(email, value);
		status(INFO, "Email Value:" + value);
		return this;
	}
	public HomePageStiletto sendSubject( String value) {
		sendKeys(subject, value);
		status(INFO, "Subject Value:" + value);
		return this;
	}
	public HomePageStiletto sendMessage( String value) {
		sendKeys(message, value);
		status(INFO, "Message Value:" + value);
		return this;
	}
	public HomePageStiletto sendAddress( String value) {
		sendKeys(address, value);
		status(INFO, "Adress Value:" + value);
		return this;
	}
	public HomePageStiletto sendPhone( String value) {
		sendKeys(phone,value);
		status(INFO, "Phone Number:" + value);
		return this;
	}
	public HomePageStiletto clickSend() {
	  click(send);
	  return this;
	}
	public HomePageStiletto driverSwitch() {
		driver_Switch(pantof_frame);
		return this;
	}
	public DetailsStiletto clickPantofi() {
	click(pantofi);
	return new DetailsStiletto(driver);
	}
	public String getTextcheck() {
	 String text=  checkmessage.getText();
		return text;
		}
}



