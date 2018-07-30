package tests;

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
	 key.addProduct();
    check.checkAddtoCart();
    check.check_ProductInfo();
	}
}
