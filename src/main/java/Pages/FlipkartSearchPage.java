package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FlipkartSearchPage {

    WebDriver driver;
    private WebDriverWait wait;

    // Element locator for the search box
    @FindBy(name = "q")
    WebElement searchbox;
    
    // Element locator for the search button
    @FindBy(css = "button._2iLD__")
    private WebElement searchButton;
    
    // Element locators for compare button
    @FindBy(xpath = "//span[text()='Add to Compare']")
    WebElement addToCompare;
    
    @FindBy(xpath = "//span[text()='COMPARE']")
    WebElement compareButton;
    

    // Constructor to initialize the page
    public FlipkartSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // Method to input search query into the search box
    public void flipkartSearchBox(String searchInput) {
        searchbox.sendKeys(searchInput);
    }

    // Method to click on the search button
    public void searchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).sendKeys(Keys.RETURN);
    }

    // Method to perform actions on the search results
    public void actionsPerformed() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCompare)).click();
    }
    
    // Method to click on the compare button
    public void compareBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(compareButton)).click();
    }
    
    // Method to check if the search button is displayed
    public boolean isSubmitbtnDisplayed() {
        try {
            return searchButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Method to check if the 'Add to Compare' button is displayed
    public boolean isAddToCompareButtonDisplayed() {
        try {
            return addToCompare.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Method to check if the 'COMPARE' button is displayed
    public boolean isCompareButtonDisplayed() {
        try {
            return compareButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
