package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StudentPageElements {
    private WebDriver driver;
    @FindBy(id = "create-btn")
    private WebElement createButton;

    @FindBy(xpath = "//table[@aria-label='Dummies list']/tbody/tr")
    private List<WebElement> rowsInGroupTable;

    @FindBy(xpath = "//div[@class='mdc-data-table__pagination-total']")
    private WebElement countStudents;

    @FindBy(xpath = "//div[@role='progressbar']")
    private WebElement progressBar;

    public StudentPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getRowsInGroupTable() {
        return rowsInGroupTable;
    }

    public WebElement getProgressBar() {
        return progressBar;
    }

    public WebElement getCreateButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-btn")));
        return createButton;
    }

    public WebElement getCountStudents() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mdc-data-table__pagination-total']")));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("//div[@class='mdc-data-table__pagination-total']"), "... loading")));
        return countStudents;
    }

}
