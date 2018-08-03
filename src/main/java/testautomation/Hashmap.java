package testautomation;
import java.util.HashMap;

public class Hashmap extends TestBase {
	public  HashMap<String, String> hmap = new HashMap<String, String>();
	public void add_details() {
		  hmap.put("Name", "Dodea Roxana");
	      hmap.put("Email", "roxanaioana2597@gmail.com");
	      hmap.put("PhoneNumber", "0757352929");
	      hmap.put("Message", "Marimile corespund?");
	      hmap.put("Address", "Strada Principala, nr 680B");	
	      hmap.put("Subject", "Pantofi");
	}
}
