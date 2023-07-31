package p1;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Basecomponent.BaseTest;

public class errorvalidation extends BaseTest {

	@Test(groups= {"Errorhandle"})
	public void LoginErrorValidation() throws IOException, InterruptedException
	{

		
		String ProductName ="ADIDAS ORIGINAL";
		
		
		
       loginpage.loginapplication("Fidato@gmail.com", "12345");
		
		
       Assert.assertEquals("Incorrect email  password.", loginpage.errorvalidation());
	
	}

	@Test
	public void ProductErrorvalidation() throws IOException, InterruptedException
	{

		
		String ProductName ="ADIDAS ORIGINAL";
		
	     ProductCatalogs pc1=loginpage.loginapplication("fateh@gmail.com", "123@Khan");
		
		
		
		List<WebElement>Products=pc1.getproductlist();
		pc1.addproducttocart(ProductName);
		Cartpage ctg=pc1.goTocardPage();
		
		
		
		Boolean match =ctg.VerifyProductsDisplay("ADIDAS ORIGINAL123");
		Assert.assertFalse(match);
}
}
