package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCart {

	WebDriver driver;
	private WebDriverWait wait;

	// WebElements
	@FindBy(name = "q")
	WebElement searchBox;

	@FindBy(css = "button[type='submit']")
	private WebElement searchButton;

	@FindBy(xpath = "//div[contains(text(), 'Apple iPhone 15 (Blue, 128 GB)')]")
	private WebElement productTitle;

	@FindBy(xpath = "//a[@title='Cart' and @class='_3RX0a-']")
	private WebElement cartButton;

	@FindBy(xpath = "//span[contains(text(),'Place Order')]")
	private WebElement placeOrderButton;

	// Constructor
	public AddToCart(WebDriver driver) {
		this.driver = driver;
		// Initializing WebDriverWait with a timeout of 20 seconds
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Initializing PageFactory elements
		PageFactory.initElements(driver, this);
	}

	// Method to search for a product
	public void searchForProduct(String searchInput) {
		// Wait for the search box to be visible, then enter searchInput and press Enter
		wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(searchInput, Keys.RETURN);
	}

	// Method to select a product from search results
	public void selectProduct() {
		// Wait for the product title to be clickable and then click it
		wait.until(ExpectedConditions.elementToBeClickable(productTitle)).click();
	}

	// Method to check if the product is successfully added to cart
	public boolean isProductAdded() {
	    try {
	        // Click the cart button
	        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
	        // Check if the place order button is visible
	        boolean isPlaceOrderVisible = wait.until(ExpectedConditions.visibilityOf(placeOrderButton)).isDisplayed();
	        // Click the cart button again to close the cart
	        cartButton.click();
	        return isPlaceOrderVisible; // Product added if place order button is visible
	    } catch (Exception e) {
	        return false; // Product not added
	    }
	}
}
