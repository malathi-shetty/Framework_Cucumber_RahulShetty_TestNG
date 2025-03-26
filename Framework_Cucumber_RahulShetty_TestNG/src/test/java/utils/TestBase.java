package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//globalConfig.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		//result = testCondition ? value1 : value:2 // java ternary code - value1 true : value2: false will store in result
		
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		
		
		if(driver == null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
		// WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
			}
			if(browser.equalsIgnoreCase("firefox"))
			{
		// WebDriverManager.firefoxdriver().setup();
	     driver = new FirefoxDriver();
			}
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     driver.get(url);
			
		}
	     return driver;
		
	}

}
