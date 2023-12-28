package testng.tessco;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Set;
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


@Test
public class Savedquotes {
	
	WebDriver driver;

	String imagereportpath = "../test-output/Output-screenshots/";
	String imagesavepath = "C:\\Users\\MRAYAVAR\\WS_1805\\Tessco1\\test-output\\Output-screenshots\\";
	
	@BeforeMethod
	public void chromeinstall() throws IOException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MRAYAVAR\\Desktop\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		// Navigating to url
				driver.get("https://stg.tessco.com/");
		
				// take screenshot
				TakesScreenshot screenshot1 = (TakesScreenshot) driver;
				File screen1 = screenshot1.getScreenshotAs(OutputType.FILE);
				Files.copy(screen1, new File(imagesavepath+"Homepage8.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 1. Launch the home page");
				Reporter.log("<br><br><img src='"+imagereportpath+"Homepage8.png' width='800' height='400'>");		
							
				
				
		//verification of home page
		String actualtitle = driver.getTitle();
		String expectedtitle = "Wireless Communication Products Distributor & Value-Added Supplier | Homepage";
		assertEquals(actualtitle, expectedtitle);
		System.out.println(actualtitle);

	}
	
	@Parameters({"username","password", "Transmitfrequency", "Receivefrequency", "Search"})
	public void savedquotes(String username, String password, String Transmitfrequency, String Receivefrequency, String Search) throws InterruptedException, IOException{
		
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
				Files.copy(screen2, new File(imagesavepath+"Loginpage8.png"));
						
				//Attached screenshot in Testing report
				Reporter.log("<br><br> 2. Navigate to login page");
				Reporter.log("<br><br><img src='"+imagereportpath+"Loginpage8.png' width='800' height='400'>");
				
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
				Files.copy(screen3, new File(imagesavepath+"Logindetails8.png"));
				
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 3. Enter Login credentials");
				Reporter.log("<br><br><img src='"+imagereportpath+"Logindetails8.png' width='800' height='400'>");		
				
				//login button
				driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
				
				// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot4 = (TakesScreenshot) driver;
				File screen4 = screenshot4.getScreenshotAs(OutputType.FILE);
				Files.copy(screen4, new File(imagesavepath+"Homepage81.png"));
						
						
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 4. User able to login homepage");
				Reporter.log("<br><br><img src='"+imagereportpath+"Homepage81.png' width='800' height='400'>");		
					
				
		//Filters and passive components category page link	
		Thread.sleep(2000);
		boolean plp = driver.findElement(By.xpath("/html/body/main/div[2]/div[4]/div[1]/div/div[2]/div/div[5]/div/a/img")).isEnabled();
		assertTrue(plp);
		
		boolean plp1 = driver.findElement(By.xpath("/html/body/main/div[2]/div[4]/div[1]/div/div[2]/div/div[5]/div/a/img")).isDisplayed();
		assertTrue(plp1);
		
		// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot5 = (TakesScreenshot) driver;
				File screen5 = screenshot5.getScreenshotAs(OutputType.FILE);
				Files.copy(screen5, new File(imagesavepath+"Filterscategory8.png"));
								
								
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 5. Filters and passive components category should be displayed");
				Reporter.log("<br><br><img src='"+imagereportpath+"Filterscategory8.png' width='800' height='400'>");
				
		
		driver.findElement(By.xpath("/html/body/main/div[2]/div[4]/div[1]/div/div[2]/div/div[5]/div/a/img")).click();
		
		// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot51 = (TakesScreenshot) driver;
				File screen51 = screenshot51.getScreenshotAs(OutputType.FILE);
				Files.copy(screen51, new File(imagesavepath+"Filterscategory81.png"));
								
								
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 6. Filters and passive components category page should be displayed");
				Reporter.log("<br><br><img src='"+imagereportpath+"Filterscategory81.png' width='800' height='400'>");
				
		//Add to cart button link 76282
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/main/div[2]/div[4]/div[2]/div/div[1]/div/div/div[2]/li[12]/div/div[2]/div[5]/div/div[2]/form[2]/button")).click();
		
		//confirmation radio button
		Thread.sleep(2000);
				WebElement r1 = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/form/div[1]/div[4]/fieldset/div/div/div[1]/div/div[3]/fieldset/label/span/span[1]"));
				r1.click();
		
			//Transmit Frequency field
			driver.findElement(By.id("configurationRows[0].attributes[1].value")).click();
			driver.findElement(By.id("configurationRows[0].attributes[1].value")).sendKeys(Transmitfrequency);
		
			//Receive Frequency field
			driver.findElement(By.id("configurationRows[0].attributes[2].value")).click();
			driver.findElement(By.id("configurationRows[0].attributes[2].value")).sendKeys(Receivefrequency);
			
			// take screenshot
			Thread.sleep(2000);
			TakesScreenshot screenshot61 = (TakesScreenshot) driver;
			File screen61 = screenshot61.getScreenshotAs(OutputType.FILE);
			Files.copy(screen61, new File(imagesavepath+"Filterscategory82.png"));
							
							
			//Attached screenshot in Testng report
			Reporter.log("<br><br> 7. Filters and passive product should be added to cart page.");
			Reporter.log("<br><br><img src='"+imagereportpath+"Filterscategory82.png' width='800' height='400'>");
			
			
			//Add tuning button
			driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/form/div[1]/div[5]/div/div/button[1]")).click();
			
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
					Thread.sleep(2000);
					TakesScreenshot screenshot71 = (TakesScreenshot) driver;
					File screen71 = screenshot71.getScreenshotAs(OutputType.FILE);
					Files.copy(screen71, new File(imagesavepath+"searchproduct8.png"));
									
									
					//Attached screenshot in Testng report
					Reporter.log("<br><br> 8. Search product should be displayed.");
					Reporter.log("<br><br><img src='"+imagereportpath+"searchproduct8.png' width='800' height='400'>");
					
		//add to cart button
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div[2]/div/div[1]/div[2]/div/div/ul/li/div/div[2]/div[5]/div/div[2]/form[1]/button")).click();
		
			
		//goto cart popup window
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/div[4]/a[2]")).click();
		
		// take screenshot
		Thread.sleep(2000);
		TakesScreenshot screenshot72 = (TakesScreenshot) driver;
		File screen72 = screenshot72.getScreenshotAs(OutputType.FILE);
		Files.copy(screen72, new File(imagesavepath+"cartpage8.png"));
						
						
		//Attached screenshot in Testng report
		Reporter.log("<br><br> 9. Cart page should be displayed.");
		Reporter.log("<br><br><img src='"+imagereportpath+"cartpage8.png' width='800' height='400'>");
				
		//purchase plans
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div/div/div[3]/div[2]/div/ul/fieldset/li/ul/li/form/div[1]/button")).click();
		driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div/div/div[3]/div[2]/div/ul/fieldset/li/ul/li/form/div[1]/ul/li[3]/a")).click();
		
		
		//Export CSV button
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div/div/div[3]/div[2]/div/ul/fieldset/li/ul/div/li[1]/div/a")).click();
		
		// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot73 = (TakesScreenshot) driver;
				File screen73 = screenshot73.getScreenshotAs(OutputType.FILE);
				Files.copy(screen73, new File(imagesavepath+"exportcsv8.png"));
								
								
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 9. Cart page should be displayed.");
				Reporter.log("<br><br><img src='"+imagereportpath+"exportcsv8.png' width='800' height='400'>");
					
		
		//clear cart button
		//driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div/div/div[3]/div[2]/div/div[5]/div[2]/button/span")).click();
		
		//import CSV button
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div/div/div[3]/div[2]/div/ul/fieldset/li/ul/div/li[2]/div[1]/a")).click();
		//driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div[1]/div[2]/div[1]/div[1]")).click();
		//Thread.sleep(3000);
			
	
		//upload button
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div[2]/div/div/button[1]")).click();
		
		
		//create quote action
		Thread.sleep(10000);
		driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div/div/div[3]/div[2]/div/ul/fieldset/li/ul/div/li[4]/a")).click();
		
		// take screenshot
		Thread.sleep(2000);
		TakesScreenshot screenshot74 = (TakesScreenshot) driver;
		File screen74 = screenshot74.getScreenshotAs(OutputType.FILE);
		Files.copy(screen74, new File(imagesavepath+"createquote8.png"));
						
		//Attached screenshot in Testng report
		Reporter.log("<br><br> 10. Quote page should be displayed.");
		Reporter.log("<br><br><img src='"+imagereportpath+"createquote8.png' width='800' height='400'>");
			
		
		//submit quote action
				Thread.sleep(4000);
				
				// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot75 = (TakesScreenshot) driver;
				File screen75 = screenshot75.getScreenshotAs(OutputType.FILE);
				Files.copy(screen75, new File(imagesavepath+"submitquote8.png"));
								
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 11. Create Quote page should be displayed.");
				Reporter.log("<br><br><img src='"+imagereportpath+"submitquote8.png' width='800' height='400'>");
					
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div[3]/div[3]/div[2]/form/div[1]/div[3]/button")).click();			
				
				// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot76 = (TakesScreenshot) driver;
				File screen76 = screenshot76.getScreenshotAs(OutputType.FILE);
				Files.copy(screen76, new File(imagesavepath+"submitquote81.png"));
								
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 12. Create Quote page should be displayed.");
				Reporter.log("<br><br><img src='"+imagereportpath+"submitquote81.png' width='800' height='400'>");
					
				
		//refresh the page
				Thread.sleep(50000);
				driver.navigate().refresh();
				Thread.sleep(2000);
		
				// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot77 = (TakesScreenshot) driver;
				File screen77 = screenshot77.getScreenshotAs(OutputType.FILE);
				Files.copy(screen77, new File(imagesavepath+"quotedetails8.png"));
								
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 13. Quote details page should be displayed.");
				Reporter.log("<br><br><img src='"+imagereportpath+"quotedetails8.png' width='800' height='400'>");
					
				
		//Export pdf button
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div[3]/div[3]/div/ul/li/div/a/div")).click();
				Thread.sleep(2000);
				
						
		//export pdf window close
		String parent = driver.getWindowHandle();
		Set<String> handle = driver.getWindowHandles();
		for (String child: handle) {
			if (!child.contains(parent)) {
				driver.switchTo().window(child);
				
				// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot78 = (TakesScreenshot) driver;
				File screen78 = screenshot78.getScreenshotAs(OutputType.FILE);
				Files.copy(screen78, new File(imagesavepath+"exportpdf8.png"));
								
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 14. Export pdf page should be displayed.");
				Reporter.log("<br><br><img src='"+imagereportpath+"exportpdf8.png' width='800' height='400'>");
					
				Thread.sleep(2000);
				driver.switchTo().window(parent);
			}
			
		}
				
		//Add items to cart button
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div[3]/div[3]/div/div/div[3]/button")).click();
				Thread.sleep(2000);
				
				// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot79 = (TakesScreenshot) driver;
				File screen79 = screenshot79.getScreenshotAs(OutputType.FILE);
				Files.copy(screen79, new File(imagesavepath+"additemstocart8.png"));
								
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 15. Cart page should be displayed when the user clicks on Add items to cart button on quote page.");
				Reporter.log("<br><br><img src='"+imagereportpath+"additemstocart8.png' width='800' height='400'>");
						
								
		//backward action
		driver.navigate().back();
		Thread.sleep(2000);
		
		//checkout button
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div[3]/div[3]/div/div/div[1]/form/button")).click();
		Thread.sleep(4000);
		
		// take screenshot
		Thread.sleep(2000);
		TakesScreenshot screenshot69 = (TakesScreenshot) driver;
		File screen69 = screenshot69.getScreenshotAs(OutputType.FILE);
		Files.copy(screen69, new File(imagesavepath+"checkout8.png"));
						
		//Attached screenshot in Testng report
		Reporter.log("<br><br> 16. Checkout page should be displayed when the user clicks on checkout button on quote page.");
		Reporter.log("<br><br><img src='"+imagereportpath+"checkout8.png' width='800' height='400'>");
			
		
		//backward action	
		driver.navigate().back();
		Thread.sleep(2000);
		
		//cancel button action
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div[3]/div[3]/div/div/div[2]/button")).click();
		
		// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot68 = (TakesScreenshot) driver;
				File screen68 = screenshot68.getScreenshotAs(OutputType.FILE);
				Files.copy(screen68, new File(imagesavepath+"cancel8.png"));
								
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 17. Quote cancel confirmation popup window should be displayed.");
				Reporter.log("<br><br><img src='"+imagereportpath+"cancel8.png' width='800' height='400'>");
					
		
		//cancel quote confirmation popup
		driver.findElement(By.id("cancelQuoteReq")).click();
		
		// take screenshot
		Thread.sleep(2000);
		TakesScreenshot screenshot67 = (TakesScreenshot) driver;
		File screen67 = screenshot67.getScreenshotAs(OutputType.FILE);
		Files.copy(screen67, new File(imagesavepath+"cancel81.png"));
						
		//Attached screenshot in Testng report
		Reporter.log("<br><br> 17. Quote cancelled details page should be displayed.");
		Reporter.log("<br><br><img src='"+imagereportpath+"cancel81.png' width='800' height='400'>");
		
		 //scroll bar
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,400)");
        		
		// take screenshot
				Thread.sleep(2000);
				TakesScreenshot screenshot66 = (TakesScreenshot) driver;
				File screen66 = screenshot66.getScreenshotAs(OutputType.FILE);
				Files.copy(screen66, new File(imagesavepath+"cancel82.png"));
								
				//Attached screenshot in Testng report
				Reporter.log("<br><br> 18. Quote cancelled details page should be displayed.");
				Reporter.log("<br><br><img src='"+imagereportpath+"cancel82.png' width='800' height='400'>");
				
	}

}

