
package rahulshettyacademy1.tests;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettacademy1.pageobjects.CartPage;
import rahulshettacademy1.pageobjects.CheckOutPage;
import rahulshettacademy1.pageobjects.ConfirmationPage;
import rahulshettacademy1.pageobjects.LandingPage;
import rahulshettacademy1.pageobjects.ProductCatalogue;
import rahulshettyacademy1.TestComponents.BaseTest;
public class SubmitOrderTest extends BaseTest
{
	@Test
	public  void submitOrder() throws IOException, InterruptedException
	{
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
		
		String productName ="ZARA COAT 3";
		
		LandingPage lp = launchApplication();
		//LandingPage lp=new LandingPage(driver);
		//lp.goTo();
		ProductCatalogue productCatalogue= lp.loginApplication("anubhuti1@mail.com", "Anubhuti@1982");
		
		//ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement>products = productCatalogue.getProducts();
		productCatalogue.addProductToCart(productName);
		
		//-------CartPage
		CartPage cp = productCatalogue.goToCartPage();
		Boolean match = cp.prodMatch(productName);
		Assert.assertTrue(match);
			
		//-------- Checkout page
		CheckOutPage chkOut= cp.goToCheckout();
		chkOut.getCountry("Ind");
		ConfirmationPage cnfrmPage= chkOut.goToConfirmationPage();
				
		// -------------Confirmation page			
		String message = cnfrmPage.verifyConfirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.close();
					
	}
}