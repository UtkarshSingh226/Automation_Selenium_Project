package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GroceryPage {

    WebDriver driver;
    WebDriverWait wait;

    // WebElement for grocery image
    @FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[10]/div/div/div/div/img")
    private WebElement groceryImage;

    // WebElement for current location button
    @FindBy(className = "QqFHMw")
    private WebElement currentLocationButton;
   
    // WebElement for staples image
    @FindBy(xpath = "//img[@class=\"xTaogf _3iTqAS\" and @src=\"https://rukminim2.flixcart.com/flap/50/50/image/ed04b09381eec3f9.jpg?q=50\"]")
    private WebElement staplesImage;
    
    // WebElement for add item button
    @FindBy(css = "button.QqFHMw.PxrzFS")
    private WebElement addItemButton;
    
    // WebElement for cart link
    @FindBy(css = "a._9Wy27C")
    private WebElement cartLink;

    // Constructor
    public GroceryPage(WebDriver driver) {
        this.driver = driver;
        // Initializing WebDriverWait with a timeout of 20 seconds
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Initializing PageFactory elements
        PageFactory.initElements(driver, this);
    }
    
    // Method to click on grocery image
    public void clickGrocery() {
        wait.until(ExpectedConditions.elementToBeClickable(groceryImage)).click();
    }
    
    // Method to click on current location button
    public void clickCurrentLocation() {
        wait.until(ExpectedConditions.elementToBeClickable(currentLocationButton)).click();
    }
    
    // Method to click on staples image
    public void clickStaples() {
        wait.until(ExpectedConditions.elementToBeClickable(staplesImage)).click();
    }
    
    // Method to click on add item button
    public void addItem() {
        wait.until(ExpectedConditions.elementToBeClickable(addItemButton)).click();
    }
    
    // Method to view cart item
    public void viewCartItem() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

    // Method to check if item is added to the cart
    public boolean isItemAdded() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cartLink));
            return true; // If the element is visible, return true
        } catch (TimeoutException e) {
            return false; // If the element is not visible within the timeout period, return false
        }	
    }
}
