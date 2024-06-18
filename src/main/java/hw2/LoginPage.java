package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement loginInput;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPasswd;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[contains(@class, 'error-block')]/h2")
    private WebElement error;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getError() {
        return error;
    }

    public void logIn(String login, String password) {
        loginInput.sendKeys(login);
        inputPasswd.sendKeys(password);
        submitButton.click();
    }

//    public StudentPage logIn(String login, String password) {
//        loginInput.sendKeys(login);
//        inputPasswd.sendKeys(password);
//        submitButton.click();
//        return new StudentPage(driver);
//    }
}
