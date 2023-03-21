package genericPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

public class BaseTest implements IAutoConstant{
	protected static WebDriver driver;
	@BeforeMethod
	public void setUp() throws IOException 
	{
		Flib flib = new Flib();
		String browserValue = flib.readPropertyData(PROP_PATH,"Browser");
		String url = flib.readPropertyData(PROP_PATH, "Url");
		
		if (browserValue.equalsIgnoreCase("chrome")) 
		{
			System.setProperty(CHROME_KEY, CHROME_PATH);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.get(url);
		}
		else if (browserValue.equalsIgnoreCase("edge")) 
		{
			System.setProperty(EDGE_KEY, EDGE_PATH);
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.get(url);
			
		}
		else
		{
			Reporter.log("invalid browser!!!",true);
		}
	}
	
	   public void failed(String methodName)
	   {
		   
		   try 
		   {
			   TakesScreenshot ts = (TakesScreenshot) driver;
			   File src = ts.getScreenshotAs(OutputType.FILE);
			   File dest = new File(SCREENSHOT_PATH+methodName+".png");
			   Files.copy(src, dest);
		   } 
		   
		   catch (Exception e) 
		   {
			// To DO Handle Exception
		}
	   }
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
