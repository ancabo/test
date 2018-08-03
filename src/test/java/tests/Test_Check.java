package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testautomation.BookOnline;
import testautomation.Cart;
import testautomation.CheckKey;
import testautomation.DetailsStiletto;
import testautomation.HomePageStiletto;
import testautomation.KeyWord;
import testautomation.LoginPage;
import testautomation.SignUpPage;
import testautomation.TestBase;

public class Test_Check extends TestBase{
	HomePageStiletto homePageStiletto;
	DetailsStiletto  detailsStiletto;
	Cart cart;
	KeyWord key;
	CheckKey check;
	LoginPage loginpage;
	SignUpPage signup ;
	BookOnline bookOnline;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void beforeMTD() {
		homePageStiletto = new HomePageStiletto(driver);
		detailsStiletto  = new DetailsStiletto(driver);
		cart = new Cart(driver);
		key = new KeyWord(driver);
		check= new CheckKey(driver);
		loginpage= new LoginPage(driver);
		signup = new SignUpPage(driver);
		bookOnline = new BookOnline(driver);
		}
	
	@Test 
	public void test_Email_message() throws InterruptedException{
		status("INFO","Start check :)");
		key.go_Url();
		key.fillcontact("Dodea Roxana", "roxana25@com","0757352929");
		homePageStiletto.clickSend();
		sleep();
		Assert.assertTrue(check.checkEmail_invalid(), "Error: Message is missing.");
		status("INFO","End of check!");
	}	
	
	@Test 
	public void test_Invalid_Phone() throws InterruptedException{
		status("INFO","Start to check :)");
		key.go_Url();
		key.fillcontact("Dodea Roxana", "roxanaioana2597@gmail.com","07??frd/&*456");
		homePageStiletto.clickSend();
		sleep();
		Assert.assertTrue(check.check_InvalidPhone(), "Error: Numeric field accept alphabet and characters.");
		status("INFO","End of check!");
	}

	@Test 
	public void test_Mandatoryfields() throws InterruptedException{
		key.go_Url();
		homePageStiletto.clickSend();
		softAssert.assertTrue(check.check_MandatoryFields(), "Mandatory fields are not visible");
		sleep();
		homePageStiletto.sendEmail("roxanaioana2597@gmail.com");
		homePageStiletto.clickSend();
		softAssert.assertTrue(check.check_Mandatory(), "Mandatory fields are not visible");
		status("FAIL", "End of test");
		softAssert.assertAll();
	}

	@Test 
	public void test_Account() throws InterruptedException{
		status("PASS","START TEST");
		key.go_Url();
		homePageStiletto.clickBookOnline();
		Assert.assertTrue(check.check_BookPage(), "Error:Book Page is missing");
		sleep();
		bookOnline.clickLogIn();
		default_content();
		sleep();
		loginpage.clickSignUp(); 
		key.signup_Filldata();
		signup.click_Xbutton();
	    default_content();
	    status("PASS","The account has been successfully created!"); 
	}
	
	@Test 
	public void test_LogInAccount() throws InterruptedException{
		//LogIn Account with invalid password
		key.go_Url();
		homePageStiletto.clickBookOnline();
		Assert.assertTrue(check.check_BookPage(), "Error:Book Page is missing");
		sleep();
		bookOnline.clickLogIn();
		default_content();
	    key.login_Filldata();
	    Assert.assertTrue(check.check_LoginMessage(), "Verification failed:Login with invalid password is working.");
	    loginpage.clickForgotPass();
	    Assert.assertTrue(check.check_Reset(), "Reset page is not found.");
	    loginpage.clickGobutton();
	    Assert.assertTrue(check.check_ConfirmPage(), "Confirm page is not found.");
	    loginpage.clickOK_button();
	}
	
}
	
