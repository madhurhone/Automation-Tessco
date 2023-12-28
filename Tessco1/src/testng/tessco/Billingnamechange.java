package testng.tessco;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
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

public class Billingnamechange {
	
	WebDriver driver;
	
	String imagereportpath = "../test-output/Output-screenshots/";
	String imagesavepath = "C:\\Users\\MRAYAVAR\\WS_1805\\Tessco1\\test-output\\Output-screenshots\\";
		
	
	@BeforeMethod
	@Parameters({"URL"})
	public void chromeinstall(String URL) throws IOException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MRAYAVAR\\Desktop\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		// Navigating to url
		driver.get(URL);
	}
	
	@Test
	@Parameters({"username","password", "companylegalentityname","newcompanylegalentityname", "firstname", "lastname", "email", "phone", "title"})
	public void billingname(String username, String password, String companylegalentityname, String newcompanylegalentityname, String firstname, String lastname, String email, String phone, String title) throws InterruptedException, IOException {
		
		// take screenshot
				TakesScreenshot screenshot1 = (TakesScreenshot) driver;
				File screen1 = screenshot1.getScreenshotAs(OutputType.FILE);
				Files.copy(screen1, new File(imagesavepath+"Homepage5.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 1. Launch the home page");
				Reporter.log("<br><br><img src='"+imagereportpath+"Homepage5.png' width='800' height='400'>");		
							
		
		//verification of home page
		String actualtitle = driver.getTitle();
		String expectedtitle = "Wireless Communication Products Distributor & Value-Added Supplier | Homepage";
		assertEquals(actualtitle, expectedtitle);
		System.out.println(actualtitle);
				
		
		driver.findElement(By.xpath("/html/body/main/header/div/div/div[2]/nav/div/ul[2]/li[1]/span/a")).click();
		
		        //user name and password
				driver.findElement(By.id("j_username")).sendKeys(username);
				
				//verification 
				boolean username1 = driver.findElement(By.id("j_username")).isDisplayed();
				assertTrue(username1);
								
				
				driver.findElement(By.id("j_password")).sendKeys(password);
				
				//verification
				boolean password1 = driver.findElement(By.id("j_password")).isDisplayed();
				assertTrue(password1);
				
				
				// take screenshot
				TakesScreenshot screenshot2 = (TakesScreenshot) driver;
				File screen2 = screenshot2.getScreenshotAs(OutputType.FILE);
				Files.copy(screen2, new File(imagesavepath+"Loginpage5.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 2. Login to tessco application.");
				Reporter.log("<br><br><img src='"+imagereportpath+"Loginpage5.png' width='800' height='400'>");		
				

				//login button
				driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
								
				//Account menu
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/main/header/div/div/div[2]/nav/div/ul[2]/li[2]/span[1]/a")).click();
								
				// take screenshot
				TakesScreenshot screenshot3 = (TakesScreenshot) driver;
				File screen3 = screenshot3.getScreenshotAs(OutputType.FILE);
				Files.copy(screen3, new File(imagesavepath+"Menupage4.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 3. Account menu should be displayed.");
				Reporter.log("<br><br><img src='"+imagereportpath+"Menupage4.png' width='800' height='400'>");			
				
				//Billing Name Change button
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/main/header/div/div/div[2]/nav/div/ul[2]/li[2]/div/div/div/ul/li[7]/a")).click();
								
				//selecting accept and terms and conditions box
				Thread.sleep(2000);
				WebElement p1 = driver.findElement(By.id("termsCheck"));
				p1.click();
								
				// take screenshot
				TakesScreenshot screenshot4 = (TakesScreenshot) driver;
				File screen4 = screenshot4.getScreenshotAs(OutputType.FILE);
				Files.copy(screen4, new File(imagesavepath+"Menupage5.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 4. Billing name change page should be displayed.");
				Reporter.log("<br><br><img src='"+imagereportpath+"Menupage5.png' width='800' height='400'>");		
								
				//Submit button
				driver.findElement(By.xpath("//*[@id=\"tcomBillingNameChangeBtn\"]")).click();
								
				// take screenshot
				TakesScreenshot screenshot5 = (TakesScreenshot) driver;
				File screen5 = screenshot5.getScreenshotAs(OutputType.FILE);
				Files.copy(screen5, new File(imagesavepath+"Error5.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 5.Error message should be displayed for all fields.");
				Reporter.log("<br><br><img src='"+imagereportpath+"Error5.png' width='800' height='400'>");		
				
				//company legal entity name label input
				driver.findElement(By.id("companyNameOld")).click();
				driver.findElement(By.id("companyNameOld")).sendKeys(companylegalentityname);
				
				//New company legal entity name label input
				driver.findElement(By.id("companyNameNew")).click();
				driver.findElement(By.id("companyNameNew")).sendKeys(newcompanylegalentityname);
				
				//DBA label
				driver.findElement(By.id("companyNameOldDba")).click();
				driver.findElement(By.id("companyNameOldDba")).sendKeys("");
				
				//New DBA label
				driver.findElement(By.id("dbaNew")).click();
				driver.findElement(By.id("dbaNew")).sendKeys("");
				
				//REASON FOR NAME CHANGE DROPDOWN
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/form/div[2]/div[4]/div/div/div[2]/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/form/div[2]/div[4]/div/div/div[2]/ul/li[1]/a")).click();
				
				// take screenshot
				TakesScreenshot screenshot6 = (TakesScreenshot) driver;
				File screen6 = screenshot6.getScreenshotAs(OutputType.FILE);
				Files.copy(screen6, new File(imagesavepath+"reasondropdown.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 6. User able to enter Company legal entity name and DBA values.");
				Reporter.log("<br><br><img src='"+imagereportpath+"reasondropdown.png' width='800' height='400'>");		
				
				
				//ENTER FIRST NAME 
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/form/div[4]/div[1]/div[1]/div/input")).sendKeys(firstname);
				
				//verification 
				boolean fname = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/form/div[4]/div[1]/div[1]/div/input")).isDisplayed();
				assertTrue(fname);				
				
				
				//ENTER LAST NAME 
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/form/div[4]/div[1]/div[2]/div/input")).sendKeys(lastname);
				
				//verification 
				boolean lname = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/form/div[4]/div[1]/div[2]/div/input")).isDisplayed();
				assertTrue(lname);				
				
				//ENTER EMAIL
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/form/div[4]/div[2]/div[1]/div/input")).sendKeys(email);
				
				//verification 
				boolean uemail = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/form/div[4]/div[2]/div[1]/div/input")).isDisplayed();
				assertTrue(uemail);				
				
				//ENTER PHONE
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/form/div[4]/div[2]/div[2]/div/input")).sendKeys(phone);
				
				//verification 
				boolean uphone = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/form/div[4]/div[2]/div[2]/div/input")).isDisplayed();
				assertTrue(uphone);	
				
				//Title label
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/form/div[4]/div[3]/div/div/input")).sendKeys(title);				
				
				//verification 
				boolean title1 = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/form/div[4]/div[3]/div/div/input")).isDisplayed();
				assertTrue(title1);
				
				// take screenshot
				TakesScreenshot screenshot7 = (TakesScreenshot) driver;
				File screen7 = screenshot7.getScreenshotAs(OutputType.FILE);
				Files.copy(screen7, new File(imagesavepath+"phone4.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 7. User able to enter first name, last name, email, phone an values.");
				Reporter.log("<br><br><img src='"+imagereportpath+"phone4.png' width='800' height='400'>");			
				
				//submit button
				driver.findElement(By.xpath("//*[@id=\"tcomBillingNameChangeBtn\"]")).click();
				
				// take screenshot
				TakesScreenshot screenshot8 = (TakesScreenshot) driver;
				File screen8 = screenshot8.getScreenshotAs(OutputType.FILE);
				Files.copy(screen8, new File(imagesavepath+"submit5.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 8. Request submitted confirmation popup should be displayed.");
				Reporter.log("<br><br><img src='"+imagereportpath+"submit5.png' width='800' height='400'>");		
				
	
	}
	
}