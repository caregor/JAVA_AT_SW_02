package hw2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LoginPageTest {
    static WebDriver driver;
    static LoginPage loginPage;
    static StudentPage studentPage;
    static CreatingModalWindow creatingModalWindow;

    @BeforeAll
    static void init(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maxized");
        driver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(driver);
        creatingModalWindow = new CreatingModalWindow(driver);
        studentPage = new StudentPage(driver);
        driver.get("https://test-stand.gb.ru/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    void invalidCredentialTest () {
        loginPage.logIn("", "");

        Assertions.assertEquals("401", loginPage.getError().getText());

    }

    @Test
    void addNewStudentTest() throws InterruptedException {
        String name = "Lady";
        String lastName = "GaGa";
        String login = "testLogin5";
        loginPage.logIn("GB202305ee7822", "a5ad0ee5ae");
        int currentStudents = studentPage.TotalStudents();
        studentPage.clickAddStudent();
        creatingModalWindow.enterName(name);
        creatingModalWindow.enterLastname(lastName);
        creatingModalWindow.enterLogin(login);
        creatingModalWindow.clickSaveButton();
        //studentPage.waitLoadingTable();
        Thread.sleep(5000l);
        creatingModalWindow.closeModalWindow();
        int actualStudents = studentPage.TotalStudents();

        GroupTableRow row = studentPage.getRowByName(String.format("%s %s", lastName, name));
        row.clickTrashIcon();
        String changedStatus = row.getStatus();

        Assertions.assertEquals("inactive", changedStatus);

        row.clickRestoreFromTrashIcon();
        String revertStatus = row.getStatus();

        Assertions.assertEquals("active", revertStatus);
        Assertions.assertEquals(currentStudents + 1, actualStudents);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
