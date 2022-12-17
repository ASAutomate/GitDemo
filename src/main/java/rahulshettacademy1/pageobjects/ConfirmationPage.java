package rahulshettacademy1.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy1.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	WebDriver driver;
	
	@FindBy(css=".hero-primary")
	WebElement mssgConfirm ;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	
	}
	
	public String verifyConfirmationMessage()
	{
		//String message = driver.findElement(By.cssSelector(".hero-primary")).getText();
		return mssgConfirm.getText();
		
		//return ConfirmationPage();
	}

	
}
