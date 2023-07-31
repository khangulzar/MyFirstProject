package p1;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Basecomponent.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest {

	String productName ="IPHONE 13 PRO";
	
	
	@Test(dataProvider= "getData",groups="submitorder")
	public void submitordertest(HashMap<String,String> input) throws IOException, InterruptedException
	{

		ProductCatalogs pc1=loginpage.loginapplication(input.get("email"), input.get("password"));
		
		
		
		List<WebElement>Products=pc1.getproductlist();
		pc1.addproducttocart(input.get("product"));
		Cartpage ctg=pc1.goTocardPage();
		
		
		
		Boolean match =ctg.VerifyProductsDisplay(input.get("input.get(\"email\"), input.get(\"password\")"));
		Assert.assertTrue(match);
		CheckOutPage choutpage =ctg.GoToCheckOut();
		choutpage.selectcountry("india");
		
		confirmationpage cmp=choutpage.sumbitOrder();
		
		
	
		
		String confirmmsg = cmp.getConfirmationMesaage(); 
		Assert.assertTrue(confirmmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		Thread.sleep(2000);
		
		System.out.println(confirmmsg);
			
	}
	
	@Test(dependsOnMethods= {"submitordertest"})
	public void orderhistory(HashMap<String,String> input) throws InterruptedException
	{
		ProductCatalogs pc1=loginpage.loginapplication(input.get("Fidato@gmail.com"), input.get("123@Khan"));
		
		OrderPage op=	pc1.goToOrderPage();
		
		Assert.assertTrue(op.VerifyOrderDisplay(input.get(productName)));
		Thread.sleep(2000);
	}
	
	
	
	
	//Dataprovider using hashmap
	@DataProvider
	public Object[][] getData() throws IOException
	{
	/*	HashMap <String,String> map = new HashMap<String,String>();
		
		map.put("email", "Fidato@gmail.com");
		map.put("password", "123@Khan");
		map.put("product", "ADIDAS ORIGINAL");
		
	HashMap map1 = new HashMap();
		
		map1.put("email", "fateh@gmail.com");
		map1.put("password", "123@Khan");
		map1.put("product", "IPHONE 13 PRO");
		*/
		
		List<HashMap<String,String>> data =  getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\data\\purchaseData.json");
		
		return new Object[][ ] {{data.get(0)},{data.get(1)}};
		
		
	}
	
	//sending data using dataprovider
	/*@DataProvider
	public Object[][] getData()
	{
		return new Object[][ ] {{"Fidato@gmail.com","123@Khan","ADIDAS ORIGINAL"},{"fateh@gmail.com","123@Khan","IPHONE 13 PRO"}};
	}
	*/

}
	