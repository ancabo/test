package testautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookOnline  extends TestBase {
		protected WebDriver driver;
		
		public  BookOnline( WebDriver driver ) {
			this.driver= driver;
			PageFactory.initElements(driver, this); 	
}
		
///////// Elements////////////////
		
	@FindBy(xpath="/html/body/main/div/bks-app/div/bks-user-login/div/div/a")
	private WebElement login_button; 
		
	
	@FindBy(id="TPASection_jj67gdexiframe")
	private WebElement book_frame;
	
	@FindBy(xpath="/html/body/main/div/bks-app/div/div[1]/bks-offering-list-page/div/div[2]/div/div/div")
	private WebElement book_title; 
	
	
//////////////Actions ///////////
	public BookOnline clickLogIn() {
		click(login_button);
		return this;
		}
	
	public BookOnline driverSwitchb() {
		driver_Switch(book_frame);
		return this;
	}
	public String getMessageTitle() {
		 String text= book_title.getText();
			return text;
	}
	
	
	

		
		
		
		
		
		
		
		
}



