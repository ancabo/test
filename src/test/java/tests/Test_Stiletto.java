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

public class Test_Stiletto extends TestBase{
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
	public void test_Stiletto() throws InterruptedException{
	key.fillContact();
	homePageStiletto.clickSend();
	Assert.assertTrue(check.checkContact(), "ERROR");
	homePageStiletto.driverSwitch()
	                .clickPantofi();
	default_content();
	key.addProduct();
	key.remove();
	sleep();
	cart.driverrSwitchCart();
	cart.wait_cart();
	Assert.assertTrue(check.checkCart(), "ERROR");
    default_content();
    Assert.assertTrue(check.check_messageCart(), "ERROR");
    sleep();
    cart.clickContinuebutton();
    default_content();
	}
}

