package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import p1.Cartpage;
import p1.OrderPage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponentData {
	
	WebDriver driver;

	
	public AbstractComponentData(WebDriver driver) {
		
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement card;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;

public void WaitforWebElementsappear(WebElement FindBy)
	
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(FindBy));
	}
	
	
	public void WaitforElementsappear(By FindBy)
	
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}

	public void WaitforElementsDisappear(WebElement ele) throws InterruptedException
	
	{
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public Cartpage goTocardPage()
	
	{
		card.click();
		Cartpage ctg=new Cartpage(driver);
		return ctg;
	}
	
	public OrderPage goToOrderPage()
	
	{
		orderHeader.click();
		OrderPage op=new OrderPage(driver);
		return op;
	}
}
