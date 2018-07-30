package testautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class PantofiStiletto extends TestBase {

	
	public WebElement getElement(Identifier identifier, String expression) {
        By byElement = null;
        switch (identifier) {
        case xpath: {
            byElement = By.xpath(expression);
            break;
        }
        case id: {
            byElement = By.id(expression);
            break;
        }
        case name: {
            byElement = By.name(expression);
            break;
        }
        case classname: {
            byElement = By.className(expression);
                
            break;
        }
        case linktext: {
            byElement = By.linkText(expression);
            break;
        }
        case partiallinktext: {
            byElement = By.partialLinkText(expression);
            break;
        }
        case tagname: {
            byElement = By.tagName(expression);
            break;
        }
        }
        WebElement element = driver.findElement(byElement);
       return element;
    }

 public static enum Identifier {
        xpath, id, name, classname, partiallinktext, linktext, tagname
    };
    
    public void sendKeys1(WebElement element, String expression) { 
		element.sendKeys(expression);

	}
    
	public void fillContact() 
	{
		driver.get("https://ancabota09.wixsite.com/internship");
		maximize();
       WebElement Name=getElement(Identifier.xpath, "//*[@id=\"field1\"]");
       Name.clear();
       sendKeys1(Name, "Dodea Roxana"); 
       WebElement Email= getElement(Identifier.xpath,"//*[@id='field2']"); //Email
       Email.clear();
	   sendKeys1(Email,"roxanaioana2597@gmail.com");
	   WebElement Subject=getElement(Identifier.xpath, "//*[@id=\"field3\"]");
		Subject.clear();
	   sendKeys1(Subject, "Pantofi");
	   WebElement Phone =getElement(Identifier.xpath, "//*[@id=\"field4\"]");
	   Phone.clear();
	   sendKeys1(Phone, "0757352929");
	   WebElement Address=getElement(Identifier.xpath, "//*[@id=\"field5\"]");
	   Address.clear();
	   sendKeys1(Address, "Jud.Cluj Strada Principala 680B");
	   WebElement Message=getElement(Identifier.xpath, "//*[@id=\"comp-jj67gh16fieldMessage\"]");
	   sendKeys1(Message, "In cat timp ajunge comanda?");
	   Message.clear();
	   WebElement Send=getElement(Identifier.xpath, "//*[@id=\"comp-jj67gh16submit\"]");
	   Send.click(); 
	   
		
	}
	public void  checkContact() throws InterruptedException {
		Thread.sleep(2000);
		 WebElement CheckMessage=getElement(Identifier.xpath, "//*[@id=\"comp-jj67gh16notifications\"]");
		String message = CheckMessage.getText();
		if (CheckMessage.isEnabled() && message.contains("Your details were sent successfully!")) {
			System.out.print("Mesajul apare");
		}
		else {
			System.out.print("Mesajul nu apare");
		}
	}
	public void addProduct()  {
		WebElement frame = getElement(Identifier.id,"comp-jj67gh0riframe");
		driver.switchTo().frame(frame);
		
		WebElement Pantofi = getElement(Identifier.xpath, "   /html/body/mini-gallery/div/section/slick/div/div/div[5]/product-item/a/div[1]/div/product-image/img");
		Pantofi.click();
		driver.switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TPAMultiSection_jj67gcjeiframe")));
		//driver.findElement(By.id("TPAMultiSection_jj67gcjeiframe"));
		WebElement frame1 = getElement(Identifier.id,"TPAMultiSection_jj67gcjeiframe");
		driver.switchTo().frame(frame1);
		
		WebElement Size = getElement(Identifier.xpath,"/html/body/product-page/div/section/div/div[2]/product-options/div/form/product-option-item[1]/div/div/div/div");
	    Size.click();
		//Select size = new Select (driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-0-1\"]/div/div[1]")));
		//size.selectByVisibleText("Medium");
		WebElement selectSize = getElement(Identifier.xpath,"//*[@id=\"ui-select-choices-row-0-1\"]/div/div[1]");
		selectSize.click();
	    // WebElement selectElement= driver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-0-1\"]/div/div[1]"));
	    // Select element = new Select(selectElement);
	    // element.selectByIndex(2);
	   
		WebElement Colour = getElement(Identifier.xpath,"/html/body/product-page/div/section/div/div[2]/product-options/div/form/product-option-item[2]/div/div/div/div/a/span[1]");
	    Colour.click();
	    WebElement selectColour = getElement(Identifier.xpath,"//*[@id=\"ui-select-choices-row-1-1\"]");
	    selectColour.click();
	    
	    WebElement Quantity = getElement(Identifier.xpath,"//*[@id=\"quantity-input\"]");
	    Quantity.clear();
	    Quantity.click();
	    sendKeys1(Quantity, "2");
	  //  driver.switchTo().defaultContent();
	    
	   // WebDriverWait wait2 = new WebDriverWait(driver, 60);// 1 minute 
		//wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("jjo5f89cframeWrap")));

		//WebElement frame2 = getElement(Identifier.id,"jjo5f89cframeWrap");
		//driver.switchTo().frame(frame2);
	  //  WebElement AddtoCart = getElement(Identifier.xpath,"/html/body/product-page/div/section/div[2]/product-options/div/form/product-action/button/user-free-text");
	  //*[@class='button-primary is-button-wide button-add-to-cart']
	    WebElement AddtoCart = getElement(Identifier.xpath,"//*[@class='button-primary is-button-wide button-add-to-cart']");
	    AddtoCart.click();
		driver.switchTo().defaultContent();
	    
	}
	public void addProduct2() throws InterruptedException {
		driver.get("https://ancabota09.wixsite.com/internship");
		
		WebElement frame = getElement(Identifier.id,"comp-jj67gh0riframe");
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		WebElement Pantofi = getElement(Identifier.xpath, "/html/body/mini-gallery/div/section/slick/div/div/div[4]/product-item/a/div[1]/div/product-image/img");
		Pantofi.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TPAMultiSection_jj67gcjeiframe")));
		WebElement frame1 = getElement(Identifier.id,"TPAMultiSection_jj67gcjeiframe");
		driver.switchTo().frame(frame1);

	    WebElement Quantity = getElement(Identifier.xpath,"//*[@id=\"quantity-input\"]");
	    Quantity.clear();
	    sendKeys1(Quantity, "4");
		
	    WebElement AddtoCart = getElement(Identifier.xpath,"//*[@class='button-primary is-button-wide button-add-to-cart']");
	    AddtoCart.click();
		driver.switchTo().defaultContent();
		
		
		
		
	}
	public void viewCart() {
				WebElement frame2 = getElement(Identifier.xpath,"//div[@id='WIX_ADS']/following-sibling::div//iframe ");
				driver.switchTo().frame(frame2);
				WebDriverWait wait2 = new WebDriverWait(driver, 60);// 1 minute 
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/cart-popup/div[2]/footer/a")));
			    WebElement ViewCart = getElement(Identifier.xpath,"/html/body/cart-popup/div[2]/footer/a");
			    ViewCart.click();
			    driver.switchTo().defaultContent();
			    
	}
	public void removeProduct() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		waitAjaxIsLoaded() ;
		WebElement frame3 = getElement(Identifier.xpath,"//div[@id='q14ikinlineContent']//iframe[@title='Cart Page']");
		driver.switchTo().frame(frame3);
		WebDriverWait wait3 = new WebDriverWait(driver, 60);// 1 minute 
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Remove')]")));
		WebElement Removeproduct = getElement(Identifier.xpath,"//span[contains(text(), 'Remove')]");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    Removeproduct.click();
	    driver.switchTo().defaultContent();
	}

	public void waitAjaxIsLoaded() {
		WebDriverWait waitAjx = new WebDriverWait(driver, 30);
		waitAjx.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
	}

	@Test
	public void testPantofi() throws InterruptedException
	{
	     fillContact();
	     checkContact();
         //addProduct();
		// viewCart();
        // removeProduct();
         //addProduct2();
		 //viewCart();
       
		
}
}