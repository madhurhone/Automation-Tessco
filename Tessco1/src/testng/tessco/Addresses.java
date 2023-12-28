package testng.tessco;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.google.common.io.Files;

public class Addresses {
	WebDriver driver;

	String imagereportpath = "../test-output/Output-screenshots/";
	String imagesavepath = "C:\\Users\\MRAYAVAR\\WS_1805\\Tessco1\\test-output\\Output-screenshots\\";

	@BeforeMethod
	public void chromeinstall(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MRAYAVAR\\Desktop\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		// Navigating to url
				driver.get("https://stg.tessco.com/");
		
	}
	
	@Test
	@Parameters({"username","password"})
	public void switchaccounts(String username, String password) throws IOException, InterruptedException{
		// take screenshot
				TakesScreenshot screenshot1 = (TakesScreenshot) driver;
				File screen1 = screenshot1.getScreenshotAs(OutputType.FILE);
				Files.copy(screen1, new File(imagesavepath+"Homepage14.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 1. Launch the home page");
				Reporter.log("<br><br><img src='"+imagereportpath+"Homepage14.png' width='800' height='400'>");		
								
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
				Files.copy(screen2, new File(imagesavepath+"Loginpage14.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 2. Navigate to login page");
				Reporter.log("<br><br><img src='"+imagereportpath+"Loginpage14.png' width='800' height='400'>");
								
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
				Files.copy(screen3, new File(imagesavepath+"Logindetails14.png"));
				
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 3. Enter Login credentials");
				Reporter.log("<br><br><img src='"+imagereportpath+"Logindetails14.png' width='800' height='400'>");		
								
				//login button
				driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
									
				// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot4 = (TakesScreenshot) driver;
				File screen4 = screenshot4.getScreenshotAs(OutputType.FILE);
				Files.copy(screen4, new File(imagesavepath+"Homepage14.png"));
												
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 4. User able to login homepage");
				Reporter.log("<br><br><img src='"+imagereportpath+"Homepage14.png' width='800' height='400'>");		
						
				//Account menu
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/main/header/div/div/div[2]/nav/div/ul[2]/li[2]/span[1]/a")).click();
				
				// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot5 = (TakesScreenshot) driver;
				File screen5 = screenshot5.getScreenshotAs(OutputType.FILE);
				Files.copy(screen5, new File(imagesavepath+"Accountmenu14.png"));
											
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 5. Account menu should be displayed");
				Reporter.log("<br><br><img src='"+imagereportpath+"Accountmenu14.png' width='800' height='400'>");
				
				//Addresses menu
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/main/header/div/div/div[2]/nav/div/ul[2]/li[2]/div/div/div/ul/li[5]/a")).click();
				
				// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot6 = (TakesScreenshot) driver;
				File screen6 = screenshot6.getScreenshotAs(OutputType.FILE);
				Files.copy(screen6, new File(imagesavepath+"Accountdropdown14.png"));
											
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 6. Addresses page should be displayed");
				Reporter.log("<br><br><img src='"+imagereportpath+"Accountdropdown14.png' width='800' height='400'>");
				
				//scroll bar
		        JavascriptExecutor jse = (JavascriptExecutor)driver;
		        jse.executeScript("window.scrollBy(0,350)");
		        
		     // take screenshot
				Reporter.log("<br><br>7.Addresses page should be displayed");
				Thread.sleep(2000);
				TakesScreenshot screenshot8 = (TakesScreenshot) driver;
				File screen8 = screenshot8.getScreenshotAs(OutputType.FILE);
				Files.copy(screen8, new File(imagesavepath+"fwpage14.png"));
				
		        //Attached screenshot in Testng report
		        Reporter.log("<br><br><img src='"+imagereportpath+"fwpage14.png' width='800' height='400'");
		        				
				//change selected addressess button
		        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/div/div[2]/div[1]/div/button")).click();
		        
				// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot7 = (TakesScreenshot) driver;
				File screen7 = screenshot7.getScreenshotAs(OutputType.FILE);
				Files.copy(screen7, new File(imagesavepath+"Tesscopage14.png"));
											
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 8. Addresses popup window should be displayed");
				Reporter.log("<br><br><img src='"+imagereportpath+"Tesscopage14.png' width='800' height='400'>");
				
				//selecting addresses in popup
				driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/table/tbody/tr[2]/td/div/label/input")).click();		
				driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/table/tbody/tr[3]/td/div/label/input")).click();
				driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/table/tbody/tr[4]/td/div/label/input")).click();
				driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/table/tbody/tr[5]/td/div/label/input")).click();
				driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/table/tbody/tr[6]/td/div/label/input")).click();
				driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/table/tbody/tr[7]/td/div/label/input")).click();
				
				
				// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot9 = (TakesScreenshot) driver;
				File screen9 = screenshot9.getScreenshotAs(OutputType.FILE);
				Files.copy(screen9, new File(imagesavepath+"addressselecting14.png"));
											
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 9. Addresses selection should be displayed.");
				Reporter.log("<br><br><img src='"+imagereportpath+"addressselecting14.png' width='800' height='400'>");
				
				//selecting addresses of other pages
				//driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/table/tbody/tr/td/div/label/input")).click();
				
				//use selected addresses button
				driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[2]/div/div/button[1]")).click();
				
				// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot10 = (TakesScreenshot) driver;
				File screen10 = screenshot10.getScreenshotAs(OutputType.FILE);
				Files.copy(screen10, new File(imagesavepath+"addressselecting13.png"));
											
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 10. Default addresses should be displayed.");
				Reporter.log("<br><br><img src='"+imagereportpath+"addressselecting13.png' width='800' height='400'>");
				
				//scroll bar
		        JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		        jse1.executeScript("window.scrollBy(0,500)");
		        
		     // take screenshot
				Reporter.log("<br><br>11.Addresses page should be displayed");
				Thread.sleep(2000);
				TakesScreenshot screenshot11 = (TakesScreenshot) driver;
				File screen11 = screenshot11.getScreenshotAs(OutputType.FILE);
				Files.copy(screen11, new File(imagesavepath+"fwpage14.png"));
				
		        //Attached screenshot in Testng report
		        Reporter.log("<br><br><img src='"+imagereportpath+"fwpage14.png' width='800' height='400'");
		        
				
	}

}
