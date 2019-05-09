import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPageObject {
    private WebDriverWait driverWait;
    WebDriver driver;

    CatalogPageObject(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 10);
    }

    public WebElement getCategoryByName(String name) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("popup2__content")));
        return driver.findElement(By.linkText("Красота и гигиена"));
    }
}
