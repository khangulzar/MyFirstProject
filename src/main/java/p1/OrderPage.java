package p1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentData;

public class OrderPage extends AbstractComponentData {

	WebDriver driver;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ProductsNames;
	
	@FindBy(css=".totalRow button")
	WebElement CheckOut;
	
	
	public OrderPage(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public Boolean VerifyOrderDisplay(String ProductName)
	
	{
		Boolean match=	ProductsNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
	    return match;
	}
	
	

	
}
