package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.FlipkartSearchPage;
import Pages.TestBase;
import Pages.ActionsPerformed;
import Pages.ViewCartPage;
import Utils.ReadXLSdata;
import Utils.ConfigReader;

public class TestScenario4 extends TestBase {
    // Logger for logging purposes
    private static Logger logger = LogManager.getLogger(TestScenario4.class);

    // Page objects for test methods
    FlipkartSearchPage actions;
    ViewCartPage backToHome;
    ActionsPerformed giftCard;

    // Test method to verify the compare button functionality
    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata", enabled=true, priority = 14)
    public void testSearch(String searchdata) {
        // Extent report test creation
        test = extent.createTest("Test Compare button is working or not");

        // Get URL from config.properties
        String url = ConfigReader.getProperty("url");

        // Open Flipkart website
        driver.get(url);
        log(Status.INFO, "Navigated to URL: " + url);
        logger.info("Navigated to URL: " + url);

        // Initialize FlipkartSearchPage
        FlipkartSearchPage actions = new FlipkartSearchPage(driver);

        // Perform search
        actions.flipkartSearchBox(searchdata);
        log(Status.INFO, "Enter product to search");
        logger.info("Enter product to search");
        
        actions.searchButton(); 
        log(Status.INFO, " Click on the search button");
        logger.info("Click on the search button");

        try {
            // Check if the "Add to Compare" button is displayed
            Assert.assertTrue(actions.isAddToCompareButtonDisplayed(), "Add to Compare button is not displayed");

            // Click on the "Add to Compare" button
            actions.actionsPerformed();
            log(Status.INFO, " Click on the compare button");
            logger.info("Click on the Add to compare button");
            
            // Check if the "COMPARE" button is displayed
            Assert.assertTrue(actions.isCompareButtonDisplayed(), "COMPARE button is not displayed");
            
            // Click on the "COMPARE" button
            actions.compareBtn();
            log(Status.INFO, "Click to compare ");
            
            // Log test status
            test.pass("Compare button tested successfully to compare two products.");
            logger.info("Compare button tested successfully to compare two products.");
        } catch (NoSuchElementException e) {
            // If the element is not found, fail the test
            test.fail("Element not found: " + e.getMessage());
            logger.info("Element not found");
        }
    }
    
    // Test method to verify the functionality of going back to the homepage from the view cart page
    @Test(priority = 15, enabled = true)
    public void testBackToTome() {
        test = extent.createTest("Test Back To Home from ViewCart");

        // Get URL from config.properties
        String url = ConfigReader.getProperty("url");

        // Open the URL
        driver.get(url);
        test.log(Status.INFO, "Navigated to URL: " + url);
        logger.info("Navigated to URL");
       
        // Initialize viewCartPage
        ViewCartPage backToHome = new ViewCartPage(driver);

        try {
            // Check if the cart icon is displayed
            Assert.assertTrue(backToHome.isCartIconDisplayed(), "Cart icon is not displayed");

            // Click on the cart icon to view the cart page
            backToHome.viewCartPage();
            test.log(Status.INFO, "Clicked on view cart icon successfully");
            logger.info("Clicked on view cart icon successfully");

            // Check if the back to homepage icon is displayed
            Assert.assertTrue(backToHome.isBackToHomePageIconDisplayed(), "Back to home page icon is not displayed");

            // Click on the back to homepage icon
            backToHome.homepage();
            test.log(Status.INFO, "Clicked on Flipkart Plus icon successfully");
            logger.info("Clicked on Flipkart Plus icon successfully");
            
            // Log test status
            test.pass("Successfully go back to homepage by clicking on Flipkart Plus");
            logger.info("Successfully go back to homepage by clicking on Flipkart Plus");
        } catch (NoSuchElementException e) {
            // If the element is not found, fail the test
            test.fail("Element not found: " + e.getMessage());
            logger.info("Element not found");
        }
    }
    
    // Test method to verify the display of the Clear Trip page
    @Test(priority = 16,  enabled = true)
    public void testClearTrip() {
        test = extent.createTest("Test Clear Trip Page");

        // Get URL from config.properties
        String url = ConfigReader.getProperty("url");

        // Open the URL
        driver.get(url);
        test.log(Status.INFO, "Navigated to URL: " + url);
        logger.info("Navigated to URL");

        // Initialize the actionsPerformed object
        ActionsPerformed clearTrip = new ActionsPerformed(driver);

        try {
            // Check if the "Cleartrip" link is displayed
            Assert.assertTrue(clearTrip.isClearTripLinkDisplayed(), "Cleartrip link is not displayed");

            // Click on the "Cleartrip" link
            clearTrip.viewClearTripPage();
            test.log(Status.INFO, " Click on the ClearTrip page");
            logger.info("Click on the ClearTrip page");
            
            // Log test status
            test.pass("Successfully displayed the ClearTrip Page");
            logger.info("Successfully displayed the ClearTrip Page");
        } catch (NoSuchElementException e) {
            // If the element is not found, fail the test
            test.fail("Element not found: " + e.getMessage());
            logger.info("Element not found");
        }
    }
    
    // Test method to verify the display of the Gift Cards page
    @Test(priority = 17, enabled = true)
    public void testGiftCards() {
        test = extent.createTest("Test Gift Cards Page");

        // Get URL from config.properties
        String url = ConfigReader.getProperty("url");

        driver.get(url);
        test.log(Status.INFO, "Navigated to URL: " + url);
        logger.info("Navigated to URL");

        ActionsPerformed giftCard = new ActionsPerformed(driver);

        try {
            // Check if the "Gift Cards" element is displayed
            Assert.assertTrue(giftCard.isGiftCardsElementDisplayed(), "Gift Cards element is not displayed");

            // Click on the "Gift Cards" element
            giftCard.viewGiftCardsPage();
            test.log(Status.INFO, " Click on the GiftCards Page");
            logger.info("Click on the GiftCards Page");
            
            // Check if the image element is displayed
            Assert.assertTrue(giftCard.isImageElementDisplayed(), "Image element is not displayed");

            // Click on the image element
            giftCard.viewAddToWalletPage();
            test.log(Status.INFO, " Click on the wallet");
            logger.info("Click on the wallet");
            
            // Log test status
            test.pass("Wallet Form is successfully shown");
            logger.info("Wallet Form is successfully shown");
        } catch (NoSuchElementException e) {
            // If the element is not found, fail the test
            test.fail("Element not found: " + e.getMessage());
            logger.info("Element not found");
        }
    }
    
    // Test method to verify the display of the Cancellation Policy page
    @Test(priority = 18, enabled = true)
    public void testCancellation() {
        test = extent.createTest("Test Cancellation Policy Page");

        // Get URL from config.properties
        String url = ConfigReader.getProperty("url");

        driver.get(url);
        test.log(Status.INFO, "Navigated to URL: " + url);
        logger.info("Navigated to URL");

        ActionsPerformed cancelPolicy = new ActionsPerformed(driver);

        try {
            // Check if the cancel policy link is displayed
            Assert.assertTrue(cancelPolicy.isCancelPolicyDisplayed(), "Cancel policy link is not displayed");

            // Click on the cancel policy link
            cancelPolicy.viewCancelPolicy();
            test.log(Status.INFO, " Click on the Cancellation Policy Page");
            logger.info("Click on the Cancellation Policy Page");
            
            // Log test status
            test.pass("Order Cancellation Page is successfully showing");
            logger.info("Order Cancellation Page is successfully showing");
        } catch (NoSuchElementException e) {
            // If the element is not found, fail the test
            test.fail("Cancel policy link not found: " + e.getMessage());
            logger.info("Cancel policy link not found");
        }
    }    
    
    // After method to capture screenshots on test failure or skip
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
            test.log(Status.FAIL, "Test failed: " + result.getThrowable());
            test.addScreenCaptureFromPath("./Screenshots/" + result.getName() + ".png");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test skipped: " + result.getName());
        }
    }
}

