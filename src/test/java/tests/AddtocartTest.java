package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.AddToCart;
import Pages.TestBase;
import Utils.ReadXLSdata;
import Utils.ConfigReader;

public class AddtocartTest extends TestBase {
    // Initialize Logger
    private static Logger logger = LogManager.getLogger(AddtocartTest.class);  
    AddToCart addToCartPage;

    // Test method to verify adding a product to the cart
    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata", priority = 1, enabled = true)
    public void testSearch(String searchdata) {
        // Create Extent test for reporting
        test = extent.createTest("Add to Cart Test");

        // Get URL from config.properties
        String url = ConfigReader.getProperty("url");
        driver.get(url);
        // Log URL navigation
        test.log(Status.INFO, "Navigated to URL: " + url);
        logger.info("Navigated to URL: " + url);

        // Initialize AddtoCart page
        addToCartPage = new AddToCart(driver);

        // Perform search
        addToCartPage.searchForProduct(searchdata);
        // Log search data
        test.log(Status.INFO, "Entered search data: " + searchdata);
        logger.info("Entered search data: " + searchdata);

        // Select the product
        addToCartPage.selectProduct();
        // Log product selection
        test.log(Status.INFO, "Selected the product");
        logger.info("Selected the product");

        // Add an assertion to verify product added to cart
        Assert.assertFalse(addToCartPage.isProductAdded(), "Product was added to the cart unexpectedly.");
        // Log success status
        test.log(Status.PASS, "Product was successfully added to the cart.");
        logger.info("Product was successfully added to the cart.");
    }

    // Method to execute after each test method
    @AfterMethod
    public void tearDown(ITestResult result) {
        // Capture screenshot and log test status
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
            // Log test failure status
            test.log(Status.FAIL, "Test failed: " + result.getThrowable());
            test.addScreenCaptureFromPath("./Screenshots/" + result.getName() + ".png");
            logger.error("Test failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            // Log test skipped status
            test.log(Status.SKIP, "Test skipped: " + result.getName());
            logger.warn("Test skipped: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            // Log test success status
            test.log(Status.PASS, "Test passed: " + result.getName());
            logger.info("Test passed: " + result.getName());
        }
    }
}
