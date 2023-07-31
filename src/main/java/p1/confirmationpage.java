package p1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentData;

public class confirmationpage extends AbstractComponentData{

	WebDriver driver;
	public confirmationpage(WebDriver driver) {
		super(driver);
		
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	
	}
	
	@FindBy(css=".hero-primary")
	WebElement ConfirmationMsg;
	
	
	public String getConfirmationMesaage()
	
	{
		return ConfirmationMsg.getText();	
	}
	
	

}
