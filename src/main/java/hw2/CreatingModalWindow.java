package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CreatingModalWindow {
    private static final Logger logger = LoggerFactory.getLogger(CreatingModalWindow.class);
    private WebDriver driver;
    private CreatingModalWindowElements elements;

    public CreatingModalWindow(WebDriver driver) {
        this.driver = driver;
        this.elements = new CreatingModalWindowElements(driver);
    }

    public void clickSaveButton(){
        elements.getSubmitButton().click();
    }

    public void closeModalWindow() {
        elements.getCloseModalWindow().click();
    }

    public void enterName(String name) {
        elements.getName().sendKeys(name);
    }

    public void enterLastname(String lastname) {
        elements.getLastname().sendKeys(lastname);
    }

    public void  enterLogin(String login) {
        elements.getLogin().sendKeys(login);
    }

    public void enterPhone(String phone){
        elements.getPhone().sendKeys(phone);
    }
}
