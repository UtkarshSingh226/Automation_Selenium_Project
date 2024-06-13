package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SellerPage {

    WebDriver driver;
    WebDriverWait wait;

    // WebElement for the "Become a Seller" link
    @FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[4]/div/a[2]")
    WebElement seller;
    
    // WebElement for the "Start Selling" button
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/div[2]/button[2]")
    WebElement startSelling;
    
    // WebElement for the mobile number field
    @FindBy(xpath = "//input[@data-testid='test-input' and @name='mobileNumber']")
    WebElement enterMobileNumber;
    
    // WebElement for the email field
    @FindBy(xpath = "//input[@data-testid='test-input' and @name=\"email\"]")
    WebElement enterEmail;
    
    // Constructor
    public SellerPage(WebDriver driver) {
        this.driver = driver;
        // Initializing WebDriverWait with a timeout of 20 seconds
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Initializing PageFactory elements
        PageFactory.initElements(driver, this);
    }
    
    // Method to click on the "Become a Seller" link
    public void clickSeller() {
        seller.click();
    }
    
    // Method to click on the "Start Selling" button
    public void startSelling() {
        startSelling.click();
    }
    
    // Method to get the WebElement for the mobile number field
    public WebElement getMobileNumberField() {
        return enterMobileNumber;
    }
    
    // Method to get the WebElement for the email field
    public WebElement getEmailField() {
        return enterEmail;
    }   
}
