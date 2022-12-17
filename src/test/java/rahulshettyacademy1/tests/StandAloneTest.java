package rahulshettyacademy1.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettacademy1.pageobjects.LandingPage;
import rahulshettacademy1.pageobjects.ProductCatalogue;
public class StandAloneTest 
{

	public static void main(String[]args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		//Below 3 lines replaced by page object class 
		
		//driver.findElement(By.id("userEmail")).sendKeys("anubhuti1@mail.com");
		//driver.findElement(By.id("userPassword")).sendKeys("Anubhuti@1982");
		//driver.findElement(By.id("login")).click();
		
		String productName ="ZARA COAT 3";
		
		LandingPage lp=new LandingPage(driver);
		lp.loginApplication("anubhuti1@mail.com", "Anubhuti@1982");
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement>products = productCatalogue.getProducts();
		productCatalogue.addProductToCart(productName);
		
		//By xpath
		//List <WebElement> prod =driver.findElements(By.xpath("//div[@class='container']//b"));
		//By css selector 
		
		driver.manage().window().maximize();
		
		//List <WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
		
		//System.out.println("List of item ");
		//for  (WebElement ele : products)
		//{
			//System.out.println(ele.getText());
			//if (ele.getText().contains("ZARA"))
			//{
				
			//}
		//}
		
		
		
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		// button[@routerLink='/dashboard/cart']
		
		driver.findElement(By.cssSelector("[routerLink*='cart']")).click();
		
		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("Ind");
		
		List <WebElement> ctry_dropdown = driver.findElements(By.cssSelector(".ta-item.list-group-item.ng-star-inserted")); 
		
		//WebElement ctry= 
		WebElement ctry1= ctry_dropdown.stream().filter(ctry->ctry.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		ctry1.click();
		
		driver.findElement(By.cssSelector(".action__submit"));
		String message = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		driver.close();
		
		
		
	}
}