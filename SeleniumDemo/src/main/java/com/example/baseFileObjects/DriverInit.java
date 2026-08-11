package com.example.baseFileObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInit{

	WebDriverWait wait;
	private WebDriver driver;
	protected Properties prop;
	private static DriverInit INSTANCE = null;

	public WebDriver getDriver() {
		return this.driver;
	}

	public DriverInit() {
		Properties prop = BaseTest.initProperties();
		String Browser = prop.getProperty("browser");
		if (Browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (Browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	public String getInitURL() {
		Properties prop = BaseTest.initProperties();
		return prop.getProperty("url");
	}
}
