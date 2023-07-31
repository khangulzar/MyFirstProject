package p1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentData;

public class Cartpage extends AbstractComponentData {

	WebDriver driver;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement CheckOut;
	
	
	public Cartpage(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public Boolean VerifyProductsDisplay(String ProductName)
	
	{
		Boolean match=	cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
	    return match;
	}
	
	
	public CheckOutPage GoToCheckOut()
	
	
	{
		CheckOut.click();
		return new CheckOutPage(driver);
	}
	
}
