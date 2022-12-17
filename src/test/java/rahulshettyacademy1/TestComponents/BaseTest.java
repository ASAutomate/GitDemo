

package rahulshettyacademy1.TestComponents;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettacademy1.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage lp;
	public WebDriver initializeDriver() throws IOException
	{
		 FileInputStream fs= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulacademy1//resources//GlobalData.properties");
		 Properties prop = new Properties();
		 prop.load(fs);
		 String browserName=prop.getProperty("browser");
		 //WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
		 if (browserName.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
				
		 }
		 else if (browserName.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			 
		 }
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 return driver;
				
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
			driver = initializeDriver();
		    lp = new LandingPage(driver);
		    lp.goTo();
			return lp;
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	 	
}
