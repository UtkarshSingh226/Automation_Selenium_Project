package Pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsPerformed {

    WebDriver driver;
    WebDriverWait wait;

    //Locators to view Cleartrip page
    @FindBy(xpath = "//a[@class=\"HlWMPX\" and text()=\"Cleartrip\"]")
    private WebElement clearTrip;

    // Locators for gift cards page
    @FindBy(xpath = "//span[text()='Gift Cards']")
    WebElement giftCards;

    @FindBy(xpath = "//img[@class='xTaogf _3iTqAS' and @alt='dm']")
    WebElement imageElement;

    // Locator for cancellation policy
    @FindBy(xpath = "//a[@href=\"/pages/returnpolicy?otracker=${otracker}_navlinks\"]")
    WebElement cancelPolicy;

    // Constructor to initialize WebDriver and WebDriverWait
    public ActionsPerformed(WebDriver driver) {
        this.driver = driver;
        // Setting up wait with a timeout of 20 seconds
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Initializing PageFactory elements
        PageFactory.initElements(driver, this);
    }

    // Method to view Cleartrip page
    public void viewClearTripPage() {
        // Wait for the Cleartrip link to be clickable and then click it
        wait.until(ExpectedConditions.elementToBeClickable(clearTrip)).click();
    }

    // Method to view Gift Cards page
    public void viewGiftCardsPage() {
        // Wait for the Gift Cards element to be clickable and then click it
        wait.until(ExpectedConditions.elementToBeClickable(giftCards)).click();
    }

    // Method to view Add to Wallet page
    public void viewAddToWalletPage() {
        // Wait for the Image element to be clickable and then click it
        wait.until(ExpectedConditions.elementToBeClickable(imageElement)).click();
    }

    // Method to view Cancellation Policy
    public void viewCancelPolicy() {
        // Wait for the Cancel Policy link to be clickable and then click it
        wait.until(ExpectedConditions.elementToBeClickable(cancelPolicy)).click();
    }

    // Method to check if Cleartrip link is displayed
    public boolean isClearTripLinkDisplayed() {
        try {
            // Check if Cleartrip link is displayed
            return clearTrip.isDisplayed();
        } catch (NoSuchElementException e) {
            // Return false if NoSuchElementException is caught (element not found)
            return false;
        }
    }

    // Method to check if Gift Cards element is displayed
    public boolean isGiftCardsElementDisplayed() {
        try {
            // Check if Gift Cards element is displayed
            return giftCards.isDisplayed();
        } catch (NoSuchElementException e) {
            // Return false if NoSuchElementException is caught (element not found)
            return false;
        }
    }

    // Method to check if Image element is displayed
    public boolean isImageElementDisplayed() {
        try {
            // Check if Image element is displayed
            return imageElement.isDisplayed();
        } catch (NoSuchElementException e) {
            // Return false if NoSuchElementException is caught (element not found)
            return false;
        }
    }

    // Method to check if Cancellation Policy link is displayed
    public boolean isCancelPolicyDisplayed() {
        try {
            // Check if Cancellation Policy link is displayed
            return cancelPolicy.isDisplayed();
        } catch (NoSuchElementException e) {
            // Return false if NoSuchElementException is caught (element not found)
            return false;
        }
    }
}
