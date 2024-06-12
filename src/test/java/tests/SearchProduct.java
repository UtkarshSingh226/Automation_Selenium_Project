package tests;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pages.FlipkartSearchPage;
import Pages.TestBase;
import Utils.ReadXLSdata;
import Utils.ConfigReader;
import com.aventstack.extentreports.Status;

public class SearchProduct extends TestBase {
    // Initialize Logger
    private static final Logger logger = LogManager.getLogger(SearchProduct.class);
    FlipkartSearchPage searchPage;

    // Test method to verify search functionality on Flipkart website
    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata", priority = 6, enabled = true)
    public void testSearch(String searchData) {
        // Create Extent test for reporting
        test = extent.createTest("Search Product Test");

        try {
            // Get URL from config.properties
            String url = ConfigReader.getProperty("url");

            // Open Flipkart website
            driver.get(url);
            // Log URL navigation
            logger.info("Launching browser");
            test.log(Status.INFO, "Launching browser");

            // Initialize FlipkartSearchPage
            searchPage = new FlipkartSearchPage(driver);

            // Perform search
            searchPage.flipkartSearchBox(searchData);
            // Log search action
            logger.info("Performed search for: " + searchData);
            test.log(Status.INFO, "Performed search for: " + searchData);

            // Assert if search button is displayed
            assertTrue(searchPage.isSubmitbtnDisplayed(), "Search button is not displayed");
            // Click on search button
            searchPage.searchButton();
            // Log search button click
            logger.info("Click on the search button");
            test.log(Status.INFO, "Click on the search button");

            // Log successful search
            logger.info("Search product successful");
            test.log(Status.PASS, "Search product successful");
        } catch (Exception e) {
            // Log any exceptions during the test
            logger.error("Error occurred during search: " + e.getMessage());
            test.log(Status.FAIL, "Error occurred during search: " + e.getMessage());
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
