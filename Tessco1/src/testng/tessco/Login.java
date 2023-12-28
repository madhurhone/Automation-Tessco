package testng.tessco;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Login {
	
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
	@Parameters({"username","password"})
	public void login(String username, String password) throws InterruptedException, IOException {
				

		// take screenshot
		TakesScreenshot screenshot1 = (TakesScreenshot) driver;
		File screen1 = screenshot1.getScreenshotAs(OutputType.FILE);
		Files.copy(screen1, new File(imagesavepath+"Homepage.png"));
				
		//Attached screenshot in Testing report
		Reporter.log("<br><br> 1. Launch the home page");
		Reporter.log("<br><br><img src='"+imagereportpath+"Homepage.png' width='800' height='400'>");		
				
		
		//verification of home page
		String actualtitle = driver.getTitle();
		String expectedtitle = "Wireless Communication Products Distributor & Value-Added Supplier | Homepage";
		assertEquals(actualtitle, expectedtitle);
		System.out.println(actualtitle);
				
		
		driver.findElement(By.xpath("/html/body/main/header/div/div/div[2]/nav/div/ul[2]/li[1]/span/a")).click();
		
		// take screenshot
		Thread.sleep(2000);
		TakesScreenshot screenshot2 = (TakesScreenshot) driver;
		File screen2 = screenshot2.getScreenshotAs(OutputType.FILE);
		Files.copy(screen2, new File(imagesavepath+"Loginpage1.png"));
				
		//Attached screenshot in Testing report
		Reporter.log("<br><br> 2. Navigate to login page");
		Reporter.log("<br><br><img src='"+imagereportpath+"Loginpage1.png' width='800' height='400'>");
		
		
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
		Thread.sleep(2000);
		TakesScreenshot screenshot3 = (TakesScreenshot) driver;
		File screen3 = screenshot3.getScreenshotAs(OutputType.FILE);
		Files.copy(screen3, new File(imagesavepath+"Logindetails1.png"));
		
		//Attached screenshot in Testng report
		Reporter.log("<br><br> 3. Enter Login credentials");
		Reporter.log("<br><br><img src='"+imagereportpath+"Logindetails1.png' width='800' height='400'>");		
		
		
		//login button
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
				
		
		// take screenshot
		Thread.sleep(2000);
		TakesScreenshot screenshot4 = (TakesScreenshot) driver;
		File screen4 = screenshot4.getScreenshotAs(OutputType.FILE);
		Files.copy(screen4, new File(imagesavepath+"Homepage1.png"));
				
				
		//Attached screenshot in Testng report
		Reporter.log("<br><br> 4. User able to login homepage");
		Reporter.log("<br><br><img src='"+imagereportpath+"Homepage1.png' width='800' height='400'>");		
				
		//Account menu
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/main/header/div/div/div[2]/nav/div/ul[2]/li[2]/span[1]/a")).click();
		
		// take screenshot
		Thread.sleep(2000);
		TakesScreenshot screenshot5 = (TakesScreenshot) driver;
		File screen5 = screenshot5.getScreenshotAs(OutputType.FILE);
		Files.copy(screen5, new File(imagesavepath+"Accountmenu1.png"));
						
						
		//Attached screenshot in Testng report
		Reporter.log("<br><br> 5. Account menu should be displayed");
		Reporter.log("<br><br><img src='"+imagereportpath+"Accountmenu1.png' width='800' height='400'>");
		
		//Logout button
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/main/header/div/div/div[2]/nav/div/ul[2]/li[2]/div/div/div/ul/li[8]/a")).click();
		
		// take screenshot
		Thread.sleep(2000);
		TakesScreenshot screenshot6 = (TakesScreenshot) driver;
		File screen6 = screenshot6.getScreenshotAs(OutputType.FILE);
		Files.copy(screen6, new File(imagesavepath+"Logout1.png"));
						
						
		//Attached screenshot in Testing report
		Reporter.log("<br><br> 6. User able to logout successfully.");
		Reporter.log("<br><br><img src='"+imagereportpath+"Logout1.png' width='800' height='400'>");
		
		
		// Negative //Empty user name and password
		driver.findElement(By.id("j_username")).sendKeys("");
		
		driver.findElement(By.id("j_password")).sendKeys("");
		
				//login button
				driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
						
				
				// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot8 = (TakesScreenshot) driver;
				File screen8 = screenshot8.getScreenshotAs(OutputType.FILE);
				Files.copy(screen8, new File(imagesavepath+"Reqerror.png"));
						
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 7. when the user provides empty credentials.");
				Reporter.log("<br><br><img src='"+imagereportpath+"Reqerror.png' width='800' height='400'>");	
										
				// Negative //Invalid user name and password
				//driver.navigate().refresh();
				//Thread.sleep(2000);
				//driver.findElement(By.id("j_username")).sendKeys("123456@@$");
				
				//driver.findElement(By.id("j_password")).sendKeys("@$@^W@");
				
						//login button
						//driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
								
						
						// take screenshot
						//Thread.sleep(2000);
						//TakesScreenshot screenshot9 = (TakesScreenshot) driver;
						//File screen9 = screenshot9.getScreenshotAs(OutputType.FILE);
						//Files.copy(screen9, new File(imagesavepath+"Reqerror1.png"));
								
								
						//Attached screenshot in Testing report
						//Reporter.log("<br><br> 8. when the user provides Invalid user name and password.");
						//Reporter.log("<br><br><img src='"+imagereportpath+"Reqerror1.png' width='800' height='400'>");	
					
						
						// Negative //valid user name and empty password
						driver.navigate().refresh();
						Thread.sleep(2000);
						driver.findElement(By.id("j_username")).clear();
						driver.findElement(By.id("j_username")).sendKeys("cdmaxx");
						
						driver.findElement(By.id("j_password")).clear();
						driver.findElement(By.id("j_password")).sendKeys("");
						
								//login button
								driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
										
								
								// take screenshot
								Thread.sleep(2000);
								TakesScreenshot screenshot10 = (TakesScreenshot) driver;
								File screen10 = screenshot10.getScreenshotAs(OutputType.FILE);
								Files.copy(screen10, new File(imagesavepath+"Reqerror2.png"));
										
										
								//Attached screenshot in Testing report
								Reporter.log("<br><br> 9. when the user provides valid user name and empty password.");
								Reporter.log("<br><br><img src='"+imagereportpath+"Reqerror2.png' width='800' height='400'>");	
							
								
								// Negative //valid user name and invalid password
								driver.navigate().refresh();
								Thread.sleep(2000);
								driver.findElement(By.id("j_username")).clear();
								driver.findElement(By.id("j_username")).sendKeys("cdmaxx");
								
								driver.findElement(By.id("j_password")).clear();
								driver.findElement(By.id("j_password")).sendKeys("");
								
										//login button
										driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
												
										
										// take screenshot
										Thread.sleep(2000);
										TakesScreenshot screenshot11 = (TakesScreenshot) driver;
										File screen11 = screenshot11.getScreenshotAs(OutputType.FILE);
										Files.copy(screen11, new File(imagesavepath+"Reqerror3.png"));
												
												
										//Attached screenshot in Testing report
										Reporter.log("<br><br> 10. when the user provides valid user name and invalid password");
										Reporter.log("<br><br><img src='"+imagereportpath+"Reqerror3.png' width='800' height='400'>");	
													
						
							// Negative //empty user name and password
										driver.navigate().refresh();
										Thread.sleep(2000);
										driver.findElement(By.id("j_username")).clear();
										driver.findElement(By.id("j_username")).sendKeys("");
										
										driver.findElement(By.id("j_password")).clear();
										driver.findElement(By.id("j_password")).sendKeys("zdxfgchvjb");
										
												//login button
												driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
														
												
												// take screenshot
												Thread.sleep(2000);
												TakesScreenshot screenshot12 = (TakesScreenshot) driver;
												File screen12 = screenshot12.getScreenshotAs(OutputType.FILE);
												Files.copy(screen12, new File(imagesavepath+"Reqerror4.png"));
														
														
												//Attached screenshot in Testing report
												Reporter.log("<br><br> 10. when the user provides empty user name and valid password");
												Reporter.log("<br><br><img src='"+imagereportpath+"Reqerror4.png' width='800' height='400'>");	
																			
						
	}
	
}
