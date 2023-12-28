package testng.tessco;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


public class OrderplacementwithTAandAP {
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
	@Parameters({"username","password", "Transmitfrequency", "Receivefrequency", "Search", "firstname", "addressline1", "addressline2","city", "postalCode"})
	public void savedquotes(String username, String password, String Transmitfrequency, String Receivefrequency, String Search, String firstname, String addressline1, String addressline2, String city, String postalCode) throws InterruptedException, IOException{
		// take screenshot
				TakesScreenshot screenshot1 = (TakesScreenshot) driver;
				File screen1 = screenshot1.getScreenshotAs(OutputType.FILE);
				Files.copy(screen1, new File(imagesavepath+"Homepage12.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 1. Launch the home page");
				Reporter.log("<br><br><img src='"+imagereportpath+"Homepage12.png' width='800' height='400'>");		
				
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
				
				//login button
				driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
				
				// take screenshot
				TakesScreenshot screenshot2 = (TakesScreenshot) driver;
				File screen2 = screenshot2.getScreenshotAs(OutputType.FILE);
				Files.copy(screen2, new File(imagesavepath+"userloggedin12.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 2. user logged in successfully.");
				Reporter.log("<br><br><img src='"+imagereportpath+"userloggedin12.png' width='800' height='400'>");		
				
				//adding product by search
				Thread.sleep(2000);
				driver.findElement(By.id("js-site-search-input")).click();
				driver.findElement(By.id("js-site-search-input")).sendKeys("14515");
				WebElement ele5 = driver.findElement(By.id("js-site-search-input"));
				if (ele5.isDisplayed()) {
					ele5.sendKeys(Keys.ENTER);
				}	
				//add to cart button
				Thread.sleep(4000);
				driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div[2]/div/div[1]/div[2]/div/div/ul/li/div/div[2]/div[5]/div/div[2]/form[1]/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/button[4]/span")).click();
				//clearing cart page
				driver.findElement(By.xpath("/html/body/main/header/nav/div/div[2]/div[2]/div/div/div[2]/ul/li[3]/div/div/div[1]/a/div[4]/span")).click();
				Thread.sleep(2000);
				driver.navigate().refresh();
				driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div/div/div[3]/div[2]/div/div[5]/div[2]/button/span")).click();
				//tessco logo
				driver.findElement(By.xpath("/html/body/main/header/nav/div/div[2]/div[1]/div/div/div/a/img")).click();
							
		//Wifi-networking Equipment category page link	
		Thread.sleep(2000);
		boolean plp = driver.findElement(By.xpath("/html/body/main/div[2]/div[4]/div[1]/div/div[2]/div/div[12]/div/a/img")).isEnabled();
		assertTrue(plp);
		
		boolean plp1 = driver.findElement(By.xpath("/html/body/main/div[2]/div[4]/div[1]/div/div[2]/div/div[12]/div/a/img")).isDisplayed();
		assertTrue(plp1);
		
		driver.findElement(By.xpath("/html/body/main/div[2]/div[4]/div[1]/div/div[2]/div/div[12]/div/a/img")).click();
		
		// take screenshot
		TakesScreenshot screenshot3 = (TakesScreenshot) driver;
		File screen3 = screenshot3.getScreenshotAs(OutputType.FILE);
		Files.copy(screen3, new File(imagesavepath+"filtersplp12.png"));
				
		//Attached screenshot in Testing report
		Reporter.log("<br><br> 3.User navigated to PLP page.");
		Reporter.log("<br><br><img src='"+imagereportpath+"filtersplp12.png' width='800' height='400'>");		
			
		//Add to cart button link 240357
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/main/div[2]/div[4]/div[2]/div/div[1]/div/div/div[2]/li[5]/div/div[2]/div[5]/div/div[2]/form[1]/button")).click();
		
		//confirmation radio button
		
			// take screenshot
			TakesScreenshot screenshot4 = (TakesScreenshot) driver;
			File screen4 = screenshot4.getScreenshotAs(OutputType.FILE);
			Files.copy(screen4, new File(imagesavepath+"frequencypopup12.png"));
					
			//Attached screenshot in Testing report
			Reporter.log("<br><br> 4.User able to give frequency values for selected product.");
			Reporter.log("<br><br><img src='"+imagereportpath+"frequencypopup12.png' width='800' height='400'>");		
				
		//continue shopping button 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/div[4]/a[1]")).click();
		
		//adding product by search 556626
		Thread.sleep(2000);
		driver.findElement(By.id("js-site-search-input")).click();
		driver.findElement(By.id("js-site-search-input")).sendKeys(Search);
		
		
		WebElement ele4 = driver.findElement(By.id("js-site-search-input"));
		if (ele4.isDisplayed()) {
			ele4.sendKeys(Keys.ENTER);
			
		}
		
		// take screenshot
				TakesScreenshot screenshot5 = (TakesScreenshot) driver;
				File screen5 = screenshot5.getScreenshotAs(OutputType.FILE);
				Files.copy(screen5, new File(imagesavepath+"searchplp12.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 5.User able to search product using search bar.");
				Reporter.log("<br><br><img src='"+imagereportpath+"searchplp12.png' width='800' height='400'>");		
				
		//add to cart button
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div[2]/div/div[1]/div[2]/div/div/ul/li/div/div[2]/div[5]/div/div[2]/form[1]/button")).click();
		
			
		//goto cart popup window
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/div[4]/a[2]")).click();
		
		// take screenshot
		TakesScreenshot screenshot6 = (TakesScreenshot) driver;
		File screen6 = screenshot6.getScreenshotAs(OutputType.FILE);
		Files.copy(screen6, new File(imagesavepath+"cartpage12.png"));
				
		//Attached screenshot in Testing report
		Reporter.log("<br><br> 6.User should be able to navigate to cart page.");
		Reporter.log("<br><br><img src='"+imagereportpath+"cartpage12.png' width='800' height='400'>");		
		
		//checkout button
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div/div/div[3]/div[2]/div/div[5]/div[1]/button")).click();
		Thread.sleep(5000);
		
		//temporary address button
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[2]/div/div[1]/div[3]/fieldset/div/form/div[1]/div[2]/div[2]/div[1]/button")).click();
		Thread.sleep(1000);
		
		//cancel button
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[2]/div/div/button[2]")).click();
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[2]/div/div[1]/div[3]/fieldset/div/form/div[1]/div[2]/div[2]/div[1]/button")).click();
		
		//name in popup window
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div[2]/input")).sendKeys(firstname);
		
		//address label
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div[3]/input")).sendKeys(addressline1);
		
		//address line 2 label
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div[4]/input")).sendKeys(addressline2);
		
		//address line 3 label
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div[5]/input")).sendKeys("");
		
		//city label
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div[6]/input")).sendKeys(city);
		
		//state drop down
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div[7]/div/div/div/div/input")).click();
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div[7]/div/div/div/div/input"));
		ele1.sendKeys("United States Minor Outlying Islands");
		ele1.sendKeys(Keys.ENTER);
		
		//zip code
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div[8]/input")).sendKeys(postalCode);
		
		// take screenshot
		TakesScreenshot screenshot7 = (TakesScreenshot) driver;
		File screen7 = screenshot7.getScreenshotAs(OutputType.FILE);
		Files.copy(screen7, new File(imagesavepath+"tempadd12.png"));
				
		//Attached screenshot in Testing report
		Reporter.log("<br><br> 7.User should be able to add new temporary address.");
		Reporter.log("<br><br><img src='"+imagereportpath+"tempadd12.png' width='800' height='400'>");		
			
		//Add new address button
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[2]/div/div/button[1]")).click();
		
		//Delivery Instructions label
		Thread.sleep(5000);
		driver.findElement(By.id("DeliveryInstructions")).sendKeys("Call for availability");
		
		// take screenshot
		TakesScreenshot screenshot8 = (TakesScreenshot) driver;
		File screen8 = screenshot8.getScreenshotAs(OutputType.FILE);
		Files.copy(screen8, new File(imagesavepath+"checkoutpage12.png"));
				
		//Attached screenshot in Testing report
		Reporter.log("<br><br> 7.User should be able to enter delivery instructions field.");
		Reporter.log("<br><br><img src='"+imagereportpath+"checkoutpage12.png' width='800' height='400'>");		
	
		//Ship all items tick mark
		WebElement p1 = driver.findElement(By.id("ShippedAsSingleShipment[0]"));
		p1.click();
		
		// take screenshot
		TakesScreenshot screenshot9 = (TakesScreenshot) driver;
		File screen9 = screenshot9.getScreenshotAs(OutputType.FILE);
		Files.copy(screen9, new File(imagesavepath+"shipitems121.png"));
				
		//Attached screenshot in Testing report
		Reporter.log("<br><br> 8.User should be able to select ship all items check box.");
		Reporter.log("<br><br><img src='"+imagereportpath+"shipitems121.png' width='800' height='400'>");		
			
		//continue to payment button
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[2]/div/div[1]/div[3]/fieldset/div/form/div[3]/button")).click();
				
		//Account payment radio button
		WebElement r2 = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div[1]/div[3]/fieldset/div/form/div[1]/div[2]/div/div[1]/div[2]/input"));
		r2.click();
		
		//P.O. Number
		Thread.sleep(1000);
		driver.findElement(By.id("PurchaseOrderNumber")).sendKeys("06122023");
	
		// take screenshot
		TakesScreenshot screenshot10 = (TakesScreenshot) driver;
		File screen10 = screenshot10.getScreenshotAs(OutputType.FILE);
		Files.copy(screen10, new File(imagesavepath+"shipitems12.png"));
				
		//Attached screenshot in Testing report
		Reporter.log("<br><br> 9.User should be able to enter P.O.Number and Account payment radio button.");
		Reporter.log("<br><br><img src='"+imagereportpath+"shipitems12.png' width='800' height='400'>");		
			
		//continue to review button
		driver.findElement(By.id("chooseTcomPayment_continue_button")).click();	
		
		//place order button
		driver.findElement(By.id("placeOrder")).click();
		
		// take screenshot
		TakesScreenshot screenshot11 = (TakesScreenshot) driver;
		File screen11 = screenshot11.getScreenshotAs(OutputType.FILE);
		Files.copy(screen11, new File(imagesavepath+"placeorder12.png"));
				
		//Attached screenshot in Testing report
		Reporter.log("<br><br> 9.User should be able to place order successfully using Temporary address and Account Payment.");
		Reporter.log("<br><br><img src='"+imagereportpath+"placeorder12.png' width='800' height='400'>");		
		
		//scroll bar
				JavascriptExecutor jse3 = (JavascriptExecutor)driver;
		        jse3.executeScript("window.scrollBy(0,500)");
		    
		        // take screenshot
				TakesScreenshot screenshot12 = (TakesScreenshot) driver;
				File screen12 = screenshot12.getScreenshotAs(OutputType.FILE);
				Files.copy(screen12, new File(imagesavepath+"APplaceorder12.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 9.User should be able to place order successfully using Temporary address and Account Payment.");
				Reporter.log("<br><br><img src='"+imagereportpath+"APplaceorder12.png' width='800' height='400'>");		
				     
	}
}
