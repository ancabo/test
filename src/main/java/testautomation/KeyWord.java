package testautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class KeyWord extends TestBase{
protected WebDriver driver;

 HomePageStiletto homePageStiletto = new HomePageStiletto(driver);
 DetailsStiletto  detailsStiletto = new DetailsStiletto(driver);
 Cart cart = new Cart(driver);
 CheckKey check = new CheckKey(driver);
 LoginPage loginpage = new LoginPage(driver);
 SignUpPage signup = new SignUpPage(driver);
 BookOnline bookOnline = new BookOnline(driver);
 Hashmap map = new Hashmap();
	public  KeyWord( WebDriver driver ) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		homePageStiletto = new HomePageStiletto(driver);
		cart = new Cart(driver);
		detailsStiletto = new DetailsStiletto(driver);
		check= new CheckKey(driver);
		loginpage= new LoginPage(driver);
		signup = new SignUpPage(driver);
		bookOnline = new BookOnline(driver);
		}
	
	public void fillContact() throws InterruptedException {
		gotoUrl("https://ancabota09.wixsite.com/internship");
		maximize();
		map.add_details();
		homePageStiletto.sendName(map.hmap.get("Name"))
			            .sendEmail(map.hmap.get("Email"))
			            .sendPhone(map.hmap.get("PhoneNumber"))
			            .sendAddress(map.hmap.get("Address"))
			            .sendSubject(map.hmap.get("Subject"))
			            .sendMessage(map.hmap.get("Message"));
	    }
	
	public void addProduct() throws InterruptedException {
		gotoUrl("https://ancabota09.wixsite.com/internship/product-page/i-m-a-product-1");
		maximize();
	  detailsStiletto.driverrSwitch()
	                .clickSize()
	                .clickSelectSize()
	                .clickColour()
	                .clickSelectColour()
	                .clickQuantity()
	                .clear_Quantity()
	                .sendQuantity();
	  sleep();
	  detailsStiletto.clickAdd();
	  default_content();
      sleep();
	  detailsStiletto.driverrrSwitch()
	                   .wait_frame()
	                // .wait_viewcart()
	                 .clickViewCart();
	  default_content();	
	  sleep();
	}
	
	public void remove() throws InterruptedException {
		cart.driverSwitchCart()
	        .waitt()
	       // .wait_remove()
	        .clickRemove();
	 default_content();	
	}

	public void login_Filldata() throws InterruptedException {
		sleep();
		loginpage.sendEmail("roxanaioana2597@gmail.com")
                 .sendPassword("siemens2018")
                 .clickLogIn();
	}
	
	public void signup_Filldata() throws InterruptedException {
		sleep();
		signup .sendEmail("roxydodeaaa597@yahoo.com")
		  .sendPassword("siemens2018")
		  .sendRetypePass("siemens2018")
		  .clickGo();
		   sleep();
	}	
	
	public void addNote() throws InterruptedException {
		  detailsStiletto.driverrSwitch()
		                .clickSize()
		                .clickSelectSize()
		                .clickColour()
		                .clickSelectColour()
		                .clickQuantity()
		                .clear_Quantity()
		                .sendQuantity();
			            sleep();
	     detailsStiletto.clickAdd();
			            default_content();
		                sleep();
	      detailsStiletto.driverrrSwitch()
			            .wait_frame()
			            .clickViewCart();	
				         sleep();
			        cart.driverrSwitchCart();	
		} 
	
	public void payPal() throws InterruptedException {
		//gotoUrl("https://ancabota09.wixsite.com/internship/product-page/i-m-a-product-1");
		//maximize();
	  detailsStiletto.driverrSwitch()
	                .clickSize()
	                .clickSelectSize()
	                .clickColour()
	                .clickSelectColour()
	                .clickQuantity()
	                .clear_Quantity()
	                .sendQuantity();
	  				sleep();
	  detailsStiletto.clickAdd();
	  				default_content();
	  				sleep();
	  detailsStiletto.driverrrSwitch()
	                .wait_frame()
	                .clickViewCart();
	  				default_content();	
	  				sleep();
	  				//cart.clickPayPal();
	  				default_content();	
	}
	
	public void go_Url() {
		gotoUrl("https://ancabota09.wixsite.com/internship");
		maximize();
	}	
	
	  public void fillcontact(String name, String email, String phone) {
			homePageStiletto.sendName(name)
				.sendEmail(email)
				.sendPhone(phone);
	 }
}

