package rahulshettacademy1.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy1.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent 
{
	WebDriver driver;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement dd_ctry;
	
	@FindBy(css=".ta-item.list-group-item.ng-star-inserted")
	List <WebElement> ctry_dropdown;
	
	@FindBy(css=".action__submit")
	WebElement btn_submit;
	
	
	//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void getCountry(String ct)
	{
		dd_ctry.sendKeys(ct);
		WebElement ctry1= ctry_dropdown.stream().filter(ctry->ctry.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		ctry1.click();
		
	}
	
	public ConfirmationPage goToConfirmationPage()
	{
		btn_submit.click();
		return new ConfirmationPage(driver);
		
	}
	//driver.findElement(By.cssSelector(".action__submit")).click();
	
	//driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("Ind");

	// = driver.findElements(By.cssSelector()); 
	
	//WebElement ctry= 
	
}
