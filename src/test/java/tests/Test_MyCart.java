package tests;

//import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testautomation.Cart;
import testautomation.CheckKey;
import testautomation.DetailsStiletto;
import testautomation.HomePageStiletto;
import testautomation.KeyWord;
import testautomation.TestBase;

public class Test_MyCart extends TestBase{
	HomePageStiletto homePageStiletto;
	DetailsStiletto  detailsStiletto;
	Cart cart;
	KeyWord key;
	CheckKey check;
	
		@BeforeMethod
		public void beforeMTD() {
			homePageStiletto = new HomePageStiletto(driver);
			detailsStiletto  = new DetailsStiletto(driver);
			cart = new Cart(driver);
			key = new KeyWord(driver);
			check= new CheckKey(driver);
			}
		

		@Test
		public void testAddNote() throws InterruptedException{
			key.addNote();
			check.checkAddtNote();
		}
		
		
		@Test
		public void testPromoCode() throws InterruptedException{
			key.addNote();
			key.promoCode();
			check.checkPromoCode();	
		}
		
		@Test
		public void testPayPal() throws InterruptedException{
			key.payPal();
			check.checkPayPal();
		}
		
		

}
