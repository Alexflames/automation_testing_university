import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class FreeDelivery extends AutoTest {

    @Test
    public void runFreeDeliveryTest() {
        HeaderPageObject headerPageObject = new HeaderPageObject(driver);
        headerPageObject.getButtonCatalog().click();
    }

    @AfterMethod
    public void closeDriver() {

    }
}
