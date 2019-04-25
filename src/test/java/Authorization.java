import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class Authorization extends AutoTest {

    static void authorize (WebDriver driver) {
        // Find the ad close element by its class name (If there is any)
        try {
            WebElement closeAd = driver.findElement(By.className("_1ZYDKa22GJ"));
            if (closeAd != null) {
                closeAd.click();
            }
        }
        catch (Exception expt) { System.out.println("Отсутствует pop-up"); }

        // Find user login button
        HeaderPageObject headerPageObject = new HeaderPageObject(driver);
        headerPageObject.clickLogin();

        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.InputLogin("an9rybot");

        // Do the same for password field
        loginPageObject.InputPassword("veryangrybot");
    }

    @Test
    public void runTest () {
        authorize(driver);
        HeaderPageObject headerPageObject = new HeaderPageObject(driver);

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.textToBePresentInElement(headerPageObject.getMyProfile(), "Мой профиль"));
    }
}
