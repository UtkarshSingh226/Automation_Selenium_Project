package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import Pages.TestBase;
import Pages.AppliancesPage;
import Pages.NavigateMyntraPage;
import Pages.NotificationPage;
import Pages.ShopsyPage;
import Pages.TermsAndConditionsPage;
import Utils.ConfigReader;

public class TestScenario3 extends TestBase {
    private static Logger logger = LogManager.getLogger(TestScenario3.class);

    // Initializing page objects
    ShopsyPage clickShopsy;
    NotificationPage clickDropdown;
    NavigateMyntraPage clickMyntra;
    TermsAndConditionsPage termsPage;
    AppliancesPage offerZone;

    // Test method to verify the functionality of navigating to Shopsy page
    @Test(priority = 9, enabled = true)
    public void testShopsy() {
        test = extent.createTest("Test Shopsy");

        try {
            // Get URL from config.properties
            String url = ConfigReader.getProperty("url");
            driver.get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            // Initialize the shopsyPage object
            clickShopsy = new ShopsyPage(driver);

            // Navigate to Shopsy page
            String shopsyUrl = "https://seller.flipkart.com/shopsy";
            driver.get(shopsyUrl);
            logger.info("Navigated to Shopsy URL: " + shopsyUrl);
            test.log(Status.INFO, "Navigated to Shopsy URL: " + shopsyUrl);

            // Add an assertion to verify the page title or any element on the Shopsy page
            String expectedTitle = "Start Your Business on Shopsy With 0% Commission | Flipkart Seller Hub"; // Example title, replace with actual expected title
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");

            logger.info("Test Shopsy passed");
            test.log(Status.PASS, "Test Shopsy passed");
        } catch (Exception e) {
            logger.error("Test Shopsy failed: " + e.getMessage());
            test.log(Status.FAIL, "Test Shopsy failed: " + e.getMessage());
            Assert.fail("Test Shopsy failed: " + e.getMessage());
        }
    }

    // Test method to verify the functionality of the notification dropdown
    @Test(priority = 10, enabled = true)
    public void testNotification() {
        test = extent.createTest("Test Notification Page");
        try {
            // Get URL from config.properties
            String url = ConfigReader.getProperty("url");

            driver.get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            // Initialize the notificationPage object
            clickDropdown = new NotificationPage(driver);

            // Check if the notification dropdown is displayed
            Assert.assertTrue(clickDropdown.isDropdownDisplayed(), "Notification dropdown is not displayed");

            // Perform actions on the notification dropdown
            clickDropdown.clickDropdown();
            logger.info("Click on the dropdown where notifications are shown");
            test.log(Status.INFO, "Click on the dropdown where notifications are shown");
            
            clickDropdown.clickNotification();
            logger.info("All the notifications are shown");
            test.log(Status.INFO, "All the notifications are shown");
            
            test.pass("Test Notification passed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Test Notification failed: " + e.getMessage());
            Assert.fail("Test Notification failed: " + e.getMessage());
        }
    }

    // Test method to verify the functionality of navigating to Myntra page from Flipkart
    @Test(priority = 11, enabled = true)
    public void testMyntraPage() {
        test = extent.createTest("Test Navigate to Myntra Page from Flipkart");
        try {
            // Get URL from config.properties
            String url = ConfigReader.getProperty("url");
            driver.get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);


            // Initialize the navigateMyntraPage object
            clickMyntra = new NavigateMyntraPage(driver);

            // Check if the Myntra page link is visible
            if (clickMyntra.isMyntraPageLinkVisible()) {
                clickMyntra.clickMyntraPage();
                
                logger.info("Click on the Myntra link");
                test.log(Status.INFO, "Navigated to Myntra Page");

                test.pass("Test Myntra Page passed");
            } else {
                // If the link is not visible, fail the test
                Assert.fail("Myntra page link is not visible");
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Test Myntra Page failed: " + e.getMessage());
            Assert.fail("Test Myntra Page failed: " + e.getMessage());
        }
    }

    // Test method to verify the functionality of the "Terms Of Use" link
    @Test(priority = 12, enabled = true)
    public void testTermsOfUseLink() {
        test = extent.createTest("Test Terms Of Use Link");
        try {
            // Get URL from config.properties
            String url = ConfigReader.getProperty("url");

            driver.get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            termsPage = new TermsAndConditionsPage(driver);

            // Check if the "Terms Of Use" link is visible
            Assert.assertTrue(termsPage.isTermsConditionsLinkVisible(), "Terms Of Use link is not visible");

            // Click on the "Terms Of Use" link
            termsPage.clickTermsCondn();
            logger.info("Click on the Terms And Conditions Page");
            test.log(Status.INFO, "Click on the Terms And Conditions Page");

            // Verify if the new page is opened or not, you can add more verifications here
            String expectedTitle = "Terms Store Online - Buy Terms Online at Best Price in India | Flipkart.com";
            Assert.assertEquals(driver.getTitle(), expectedTitle, "Terms Of Use page is not opened");
            test.pass("Test Terms Of Use Link passed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Test Terms Of Use Link failed: " + e.getMessage());
            Assert.fail("Test Terms Of Use Link failed: " + e.getMessage());
        }
    }

    // Test method to verify the functionality of the offer zone
    @Test(priority = 13, enabled = true)
    public void testOfferZone() {
        test = extent.createTest("Test Offer Zone");
        try {
            // Get URL from config.properties
            String url = ConfigReader.getProperty("url");

            driver.get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            // Initialize the appliancesPage object
            AppliancesPage offerZone = new AppliancesPage(driver);

            // Check if the appliances link is visible
            if (offerZone.isAppliancesLinkVisible()) {
                // Click on the Appliances link
                offerZone.clickAppliances();
                logger.info("Clicked on Appliances link");
                test.log(Status.INFO, "Clicked on Appliances link");

                // Check if the offer zone page link is visible
                if (offerZone.isOfferZonePageLinkVisible()) {
                    // Click on the offer zone page link
                    offerZone.goToOfferZonePage();
                    logger.info("Clicked on Offer Zone Page link");
                    test.log(Status.INFO, "Clicked on Offer Zone Page link");

                    // Check if the offer product page link is visible
                    if (offerZone.isOfferProductPageLinkVisible()) {
                        // Click on the offer product page link
                        offerZone.goToOfferProductPage();
                        logger.info("Clicked on Offer Product Page link");
                        test.log(Status.INFO, "Clicked on Offer Product Page link");

                        test.pass("Test Offer Zone passed");
                    } else {
                        // If the offer product page link is not visible, fail the test
                        Assert.fail("Offer Product Page link is not visible");
                    }
                } else {
                    // If the offer zone page link is not visible, fail the test
                    Assert.fail("Offer Zone Page link is not visible");
                }
            } else {
                // If the appliances link is not visible, fail the test
                Assert.fail("Appliances link is not visible");
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Test Offer Zone failed: " + e.getMessage());
            Assert.fail("Test Offer Zone failed: " + e.getMessage());
        }
    }
    
    // After method to perform actions after each test method
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

