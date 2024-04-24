package bankingPackage;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class Parameters {
	
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	Assertion Assert = new Assertion();
	String URL = "https://globalsqa.com/angularJs-protractor/BankingProject/#/login";
	
	
	
	
	String[] randomFirstName = {"Ahmad","Abdallah","Adam","Yousef","Omar","Samer","Khaled","Mustafa"};
	String[] randomLastName = {"Mansour","Mansi","zeyad","Haddad","Khalel","Zyoud","Mahmoud","Zaid"};
	String[] randomPostalCode = {"12347","11654","11455","11765","11567","11789","11324","11345"};
	
	int randomNumber = rand.nextInt();
	
	int randomFN = rand.nextInt(randomFirstName.length);
	int randomLN = rand.nextInt(randomLastName.length);
	int randomPC = rand.nextInt(randomPostalCode.length);
	
	
}
