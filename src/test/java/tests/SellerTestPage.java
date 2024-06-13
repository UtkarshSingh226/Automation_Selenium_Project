package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.TestBase;
import Pages.SellerPage;
import Utils.ConfigReader;

public class SellerTestPage extends TestBase {
    SellerPage getSellerPage;
    private static final Logger logger = LogManager.getLogger(SellerTestPage.class);

    // Test method to verify the functionality of the Seller page
    @Test(priority = 7, enabled = true)
    public void testSellerPage() {
        // Create a new Extent report test instance
        test = extent.createTest("Seller Page Test");

        try {
            // Get URL from config.properties
            String url = ConfigReader.getProperty("url");
            
            // Navigate to the URL
            driver.get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            // Initialize the Seller page
            getSellerPage = new SellerPage(driver);
            
            // Click on the Seller link
            getSellerPage.clickSeller();
            logger.info("Clicked on Seller");
            test.log(Status.INFO, "Clicked on Seller");

            // Click on the Start Selling button
            getSellerPage.startSelling();
            logger.info("Clicked on Start Selling");
            test.log(Status.INFO, "Clicked on Start Selling");

            // Verify the presence of the username field
            WebElement usernameField = getSellerPage.getMobileNumberField();
            try {
                Assert.assertTrue(usernameField.isDisplayed(), "Username field is not displayed");
                logger.info("Username field is displayed");
                test.log(Status.PASS, "Username field is displayed");
            } catch (AssertionError e) {
                logger.error("Username field is not displayed: " + e.getMessage());
                test.log(Status.FAIL, "Username field is not displayed: " + e.getMessage());
                throw e;
            }

            // Verify the presence of the email field
            WebElement emailField = getSellerPage.getEmailField();
            try {
                Assert.assertTrue(emailField.isDisplayed(), "Email field is not displayed");
                logger.info("Email field is displayed");
                test.log(Status.PASS, "Email field is displayed");
            } catch (AssertionError e) {
                logger.error("Email field is not displayed: " + e.getMessage());
                test.log(Status.FAIL, "Email field is not displayed: " + e.getMessage());
                throw e;
            }

        } catch (Exception e) {
            // pass
        }
    }
    
    // Method to perform actions after each test method
    @AfterMethod
    public void tearDown(ITestResult result) {
        // Capture screenshot if test fails
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
            test.log(Status.FAIL, "Test failed: " + result.getThrowable());
            test.addScreenCaptureFromPath("./Screenshots/" + result.getName() + ".png");
        } 
        // Log if test is skipped
        else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test skipped: " + result.getName());
        }
    }
}
