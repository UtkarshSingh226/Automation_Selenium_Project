package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.MobilesPage;
import Pages.TestBase;
import Utils.ConfigReader;

public class MobilePageTest extends TestBase {
    // Initialize Logger
    private static final Logger logger = LogManager.getLogger(MobilePageTest.class);

    // Initialize mobilesPage
    MobilesPage getMobilePage;

    // Test method to verify functionality of the Mobile page
    @Test(priority = 5, enabled = true)
    public void testMobilePage() {
        // Create Extent test for reporting
        test = extent.createTest("Mobile Page Test");

        try {
            // Get URL from config.properties
            String url = ConfigReader.getProperty("url");
            driver.get(url);
            // Log URL navigation
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            // Initialize mobilesPage
            getMobilePage = new MobilesPage(driver);

            // Check if Mobile image is Clickable
            Assert.assertTrue(getMobilePage.isMobilesImageClickable(), "Mobiles image is not clickable");
            // Log Mobile image Clickability
            logger.info("Mobiles image is clickable");
            test.log(Status.PASS, "Mobiles image is clickable");

            // Click on Mobile Image
            getMobilePage.clickMobilesImage();
            // Log click on Mobile Image
            logger.info("Clicked on Mobiles Image");
            test.log(Status.INFO, "Clicked on Mobiles Image");
        } catch (Exception e) {
            // Log any exceptions during the test
            logger.error("Error occurred while performing Mobile Page test: " + e.getMessage());
            test.log(Status.FAIL, "Error occurred while performing Mobile Page test: " + e.getMessage());
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
