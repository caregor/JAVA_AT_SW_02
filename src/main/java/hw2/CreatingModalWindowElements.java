package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreatingModalWindowElements {
    private WebDriver driver;

    @FindBy(xpath = "//input[@type='text']")
    private List<WebElement> inputFields;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@data-mdc-dialog-action='close']")
    private WebElement closeModalWindow;

    @FindBy(xpath = "//span[@slot='title']/../../..")
    private WebElement modalWindow;

    public CreatingModalWindowElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement getName(){
        return inputFields.get(0);
    }

    public WebElement getLastname(){
        return inputFields.get(1);
    }

    public WebElement getLogin(){
        return inputFields.get(2);
    }

    public WebElement getPhone(){
        return inputFields.get(3);
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getCloseModalWindow(){
        return closeModalWindow;
    }

    public WebElement getModalWindow() {
        return modalWindow;
    }

}
