package testautomation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test_first extends TestBase{
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
