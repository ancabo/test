package tests;

import org.testng.Assert;
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
			key.addProduct();
			cart.driverrSwitchCart();
			sleep();
			cart.clickAddNote();
		    sleep();
		    cart.sendNote();
		    default_content();	
			Assert.assertTrue(check.checkAddtNote(),"Verification Failed: Message is missing!");
		}
		
		@Test
		public void testPromoCode() throws InterruptedException{
			key.addProduct();
			cart.driverrSwitchCart();
			sleep();
            cart.clickPromoCode();
		    sleep();
		    cart.writePromo();
		    sleep();
		    cart.clickApplyPromo();
		    default_content();
			Assert.assertTrue(check.checkPromoCode() ,"Verification Failed: Message is missing!");
		}
		
		@Test
		public void testPayPal() throws InterruptedException{
			key.addProduct();
			cart.driverrSwitchCart();
			sleep();
			default_content();
			Assert.assertTrue(check.checkPayPal() ,"Verification Failed: Message is missing!");	
			sleep();
			default_content();
			Assert.assertTrue(check.check_Checkout(),"Verification Failed: Message is missing!");
		}
}
