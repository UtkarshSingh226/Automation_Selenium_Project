package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    WebDriver driver;
    
    // WebElement for the "Login" span
    @FindBy(xpath = "//span[text()='Login']")
    WebElement loginSpan;
    
    // WebElement for the "New to Flipkart? Create an account" link
    @FindBy(xpath = "//a[text()='New to Flipkart? Create an account']")
    WebElement createAccountLink;
    
    // WebElement for the input element
    @FindBy(xpath = "//input[@maxlength='10']")
    WebElement inputElement;

    // WebElement for the continue button
    @FindBy(xpath = "//button[contains(@class, 'QqFHMw')]")
    WebElement continueButton;

    // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        // Initializing PageFactory elements
        PageFactory.initElements(driver, this);
    }
    
    // Method to click on the "Login" span
    public void clickLogin() {
        loginSpan.click();
    }
    
    // Method to click on the "New to Flipkart? Create an account" link
    public void clickCreateAccountLink() {
        createAccountLink.click();
    }
    
    // Method to set input value in the input element
    public void setInputValue(String value) {
        // Clear any existing value and set the new value
        inputElement.clear();
        inputElement.sendKeys(value);
    }

    // Method to click on the continue button
    public void clickContinueButton() {
        continueButton.click();
    }

    // Method to check if the continue button is clickable
    public boolean isContinueButtonClickable() {
        try {
            // Wait until the continue button is clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(continueButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
