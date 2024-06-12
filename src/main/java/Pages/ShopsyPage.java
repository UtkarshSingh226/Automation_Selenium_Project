package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopsyPage {

    WebDriver driver;

    // WebElement for the "Become a Seller" link
    @FindBy(xpath = "//a[@class='_1krdK5 _3jeYYh' and @title='Become a Seller']")
    WebElement seller;
    
    // WebElement for the username field
    @FindBy(xpath = "//input[@name='fullName']")
    WebElement userNameField;
 
    // WebElement for the mobile number/email field
    @FindBy(xpath = "//input[@data-testid='test-input' and @type='text' and @placeholder='Enter Mobile Number / Email ID' and @label='Enter Mobile Number / Email ID' and @name='contactInformation']")
    WebElement userMobileEmailField;
    
    // WebElement for the message field
    @FindBy(xpath ="//input[@data-testid='test-input' and @type='text' and @placeholder='Type Your Messsage' and @label='Type Your Messsage' and @name='message']")
    WebElement messageField;
    
    // WebElement for the submit button
    @FindBy(xpath="//button[@data-testid='button' and text()='Send Query']")
    WebElement submitButton;
   

    // Constructor
    public ShopsyPage(WebDriver driver) {
        this.driver = driver;
        // Initializing PageFactory elements
        PageFactory.initElements(driver, this);
    }

    // Method to click on the "Become a Seller" link
    public void clickSeller() {
        // Wait for the seller link to be clickable and then click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(seller)).click();
    }
    
    // Method to enter username in the username field
    public void enterUsername(String name) {
        // Wait for the username field to be visible and then enter the username
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(userNameField)).sendKeys(name);
    }
    
    // Method to enter mobile number/email in the mobile/email field
    public void enterMobileNum(String value) {
        // Wait for the mobile/email field to be visible and then enter the value
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(userMobileEmailField)).sendKeys(value);
    }
    
    // Method to enter message in the message field
    public void enterMessage(String message) {
        // Wait for the message field to be visible and then enter the message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(messageField)).sendKeys(message);
    }
    
    // Method to click on the submit button
    public void clickSubmit() {
        // Wait for the submit button to be clickable and then click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
}
