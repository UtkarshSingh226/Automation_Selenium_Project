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
    @FindBy(xpath = "//a[@class=\"_1krdK5 _3jeYYh\" and @title=\"Become a Seller\"]")
    WebElement seller;
    
    // WebElement for the "Start Selling" button
    @FindBy(xpath = "//button[@data-testid=\"button\" and text()=\"Start Selling\"]")
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
