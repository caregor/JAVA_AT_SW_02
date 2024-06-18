package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class GroupTableRow {
    private final WebElement root;

    public GroupTableRow(WebElement root) {
        this.root = root;
    }
    public String getName(){
        return root.findElement(By.xpath("./td[2]")).getText();
    }
    public String getStatus(){
        return root.findElement(By.xpath("./td[4]")).getText();
    }
    public void clickTrashIcon(){
        root.findElement(By.xpath("./td/button[text()='delete']")).click();
        FluentWait<WebElement> wait = new FluentWait<>(root)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(root -> root.findElement(By.xpath("./td/button[text()='restore_from_trash']")));
    }
    public void clickRestoreFromTrashIcon(){
        root.findElement(By.xpath("./td/button[text()='restore_from_trash']")).click();
        FluentWait<WebElement> wait = new FluentWait<>(root)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(root -> root.findElement(By.xpath("./td/button[text()='delete']")));
    }
}
