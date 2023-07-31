package p1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComponentData;

public class CheckOutPage extends AbstractComponentData {

	
	
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//a[normalize-space()='Place Order']")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement counrty;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectcountry;
	

	
	By result = By.cssSelector(".ta-results");
	
	public void selectcountry(String CountryName)
	
	{
		
		Actions a = new Actions(driver);
		a.sendKeys(counrty,CountryName).build().perform();
		
		WaitforElementsappear(result);
		
		selectcountry.click();
	}
	
	public confirmationpage sumbitOrder()
	
	{
		submit.click();
		
		return new confirmationpage(driver);
	}
	
}
