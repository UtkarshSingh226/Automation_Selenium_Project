package Pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import Utils.ExtentManager;
import Utils.WebDriverFactory;

public class TestBase {
    // WebDriver instance to interact with the browser
    protected WebDriver driver;
    
    // ExtentReports instance for generating HTML reports
    protected static ExtentReports extent;
    
    // ExtentTest instance to represent the current test case
    protected ExtentTest test;

    // Method to be executed before the test suite starts
    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentManager.getInstance(); // Initialize ExtentReports
    }

    // Method to be executed before each test method
    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver and maximize the browser window
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.initializeDriver("chrome");
        driver.manage().window().maximize();
        webDriverFactory.globalWait(10); // Set a global wait time
    }

    // Method to be executed after each test method
    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver instance after the test method execution
        if (driver != null) {
            driver.quit();
        }
    }

    // Method to be executed after the test suite completes
    @AfterSuite
    public void afterSuite() {
        // Flush the ExtentReports instance to write all logs to the report
        if (extent != null) {
            extent.flush();
        }
    }

    // Method to log test status and details to the Extent report
    protected void log(Status status, String details) {
        if (test != null) {
            test.log(status, details);
        }
    }

    // Method to capture and save a screenshot
    public void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Convert WebDriver instance to TakesScreenshot instance
            TakesScreenshot ts = (TakesScreenshot) driver;
            
            // Capture screenshot as File
            File source = ts.getScreenshotAs(OutputType.FILE);
            
            // Copy the screenshot to the desired location
            FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));
            
            // Log message confirming screenshot capture
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            // Log exception if there is an error capturing the screenshot
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}
