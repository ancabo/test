package testautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends TestBase {
	protected WebDriver driver;
	
	public  Cart( WebDriver driver ) {
		this.driver= driver;
		PageFactory.initElements(driver, this); 	
		}
///////// Elements////////////////
	
	@FindBy(xpath="//div[@id='q14ikinlineContent']//iframe[@title='Cart Page'] ")
	private WebElement frame_cart1; 

	@FindBy(xpath="//span[contains(text(), 'Remove')]")
	private WebElement remove; 
	
    @FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/div")
	   private WebElement checkCart; 
		
    @FindBy(xpath=" //div[@id='q14ikinlineContent']//iframe[@title='Cart Page']")
	   private WebElement cart_frame; 
		  
    @FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[1]/div/div/div/div[3]/span")
	   private WebElement emptymessage; 
	


///////// Actions////////////////
	public Cart clickRemove() {
		  click(remove);
		  return this;
		}
	public Cart driverSwitchCart() {
		driver_Switch(frame_cart1);
		return this;
	   }
	
	public Cart waitt() throws InterruptedException {
		waait(remove,"//span[contains(text(), 'Remove')] ");
		return this; 	
		}
	
	public Cart wait_remove() throws InterruptedException {
		waitt(remove);
		return this; 	
		}
	
	public String getTextCart () {
		   String text = checkCart.getText();
			return text;
			}
	
	public Cart driverrSwitchCart() {
		driver_Switch(cart_frame);
		return this;
	
		}	
	public Cart wait_cart() throws InterruptedException {
		waitt(checkCart);
		return this; 	
	}
	
	public String emptyTextCart () {
		   String text = emptymessage.getText();
			return text;
			}

	
	
	
	
}