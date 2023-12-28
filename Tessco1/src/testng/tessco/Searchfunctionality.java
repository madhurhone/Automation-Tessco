package testng.tessco;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Searchfunctionality {

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
	@Parameters({"username","password", "Transmitfrequency", "Receivefrequency", "Search"})
	public void savedquotes(String username, String password, String Transmitfrequency, String Receivefrequency, String Search) throws InterruptedException{
		
		//verification of home page
				String actualtitle = driver.getTitle();
				String expectedtitle = "Wireless Communication Products Distributor & Value-Added Supplier | Homepage";
				assertEquals(actualtitle, expectedtitle);
				System.out.println(actualtitle);
				
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
				//cart page
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/button[4]/span")).click();
				
				
						
	}
	
	
}
