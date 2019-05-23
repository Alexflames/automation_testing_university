package pagepack;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegionSelectPageObject
{
    private WebDriverWait driverWait;
    WebDriver driver;

    public RegionSelectPageObject(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 10);
    }

    // The cities to choose will appear on screen as a list
    @Step("Choose first suggested region")
    public void chooseCityFromList() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("region-suggest__list-item")));
        WebElement regionSuggest = driver.findElement(By.className("region-suggest__list-item"));
        regionSuggest.click();
    }

    @Step("Click city change button")
    public void clickCityChange() {
        WebElement inputCityBtn = driver.findElement(By.className("region-select-form__continue-with-new"));
        inputCityBtn.click();
    }

    @Step("Wait for city change window to disappear")
    public void waitCityChangeWindowDisappear() {
        // Wait until region selector disappears
        driverWait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.className("region-select-form__continue-with-new")));
    }

    @Step("Set user city")
    public void setCity(String cityName) {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("region-suggest")));
        WebElement inputCity =
                driver.findElement(By.className("region-suggest")).findElement(By.className("input__control"));
        inputCity.sendKeys(cityName);

        chooseCityFromList();
        clickCityChange();
        waitCityChangeWindowDisappear();
    }
}
