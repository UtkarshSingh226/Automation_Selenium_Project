package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.TestBase;
import Pages.AppliancesPage;
import Utils.ConfigReader;

public class AppliancesTestPage extends TestBase {
    // Initialize Logger
    private static final Logger logger = LogManager.getLogger(AppliancesTestPage.class);
    AppliancesPage getAppliancesPage;

    // Test method to verify Appliances page functionality
    @Test(priority = 2, enabled = true)
    public void testAppliancesPage() {
        // Create Extent test for reporting
        test = extent.createTest("Appliances Page Test");

        try {
            // Get URL from config.properties
            String url = ConfigReader.getProperty("url");
            driver.get(url);
            // Log URL navigation
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            // Initialize AppliancesPage
            getAppliancesPage = new AppliancesPage(driver);

            // Check if Appliances link is visible
            try {
                Assert.assertTrue(getAppliancesPage.isAppliancesLinkVisible(), "Appliances link is not visible");
                // Log successful visibility of Appliances link
                logger.info("Appliances link is visible");
                test.log(Status.PASS, "Appliances link is visible");
            } catch (AssertionError e) {
                // Log failure to find Appliances link
                logger.error("Appliances link is not visible: " + e.getMessage());
                test.log(Status.FAIL, "Appliances link is not visible: " + e.getMessage());
                throw e;
            }

            // Click on Appliances link
            getAppliancesPage.clickAppliances();
            // Log click on Appliances link
            logger.info("Clicked on Appliances");
            test.log(Status.INFO, "Clicked on Appliances");

        } catch (Exception e) {
            // Log any exceptions during the test
            logger.error("Error occurred during Appliances Page Test: " + e.getMessage());
            test.log(Status.FAIL, "Error occurred during Appliances Page Test: " + e.getMessage());
            // Fail the test if an exception occurs
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
