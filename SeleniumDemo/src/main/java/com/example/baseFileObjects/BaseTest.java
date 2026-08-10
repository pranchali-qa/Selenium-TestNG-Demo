package com.example.baseFileObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected Properties prop = initProperties();
	private static final Logger log = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;

	public static Properties initProperties() {
		Properties prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
			        System.getProperty("user.dir") + "\\TestData\\TestData.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			log.error("File not found at the given location");
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return prop;
	}
}
