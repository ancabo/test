package tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testautomation.Cart;
import testautomation.CheckKey;
import testautomation.DetailsStiletto;
import testautomation.HomePageStiletto;
import testautomation.KeyWord;
import testautomation.TestBase;

public class Test_ClickFacebook extends TestBase {
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
	public void testclickFacebook() throws InterruptedException{	
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
		sleep();
		status("PASS","END OF TEST");
	}

}
