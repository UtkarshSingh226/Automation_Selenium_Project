package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AppliancesPage {

    WebDriver driver;
    private WebDriverWait wait;
    
    // Locators to test appliances page
    @FindBy(xpath = "//img[@alt=\"Appliances\"]")
    private WebElement appliancesLink;
    
    @FindBy(xpath = "//img[@class=\"xTaogf _3iTqAS\" and @alt=\"SDF\"]")
    private WebElement openProduct;
    
    @FindBy(css = "div.KzDlHZ")  
    private WebElement samsungTVElement;

    @FindBy(xpath= "//span[text()=\"Share\"]")
    private WebElement shareButton;
    
    // Locators for testcase Offerzone
    @FindBy(xpath= "//a[@class=\"TSD49J\" and text()=\"Offer Zone\"]")
    private WebElement offerZoneLink;
    
    @FindBy(xpath = "//img[@alt='Apple iPads (Shop Now!)']")
    WebElement ipadImage;

    // Constructor
    public AppliancesPage(WebDriver driver) {
        this.driver = driver;
        // Initializing WebDriverWait with a timeout of 20 seconds
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Initializing PageFactory elements
        PageFactory.initElements(driver, this);
    }

    // Method to click on Appliances link
    public void clickAppliances() {
        wait.until(ExpectedConditions.elementToBeClickable(appliancesLink)).click();
    }

    // Method to click on a product
    public void clickProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(openProduct)).click();
    }

    // Method to click on a TV product
    public void clickTv() {
        wait.until(ExpectedConditions.elementToBeClickable(samsungTVElement)).click();
    }

    // Method to click on Share button
    public void clickShare() {
        wait.until(ExpectedConditions.elementToBeClickable(shareButton)).click();
    }

    // Method to navigate to Offer Zone page
    public void goToOfferZonePage() {
        wait.until(ExpectedConditions.elementToBeClickable(offerZoneLink)).click();
    }

    // Method to navigate to Offer Product page
    public void goToOfferProductPage() {
        wait.until(ExpectedConditions.elementToBeClickable(ipadImage)).click();
    }

    // Method to check if Appliances link is visible
    public boolean isAppliancesLinkVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(appliancesLink));
            return true; // If the element is visible, return true
        } catch (TimeoutException e) {
            return false; // If the element is not visible within the timeout period, return false
        }
    }

    // Method to check if Offer Zone link is visible
    public boolean isOfferZonePageLinkVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(offerZoneLink));
            return true; // If the element is visible, return true
        } catch (TimeoutException e) {
            return false; // If the element is not visible within the timeout period, return false
        }
    }

    // Method to check if Offer Product page link is visible
    public boolean isOfferProductPageLinkVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ipadImage));
            return true; // If the element is visible, return true
        } catch (TimeoutException e) {
            return false; // If the element is not visible within the timeout period, return false
        }
    }
}
