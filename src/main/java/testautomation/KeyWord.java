package testautomation;

import java.util.concurrent.TimeUnit;

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
		status("PASS","START TEST");
		gotoUrl("https://ancabota09.wixsite.com/internship");
		maximize();
		homePageStiletto.sendName("Dodea Roxana")
			.sendEmail("roxanaioana2597@gmail.com")
			.sendPhone("0757352929")
			.sendAddress("Strada Principala nr 680B")
			.sendSubject("Pantofi")
			.sendMessage("Marimile corespund?")
		    .clickSend();
		  check.checkContact();
		  homePageStiletto.driverSwitch()
		                  .clickPantofi();
		default_content();
		
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
	
	public void createAccount() throws InterruptedException {
	   status("PASS","Start: Create account!");
	   gotoUrl("https://ancabota09.wixsite.com/internship");
	   maximize();
	   homePageStiletto.clickBookOnline();
       check.check_BookPage();
       sleep();
       // loginpage.switchFrame();
        //loginpage.Wait();
       loginpage.clickSignUp(); 
       sleep();
       signup .sendEmail("roxydodea597@yahoo.com")
  			  .sendPassword("siemens2018")
  			  .sendRetypePass("siemens2018")
  			  .clickGo();
  			   sleep();
       signup.click_Xbutton();
       default_content();
       status("PASS","The account has been successfully created!");
        
	}

	public void login_Account() throws InterruptedException {
		status("PASS","START TEST");
		gotoUrl("https://ancabota09.wixsite.com/internship");
		maximize();
		homePageStiletto.clickBookOnline();
        check.check_BookPage();
        sleep();
        loginpage.sendEmail("roxanaioana2597@gmail.com")
		        .sendPassword("siemens2018")
		        .clickLogIn();
        check.check_LoginMessage();
        loginpage.clickForgotPass();
        check.check_Reset();
        loginpage.clickGobutton();
        check.check_ConfirmPage();
        status("PASS","END OF TEST");
	}
	
	public void clickFacebook() throws InterruptedException {
		status("PASS","START TEST");
		gotoUrl("https://ancabota09.wixsite.com/internship/product-page/i-m-a-product-1");
		maximize();
detailsStiletto.driverrSwitch();
		sleep();
detailsStiletto.clickFacebook();
		sleep();
try {
     TimeUnit.SECONDS.sleep(10);
} catch (InterruptedException e) {
    //Handle exception
}
//detailsStiletto.driverSwitchToFacebook();
//detailsStiletto.clickLoginSiemens();
status("PASS","END OF TEST");
	} 
	
	public void addNote() throws InterruptedException {
		status("PASS","START TEST");
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
		            .clickViewCart();	
			         sleep();
		        cart.driverrSwitchCart();
			    cart.clickAddNote();
			        sleep();
			    cart.sendNote();
			         default_content();	
	} 

public void promoCode() throws InterruptedException {
		cart.driverSwitchCart()
            .waitt();
		cart.clickPromoCode();
		    sleep();
		cart.writePromo();
		    sleep();
		cart.clickApplyPromo();
		    default_content();	
	}
	
	public void payPal() throws InterruptedException {
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
	                .clickViewCart();
	  				default_content();	
	  				sleep();
	  				//cart.clickPayPal();
	  				default_content();	
	}
	
}

