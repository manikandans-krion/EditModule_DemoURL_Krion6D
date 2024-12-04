package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWebDriverManager {
    private static WebDriver driver;
   // private static final String BASE_URL = "https://tiger.krion6d.com/login"; // Direct URL

    private static final String BASE_URL = "https://demo.krion6d.com/login";
    
    // Method to get the WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            // Setup Chrome WebDriver using WebDriverManager
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            // No headless mode

            // Initialize ChromeDriver with the appropriate options
            driver = new ChromeDriver(options);

            // Directly get the base URL
            driver.get(BASE_URL);

            // Maximize the browser window
            driver.manage().window().maximize();
        }
        return driver;
    }  
    }
