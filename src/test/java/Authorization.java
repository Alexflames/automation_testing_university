import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagepack.AutoTest;
import pagepack.HeaderPageObject;
import pagepack.LoginPageObject;

public class Authorization extends AutoTest {

    @Test
    public void runTest () {
        HeaderPageObject headerPageObject = new HeaderPageObject(AutoTest.getDriver());
        headerPageObject.authorize(getDriver());

        Assert.assertEquals(headerPageObject.getMyProfile().getText(), "Мой профиль");
    }
}
