package testautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class KeyWord extends TestBase{
protected WebDriver driver;

 HomePageStiletto homePageStiletto = new HomePageStiletto(driver);
 DetailsStiletto  detailsStiletto = new DetailsStiletto(driver);
 Cart cart = new Cart(driver);
 CheckKey check = new CheckKey(driver);
	
	public  KeyWord( WebDriver driver ) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		homePageStiletto = new HomePageStiletto(driver);
		cart = new Cart(driver);
		detailsStiletto = new DetailsStiletto(driver);
		check= new CheckKey(driver);
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
	
}
