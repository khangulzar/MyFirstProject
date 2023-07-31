package p1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentData;

public class ProductCatalogs extends AbstractComponentData{
	
	WebDriver driver;
	
	public ProductCatalogs(WebDriver driver)
	
	{
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	//List<WebElement> Products=driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement>Products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By productby = By.cssSelector(".mb-3");
	By addToCard = By.cssSelector(".fa.fa-shopping-cart");
	By toastMessage =By.cssSelector("#toast-container");
	
	public List<WebElement> getproductlist()
	{
		WaitforElementsappear(productby);
		return Products;
	}
	
	public WebElement getproductbyName(String productname)
	
	{
		WebElement prod=Products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
	}
	
	public void addproducttocart(String productname) throws InterruptedException
	{
		WebElement prod=getproductbyName(productname);
		
		prod.findElement(addToCard).click();
		WaitforElementsappear(toastMessage);
		WaitforElementsDisappear(spinner);
	}
	
}
