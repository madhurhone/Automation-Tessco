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

public class Joinexisting {
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
	@Parameters({"Account","firstname", "lastname", "email", "phone", "Rusername", "Rpassword", "Rconfirmpassword"})
	public void joinexisting(String Account, String firstname, String lastname, String email, String phone,String Rusername, String Rpassword, String Rconfirmpassword) throws IOException, InterruptedException {
		        // take screenshot
				TakesScreenshot screenshot1 = (TakesScreenshot) driver;
				File screen1 = screenshot1.getScreenshotAs(OutputType.FILE);
				Files.copy(screen1, new File(imagesavepath+"Homepage4.png"));
										
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 1. Launch the home page");
				Reporter.log("<br><br><img src='"+imagereportpath+"Homepage4.png' width='800' height='400'>");		
										
								
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
				Files.copy(screen, new File(imagesavepath+"Logindetails4.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br><img src='"+imagereportpath+"Logindetails4.png' width='800' height='400'");
						
				//Register button
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div[2]/div[2]/div/div/div/a")).click();
						
						
				// take screenshot
				Reporter.log("<br><br>3. Registration page");
				Thread.sleep(2000);
				TakesScreenshot screenshot3 = (TakesScreenshot) driver;
				File screen3 = screenshot3.getScreenshotAs(OutputType.FILE);
				Files.copy(screen3, new File(imagesavepath+"Registration4.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br><img src='"+imagereportpath+"Registration4.png' width='800' height='400'");
						
				//Join existing Button
				Thread.sleep(2000);
				WebElement r1 = driver.findElement(By.id("regAccountType_EXISTING"));
				r1.click();
						
				// take screenshot
				Reporter.log("<br><br>4. User able to select Join existing Button");
				Thread.sleep(2000);
				TakesScreenshot screenshot4 = (TakesScreenshot) driver;
				File screen4 = screenshot4.getScreenshotAs(OutputType.FILE);
				Files.copy(screen4, new File(imagesavepath+"joinexisting4.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br><img src='"+imagereportpath+"joinexisting4.png' width='800' height='400'");
				
				//Enter Account
				driver.findElement(By.id("accountNumber")).sendKeys(Account);
				
				//Continue button
				driver.findElement(By.xpath("//*[@id=\"existingAccountInput\"]/div[3]/div/button")).click();
				
				// take screenshot
				Reporter.log("<br><br>5. User able to see join existing information ");
				Thread.sleep(2000);
				TakesScreenshot screenshot5 = (TakesScreenshot) driver;
				File screen5 = screenshot5.getScreenshotAs(OutputType.FILE);
				Files.copy(screen5, new File(imagesavepath+"contiue4.png"));
				
				//Attached screenshot in Testing report
				Reporter.log("<br><br><img src='"+imagereportpath+"contiue4.png' width='800' height='400'");
				
				//NEGATIVE SCENARIO WITHOUT ANY DATA
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[1]/div[1]/div/input")).sendKeys("");
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[1]/div[2]/div/input")).sendKeys("");
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[2]/div[1]/div/input")).sendKeys("");
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[2]/div[3]/div/input")).sendKeys("");
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[4]/div/div/input")).sendKeys("");
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[6]/div[1]/div/input")).sendKeys("");
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[6]/div[2]/div/input")).sendKeys("");
					
				//selecting accept and terms and conditions box
				Thread.sleep(2000);
				WebElement p = driver.findElement(By.id("TermsCheck_tcomExistingRegistrationForm"));
				p.click();
				
				
				//Register button
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[4]/div[1]/button")).click();
				
				// take screenshot
				Reporter.log("<br><br>6. User should able to see error messages for all fields");
				Thread.sleep(2000);
				TakesScreenshot screenshot10 = (TakesScreenshot) driver;
				File screen10 = screenshot10.getScreenshotAs(OutputType.FILE);
				Files.copy(screen10, new File(imagesavepath+"register4.png"));
				
				//Attached screenshot in Testing report
				Reporter.log("<br><br><img src='"+imagereportpath+"register4.png' width='800' height='400'");
							
				
				//NEGATIVE SCENARIO WITH WRONG DATA
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[1]/div[1]/div/input")).sendKeys("1234567");
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[1]/div[2]/div/input")).sendKeys("123456");
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[2]/div[1]/div/input")).sendKeys("TESTDEMO");
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[2]/div[3]/div/input")).sendKeys("sdfghjghdj");
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[4]/div/div/input")).sendKeys("@#$!#@$%%");
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[6]/div[1]/div/input")).sendKeys("1234435");
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[6]/div[2]/div/input")).sendKeys("asfdghgf");
								
				//Register button
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[4]/div[1]/button")).click();
				
				// take screenshot
				Reporter.log("<br><br>7. User should able to see error messages for wrong data fields");
				Thread.sleep(2000);
				TakesScreenshot screenshot9 = (TakesScreenshot) driver;
				File screen9 = screenshot9.getScreenshotAs(OutputType.FILE);
				Files.copy(screen9, new File(imagesavepath+"register1.png"));
				
				//Attached screenshot in Testing report
				Reporter.log("<br><br><img src='"+imagereportpath+"register1.png' width='800' height='400'");
							
				
				
				//ENTER FIRST NAME 
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[1]/div[1]/div/input")).clear();
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[1]/div[1]/div/input")).sendKeys(firstname);
				
				//verification 
				boolean fname = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[1]/div[1]/div/input")).isDisplayed();
				assertTrue(fname);				
				
				
				//ENTER LAST NAME 
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[1]/div[2]/div/input")).clear();
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[1]/div[2]/div/input")).sendKeys(lastname);
				
				//verification 
				boolean lname = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[1]/div[2]/div/input")).isDisplayed();
				assertTrue(lname);				
				
				//ENTER EMAIL
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[2]/div[1]/div/input")).clear();
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[2]/div[1]/div/input")).sendKeys(email);
				
				//verification 
				boolean uemail = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[2]/div[1]/div/input")).isDisplayed();
				assertTrue(uemail);				
				
				//PHONE CODE DROPDOWN
				driver.findElement(By.xpath("//*[@id=\"selectTcomExistingRegistrationForm\"]/div[3]/div[2]/div[2]/div/div/div/div/div/input")).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"selectTcomExistingRegistrationForm\"]/div[3]/div[2]/div[2]/div/div/div/div/div/input")).click();
				Thread.sleep(2000);
				WebElement ele = driver.findElement(By.xpath("//*[@id=\"selectTcomExistingRegistrationForm\"]/div[3]/div[2]/div[2]/div/div/div/div/div/input"));
				ele.sendKeys("+91");
				ele.sendKeys(Keys.ENTER);
				
				
				//ENTER PHONE
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[2]/div[3]/div/input")).clear();
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[2]/div[3]/div/input")).sendKeys(phone);
				
				//verification 
				boolean uphone = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[2]/div[3]/div/input")).isDisplayed();
				assertTrue(uphone);				
				
				
				//JOB TITLE DROPDOWN
				Thread.sleep(5000);
								
				WebElement ele4 = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[3]/div/div[2]/div/button"));
				if (ele4.isDisplayed()) {
					ele4.sendKeys(Keys.ENTER);
					
				}
				
				
				//driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[3]/div/div[2]/div/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"selectTcomExistingRegistrationForm\"]/div[3]/div[3]/div/div[2]/div/ul/li[5]/a")).click();
				
				
				//ENTER TESSCO.COM USERNAME
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[4]/div/div/input")).clear();
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[4]/div/div/input")).sendKeys(Rusername);
				
				//verification 
				boolean Uname = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[4]/div/div/input")).isDisplayed();
				assertTrue(Uname);				
				
				//ENTER LOGIN INFO/ PASSWORD
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[6]/div[1]/div/input")).clear();
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[6]/div[1]/div/input")).sendKeys(Rpassword);
				
				//verification 
				boolean pwd = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[6]/div[1]/div/input")).isDisplayed();
				assertTrue(pwd);				
				
				//ENTER LOGIN INFO/ CONFIRM PASSWORD
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[6]/div[2]/div/input")).clear();
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[6]/div[2]/div/input")).sendKeys(Rconfirmpassword);
				
				//verification 
				boolean cpwd = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[3]/div[6]/div[2]/div/input")).isDisplayed();
				assertTrue(cpwd);				
				
				// take screenshot
				Reporter.log("<br><br>8. User able to enter First name, Last name, email, Phone, Tessco.com username, password and confirm password");
				Thread.sleep(2000);
				TakesScreenshot screenshot7 = (TakesScreenshot) driver;
				File screen7 = screenshot7.getScreenshotAs(OutputType.FILE);
				Files.copy(screen7, new File(imagesavepath+"cnfpwd4.png"));
				
				//Attached screenshot in Testing report
				Reporter.log("<br><br><img src='"+imagereportpath+"cnfpwd4.png' width='800' height='400'");
								
				
				//Register button
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/form/div[4]/div[1]/button")).click();
				
				// take screenshot
				Reporter.log("<br><br>9. User able to register successfully");
				Thread.sleep(2000);
				TakesScreenshot screenshot8 = (TakesScreenshot) driver;
				File screen8 = screenshot8.getScreenshotAs(OutputType.FILE);
				Files.copy(screen8, new File(imagesavepath+"register2.png"));
				
				//Attached screenshot in Testing report
				Reporter.log("<br><br><img src='"+imagereportpath+"register2.png' width='800' height='400'");
				
						
	}
	
			
}
