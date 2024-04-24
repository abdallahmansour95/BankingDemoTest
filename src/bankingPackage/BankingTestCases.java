package bankingPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BankingTestCases extends Parameters {
	
	
	
	@BeforeTest
	
	
	public void mySetup() {
		
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
	 
		
		
		
		
		
	}
	
	
   @Test(priority = 1 )
   
   
   public void customerTest() throws InterruptedException {
	   
	   WebElement CustomerLogBtn = driver.findElement(By.cssSelector("button[ng-click='customer()']"));
	   Thread.sleep(2000);
	   CustomerLogBtn.click();
	   
	   Thread.sleep(2000);
	   
	   // Find the dropdownList element
	   WebElement dropDownList = driver.findElement(By.id("userSelect"));
	   
	   // Create a Select object from the dropdown element
	   Select select = new Select(dropDownList);
	   
	   // Get all the options from the dropdown
	   List <WebElement> options = select.getOptions();
	   
	// Generate a random index within the range of options
	   int optionCount = options.size();
	   int randomIndex = rand.nextInt(optionCount);
	   
	// Select the option at the random index
	   select.selectByIndex(randomIndex);
	   
	   Thread.sleep(1000);
	   
	   
	   WebElement LoginBtn = driver.findElement(By.className("btn-default"));
	   LoginBtn.click();
	   
	   
   }   
   
   
       @Test(priority = 2,enabled = false )
       
       
       public void addDeposit() throws InterruptedException {
    	   
    	 WebElement DepositBtn = driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass2']"));
    	 
    	 Thread.sleep(2000);
    	 DepositBtn.click();
    	 
    	 
    	 WebElement amountField = driver.findElement(By.cssSelector("input[placeholder='amount']"));
    	 
    	 int minAmount = 10;
    	 int maxAmount = 100;
    	 int randomAmount = rand.nextInt(maxAmount - minAmount + 1) + minAmount;
    	 
    	 
    	 
    	// Clear the existing value and set the random amount
         amountField.clear();
         amountField.sendKeys(Integer.toString(randomAmount));

         // Print the random amount for verification
         System.out.println("Random amount selected: " + randomAmount);
         
         Thread.sleep(2000);
         
         
         WebElement SecDepositBtn = driver.findElement(By.xpath("//button[@type='submit']"));
    	 
    	 Thread.sleep(2000);
    	 SecDepositBtn.click();
    	 
    	 
    	 
    	 Thread.sleep(4000);
    	 
  
    	
    	 
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    	 
         WebElement WithdrawBtn = driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass3']"));
      	 
      	 Thread.sleep(3000);
      	 WithdrawBtn.click();
      	 
      	
      	WebElement withdrawalAmountField = driver.findElement(By.cssSelector("input[placeholder='amount']"));
      	
     // Clear the existing value and set the random amount for withdrawal
      	withdrawalAmountField.clear();
      	withdrawalAmountField.sendKeys(Integer.toString(randomAmount));

    	 
    	 
    	 
     // Print the random amount for verification
      	System.out.println("Random amount to withdraw: " + randomAmount);

      	Thread.sleep(2000);

      	// Locate the withdraw button and click it
      	WebElement withdrawSubmitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
      	Thread.sleep(2000);
      	withdrawSubmitBtn.click();
    	
    	 
      	Thread.sleep(2000);
    	 
    	 
      	
      	
      	
     // Get the initial balance
        WebElement balanceElement = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)"));
        double initialBalance = Double.parseDouble(balanceElement.getText());
      	
        double depositAmount = generateRandomAmount();
        double withdrawalAmount = generateRandomAmount();
      	
     // Calculate expected balance
        double expectedBalance = initialBalance + depositAmount - withdrawalAmount;

        // Get the current balance after transactions
        double currentBalance = Double.parseDouble(balanceElement.getText());

        // Assert if the balance is correct
        Assert.assertEquals(currentBalance, expectedBalance, "Balance is not correct.");
        System.out.println("This is current balance" + currentBalance);
        System.out.println("This is Expected balance" + expectedBalance);
        
        
      	
      	
      	
    	   
       }
       
       
       private double generateRandomAmount() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Test(priority = 3,enabled = false)
       
       
       public void managerTest() throws InterruptedException {
    	   
    	   WebElement ManagerLogBtn =  driver.findElement(By.cssSelector("button[ng-click='manager()']"));
    	   Thread.sleep(2000);
    	   ManagerLogBtn.click();
    	   
    	   Thread.sleep(2000);
    	   
    	   WebElement AddCustomerBtn = driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass1']"));
    	   AddCustomerBtn.click();
    	   
    	   Thread.sleep(2000);
    	   
    	   
    	   
    	   
    	   WebElement FirstNameInput = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
    	   FirstNameInput.sendKeys(randomFirstName[randomFN]);
    	   
    	   Thread.sleep(2000);
    	   WebElement LastNameInput = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
    	   LastNameInput.sendKeys(randomLastName[randomLN]);
    	   Thread.sleep(2000);
    	   WebElement PostalCodeInput = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
    	   PostalCodeInput.sendKeys(randomPostalCode[randomPC]);
    	   
    	   Thread.sleep(2000);
    	   
    	   WebElement AddCusSubBtn = driver.findElement(By.xpath("//button[@type='submit']"));
    	   AddCusSubBtn.click();
    	   
    	  
    	    Alert alert = driver.switchTo().alert();
    	    alert.accept(); 
    	   
    	   
    	   Thread.sleep(2000);
    	   
    	   
       }
       
       
    	   @Test(priority = 4,enabled = false)
    	   
    	   public void addAccount() throws InterruptedException {
    	   
    	   WebElement OpenAccBtn = driver.findElement(By.xpath("//button[contains(text(), 'Open Account')]"));
    	   OpenAccBtn.click();
    	   
    	   
    	   Thread.sleep(2000);
    	   
    	   WebElement dropDownCustList = driver.findElement(By.xpath("//select[@id='userSelect']"));
    	   
    	   
    	   Select select = new Select(dropDownCustList);
    	   
    	  
    	   select.selectByIndex(6);
    	   
    	   Thread.sleep(1000);
    	   
    	   
    	   
           WebElement dropDownCurrList = driver.findElement(By.xpath("//select[@id='currency']"));
    	   
    	   
    	   Select selecttwo = new Select(dropDownCurrList);
    	   
    	   int optionsCount = selecttwo.getOptions().size();
    	   
    	   int RandomCurrancy = rand.nextInt(optionsCount);
    	   
    	  
    	   selecttwo.selectByIndex(RandomCurrancy);
    	   
    	   
    	   
    	   Thread.sleep(1000);
    	   
    	   
    	   WebElement ProccessBtn = driver.findElement(By.xpath("//button[@type='submit' and text()='Process']"));
    	   ProccessBtn.click();
    	   
    	   
    	   Thread.sleep(3000);
    	   
    	 

    	   Alert Alerttwo = driver.switchTo().alert();
			
   		
    	   String AlertMsg = Alerttwo.getText();
    	   
    	   System.out.println("Alert Message : " + AlertMsg);
    	   
    	   Alerttwo.accept();
    	   
       }
    	   
    	   @Test(priority = 5,enabled = false)
    	   
    	   public void deleteCustomer() throws InterruptedException {
    		   
    		   WebElement CustomerButton= driver.findElement(By.cssSelector("button[ng-click='showCust()']"));
    		   Thread.sleep(1000);
    		   CustomerButton.click();
    		   
    		   Thread.sleep(2000);
    		   
    		  WebElement DeleteButton = driver.findElement(By.cssSelector("tbody tr:nth-child(6) td:nth-child(5) button:nth-child(1)"));
    		  DeleteButton.click();
    		   
    		   
    	   }
   
   
   
   
   
   
   
   

}
