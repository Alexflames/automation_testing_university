import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagepack.AutoTest;
import pagepack.HeaderPageObject;
import pagepack.LoginPageObject;

public class Authorization extends AutoTest {

    public static void authorize (WebDriver driver) {
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
        loginPageObject.sendInputLogin("an9rybot");

        // Do the same for password field
        loginPageObject.sendInputPassword("veryangrybot");
    }

    @Test
    public void runTest () {
        Authorization.authorize(AutoTest.getDriver());
        HeaderPageObject headerPageObject = new HeaderPageObject(AutoTest.getDriver());

        Assert.assertEquals(headerPageObject.getMyProfile().getText(), "Мой профиль");
    }
}
