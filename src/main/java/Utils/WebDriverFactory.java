package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class WebDriverFactory {
    private static WebDriver driver = null;

    // Method to create a new WebDriver instance
    public WebDriver createDriver() {
        return new ChromeDriver();
    }

    // Method to initialize the WebDriver based on the browser name
    @SuppressWarnings("deprecation")
    public WebDriver initializeDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            // Setup ChromeDriver using WebDriverManager
            // WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            // Uncomment the line below to run Chrome in headless mode
            // options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("ie") || browserName.equalsIgnoreCase("internet explorer")) {
            // Setup InternetExplorerDriver using WebDriverManager
            // WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser name provided");
        }

        // Set implicit wait for WebDriver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    // Method to set a global wait time for the WebDriver
    @SuppressWarnings("deprecation")
    public void globalWait(int globalWaitTime) {
        driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
    }

    // Method to get the WebDriver instance
    public static WebDriver getDriver() {
        return driver;
    }
}
