package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MobilesPage {

    WebDriver driver;
    
    // WebElement for the mobiles image
    @FindBy(xpath = "//img[@class=\"_2puWtW _3a3qyb\" and @alt=\"Mobiles\"]")
    private WebElement mobilesImage;
    
    // Constructor
    public MobilesPage(WebDriver driver) {
        this.driver = driver;
        // Initializing PageFactory elements
        PageFactory.initElements(driver, this);
    }

    // Method to click on the mobiles image
    public void clickMobilesImage() {
        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Wait for the mobiles image to be clickable and then click it
        wait.until(ExpectedConditions.elementToBeClickable(mobilesImage)).click();
    }
    
    // Method to verify if the mobiles image is clickable
    public boolean isMobilesImageClickable() {
        try {
            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            // Wait for the mobiles image to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(mobilesImage));
            return true; // If the element is clickable, return true
        } catch (Exception e) {
            return false; // If an exception occurs or the element is not clickable, return false
        }
    }
}
