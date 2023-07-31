package Basecomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import p1.LandingLoginPage;



public class BaseTest {
	
	public WebDriver driver;
	public LandingLoginPage loginpage;
	
	public WebDriver initializeDriver() throws IOException
	
	{
	Properties pro = new Properties();
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src/main//java/Resource//GlobalData.properties");
	
	pro.load(fis);
	String browserName =pro.getProperty("Browser");
	
	
	
	if(browserName.equalsIgnoreCase("chrome"))
	
	{
	
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 }
	
	
	else if(browserName.equalsIgnoreCase("firefox"))	
	{
		
	}
	
	else if(browserName.equalsIgnoreCase("edge"))
	{
		
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
	}
	
public List<HashMap<String,String>> getJsonData(String FilePath) throws IOException 
	
	{
		String JsonContent = FileUtils.readFileToString(new File(FilePath),
				StandardCharsets.UTF_8);
	
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>()
		{});
		return data;
		
	}
	
public  String TakeScreenshort(String testcaseName) throws IOException

{
	TakesScreenshot  ts = (TakesScreenshot)driver;
	File Source = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(("user.dir") + "//reports//" + testcaseName +".png");
	FileUtils.copyFile(Source, file);
	return (("user.dir") + "//reports//" + testcaseName +".png");
	
}
	@BeforeMethod(alwaysRun=true)
	
	public LandingLoginPage  LaunchApplication() throws IOException
	{
		driver=initializeDriver();
		 loginpage = new LandingLoginPage(driver);
		loginpage.goTo();
		return loginpage;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void closedDriver()
	
	{
		driver.close();
	}
	
	

	}
	



