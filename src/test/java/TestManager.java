import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestManager {
    WebDriver driver;

    @BeforeClass
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void driverInit() {
        // Create a new instance of the Chrome driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Use this to visit Beru.ru
        driver.get("http://beru.ru");
    }

    @Test
    public void runTest() {
        System.out.println("----------------------------------");
        Authorization.runTest(driver);
        System.out.println("----------------------------------");
    }

    //Close the browser
    @AfterTest
    public void closeDriver() {
        //driver.quit();
    }

}
