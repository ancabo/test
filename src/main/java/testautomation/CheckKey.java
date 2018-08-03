package testautomation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
	
	 public boolean checkContact() throws InterruptedException {
		    sleep();
		    boolean ok;
		    String CheckMessage = homePageStiletto.getTextcheck();
			System.out.println("Stringul este:" + CheckMessage);
			if (CheckMessage.equals("Your details were sent successfully!")) {
				 status("PASS", "Details were sent successfully");
				 ok=true;
				 return ok;
				} 
			else {
				 status("FAIL", "Details were not sent ! :( ");
				 ok= false;
				 return ok;
				}
			}
	 
	    public boolean checkCart() throws InterruptedException {
			 boolean ok;
			 String CheckCart = cart.getTextCart();
			 CheckCart= CheckCart.replaceAll("[^\\d.]", "");
			 System.out.println("Stringul este:" + CheckCart);
			if (CheckCart.equals("0")) {
				 status("PASS", "Cosul este gol.");
				 ok=true;
				 return ok;
				} 
			else {
				 status("FAIL", "Cosul nu s-a golit.");
				 ok= false;
				 return ok;
				}
	 }
	 
		 public boolean check_messageCart() throws InterruptedException {
			 boolean ok;
			 sleep();
			 cart.driverrSwitchCart();
			 cart.wait_cart();
			 String MessageCart = cart.emptyTextCart ();
			 System.out.println("Stringul este:" + MessageCart);
			if (MessageCart.equals("Cart is empty")) {
				 status("PASS", "Mesajul apare:Cart is empty.");
				 ok=true;
				 return ok;
				} 
			else {
				 status("FAIL", "Mesajul nu apare.");
				 ok = false;
				 return ok;
			}
	 }
	 
	 		public boolean checkEmail_invalid() throws InterruptedException {
			   boolean ok;
			    String CheckMessageEmail = homePageStiletto.getMessageEmail();
			    if (CheckMessageEmail.equals("Please provide a valid email")) {
			    	status("PASS","Message: Please provide a valid email");
			    	ok=true;
			        return ok ;
			    }
			    else {
			    	status("FAIL","Error:Message is missing");
			    	ok=false;
			    	return ok;
			    }
		 }	

			public boolean check_BookPage() throws InterruptedException {
				sleep();
				boolean ok;
				bookOnline.driverSwitchb();
				sleep();
				String actual_message =bookOnline.getMessageTitle();
			    if (actual_message.equals("Nothing to book right now. Check back soon.")) {
			    	status("PASS","Welcome!Book Page is displayed.");
			    	ok=true;
			        return ok ;
			    }
			    else {
			    	status("FAIL","Error:Book Page is missing");
			    	ok=false;
			    	return ok;
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
					ok=true;
			        return ok ;
			    }
			    else {
			    	status("FAIL","Confirm  Page is missing!");
			    	ok=false;
			    	return ok;
			    }		
			}
			
			public boolean  checkAddtoCart() throws InterruptedException {
				 sleep();
				detailsStiletto.driverrSwitch();
				sleep();
				 String CheckButton =  detailsStiletto.getTextAddCart(); 
				 System.out.println("Butonul este pe pagina:" + CheckButton);
				if (CheckButton.equals("ADD TO CART")) {
					 status("PASS", "Mesajul apare: ADD TO CART.");
					// System.out.println(" True" + CheckButton);
					 return true;
					} else {
					status("FAIL", "Mesajul nu apare: ADD TO CART.");
					 return false;
					}
			 }
			 
			public boolean checkAddtNote() throws InterruptedException {
				 sleep();
				cart.driverrSwitchCart();
				sleep();
				 String CheckAddNote =  cart.getTextAddNote(); 
				 System.out.println("Butonul este pe pagina:" + CheckAddNote);
				if (CheckAddNote.equals("Add a note")) {
					 status("PASS", "Mesajul apare: Add a note.");
					 return true; 
					} else {
					 status("FAIL", "Mesajul nu apare.");
					 return false;
					}
			 }
			 
			 public boolean  checkPromoCode() throws InterruptedException {
					sleep();
					boolean ok;
					cart.driverrSwitchCart();
					sleep();
					 String CheckPromoCode =  cart.getTextPromoCode(); 
					 System.out.println("Butonul este pe pagina:" + CheckPromoCode);
					if (CheckPromoCode.equals("Enter a promo code")) {
						 status("PASS", "Mesajul apare: Enter a promo code.");
						 ok=true;
						 return ok;
						} 
					else {
						 status("FAIL", "Mesajul nu apare.");
						 ok=false;
						 return ok;
					}
				 }
			 
			 public boolean checkPayPal() throws InterruptedException {
				    sleep();
				    boolean ok;
					cart.driverrSwitchCart();
					sleep();
					 String CheckMessagePayPal =  cart.getTextcheckPay(); 
					 System.out.println("Butonul este pe pagina:" + CheckMessagePayPal);
					if (CheckMessagePayPal.equals("Check out with")) {
						 status("PASS", "Mesajul apare: Check out with");
						 ok=true;
						 return ok; 
						} else {
						 status("FAIL", "Mesajul nu apare.");
						 ok=false;
						 return ok;
						}
			     } 
			 
			 public boolean check_Checkout() throws InterruptedException {
					sleep();
					cart.driverSwitchCart();
					sleep();
					String actual_message =cart.getMessageTitle();
					if (actual_message.equals("Checkout")){
						status("PASS","Checkout is displayed.");
						return  true;	
					} else {
						status("FAIL","Error:Checkout is missing");
						return false;
					}										
				}
			 
			 public boolean check_MandatoryFields()  {		
			        boolean ok ;
					//verificam daca atunci cand nu completam cu date apare mesajul pentru campurile care trebuie completate obligatoriu
					String expected_message = "	Please fill in all required fields.";
					String actual_message =homePageStiletto.getMessagePhone();
					System.out.println("Stringul este: " + actual_message);
					 if (actual_message.equals(expected_message)) {
					 status("PASS","Mandatory fields are visible and selected!");
							ok=true;
					        return ok ;
					    }
					    else {
					    	status("FAIL","Mandatory fields are not visible!");
					    	ok=false;
					    	return ok;
					    }	  
				 }
			 
			 public boolean check_Mandatory()  {		
			        boolean ok ;
					String actual_messagefields =homePageStiletto.getMessageMandatory();
					String expected= "Please fill in all required fields.";
					System.out.println("Stringul este"+ actual_messagefields);
					 if (actual_messagefields.equals(expected)) {
					 status("PASS","Mandatory fields are visible and selected!");
							ok=true;
					        return ok ;
					    }
					    else {
					    	status("FAIL","Mandatory fields are not visible!");
					    	ok=false;
					    	return ok;
					    }	  
			     }
			 public boolean check_InvalidPhone()  {		
			        boolean ok ;
			        String expected_message = "Please provide a valid phone";
					String actual_message =homePageStiletto.getMessagePhone();
					System.out.println("Stringul este"+ actual_message);
					 if (actual_message.equals(expected_message)) {
							status("PASS","Numeric field PHONE doesn't accept ALPHABETS and CHARACTERS!");
							ok=true;
					        return ok ;
					    }
					    else {
					    	status("FAIL","Numeric field PHONE accept ALPHABETS and CHARACTERS!");
					    	ok=false;
					    	return ok;
					    }	  
			     } 
}
