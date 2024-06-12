package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ViewCartPage {

    WebDriver driver;
    
    // WebElement for the cart icon
    @FindBy(xpath = "//a[@title='Cart' and @class='_3RX0a-']")
    private WebElement cartIcon;
    
    // WebElement for the back to homepage icon
    @FindBy(xpath = "//img[@class=\"W5mR4e\"]")
    private WebElement backToHomePage;

    // Constructor
    public ViewCartPage(WebDriver driver) {
        this.driver = driver;
        // Initializing PageFactory elements
        PageFactory.initElements(driver, this);
    }

    // Method to view the cart page
    public void viewCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }
    
    // Method to navigate back to the homepage
    public void homepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(backToHomePage)).click();
    }
    
    // Method to check if the cart icon is displayed
    public boolean isCartIconDisplayed() {
        try {
            return cartIcon.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Method to check if the back to homepage icon is displayed
    public boolean isBackToHomePageIconDisplayed() {
        try {
            return backToHomePage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
