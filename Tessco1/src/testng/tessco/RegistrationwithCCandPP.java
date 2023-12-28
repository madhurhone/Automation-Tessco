package testng.tessco;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class RegistrationwithCCandPP {
WebDriver driver;
		
String imagereportpath = "../test-output/Output-screenshots/";
String imagesavepath = "C:\\Users\\MRAYAVAR\\WS_1805\\Tessco1\\test-output\\Output-screenshots\\";
	
	@BeforeMethod
	@Parameters({"URL"})
	public void chromeinstall(String URL) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MRAYAVAR\\Desktop\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
				
		// Navigating to url
		driver.get(URL);
				
								
				
	}

	
	@Test
	@Parameters({"username","password","companylegalentityname","addressline1","addressline2","city", "postalCode", "Emailaddresstoreceiveinvoices", "firstname", "lastname", "email", "phone", "Rusername", "Rpassword", "Rconfirmpassword", "contactfirstname", "contactlastname"})
	public void registration(String username, String password, String companylegalentityname, String addressline1, String addressline2, String city, String postalCode, String Emailaddresstoreceiveinvoices, String firstname, String lastname, String email, String phone, String Rusername, String Rpassword, String Rconfirmpassword, String contactfirstname, String contactlastname) throws InterruptedException, IOException {
		
		// take screenshot
		TakesScreenshot screenshot1 = (TakesScreenshot) driver;
		File screen1 = screenshot1.getScreenshotAs(OutputType.FILE);
		Files.copy(screen1, new File(imagesavepath+"Homepage2.png"));
								
		//Attached screenshot in Testing report
		Reporter.log("<br><br> 1. Launch the home page");
		Reporter.log("<br><br><img src='"+imagereportpath+"Homepage2.png' width='800' height='400'>");		
								
						
		//verification of home page
		String actualtitle = driver.getTitle();
		String expectedtitle = "Wireless Communication Products Distributor & Value-Added Supplier | Homepage";
		assertEquals(actualtitle, expectedtitle);
		System.out.println(actualtitle);
		
		driver.findElement(By.xpath("/html/body/main/header/div/div/div[2]/nav/div/ul[2]/li[1]/span/a")).click();
				
		// take screenshot
		Reporter.log("<br><br>2. Login and Register page");
		Thread.sleep(2000);
		TakesScreenshot screenshot2 = (TakesScreenshot) driver;
		File screen = screenshot2.getScreenshotAs(OutputType.FILE);
		Files.copy(screen, new File(imagesavepath+"Logindetails2.png"));
				
		//Attached screenshot in Testing report
		Reporter.log("<br><br><img src='"+imagereportpath+"Logindetails2.png' width='800' height='400'");
				
		//Register button
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div[2]/div[2]/div/div/div/a")).click();
				
				
		// take screenshot
		Reporter.log("<br><br>3. Registration page");
		Thread.sleep(2000);
		TakesScreenshot screenshot3 = (TakesScreenshot) driver;
		File screen3 = screenshot3.getScreenshotAs(OutputType.FILE);
		Files.copy(screen3, new File(imagesavepath+"Registration2.png"));
				
		//Attached screenshot in Testing report
		Reporter.log("<br><br><img src='"+imagereportpath+"Registration2.png' width='800' height='400'");
				
		//New Register Button
		Thread.sleep(2000);
		WebElement r1 = driver.findElement(By.id("regAccountType_NEW"));
		r1.click();
				
		// take screenshot
		Reporter.log("<br><br>4. User able to select New Registration Button");
		Thread.sleep(2000);
		TakesScreenshot screenshot4 = (TakesScreenshot) driver;
		File screen4 = screenshot4.getScreenshotAs(OutputType.FILE);
		Files.copy(screen4, new File(imagesavepath+"ClickRegister2.png"));
				
		//Attached screenshot in Testing report
		Reporter.log("<br><br><img src='"+imagereportpath+"ClickRegister2.png' width='800' height='400'");
			
		
		//NEGATIVE VALIDATION WITHOUT ANY DATA
		driver.findElement(By.id("CompanyLegalEntityName")).sendKeys("");
		driver.findElement(By.id("AddressLine1")).sendKeys("");
		driver.findElement(By.id("AddressLine2")).sendKeys("");
		
				
		//COMPANY LEGAL ENTITY NAME
		driver.findElement(By.id("CompanyLegalEntityName")).click();
		driver.findElement(By.id("CompanyLegalEntityName")).sendKeys(companylegalentityname);
				
		//verification 
		boolean companyname = driver.findElement(By.id("CompanyLegalEntityName")).isDisplayed();
		assertTrue(companyname);				
				
		//COUNTRY DROPDOWN
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"selectTcomNewRegistrationForm\"]/div[2]/div[1]/div[2]/div/div/div/div/div/input")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"selectTcomNewRegistrationForm\"]/div[2]/div[1]/div[2]/div/div/div/div/div/input"));
		ele.sendKeys("India");
		ele.sendKeys(Keys.ENTER);
				
		//ADDRESS LINE 1
		driver.findElement(By.id("AddressLine1")).sendKeys(addressline1);
				
		//verification 
		boolean AL = driver.findElement(By.id("AddressLine1")).isDisplayed();
		assertTrue(AL);				
						
				
		//ADDRESS LINE 2
		driver.findElement(By.id("AddressLine2")).sendKeys(addressline2);
				
		//verification 
		boolean address2 = driver.findElement(By.id("AddressLine2")).isDisplayed();
		assertTrue(address2);				
				
		// take screenshot
		Reporter.log("<br><br>5. User able to Enter Company legal entity name, country, Company Billing Address Line 1 and Company Billing Address Line 2");
		Thread.sleep(2000);
		TakesScreenshot screenshot5 = (TakesScreenshot) driver;
		File screen5 = screenshot5.getScreenshotAs(OutputType.FILE);
		Files.copy(screen5, new File(imagesavepath+"Addressline2.png"));
				
		//Attached screenshot in Testing report
		Reporter.log("<br><br><img src='"+imagereportpath+"Addressline2.png' width='800' height='400'");
				
				
		//ENTER CITY
		driver.findElement(By.id("City")).sendKeys(city);
				
		//verification 
		boolean cityname = driver.findElement(By.id("City")).isDisplayed();
		assertTrue(cityname);	
		
		//COUNTRY DROPDOWN
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"selectTcomNewRegistrationForm\"]/div[2]/div[3]/div[3]/div[2]/div/div/div/div/div/input")).click();
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.xpath("//*[@id=\"selectTcomNewRegistrationForm\"]/div[2]/div[3]/div[3]/div[2]/div/div/div/div/div/input"));
		ele1.sendKeys("Telangana");
		ele1.sendKeys(Keys.ENTER);
		
								
		//ENTER POSTAL CODE
		driver.findElement(By.id("PostalCode")).sendKeys(postalCode);
				
		//verification 
		boolean postal = driver.findElement(By.id("PostalCode")).isDisplayed();
		assertTrue(postal);				
								
		//ENTER EMAIL ADDRESS TO RECEIVE INVOICES
		driver.findElement(By.id("EmailAddressToReceiveInvoices")).sendKeys(Emailaddresstoreceiveinvoices);
				
		//verification 
		boolean emailinvoice = driver.findElement(By.id("EmailAddressToReceiveInvoices")).isDisplayed();
		assertTrue(emailinvoice);				
						
		//ENTER ACCOUNTS PAYABLE (AP) CONTACT FIRST NAME 
		driver.findElement(By.xpath("//*[@id=\"NTAccountPayableContactFirstName\"]")).sendKeys(contactfirstname);
				
				//verification 
				boolean Fname = driver.findElement(By.xpath("//*[@id=\"NTAccountPayableContactFirstName\"]")).isDisplayed();
				assertTrue(Fname);				
				
				//ENTER ACCOUNTS PAYABLE (AP) CONTACT LAST NAME 
				driver.findElement(By.xpath("//*[@id=\"NTAccountPayableContactLastName\"]")).sendKeys(contactlastname);
				
				//verification 
				boolean Lname = driver.findElement(By.xpath("//*[@id=\"NTAccountPayableContactLastName\"]")).isDisplayed();
				assertTrue(Lname);				
				
				//ENTER ACCOUNTS PAYABLE (AP) CONTACT EMAIL
				driver.findElement(By.id("NTAccountPayableContactEmail")).sendKeys(Emailaddresstoreceiveinvoices);
				
				//verification 
				boolean useremail = driver.findElement(By.id("NTAccountPayableContactEmail")).isDisplayed();
				assertTrue(useremail);				
				
				
				//AP PHONE CODE DROPDOWN
				driver.findElement(By.xpath("//*[@id=\"selectTcomNewRegistrationForm\"]/div[2]/div[3]/div[6]/div[2]/div/div/div/div/div/input")).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"selectTcomNewRegistrationForm\"]/div[2]/div[3]/div[6]/div[2]/div/div/div/div/div/input")).click();
				Thread.sleep(2000);
				WebElement ele2 = driver.findElement(By.xpath("//*[@id=\"selectTcomNewRegistrationForm\"]/div[2]/div[3]/div[6]/div[2]/div/div/div/div/div/input"));
				ele2.sendKeys("+91");
				ele2.sendKeys(Keys.ENTER);
				
				
				//ENTER AP PHONE
				driver.findElement(By.id("NTAccountPayableContactPhone")).sendKeys(phone);
				
				//verification 
				boolean userphone = driver.findElement(By.id("NTAccountPayableContactPhone")).isDisplayed();
				assertTrue(userphone);				
				
				// take screenshot
				Reporter.log("<br><br>6. User able to enter City, postal code, AP first name, AP last name, AP email and AP phone");
				Thread.sleep(2000);
				TakesScreenshot screenshot6 = (TakesScreenshot) driver;
				File screen6 = screenshot6.getScreenshotAs(OutputType.FILE);
				Files.copy(screen6, new File(imagesavepath+"apphone2.png"));
				
				//Attached screenshot in Testing report
				Reporter.log("<br><br><img src='"+imagereportpath+"apphone2.png' width='800' height='400'");
				
				
				//STATE SALES TAX EXEMPT DROPDOWN
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"selectTcomNewRegistrationForm\"]/div[2]/div[3]/div[7]/div[1]/div[2]/div/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.linkText("Yes")).click();
				
				
				//DESIRED PAYMENT TERMS DROPDOWN
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"selectTcomNewRegistrationForm\"]/div[2]/div[3]/div[7]/div[3]/div[2]/div/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.linkText("CREDIT CARD")).click();
				
				
				//ENTER FIRST NAME 
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[1]/div[1]/div/input")).sendKeys(firstname);
				
				//verification 
				boolean fname = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[1]/div[1]/div/input")).isDisplayed();
				assertTrue(fname);				
				
				
				//ENTER LAST NAME 
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[1]/div[2]/div/input")).sendKeys(lastname);
				
				//verification 
				boolean lname = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[1]/div[2]/div/input")).isDisplayed();
				assertTrue(lname);				
				
				//ENTER EMAIL
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[2]/div[1]/div/input")).sendKeys(Emailaddresstoreceiveinvoices);
				
				//verification 
				boolean uemail = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[2]/div[1]/div/input")).isDisplayed();
				assertTrue(uemail);				
				
				//ENTER PHONE
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[2]/div[3]/div/input")).sendKeys(phone);
				
				//verification 
				boolean uphone = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[2]/div[3]/div/input")).isDisplayed();
				assertTrue(uphone);				
				
				
				//JOB TITLE DROPDOWN
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"selectTcomNewRegistrationForm\"]/div[5]/div[3]/div/div[2]/div/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.linkText("Purchasing or Logistics")).click();
				
				
				//ENTER TESSCO.COM USERNAME 
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[4]/div/div/input")).sendKeys(Rusername);
				
				//verification 
				boolean Uname = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[4]/div/div/input")).isDisplayed();
				assertTrue(Uname);				
				
				//ENTER LOGIN INFO/ PASSWORD
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[6]/div[1]/div/input")).sendKeys(Rpassword);
				
				//verification 
				boolean pwd = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[6]/div[1]/div/input")).isDisplayed();
				assertTrue(pwd);				
				
				//ENTER LOGIN INFO/ CONFIRM PASSWORD
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[6]/div[2]/div/input")).sendKeys(Rconfirmpassword);
				
				//verification 
				boolean cpwd = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[2]/form/div[5]/div[6]/div[2]/div/input")).isDisplayed();
				assertTrue(cpwd);				
				
				// take screenshot
				Reporter.log("<br><br>7. User able to enter First name, Last name, email, Phone, Tessco.com username, password and confirm password");
				Thread.sleep(2000);
				TakesScreenshot screenshot7 = (TakesScreenshot) driver;
				File screen7 = screenshot7.getScreenshotAs(OutputType.FILE);
				Files.copy(screen7, new File(imagesavepath+"cnfpwd2.png"));
				
				//Attached screenshot in Testing report
				Reporter.log("<br><br><img src='"+imagereportpath+"cnfpwd2.png' width='800' height='400'");
				
				
				//selecting accept and terms and conditions box
				Thread.sleep(2000);
				WebElement p1 = driver.findElement(By.id("TermsCheck_tcomNewRegistrationForm"));
				p1.click();
				
				
				//Register button
				driver.findElement(By.xpath("//*[@id=\"tcomNewRegistrationRegisterBtn\"]")).click();
				
				// take screenshot
				Reporter.log("<br><br>7. User able to register successfully");
				Thread.sleep(2000);
				TakesScreenshot screenshot8 = (TakesScreenshot) driver;
				File screen8 = screenshot8.getScreenshotAs(OutputType.FILE);
				Files.copy(screen8, new File(imagesavepath+"register5.png"));
				
				//Attached screenshot in Testing report
				Reporter.log("<br><br><img src='"+imagereportpath+"register5.png' width='800' height='400'");
							

	}

}
