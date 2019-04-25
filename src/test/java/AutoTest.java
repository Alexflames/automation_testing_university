import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.regex.Pattern;

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
        WebElement myProfile = driver.findElement(By.className("header2-nav-item__text"));
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.textMatches(By.className("header2-nav-item__text"), Pattern.compile("Мой профиль")));

        // Hover mouse over 'My profile' to logout from user
        Actions mouseHover = new Actions(driver);
        mouseHover.moveToElement(myProfile).perform();

        (new WebDriverWait(driver, 10)).until(
        ExpectedConditions.presenceOfElementLocated(By.className("header2-user-menu__logout")));
        WebElement logout = driver.findElement(By.className("header2-user-menu__logout"));
        logout.click();
        driver.quit();
    }
}
