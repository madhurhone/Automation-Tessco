package testng.tessco;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Set;

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

public class Orderhistorypage {
	
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
	@Parameters({"username","password", "sku", "salesorder"})
	public void orderhistory(String username, String password, String sku, String salesorder) throws InterruptedException, IOException{
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
				
				
		//login button
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
		
		// take screenshot
		Reporter.log("<br><br>1. User able to login homepage");
		Thread.sleep(2000);
		TakesScreenshot screenshot1 = (TakesScreenshot) driver;
		File screen = screenshot1.getScreenshotAs(OutputType.FILE);
		Files.copy(screen, new File(imagesavepath+"Homepage7.png"));
		
		//Attached screenshot in Testng report
		Reporter.log("<br><br><img src='"+imagereportpath+"Homepage7.png' width='800' height='400'");		
		
		
		//account menu
		driver.findElement(By.xpath("/html/body/main/header/div/div/div[2]/nav/div/ul[2]/li[2]/span[1]/a")).click();
	
		
		
		// take screenshot
				Reporter.log("<br><br>2. Order history menu is displayed.");
				Thread.sleep(2000);
				TakesScreenshot screenshot2 = (TakesScreenshot) driver;
				File screen1 = screenshot2.getScreenshotAs(OutputType.FILE);
				Files.copy(screen1, new File(imagesavepath+"Orderhistorypage7.png"));
				
		//Attached screenshot in Testng report
		Reporter.log("<br><br><img src='"+imagereportpath+"Orderhistorypage7.png' width='800' height='400'");
		
		//order history menu
				driver.findElement(By.xpath("/html/body/main/header/div/div/div[2]/nav/div/ul[2]/li[2]/div/div/div/ul/li[2]/a")).click();
				
		//Download order history link
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/a")).click();
		
		// take screenshot
		Reporter.log("<br><br>3. Download Order History.");
		Thread.sleep(2000);
		TakesScreenshot screenshot3 = (TakesScreenshot) driver;
		File screen2 = screenshot3.getScreenshotAs(OutputType.FILE);
		Files.copy(screen2, new File(imagesavepath+"DownloadOH7.png"));
		
        //Attached screenshot in Testng report
        Reporter.log("<br><br><img src='"+imagereportpath+"DownloadOH7.png' width='800' height='400'");

		
        //pagination on order history page
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[2]/div/div/div/div[2]/ul/li[8]/a")).click();
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[2]/div/div/div/div[2]/ul/li[8]/a")).click();
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[2]/div/div/div/div[2]/ul/li[8]/a")).click();
        
        //scroll bar
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,350)");
        
     // take screenshot
		Reporter.log("<br><br>4. Order history page.");
		Thread.sleep(2000);
		TakesScreenshot screenshot4 = (TakesScreenshot) driver;
		File screen3 = screenshot4.getScreenshotAs(OutputType.FILE);
		Files.copy(screen3, new File(imagesavepath+"fwpage7.png"));
		
        //Attached screenshot in Testng report
        Reporter.log("<br><br><img src='"+imagereportpath+"fwpage7.png' width='800' height='400'");
        
        
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[2]/div/div/div/div[2]/ul/li[8]/a")).click();
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[2]/div/div/div/div[2]/ul/li[8]/a")).click();
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[2]/div/div/div/div[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[2]/div/div/div/div[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[2]/div/div/div/div[2]/ul/li[1]/a")).click();
              
        //scroll bar
        JavascriptExecutor jse1 = (JavascriptExecutor)driver;
        jse1.executeScript("window.scrollBy(0,350)");
        
     // take screenshot
		Reporter.log("<br><br>5. Order history page.");
		Thread.sleep(2000);
		TakesScreenshot screenshot5 = (TakesScreenshot) driver;
		File screen4 = screenshot5.getScreenshotAs(OutputType.FILE);
		Files.copy(screen4, new File(imagesavepath+"bdpage7.png"));
		
        //Attached screenshot in Testng report
        Reporter.log("<br><br><img src='"+imagereportpath+"bdpage7.png' width='800' height='400'");
        
		//Search by sales order box display or not
		driver.findElement(By.id("orderHistorySearchInput")).sendKeys(salesorder);
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[1]/div[1]/form/div[1]/span/button/span")).click();
		
		//verification
				boolean sku1 = driver.findElement(By.id("orderHistorySearchInput")).isDisplayed();
				assertTrue(sku1);
				
		//selecting sales order
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/table/tbody/tr/td[2]/a")).click();		

		// take screenshot
				Reporter.log("<br><br>6. Order details page.");
				Thread.sleep(2000);
				TakesScreenshot screenshot6 = (TakesScreenshot) driver;
				File screen5 = screenshot6.getScreenshotAs(OutputType.FILE);
				Files.copy(screen5, new File(imagesavepath+"Orderdetails7.png"));
				
		        //Attached screenshot in Testng report
		        Reporter.log("<br><br><img src='"+imagereportpath+"Orderdetails7.png' width='800' height='400'");
		        
		 //Return items button
		        
		      //scroll bar
		        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		        jse2.executeScript("window.scrollBy(0,350)");
		        
		       
		     // take screenshot
				Reporter.log("<br><br>7. Order details page.");
				Thread.sleep(2000);
				TakesScreenshot screenshot7 = (TakesScreenshot) driver;
				File screen6 = screenshot7.getScreenshotAs(OutputType.FILE);
				Files.copy(screen6, new File(imagesavepath+"Orderdetails71.png"));
				
		        //Attached screenshot in Testng report
		        Reporter.log("<br><br><img src='"+imagereportpath+"Orderdetails71.png' width='800' height='400'");
		      
		        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[6]/div[1]/div[1]/div/button")).click();
		     
		        // take screenshot
				Reporter.log("<br><br>8. Return Items popup window.");
				Thread.sleep(2000);
				TakesScreenshot screenshot8 = (TakesScreenshot) driver;
				File screen7 = screenshot8.getScreenshotAs(OutputType.FILE);
				Files.copy(screen7, new File(imagesavepath+"Returnitems7.png"));
				
		        //Attached screenshot in Testng report
		        Reporter.log("<br><br><img src='"+imagereportpath+"Returnitems7.png' width='800' height='400'");
		      
		        //Download Standard return form button
		        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/div[2]/div/a")).click();
		        
		     		  		        
		      //Download Standard return form page close
		        String parent = driver.getWindowHandle();
				Set<String> handle = driver.getWindowHandles();
				for (String child: handle) {
					if (!child.contains(parent)) {
						driver.switchTo().window(child);
						
						// take screenshot
						Reporter.log("<br><br>9. Return Items page.");
						Thread.sleep(2000);
						TakesScreenshot screenshot9 = (TakesScreenshot) driver;
						File screen8 = screenshot9.getScreenshotAs(OutputType.FILE);
						Files.copy(screen8, new File(imagesavepath+"Downloadpdf7.png"));
						
				        //Attached screenshot in Testng report
				        Reporter.log("<br><br><img src='"+imagereportpath+"Downloadpdf7.png' width='800' height='400'");
				        
						Thread.sleep(2000);
						driver.switchTo().window(parent);
					}
					
				}
						        
				//refresh the page
				driver.navigate().refresh();
				Thread.sleep(2000);     
		        
		  //purchase again button
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[6]/div[1]/div[2]/div/button")).click();

	    
	     // take screenshot
			Reporter.log("<br><br>10. User able to navigate to cart page.");
			Thread.sleep(2000);
			TakesScreenshot screenshot10 = (TakesScreenshot) driver;
			File screen9 = screenshot10.getScreenshotAs(OutputType.FILE);
			Files.copy(screen9, new File(imagesavepath+"purchaseagain7.png"));
			
	        //Attached screenshot in Testng report
	        Reporter.log("<br><br><img src='"+imagereportpath+"purchaseagain7.png' width='800' height='400'");
	          
		
		//backward action
				driver.navigate().back();
				Thread.sleep(2000);
				driver.navigate().back();
				Thread.sleep(2000);
				
		//Search by SKU box display or not		
				driver.findElement(By.id("orderHistorySearchInput")).clear();
				driver.findElement(By.id("orderHistorySearchSKUInput")).sendKeys(sku);
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[1]/div[1]/form/div[2]/span/button/span")).click();
		
		//scroll bar
		JavascriptExecutor jse3 = (JavascriptExecutor)driver;
        jse3.executeScript("window.scrollBy(0,500)");
		
		// take screenshot
				Reporter.log("<br><br>11. Search for an order.");
				Thread.sleep(2000);
				TakesScreenshot screenshot11 = (TakesScreenshot) driver;
				File screen10 = screenshot11.getScreenshotAs(OutputType.FILE);
				Files.copy(screen10, new File(imagesavepath+"searchsku7.png"));
				
		        //Attached screenshot in Testng report
		        Reporter.log("<br><br><img src='"+imagereportpath+"searchsku7.png' width='800' height='400'");
		        
		     
		        
	}
}
