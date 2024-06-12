package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NotificationPage {

    WebDriver driver;
    WebDriverWait wait;

    // WebElement for the "More Help" dropdown
    @FindBy(xpath = "//img[@class='-dOa_b']")
    private WebElement moreHelpDropdown;
    
    // WebElement for the "Notification Preferences" link
    @FindBy(xpath = "//li[@class=\"AT0fUR\" and text()=\"Notification Preferences\"]")
    private WebElement notificationPreferencesImage;

    // Constructor
    public NotificationPage(WebDriver driver) {
        this.driver = driver;
        // Initializing WebDriverWait with a timeout of 20 seconds
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Initializing PageFactory elements
        PageFactory.initElements(driver, this);
    }
    
    // Method to click on the "More Help" dropdown
    public void clickDropdown() {
        moreHelpDropdown.click();
    }
    
    // Method to click on the "Notification Preferences" link
    public void clickNotification() {
        notificationPreferencesImage.click();
    }

    // Method to check if the "More Help" dropdown is displayed
    public boolean isDropdownDisplayed() {
        try {
            // Wait until the "More Help" dropdown is visible
            wait.until(ExpectedConditions.visibilityOf(moreHelpDropdown));
            return true; // If the element is visible, return true
        } catch (TimeoutException e) {
            return false; // If the element is not visible within the timeout period, return false
        }
    }   
}
