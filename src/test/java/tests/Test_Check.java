package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
		check.checkEmail_invalid();	
	}	
	
	@Test 
	public void test_Invalid_Phone() throws InterruptedException{
		check.verifyInvalid_phone();	
	}
	

	@Test 
	public void test_Mandatoryfields() throws InterruptedException{
		check.check_Mandatoryfields();
	}
	

	@Test 
	public void test_Account() throws InterruptedException{
		status("PASS","START TEST");
		gotoUrl("https://ancabota09.wixsite.com/internship");
		maximize();
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
		status("PASS","START TEST");
		gotoUrl("https://ancabota09.wixsite.com/internship");
		maximize();
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
	    status("PASS","END OF TEST");
	    
		
		
		
		
		
		
		
		
		
		
		
		
	
		
	}
	
}
	
