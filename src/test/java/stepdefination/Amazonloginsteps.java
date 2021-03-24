package stepdefination;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Amazonloginsteps {
	
	WebDriver driver;
	@Given("^Browser is open$")
	public void browser_is_open() throws Exception {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Ganesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Ganesh\\Drivers\\geckodriver-v0.29.0-win64(1)\\geckodriver.exe");
		//driver =new ChromeDriver();
		driver =new FirefoxDriver();
		 File src = new File("C:\\Users\\Ganesh\\Amazontestdata.xlsx");
		 	FileInputStream fls = new FileInputStream(src);
			XSSFWorkbook xsf = new XSSFWorkbook(fls);
			XSSFSheet sheet = xsf.getSheetAt(0);
			String  url = sheet.getRow(1).getCell(4).getStringCellValue();
		    driver.get(url);
	//	driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	   // throw new PendingException();
	}

	@When("^User is on Homepage$")
	public void User_is_on_Homepage() throws Exception {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-nav-role='signin']")));
		driver.findElement(By.xpath("//a[@data-nav-role='signin']")).isDisplayed();
		//throw new PendingException();
	}
	
	@Then("^User Click on Sign-in button$")
	public void user_Click_on_Sign_in_button() throws Exception {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-nav-role='signin']")));
		driver.findElement(By.xpath("//a[@data-nav-role='signin']")).click();
	   // throw new PendingException();
	}


	@Then("^User navigated to sign in page$")
	public void user_navigated_to_sign_in_page() throws Exception {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")));
		driver.findElement(By.xpath("//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")).isDisplayed();
		//throw new PendingException();
	}

	@Then("^User Enters the Valid Email or \"([^\"]*)\"$")
	public void user_Enters_the_Valid_Email_or_Mobile_Number(String InputNumber) throws Exception {
		/*File src = new File("C:\\Users\\Ganesh\\Amazontestdata.xlsx");
		FileInputStream fls = new FileInputStream(src);
		XSSFWorkbook xsf = new XSSFWorkbook(fls);
		XSSFSheet sheet = xsf.getSheetAt(0);
		String  InputNumber = sheet.getRow(1).getCell(0).getRawValue();*/
		driver.findElement(By.xpath("//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")).sendKeys(InputNumber);
	    //throw new PendingException();
	}

	@And("^User Click on Continue button$")
	public void user_Click_on_Continue_button() throws Exception {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	   // throw new PendingException();
	}

	@Then("^User Enters the Valid Password$")
	public void user_Enters_the_Valid_Password() throws Exception {
		File src = new File("C:\\Users\\Ganesh\\Amazontestdata.xlsx");
		FileInputStream fls = new FileInputStream(src);
		XSSFWorkbook xsf = new XSSFWorkbook(fls);
		XSSFSheet sheet = xsf.getSheetAt(0);
		String  Password = sheet.getRow(1).getCell(1).getStringCellValue();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
	    //throw new PendingException();
	}

	@And("^User Click on Sign-In button$")
	public void user_Click_on_Sign_In_button() throws Exception {
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).submit();
	    //throw new PendingException();
	}

	@Then("^User Navigated to the home page$")
	public void user_Navigated_to_the_home_page() throws Exception {
		File src = new File("C:\\Users\\Ganesh\\Amazontestdata.xlsx");
		FileInputStream fls = new FileInputStream(src);
		XSSFWorkbook xsf = new XSSFWorkbook(fls);
		XSSFSheet sheet = xsf.getSheetAt(0);
		String  Validuser = sheet.getRow(1).getCell(2).getStringCellValue();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")));
		String expectedUser = Validuser;
		String actualUser = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).getText();
		Assert.assertEquals(expectedUser, actualUser);
	   // throw new PendingException();
	}
	
	@And("^User Mousehover on Accounts and List tab$")
	public void user_Mousehover_on_Accounts_and_List_tab() throws Exception {
		Actions actions = new Actions(driver);
		// WebElement elmYouraccount = driver.findElement(By.xpath("//a[@data-nav-ref='nav_youraccount_btn']"));
		WebElement elmYouraccount = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		 actions.moveToElement(elmYouraccount).perform();		
		 //actions.moveToElement(elmYouraccount).build().perform();
		// elmYouraccount.click();
	    
	}

	@And("^User Click on Sign out button$")
	public void user_Click_on_Sign_out_button() throws Exception {
		 driver.findElement(By.xpath("//a[@id='nav-item-signout']")).click();
	    
	}

	@Then("^User Successfully logout$")
	public void user_Successfully_logout() throws Exception {
		
		 WebDriverWait wait=new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='a-spacing-small']")));
		 Boolean elmSignintxtdisplay = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).isDisplayed();
		 System.out.println("Element displayed is :"+elmSignintxtdisplay);
	  
	}

}
