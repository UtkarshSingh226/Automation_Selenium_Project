package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TravelPage {

    WebDriver driver;

    // WebElement for the "Travel" image
    @FindBy(xpath = "//img[@alt=\"Travel\"]")
    private WebElement travelImage;

    // WebElement for the "From" input field
    @FindBy(xpath = "//input[@name='0-departcity']")
    private WebElement fromInputField;

    // WebElement for the "To" input field
    @FindBy(xpath = "//input[@name='0-arrivalcity']")
    private WebElement toInputField;

    // WebElement for the search button
    @FindBy(xpath = "//button[@class='QqFHMw sgUmTV M5XAsp']")
    private WebElement searchButton;

    // Constructor
    public TravelPage(WebDriver driver) {
        this.driver = driver;
        // Initializing PageFactory elements
        PageFactory.initElements(driver, this);
    }

    // Method to navigate to the travel page
    public void getTravelPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(travelImage));
        travelImage.click();
    }

    // Method to check if the "From" input field is displayed
    public boolean isFromInputFieldDisplayed() {
        try {
            return fromInputField.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Method to check if the "To" input field is displayed
    public boolean isToInputFieldDisplayed() {
        try {
            return toInputField.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Method to check if the search button is displayed
    public boolean isSearchButtonDisplayed() {
        try {
            return searchButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
