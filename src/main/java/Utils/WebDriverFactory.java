package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
    private static WebDriver driver = null;

    // Method to create a new WebDriver instance
    public WebDriver createDriver() {
        return new ChromeDriver();
    }

    // Method to initialize the WebDriver based on the browser name
    public WebDriver initializeDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\utkarshsingh01\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("ie") || browserName.equalsIgnoreCase("internet explorer")) {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\utkarshsingh01\\Downloads\\IEDriverServer_x64_4.14.0\\IEDriverServer.exe");
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
