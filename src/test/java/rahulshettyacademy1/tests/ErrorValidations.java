package rahulshettyacademy1.tests;

import org.testng.Assert;

import rahulshettacademy1.pageobjects.ProductCatalogue;
import rahulshettyacademy1.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest 
{
        public void LoginErrorValidation()
        {
        	//LandingPage lp = 
        	String productName ="ZARA COAT 3";
        	lp.loginApplication("anubhuti@mail.com", "Anubhuti@1982");
        	Assert.assertEquals("Incorrect email or psswd", lp);
        }
        
        public void ProductErrorValidation()
        {
        	
        }
}
