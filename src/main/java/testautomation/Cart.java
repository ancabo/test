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
    
    @FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[1]/div/div/div/div[3]/div/a")
	private WebElement continueButton; 
	
    @FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[2]/div[1]/section/div[2]/div/button")
	private WebElement clickAddNote; 
    
    @FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[2]/div[1]/section/div[2]/div/button/span")
	private WebElement checkbuttonAddNote; 
    
    @FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[2]/div[1]/section/div[1]/div/button/span")
	private WebElement checkPromoCode; 
    
    @FindBy(xpath="//*[contains(text(),'Enter a promo code')]")
	private WebElement clickPromoCode; 
    
    @FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[2]/div[1]/section/div[2]/div/div/div/div[1]/textarea")
	private WebElement note; 
    
    @FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[2]/div[1]/section/div[1]/div/div/form/div/div[1]/div/div/input")
	private WebElement writepromocode; 
    
    @FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[2]/div[1]/section/div[1]/div/div/form/div/div[2]/button/div")
   	private WebElement clickApplyPromo; 
    
    @FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/section/div/div[2]/div/div[2]/button/div")
	private WebElement checkmessagePay; 
    
    @FindBy(xpath="[contains(text(),'title')]")
	private WebElement checkout;
    
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
	
	public HomePageStiletto clickContinuebutton () {
		click(continueButton);
	    return new HomePageStiletto(driver) ;
	 }
	
	public Cart clickAddNote() {
		click(clickAddNote);
	    return this ;
	 }
	
	public String getTextAddNote () {
		   String text = checkbuttonAddNote.getText();
			return text;
	 }
	
	public Cart checkPromoCode() {
		click(checkPromoCode);
	    return this ;
	 }

	public String getTextPromoCode () {
		   String text = checkPromoCode.getText();
			return text;
	 }

	public Cart clickPromoCode() {
		click(clickPromoCode);
	    return this ;
	 }
	
	public Cart sendNote() {
		 sendKeys(note, "Colour 2");
		  return this;
	 }
	
	public Cart writePromo() {
		 sendKeys(writepromocode, "123456789");
		  return this;
	 }
	
	public Cart clickApplyPromo() {
		click(clickApplyPromo);
	    return this ;
	 }
	
	public String getTextcheckPay() {
		 String text=  checkmessagePay.getText();
			return text;
	 }
	
	public String getMessageTitle () {
		   String text = checkout.getText();
			return text;
	 }	
}