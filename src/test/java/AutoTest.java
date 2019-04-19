import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AutoTest {
    WebDriver driver;

    @BeforeMethod
    public void driverInit() {
        WebDriverManager.chromedriver().setup();
        // Create a new instance of the Chrome driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Use this to visit Beru.ru
        driver.get("http://beru.ru");
    }

    //Close the browser
    @AfterMethod
    public void closeDriver() {
        //driver.quit();
    }
}
