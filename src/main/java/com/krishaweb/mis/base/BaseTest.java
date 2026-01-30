package com.krishaweb.mis.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // driver = new ChromeDriver();
        // driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        options.addArguments("--headless=new");   // REQUIRED
        options.addArguments("--no-sandbox");     // REQUIRED for GitHub Actions
        options.addArguments("--disable-dev-shm-usage"); // Prevent crashes
        options.addArguments("--disable-gpu");    // Linux safety
        options.addArguments("--window-size=1920,1080");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
