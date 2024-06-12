package Pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TermsAndConditionsPage {

    WebDriver driver;
    
    // WebElement for the "Terms Of Use" link
    @FindBy(xpath = "//a[@class=\"HlWMPX\" and text()=\"Terms Of Use\"]")
    WebElement termsConditions;
    
    // Constructor
    public TermsAndConditionsPage(WebDriver driver) {
        this.driver = driver;
        // Initializing PageFactory elements
        PageFactory.initElements(driver, this);
    }
    
    // Method to click on the "Terms Of Use" link
    public void clickTermsCondn() {
        // Wait for the "Terms Of Use" link to be visible and then click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(termsConditions));
        termsConditions.click();
    }

    // Method to check if the "Terms Of Use" link is visible
    public boolean isTermsConditionsLinkVisible() {
        try {
            // Wait for the "Terms Of Use" link to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(termsConditions));
            return true; // If the element is visible, return true
        } catch (TimeoutException e) {
            return false; // If the element is not visible within the timeout period, return false
        }
    }
}
