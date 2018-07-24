package testautomation;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CheckKey extends TestBase{
	protected WebDriver driver;
	HomePageStiletto homePageStiletto = new HomePageStiletto(driver);
	DetailsStiletto  detailsStiletto = new DetailsStiletto(driver);
	Cart cart= new Cart(driver);
	SoftAssert softAssert = new SoftAssert();
	
	 public  CheckKey( WebDriver driver ) {
			this.driver= driver;
			PageFactory.initElements(driver, this);
			homePageStiletto = new HomePageStiletto(driver);
			detailsStiletto = new DetailsStiletto(driver);
			cart = new Cart(driver);
			}
	
	
	 public void  checkContact() throws InterruptedException {
			Thread.sleep(2000);
		    String CheckMessage = homePageStiletto.getTextcheck();
		    softAssert.assertTrue(CheckMessage.contains("Your details were  successfuly!"), "Details were not successfully");
			status("PASS", "Mesajul apare.");
//			if (homePageStiletto.getCheckMessage().isEnabled() && CheckMessage.contains("Your details were sent successfully!")) {
//				status("PASS", "Mesajul apare.");
//			}
//			else {
//				status("FAIL", "Mesajul nu apare.");
//			}
			softAssert.assertAll();
			}
	 public void  checkCart() throws InterruptedException {
		 sleep();
		 cart.driverrSwitchCart();
		 cart.wait_cart();
		  String CheckCart = cart.getTextCart();
		 CheckCart= CheckCart.replaceAll("[^\\d.]", "");
		 System.out.println("Stringul este:" + CheckCart);
		if (CheckCart.equals("0")) {
			 status("PASS", "Cosul este gol.");
			} else {
			 status("FAIL", "Cosul nu s-a golit.");

			}

		 default_content();
	 }
	 public void  check_messageCart() throws InterruptedException {
		 sleep();
		 cart.driverrSwitchCart();
		 cart.wait_cart();
		 String MessageCart = cart.emptyTextCart ();
		 System.out.println("Stringul este:" + MessageCart);
		if (MessageCart.equals("Cart is empty")) {
			 status("PASS", "Mesajul apare:Cart is empty.");
			} else {
			 status("FAIL", "Mesajul nu apare.");

			}

		 default_content();
		 status("PASS","END OF TEST");
	 }
	 
	 
		
}
