package testautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsStiletto extends TestBase {
	protected WebDriver driver;
	
	public  DetailsStiletto( WebDriver driver ) {
		this.driver= driver;
		PageFactory.initElements(driver, this); 	
		}
	
///////// Elements////////////////
	
	@FindBy(id="TPAMultiSection_jj67gcjeiframe")
	private WebElement frame_meniu; 
	
	@FindBy(xpath="/html/body/product-page/div/section/div/div[2]/product-options/div/form/product-option-item[1]/div/div/div/div")
	private WebElement size; 
	
	@FindBy(xpath="//*[@id='ui-select-choices-row-0-1']/div/div[1]")
	private WebElement select_size; 
	
	@FindBy(xpath="/html/body/product-page/div/section/div/div[2]/product-options/div/form/product-option-item[2]/div/div/div/div/a/span[1]")
	private WebElement colour; 
	
	@FindBy(xpath="//*[@id='ui-select-choices-row-1-1']")
	private WebElement select_colour; 
	
	@FindBy(xpath="//*[@id='quantity-input']")
	private WebElement quantity; 
	
	@FindBy(xpath="//*[@class='button-primary is-button-wide button-add-to-cart']")
	private WebElement add_toCart; 
	
	
    @FindBy(xpath="//div[@id='WIX_ADS']/following-sibling::div//iframe ")
    private WebElement frame_cart; 

   @FindBy(xpath="/html/body/cart-popup/div[2]/footer/a")
   private WebElement viewCart; 
   
   @FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/div")
   private WebElement checkCart; 
	
   @FindBy(xpath=" //div[@id='q14ikinlineContent']//iframe[@title='Cart Page']")
   private WebElement cart_frame; 
  
   @FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[1]/div/div/div/div[3]/span")
   private WebElement emptymessage; 
   
   @FindBy(xpath="//*[@class='button-primary is-button-wide button-add-to-cart']")
   private WebElement checkbutton; 
   
   @FindBy(xpath="/html/body/product-page/div/section/div/div[2]/social-networks/ul/li[1]/a")
	private WebElement buttonFacebook; 
   
   /*@FindBy(xpath="//*[@id=\"facebook\"]")
	private WebElement paginanouaFacebook; */
   
	
  /* @FindBy(xpath="//*[@id=\"content-zone\"]")
  	private WebElement driverSwitchtoFacebook; 
	
   @FindBy(xpath="//*[@id=\"portlet_windows\"]/div[3]/form/div[2]/a/span/span")
 	private WebElement clickLogin; */
   
   
   
	
	
//////////////Actions ///////////
	public DetailsStiletto clickSize() {
		  click(size);
		  return this;
		}
	
	public DetailsStiletto clickSelectSize() {
		  click(select_size);
		  return this;
		}
	
	public DetailsStiletto clickColour() {
		  click(colour);
		  return this;
		}
	
	public DetailsStiletto clickSelectColour() {
		  click(select_colour);
		  return this;
		}
	
	public DetailsStiletto clickQuantity() {
		  click(quantity);
		  return this;
		}
	
	public DetailsStiletto clear_Quantity() {
		  clear_Field(quantity);
		  return this;
		}
	
	public DetailsStiletto sendQuantity() {
		 sendKeys(quantity, "2");
		  return this;
		}
	
	public DetailsStiletto clickAdd() {	
		click(add_toCart);
		return this;
	    }
	
	public DetailsStiletto driverrSwitch() {
		driver_Switch(frame_meniu);
		return this;
	}
	
	public DetailsStiletto clickViewCart() {
		  click(viewCart);
		  return this;
		}
		
	public DetailsStiletto driverrrSwitch() {
		driver_Switch(frame_cart);
		return this;
	   }
	
	public DetailsStiletto wait_frame() throws InterruptedException {
		waait(viewCart,"/html/body/cart-popup/div[2]/footer/a ");
		return this; 	
		}
	
	public DetailsStiletto wait_viewcart() throws InterruptedException {
		waitt(viewCart);
		return this; 	
	}
	
	public String getTextAddCart () {
		   String text = checkbutton.getText();
			return text;
			}
	
	public DetailsStiletto wait_checkAdd() throws InterruptedException {
		waitt(checkbutton);
		return this; 	
	}
	
	public DetailsStiletto clickFacebook() {
		  click(buttonFacebook);
		  return this;
		}
	
	/*public DetailsStiletto waitPaginaNoua() {
		  click(paginanouaFacebook);
		  return this;
		}*/
	
	/*public DetailsStiletto driverSwitchToFacebook() {
		driver_Switch(driverSwitchtoFacebook);
		return this;
	}
	
	public DetailsStiletto clickLoginSiemens() {
		  click(clickLogin);
		  return this;
		}*/
	
	
}

