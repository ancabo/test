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
		
public class Test_AddtoCart extends TestBase {
	HomePageStiletto homePageStiletto;
	DetailsStiletto  detailsStiletto;
	Cart cart;
	KeyWord key;
	CheckKey check;
	
	@BeforeMethod
	public void beforeMTD() {
		key = new KeyWord(driver);
		check= new CheckKey(driver);
		}
	
	@Test
	public void testAddtoCart() throws InterruptedException{
	gotoUrl("https://ancabota09.wixsite.com/internship/product-page/i-m-a-product-1");
	maximize();
	key.addProduct();
	Assert.assertTrue(check.checkAddtoCart(),"Error");
    //check.check_Checkout();
    //Assert.assertTrue(check.check_Checkout(),"Verification Failed: Message is missing!");
	}
}
