package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.GroceryPage;
import Pages.TestBase;
import Utils.ConfigReader;
import Utils.ReadXLSdata;

public class GroceryTestPage extends TestBase {
    // Initialize Logger
    private static Logger logger = LogManager.getLogger(GroceryTestPage.class);
    GroceryPage groceryPage;

    // Test method to verify Grocery page functionality
    @Test(priority = 3, enabled = true)
    public void testGroceryPage() {
    	// Check if test execution is required
        ReadXLSdata.checkTestExecution("testGroceryPage");
    	
        // Create Extent test for reporting
        test = extent.createTest("Grocery Page Test");

        try {
            // Get URL from config.properties
            String url = ConfigReader.getProperty("url");
            driver.get(url);
            // Log URL navigation
            log(Status.INFO, "Navigated to URL: " + url);
            logger.info("Navigated to URL: " + url);

            // Initialize GroceryPage
            groceryPage = new GroceryPage(driver);

            // Click on Grocery link
            groceryPage.clickGrocery();
            // Log click on Grocery link
            log(Status.INFO, "Clicked on Grocery");
            logger.info("Clicked on Grocery");

            // Click on Current Location
            groceryPage.clickCurrentLocation();
            // Log click on Current Location
            log(Status.INFO, "Clicked on Current Location");
            logger.info("Clicked on Current Location ");

            // Click on Staples
            groceryPage.clickStaples();
            // Log click on Staples
            log(Status.INFO, "Clicked on Staples");
            logger.info("Clicked on Staples");

            // Add item to cart
            groceryPage.addItem();
            // Log item added to cart
            log(Status.INFO, "Added Item to Cart");
            logger.info("Added Item to Cart");

            // View cart item
            groceryPage.viewCartItem();
            // Log view cart item
            log(Status.INFO, "Viewed Cart Item");
            logger.info("Viewed Cart Item");

            // Add an assertion to verify item added to cart
            Assert.assertTrue(groceryPage.isItemAdded(), "Item was not added to the cart.");
        } catch (Exception e) {
            // Log any exceptions during the test
            logger.error("Error occurred during Grocery Page Test: " + e.getMessage());
            test.log(Status.FAIL, "Error occurred during Grocery Page Test: " + e.getMessage());
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
