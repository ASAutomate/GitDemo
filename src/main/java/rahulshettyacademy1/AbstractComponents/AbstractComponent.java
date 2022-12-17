
package rahulshettyacademy1.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettacademy1.pageobjects.CartPage;

public class AbstractComponent {

	WebDriver driver;
	
	@FindBy(css="[routerLink*='cart']")
	WebElement cartHeader;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void waitForElementToAppear(By FindBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public CartPage goToCartPage()
	{
		//driver.findElement(By.cssSelector("[routerLink*='cart']")).click();
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public void waitForElementToDisappear() throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
		Thread.sleep(1000);
	}
	
	
	
	
}
