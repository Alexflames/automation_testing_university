import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

public class ChangeCity extends AutoTest {

    @Test
    public void runCityTest() {
        Authorization.authorize(driver);

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("region-form-opener")));
        WebElement cityChangeBtn = driver.findElement(By.className("region-form-opener"));
        cityChangeBtn.click();

        //String inputCityXpath = "//div[@class='region-suggest']/descendant::input[@class='input__control']";
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("region-suggest")));
        WebElement inputCity =
                driver.findElement(By.className("region-suggest")).findElement(By.className("input__control"));
        inputCity.sendKeys("Хвалынск");

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("region-suggest__list-item")));
        WebElement regionSuggest = driver.findElement(By.className("region-suggest__list-item"));
        regionSuggest.click();

        WebElement inputCityBtn = driver.findElement(By.className("region-select-form__continue-with-new"));
        inputCityBtn.click();
    }
}
