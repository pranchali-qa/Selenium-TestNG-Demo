package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.example.baseFileObjects.BaseTest;
import com.example.baseFileObjects.DriverInit;
import com.example.login.loginPage;
import org.testng.Assert;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loginTest extends BaseTest {
    
    private static final Logger log = LogManager.getLogger(loginTest.class);
	private WebDriverWait wait;
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new DriverInit().getDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		loginObject = new loginPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
	public void cleanUp() {
		driver.quit();
	}

    loginPage loginObject = new loginPage(driver);

    @Test(priority = 1, description = "This is test 1")
    public void loginTest1() throws InterruptedException {
        
        prop = initProperties();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		loginObject = new loginPage(driver);
		String username = System.getenv("USERNAME");
		String password = System.getenv("ACCESS_KEY");
		System.out.println("password "+password);
		System.out.println("username "+username);

		log.info("Enter Username");
		// loginObject.enterUserName(prop.getProperty("username"), wait);
		loginObject.enterUserName(username, wait);
		log.info("Enter Password");
		// loginObject.enterPassword(prop.getProperty("password"), wait);
        loginObject.enterPassword(password, wait);
		loginObject.clickOnSignInBtn(wait);
		log.info("Click on log in button.");
		System.out.println("Login with valid credentials succeeded");
        Assert.assertTrue(true, "Login with valid credentials succeeded");
    }
}
