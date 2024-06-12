package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.SignUpPage;
import Pages.TestBase;
import Utils.ConfigReader;

public class SignupTest extends TestBase {
    private static final Logger logger = LogManager.getLogger(SignupTest.class);
    SignUpPage signUpPage;

    // Test method to verify the functionality of the sign-up process
    @Test(priority = 8, enabled = true)
    public void testSignUp() {
        // Create a new Extent report test instance
        test = extent.createTest("Sign Up Test");

        try {
            // Get URL from config.properties
            String url = ConfigReader.getProperty("url");

            // Open sign-up page
            driver.get(url);
            logger.info("Launching browser");
            test.log(Status.INFO, "Launching browser");

            // Initialize SignUpPage
            signUpPage = new SignUpPage(driver);

            // Perform sign-up process
            signUpPage.clickLogin();
            test.log(Status.PASS, "Clicked on the signup link");
            logger.info("Clicked on the signup link");
            
            signUpPage.clickCreateAccountLink();
            test.log(Status.PASS, "Clicked on Create new account link");
            logger.info("Clicked on Create new account link");
            
            signUpPage.setInputValue("9452271671");
            test.log(Status.PASS, "Entered the phone number to register");
            logger.info("Entered the phone number to register");
            
            signUpPage.clickContinueButton();
            test.log(Status.PASS, "Clicked on continue and sign up is successful");
            logger.info("Sign up successful");

            // Assertion to check if the "Continue" button is clickable
            Assert.assertTrue(signUpPage.isContinueButtonClickable(), "Continue button is not clickable");

        } catch (Exception e) {
            logger.error("Error occurred while performing sign up: " + e.getMessage());
            test.log(Status.FAIL, "Error occurred while performing sign up: " + e.getMessage());
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
