package tests;

import org.testng.annotations.BeforeMethod;

import testautomation.Cart;
import testautomation.CheckKey;
import testautomation.DetailsStiletto;
import testautomation.HomePageStiletto;
import testautomation.KeyWord;
import testautomation.TestBase;


public class Test2 extends TestBase {
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


}
