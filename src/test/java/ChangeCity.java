import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class ChangeCity extends AutoTest {

    @Test
    public void runCityTest() {
        Authorization.authorize(driver);
    }

    public static void runTest(WebDriver driver) {
        Authorization.authorize(driver);
    }
}
