package testautomation;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {
	public static final String IE_DRIVER = "drivers\\IEDriverServer.exe";
	public static final String CHROME_DRIVER = "drivers\\chromedriver.exe";
	public static final String IE_OR_CHROME = "CHROME"; 
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
	public void beforeMethod(Method method){
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
  
	@AfterTest
	public void driverStop() {	
		driver.quit();
	} 
	
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
	        } 
	    catch (Exception e) {
	            System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
	            Assert.assertFalse(true, "Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
	        }
	         attempts++;
	    }
    }
}
	

