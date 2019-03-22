import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestManager {
    WebDriver driver;

    @BeforeClass
    void driverSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void RunTest() {
        driverSetup();
        AuthorizationTest.Run(driver);
    }

}
