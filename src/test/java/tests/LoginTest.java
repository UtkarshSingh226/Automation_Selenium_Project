package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.LoginPage;
import Pages.TestBase;
import Utils.ReadXLSdata;
import Utils.ConfigReader;

public class LoginTest extends TestBase {
    // Initialize Logger
    private static Logger logger = LogManager.getLogger(LoginTest.class);

    // Initialize LoginPage
    LoginPage loginPage;

    // Test method to verify login functionality
    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata", priority = 4, enabled = true)
    public void testLogin(String value) {
        // Create Extent test for reporting
        test = extent.createTest("Login Test with value: " + value);

        try {
            // Get URL from config.properties
            String url = ConfigReader.getProperty("url");
            driver.get(url);
            // Log URL navigation
            log(Status.INFO, "Navigated to URL: " + url);
            logger.info("Navigated to URL: " + url);

            // Initialize LoginPage
            loginPage = new LoginPage(driver);

            // Click on Login link
            loginPage.clickLogin();
            // Log click on Login link
            log(Status.INFO, "Clicked Login");
            logger.info("Clicked Login");

            // Enter username
            loginPage.enterUsername(value);
            // Log entered username
            log(Status.INFO, "Entered Username: " + value);
            logger.info("Entered Username: " + value);

            // Click on Submit button
            loginPage.clickSubmit();
            // Log click on Submit button
            log(Status.INFO, "Clicked Submit");
            logger.info("Clicked Submit");

            // Log test completion
            logger.info("Test completed for value: " + value);
        } catch (Exception e) {
            // Log any exceptions during the test
            logger.error("Error occurred during Login Test: " + e.getMessage());
            test.log(Status.FAIL, "Error occurred during Login Test: " + e.getMessage());
            // Capture screenshot and fail the test
            captureScreenshot(driver, "LoginTestFailure");
            Assert.fail("Test failed: " + e.getMessage());
        }
    }

    // Method to execute after each test method
    @AfterMethod
    public void tearDown(ITestResult result) {
        // Capture screenshot and log test status
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
            test.log(Status.FAIL, "Test failed: " + result.getThrowable());
            test.addScreenCaptureFromPath("./Screenshots/" + result.getName() + ".png");
        } else if (result.getStatus() == ITestResult.SKIP) {
            // Log test skipped status
            test.log(Status.SKIP, "Test skipped: " + result.getName());
        }
    }
}
