package pagepack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPageObject {
    private WebDriverWait driverWait;
    WebDriver driver;

    public SettingsPageObject(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 10);
    }

    public WebElement getMyCity() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("settings-list_type_region")));
        return driver.findElement(By.className("settings-list_type_region"));
    }
}
