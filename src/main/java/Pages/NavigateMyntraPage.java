package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NavigateMyntraPage {

    WebDriver driver;
    WebDriverWait wait;

    // WebElement for the Myntra link
    @FindBy(xpath = "//a[@class=\"HlWMPX\" and text()=\"Myntra\"]")
    private WebElement clickMyntra;

    // Constructor
    public NavigateMyntraPage(WebDriver driver) {
        this.driver = driver;
        // Initializing WebDriverWait with a timeout of 20 seconds
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Initializing PageFactory elements
        PageFactory.initElements(driver, this);
    }

    // Method to click on the Myntra link
    public void clickMyntraPage() {
        clickMyntra.click();
    }

    // Method to check if the Myntra link is visible
    public boolean isMyntraPageLinkVisible() {
        try {
            // Wait until the Myntra link is visible
            wait.until(ExpectedConditions.visibilityOf(clickMyntra));
            return true; // If the element is visible, return true
        } catch (TimeoutException e) {
            return false; // If the element is not visible within the timeout period, return false
        }
    }
}
