package testautomation;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testautomation.PantofiStiletto.Identifier;


public class TestBase {
	public static final String IE_DRIVER = "drivers\\IEDriverServer.exe";
	public static final String CHROME_DRIVER = "drivers\\chromedriver.exe";
	public static final String IE_OR_CHROME = "CHROME"; // can be IE or CHROME
	public static final String INFO = "INFO"; 
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test; 
	

	@BeforeTest
	public void beforeTest() {	
		driverStart();
		intializeReport();
	}
	
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		test = extent.createTest(method.getName()); 
	}	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		String screenShot;
		if(driver != null){
		// screenShot = metoda pt screenshot
		}else{
			screenShot = null;
		}		
        if (result.getStatus() == ITestResult.FAILURE) {
        	test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable().toString(), ExtentColor.RED));
        	//test.addScreenCaptureFromPath(screenShot);
        	if(driver != null){
        	driver.manage().deleteAllCookies();
        	}
        }
        else if (result.getStatus() == ITestResult.SKIP)
        	test.log(Status.SKIP, MarkupHelper.createLabel(result.getThrowable().toString(), ExtentColor.ORANGE));
        else
        	test.log(Status.PASS, MarkupHelper.createLabel("Passed", ExtentColor.GREEN));

        extent.flush();
    } 
  
  // @AfterTest
	//public void driverStop() {	
		//driver.quit();
	//} 
	public void intializeReport() {		
		htmlReporter = new ExtentHtmlReporter("./Report.html");
		htmlReporter.config().setDocumentTitle("Test Automation Report");
		htmlReporter.config().setReportName("Test Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter); 		
	}
	
	
	public void driverStart() {

		if (IE_OR_CHROME.equals("IE")) {
			System.setProperty("webdriver.ie.driver", IE_DRIVER);
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.ignoreZoomSettings();
			options.introduceFlakinessByIgnoringSecurityDomains();
			options.setCapability("nativeEvents", false);
			options.setCapability("unexpectedAlertBehaviour", "accept");
			options.setCapability("ignoreProtectedModeSettings", true);
			options.setCapability("disable-popup-blocking", true);
			options.setCapability("enablePersistentHover", true);
			options.setCapability("default", true);
			driver = new InternetExplorerDriver(options);
		} else {
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
			driver = new ChromeDriver();
		}
	}
	
//////////Reporting Methods/////////
	public void statusPass(String msg) {
	test.log(Status.PASS, msg);
	}
	public void statusFail(String msg) {
		test.log(Status.FAIL, msg);
		}
	public void statusInfo(String msg) {
		test.log(Status.INFO, msg);
		}
	public void statusWarning(String msg) {
		test.log(Status.WARNING, msg);
		}
	
	public void status(String status, String msg){
        switch (status) {
         case "PASS": {
               statusPass(msg);
               break;
        }
         case "FAIL": {
             statusFail(msg);
             break;
         }
         case "INFO": {
             statusInfo(msg);
             break;
         }
         case "WARNING": {
             statusWarning(msg);
             break;
         }
         
         
         
         
         }
      
	}

// fail
// info
// warning
// 1 metoda pt toate 4


// metoda pt wait in care puteti folosi Try catch
// for in care sa iterez 5
// try obiect ce vrei sa gasesti webelement
// in catch astepti de ex 1 sec 

// wait cu  while loop + timer / sau do while

// retun boolean  booleanResult 
	
	/////Core Selenim Methods///////
	 public void sendKeys(WebElement element, String expression) { 
		 element.sendKeys(expression);
	 }	
	
	public void click (WebElement element) {
		element.click();
	}
	
	public void gotoUrl(String value) {
		driver.get(value);		
	}
	public void driver_Switch(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void maximize() {
		driver.manage().window().maximize();
	}
	public void  default_content () {
		driver.switchTo().defaultContent();
	}
	public void  clear_Field (WebElement element) {
		element.clear();
	}
	public void sleep() throws InterruptedException {
		Thread.sleep(2000);
	}
	public void wait(WebElement element, String value) {
		
		WebDriverWait wait3 = new WebDriverWait(driver, 5);// 1 minute 
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
	}
	
	public void waait(WebElement element, String value) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		for(int i=0;i<5; i++) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
			}
			 catch(Exception e){
				 Thread.sleep(1000);
			 }
		}
		}
		public void waitt(WebElement element) {
	    boolean clicked = false;
	    int attempts = 0;
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    while(!clicked && attempts < 5) {
	    try {
	            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	            System.out.println("Successfully clicked on the WebElement: ");
	            clicked = true;
	            break;
	     } catch (Exception e) {
	            System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
	            Assert.assertFalse(true, "Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
	        }
	         attempts++;
	    }
     }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/////____________
	@Test
	public void testGoToGoogle() throws InterruptedException {
		driver.get("https://www.google.ro/");
		driver.manage().window().maximize();
		WebElement searchbar = driver.findElement(By.name("q"));
		searchbar.sendKeys("Universitatea Tehnica Cluj Napoca");
		searchbar.submit();
		WebElement UTCN = driver.findElement(By.linkText("Universitatea Tehnica din Cluj-Napoca"));
		UTCN.click();
		Thread.sleep(5000);
		WebElement tur_virtual = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[1]/div[5]/a "));
		tur_virtual.click();
		//WebElement siemens = driver.findElement(By.xpath("//*[@id=\"portlet_windows\"]/div[3]/form/div[2]/a/span/span"));
		//siemens.click();
		Thread.sleep(5000);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.navigate().back();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		//driver.navigate().to("https://www.utcluj.ro/");
		Thread.sleep(5000);
		WebElement contact = driver.findElement(By.xpath("//*[@id='header-top']/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		String url_1 = driver.getCurrentUrl();
		String url_2 = "https://www.utcluj.ro/universitatea/contact/";
		if (url_1.equals(url_2)) {
			System.out.println(" True: Url_1 is equal with Url_2");
		} else {
			System.out.println("False: Url_1 is not equal with Url_2");

		}

		Thread.sleep(5000);
		WebElement faxx = driver.findElement(By.xpath("/html/body/div[5]/div[2]/p[5]/span"));
		String a = faxx.getText();
		System.out.println("Numarul de telefon al faxului este :" + a);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.close();

		// String Fax_number
		// =driver.findElements(By.xpath("/html/body/div[5]/div[2]/p[5]/span")).get(0).getText();
		// System.out.println("Numarul de telefon al faxului este :" + Fax_number);
		// driver.close();

		// maximizare fereastra browser <3
		// click in search bar si cautare UTCN
		// click pe primul link din rezultate Universitatea Tehnica din Cluj-Napoca
		// click pe tur virtual din meniu
		// click back
		// asteptam sa se incarce pagina si click pe contact
		// luam linkul din bara browserului si verificam ca este egal cu
		// https://www.utcluj.ro/universitatea/contact/
		// luam cu selenium numarul de telefon al faxului si il afisam in consola
		// inchidem browserul
	}
}

