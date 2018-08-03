package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testautomation.PantofiStiletto;
import testautomation.TestBase;

public class Test_Pantofi extends TestBase {
 PantofiStiletto pantofi= new PantofiStiletto();
	@Test
	public void testPantofi() throws InterruptedException
	{
	     pantofi.fillContact();
	     Assert.assertTrue(pantofi.checkContact(), "Reset page is not found.");
         pantofi.addProduct();
		 pantofi.viewCart();
         pantofi.removeProduct();
    }
}
