import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class ChangeCity extends AutoTest {

    @DataProvider
    public Object[] cityOptions() {
        return new Object[]{
                "Хвалынск",
                "Москва"
        };
    }

    @Test(dataProvider = "cityOptions")
    public void runCityTest(String dataCityName) {
        Authorization.authorize(driver);

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("region-form-opener")));
        WebElement cityChangeBtn = driver.findElement(By.className("region-form-opener"));
        cityChangeBtn.click();

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("region-suggest")));
        WebElement inputCity =
                driver.findElement(By.className("region-suggest")).findElement(By.className("input__control"));
        inputCity.sendKeys(dataCityName);

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("region-suggest__list-item")));
        WebElement regionSuggest = driver.findElement(By.className("region-suggest__list-item"));
        regionSuggest.click();

        WebElement inputCityBtn = driver.findElement(By.className("region-select-form__continue-with-new"));
        inputCityBtn.click();

        // Wait until region selector disappears
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.invisibilityOfElementLocated(
                                By.className("region-select-form__continue-with-new")));

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.elementToBeClickable(By.className("header2-nav-item_type_profile")));
        WebElement myProfile = driver.findElement(By.className("header2-nav-item_type_profile"));

        // Hover mouse over 'My profile'
        Actions mouseHover = new Actions(driver);
        mouseHover.moveToElement(myProfile).perform();

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("header2-user-menu__item_type_settings")));
        WebElement userSettings = driver.findElement(By.className("header2-user-menu__item_type_settings"));
        userSettings.click();

        // Check of top-left city button & settings city name
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("region-form-opener")));
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.textMatches(By.className("region-form-opener"), Pattern.compile(dataCityName)));

        // Check your city in settings
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("settings-list_type_region")));
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.textMatches(
                        By.className("settings-list_type_region"),
                        Pattern.compile(dataCityName)));

        WebElement returnToMain = driver.findElement(By.className("header2__logo"));
        returnToMain.click();
    }
}
