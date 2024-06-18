package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qatools.TextParser;

import java.time.Duration;

public class StudentPage {
    private static final Logger logger = LoggerFactory.getLogger(StudentPage.class);
    private WebDriver driver;
    private StudentPageElements elements;

    public StudentPage(WebDriver driver) {
        this.driver = driver;
        this.elements = new StudentPageElements(driver);
    }

    public CreatingModalWindow clickAddStudent(){
        elements.getCreateButton().click();
        return new CreatingModalWindow(driver);
    }

    public GroupTableRow getRowByName(String name){
        return elements.getRowsInGroupTable().stream().map(GroupTableRow::new)
                .filter(row -> row.getName().equals(name))
                .findFirst().orElseThrow();
    }

    public int TotalStudents () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedCondition<Boolean>) d -> "true".equals(elements.getProgressBar().getAttribute("aria-hidden")));
        String text = elements.getCountStudents().getText();
        logger.info("All Students: " + text);
        return TextParser.getLastNumberFromString(text);
    }

    public void waitLoadingTable(){
        String attributeValue = elements.getProgressBar().getAttribute("aria-hidden");
        logger.info("Значение атрибута: " + attributeValue);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(elements.getProgressBar(), "aria-hidden", "true"));
        //wait.until((ExpectedCondition<Boolean>) driver -> "true".equals(elements.getProgressBar().getAttribute("aria-hidden")));
    }

}
