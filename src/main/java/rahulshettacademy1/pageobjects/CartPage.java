package rahulshettacademy1.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy1.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	//-------CartPage
			WebDriver driver;
			
			@FindBy(css=".cartSection h3")
			List<WebElement>cartProducts;
			
			
			@FindBy(css=".totalRow button")
			WebElement chkOut;
			
			//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
			public CartPage(WebDriver driver)
			{
				super(driver);
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}
			
			public Boolean prodMatch(String productName)
			{
				Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
				return match;
				//Assert.assertTrue(match);
			}
			
			public CheckOutPage goToCheckout()
			{
				//driver.findElement(By.cssSelector(".totalRow button")).click();
				chkOut.click();
				return new CheckOutPage(driver);
			}
	
	
}
