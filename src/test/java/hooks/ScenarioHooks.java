package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ScenarioHooks extends Base {

	@Before
	public void setup()
	{
		try {
			
		WebDriver driver;
		
		String browser=getData("browser");
		 
		System.out.println("java -jar src/main/resources/selenium-server-4.51.0.jar standalone");
		
		if(browser.equals("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),options);
		}
		else if(browser.equals("firefox"))
		{
			FirefoxOptions options=new FirefoxOptions();
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),options);
		}
		else
		{
			EdgeOptions options=new EdgeOptions();
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),options);
		}

		driver.manage().window().maximize();
		setDriver(driver);
	}
	catch (Exception ex) {
		// TODO Auto-generated catch block
		System.out.println(ex.getMessage());}
}

	     
	@After
	public void teardown(Scenario scenario)
	{
		
			if(!scenario.isFailed())
			
				{byte[] screenshot=((TakesScreenshot)
						getDriver()).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
			
			getDriver().quit();
				}
		
	}
}
