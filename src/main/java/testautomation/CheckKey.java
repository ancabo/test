package testautomation;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CheckKey extends TestBase{
	protected WebDriver driver;
	HomePageStiletto homePageStiletto = new HomePageStiletto(driver);
	DetailsStiletto  detailsStiletto = new DetailsStiletto(driver);
	Cart cart= new Cart(driver);
	SoftAssert softAssert = new SoftAssert();
	BookOnline bookOnline = new BookOnline (driver);
	LoginPage loginpage = new LoginPage(driver);
	
	 public  CheckKey( WebDriver driver ) {
			this.driver= driver;
			PageFactory.initElements(driver, this);
			homePageStiletto = new HomePageStiletto(driver);
			detailsStiletto = new DetailsStiletto(driver);
			cart = new Cart(driver);
			bookOnline= new BookOnline(driver);
			loginpage = new LoginPage(driver);
			}
	
	
	 public void  checkContact() throws InterruptedException {
			Thread.sleep(2000);
		    String CheckMessage = homePageStiletto.getTextcheck();
		    softAssert.assertTrue(CheckMessage.contains("Your details were  successfuly!"), "Details were not successfully");
			status("PASS", "Mesajul apare.");
//			if (homePageStiletto.getCheckMessage().isEnabled() && CheckMessage.contains("Your details were sent successfully!")) {
//				status("PASS", "Mesajul apare.");
//			}
//			else {
//				status("FAIL", "Mesajul nu apare.");
//			}
			softAssert.assertAll();
			}
	 public void  checkCart() throws InterruptedException {
		 sleep();
		 cart.driverrSwitchCart();
		 cart.wait_cart();
		  String CheckCart = cart.getTextCart();
		 CheckCart= CheckCart.replaceAll("[^\\d.]", "");
		 System.out.println("Stringul este:" + CheckCart);
		if (CheckCart.equals("0")) {
			 status("PASS", "Cosul este gol.");
			} else {
			 status("FAIL", "Cosul nu s-a golit.");

			}

		 default_content();
	 }
	 public void  check_messageCart() throws InterruptedException {
		 sleep();
		 cart.driverrSwitchCart();
		 cart.wait_cart();
		 String MessageCart = cart.emptyTextCart ();
		 System.out.println("Stringul este:" + MessageCart);
		if (MessageCart.equals("Cart is empty")) {
			 status("PASS", "Mesajul apare:Cart is empty.");
			} else {
			 status("FAIL", "Mesajul nu apare.");

			}

		 default_content();
		 status("PASS","END OF TEST");
	 }
	 
	 public void checkEmail_invalid() throws InterruptedException {
			status("PASS","START TEST");
			gotoUrl("https://ancabota09.wixsite.com/internship");
			maximize();
			homePageStiletto.sendName("Dodea Roxana")
				.sendEmail("roxana25@com")
				.sendPhone("0757352929")
				.sendAddress("Strada Principala nr 680B")
				.sendSubject("Pantofi")
				.sendMessage("Marimile corespund?")
			    .clickSend();
			Thread.sleep(2000);
		    String CheckMessageEmail = homePageStiletto.getMessageEmail();
		   softAssert.assertTrue(CheckMessageEmail.contains("Please provide a valid email"), "Verification Failed: Message is missing!");
		    status("PASS","Message: Please provide a valid email");
		    homePageStiletto.driverSwitch();
			default_content();
		   softAssert.assertAll();
		  status("PASS","END OF TEST");
			 }	
	 public void verifyInvalid_phone() throws InterruptedException {
			gotoUrl("https://ancabota09.wixsite.com/internship");
			maximize();
			homePageStiletto.sendName("Dodea Roxana")
				.sendEmail("roxanaioana2597@gmail.com")
				.sendPhone("0757??abcds_=")
				.sendAddress("Strada Principala nr 680B")
				.sendSubject("Pantofi")
				.sendMessage("Marimile corespund?")
			    .clickSend();
			Thread.sleep(2000);
			String expected_message = "Please provide a valid phone";
			String actual_message =homePageStiletto.getMessagePhone();
			try {
				Assert.assertEquals(actual_message, expected_message);
				status("PASS","Numeric field PHONE doesn't accept ALPHABETS and CHARACTERS!");
			}catch(AssertionError e) {
				status("FAIL","Numeric field PHONE accept ALPHABETS and CHARACTERS!");
			}
	 }
			public void check_Mandatoryfields() throws InterruptedException {
				gotoUrl("https://ancabota09.wixsite.com/internship");
				maximize();
				homePageStiletto.clickSend();
				//verificam daca atunci cand nu completam cu date apare mesajul pentru campurile care trebuie completate obligatoriu
				String expected_message = "	Please fill in all required fields.";
				String actual_message =homePageStiletto.getMessagePhone();
				System.out.println("Stringul este: " + actual_message);
				try {
					Assert.assertEquals(actual_message, expected_message);
					status("PASS","Mandatory fields are visible.");
				}catch(AssertionError e) {
					status("FAIL","Mandatory fields are not visible");
				}
				sleep();
				// verificam daca atunci cand introducem emailul valid apare mesajul pentru campurile completate obligatoriu
				homePageStiletto.sendEmail("roxanaioana2597@gmail.com");
				homePageStiletto.clickSend();
				sleep();
				String actual_messagefields =homePageStiletto.getMessageMandatory();
				String expected= "Please fill in all required fields.";
				System.out.println("Stringul este"+ actual_messagefields);
				try {
					Assert.assertEquals(actual_messagefields, expected);
					status("PASS","Mandatory fields are visible and selected!");
				}catch(AssertionError e) {
					status("FAIL","Mandatory fields are not visible");
				}
			
			}
			
			public boolean check_BookPage() throws InterruptedException {
				sleep();
				boolean ok ;
				bookOnline.driverSwitchb();
				sleep();
				String actual_message =bookOnline.getMessageTitle();
			    if (actual_message.equals("Nothing to book right now. Check back soon.")) {
			    	status("PASS","Welcome!Book Page is displayed.");
			        return ok=true ;
			    }
			    else {
			    	status("FAIL","Error:Book Page is missing");
			    	return ok=false;
			    }
				
			}
		   
			public boolean check_LoginMessage() throws InterruptedException {
				sleep();
				boolean ok;
			    String actual_message = loginpage.getErrorMessage();
			    
			    if (actual_message.equals("Wrong email or password")) {
			    	status("PASS","Message error: Login with wrong password is not working!!");
			    	ok =true;
			        return ok ;
			    }
			    else {
			    	status("FAIL","Login with wrong password is working!!");
			    	ok=false;
			    	return ok;
			    }		
			}
			public boolean check_Reset() throws InterruptedException {
				sleep();
				boolean ok ;
			    String actual_message = loginpage.getResetTitle();
			    if (actual_message.equals("Reset Password")) {
			    	status("PASS","Reset Page is displayed.");
					loginpage.sendEmailreset("roxanaioana2597@gmail.com");
					ok=true;
			        return ok ;
			    }
			    else {
			    	status("FAIL","Reset Page is missing!");
			    	ok=false;
			    	return ok;
			    }							
			}
			public boolean check_ConfirmPage() throws InterruptedException {
				sleep();
				boolean ok;
			    String actual_message = loginpage.getValidationMessage();
			    if (actual_message.equals("Please Check Your Email")) {
			    	status("PASS","Confirm Page is displayed.");
					loginpage.sendEmailreset("roxanaioana2597@gmail.com");
					ok=true;
			        return ok ;
			    }
			    else {
			    	status("FAIL","Confirm  Page is missing!");
			    	ok=false;
			    	return ok;
			    }		
			}
			
			public void  checkAddtoCart() throws InterruptedException {
				 sleep();
				detailsStiletto.driverrSwitch();
				//detailsStiletto.wait_checkAdd();
				sleep();
				 String CheckButton =  detailsStiletto.getTextAddCart(); 
				 System.out.println("Butonul este pe pagina:" + CheckButton);
				if (CheckButton.equals("ADD TO CART")) {
					 status("PASS", "Mesajul apare: ADD TO CART.");
					} else {
					 status("FAIL", "Mesajul nu apare.");

					}
				 default_content();
				 status("PASS","END OF TEST");
			 }
			 //softAssert.assertAll();
			 
			 public void  checkAddtNote() throws InterruptedException {
				 sleep();
				cart.driverrSwitchCart();
				sleep();
				 String CheckAddNote =  cart.getTextAddNote(); 
				 System.out.println("Butonul este pe pagina:" + CheckAddNote);
				if (CheckAddNote.equals("Add a note")) {
					 status("PASS", "Mesajul apare: Add a note.");
					} else {
					 status("FAIL", "Mesajul nu apare.");

					}
				 default_content();
				 status("PASS","END OF TEST");
			 }
			 
			 
			 public void  checkPromoCode() throws InterruptedException {
				 sleep();
				cart.driverrSwitchCart();
				sleep();
				 String CheckPromoCode =  cart.getTextPromoCode(); 
				 System.out.println("Butonul este pe pagina:" + CheckPromoCode);
				if (CheckPromoCode.equals("Enter a promo code")) {
					 status("PASS", "Mesajul apare: Enter a promo code.");
					} else {
					 status("FAIL", "Mesajul nu apare.");

					}
				 default_content();
				 status("PASS","END OF TEST");
			 }
			 
			 public void  checkPayPal() throws InterruptedException {
					/*Thread.sleep(2000);
				    String CheckMessagePayPal = cart.getTextcheckPay();
				    softAssert.assertTrue(CheckMessagePayPal.contains("Check out with PayPal"), "Details were not successfully");
					status("PASS", "Mesajul apare.");
//					if cart.getCheckMessagePayPal().isEnabled() && CheckMessagePayPal.contains("Check out with PayPal")) {
//						status("PASS", "Mesajul apare.");
//					}
//					else {
//						status("FAIL", "Mesajul nu apare.");
//					}
					softAssert.assertAll();
					}*/
				 
				 sleep();
					cart.driverrSwitchCart();
					sleep();
					 String CheckMessagePayPal =  cart.getTextcheckPay(); 
					 System.out.println("Butonul este pe pagina:" + CheckMessagePayPal);
					if (CheckMessagePayPal.equals("Check out with PayPal")) {
						 status("PASS", "Mesajul apare: Check out with PayPal");
						} else {
						 status("FAIL", "Mesajul nu apare.");

						}
					 default_content();
					 status("PASS","END OF TEST");
			 } 
			 
				public void check_ProductInfo() throws InterruptedException {
					sleep();
					cart.driverSwitchCart();
					sleep();
					String actual_message =cart.getMessageTitle();
					try {
						Assert.assertTrue(actual_message.contains("Checkout"), "Verification Failed: Message is missing!");
						status("PASS","Checkout is displayed.");
					}
					catch(AssertionError e) {
						status("FAIL","Error:Checkout is missing");
					}										
				} 
 
	 
}
