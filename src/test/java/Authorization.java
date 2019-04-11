import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder;
import java.util.regex.Pattern;

public class Authorization {

    public static void Authorize (WebDriver driver) {
        // Find the ad close element by its class name (If there is any)
        WebElement closeAd = driver.findElement(By.className("_1ZYDKa22GJ"));
        if (closeAd != null) {
            closeAd.click();
        }

        // Find user login button
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("header2-user")));
        WebElement userLoginBtn = driver.findElement(By.className("header2-user"));
        userLoginBtn.click();

        // Find login input field
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.id("passp-field-login")));
        WebElement inputLogin = driver.findElement(By.id("passp-field-login"));
        inputLogin.sendKeys("an9rybot");
        // Now submit the form. WebDriver will find the form for us from the element
        inputLogin.submit();

        // Due to dynamic page load we have to wait for password field to appear
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.id("passp-field-passwd")));
        // Do the same for password field
        WebElement passwordInput = driver.findElement(By.id("passp-field-passwd"));
        passwordInput.sendKeys("veryangrybot");
        passwordInput.submit();
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("header2-nav-item__text")));
    }

    public static void RunTest (WebDriver driver) {
        Authorize(driver);
        WebElement myProfile = driver.findElement(By.className("header2-nav-item__text"));
        boolean result = (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.textMatches(By.className("header2-nav-item__text"), Pattern.compile("Мой профиль")));
        System.out.println("----------------------------------");
        System.out.println("Результат теста авторизации: " + result);
        System.out.println("----------------------------------");
    }
}