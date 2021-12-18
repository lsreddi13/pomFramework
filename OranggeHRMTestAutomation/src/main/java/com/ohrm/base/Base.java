package com.ohrm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	public static Properties prop;
	
	public Base() throws IOException {		
		prop = new Properties();
		String filePath= ".//src//main//java//com//ohrm//config//config.properties";
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);		
	}
	
	public static void initialize() {
		String browserName = prop.getProperty("browser");
		//switch controlelr // if condition 		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		}
		if(browserName.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}
		if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}
		if(browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}
		//maximize window
		driver.manage().window().maximize();
		//delete cookies
		driver.manage().deleteAllCookies();		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	public void takeScreenshot() {
		
	}
	
	public void readDataXLS() {
		
		
	}
	
	
	
}
