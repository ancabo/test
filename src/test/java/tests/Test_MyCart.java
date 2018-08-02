package tests;

import org.testng.Assert;
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
			status("PASS","START TEST");
			gotoUrl("https://ancabota09.wixsite.com/internship/product-page/i-m-a-product-1");
			maximize();
			key.addNote();
			cart.clickAddNote();
		    sleep();
		    cart.sendNote();
		    default_content();	
			Assert.assertTrue(check.checkAddtNote(),"Verification Failed: Message is missing!");
		}
		
		
		@Test
		public void testPromoCode() throws InterruptedException{
			status("PASS","START TEST");
			gotoUrl("https://ancabota09.wixsite.com/internship/product-page/i-m-a-product-1");
			maximize();
			key.addNote();
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
			gotoUrl("https://ancabota09.wixsite.com/internship/product-page/i-m-a-product-1");
			maximize();
			key.payPal();
			Assert.assertTrue(check.checkPayPal() ,"Verification Failed: Message is missing!");	
			//Assert.assertTrue(check.check_Checkout(),"Verification Failed: Message is missing!");
		}
		
		

}
