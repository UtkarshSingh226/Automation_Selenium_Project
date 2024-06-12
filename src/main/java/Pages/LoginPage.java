package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // WebElements
    @FindBy(xpath = "//span[text()='Login']")
    WebElement loginSpan;

    @FindBy(css = "input[type='text'][class='r4vIwl BV+Dqf'][autocomplete='off']")
    WebElement usernameInput;
    
    @FindBy(css = "button.QqFHMw")
    WebElement requestOTPButton;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Initializing WebDriverWait with a timeout of 20 seconds
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Initializing PageFactory elements
        PageFactory.initElements(driver, this);
    }
    
    // Method to click on the login button
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginSpan)).click();
    }

    // Method to enter username
    public void enterUsername(String value) {
        usernameInput.sendKeys(value);
    }
    
    // Method to click on the submit/request OTP button
    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(requestOTPButton)).click();
    }
}
