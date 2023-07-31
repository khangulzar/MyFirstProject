package p1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentData;

public class LandingLoginPage extends AbstractComponentData{
	
	WebDriver driver;
	
	public LandingLoginPage(WebDriver driver)
	
	{
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	//div[class='ng-tns-c4-16 toast-message ng-star-inserted']
	//.ng-tns-c4-18.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	@FindBy(css="[class*='flyInOut']")
	WebElement errorvalidation;
	
	@FindBy(id="userEmail")
	WebElement UserName;
	
	@FindBy(id="userPassword")
	WebElement pass;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	
	public ProductCatalogs loginapplication(String email,String password)
	
	{
		UserName.sendKeys(email);
		pass.sendKeys(password);
		submit.click();
		
		ProductCatalogs pc1 = new ProductCatalogs(driver);
		return pc1;
	}
	
	public String errorvalidation()
	{
		
		WaitforWebElementsappear(errorvalidation);
		return errorvalidation.getText();
		
	}
	public void goTo()
	{
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
}
