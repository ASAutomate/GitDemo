

package rahulshettacademy1.pageobjects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy1.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent
{

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List <WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;              // This will actually have webelements list
	
	@FindBy(css=".ng-animating")
	WebElement Spinner;
	
	By productsBy= By.cssSelector(".mb-3"); // This will have locator of products 
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage =By.cssSelector("#toast-container");
	//By =By.cssSelector(".ng-animating");
	
	public List<WebElement> getProducts()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productname)
	{
		WebElement prod1= products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod1;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		waitForElementToAppear(toastMessage);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		try {
			waitForElementToDisappear();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
}
