import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPageObject {
    private WebElement userLoginBtn;
    private WebElement myProfile;
    private WebElement buttonCatalog;
    private WebDriver driver;
    private WebDriverWait driverWait;

    HeaderPageObject(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 10);
        reloadPageObject();
    }

    public void reloadPageObject() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("header2-nav__user")));
        userLoginBtn = driver.findElement(By.className("header2-nav__user"));

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("header2-nav-item__text")));
        myProfile = driver.findElement(By.className("header2-nav-item__text"));
        buttonCatalog = driver.findElement(By.className("button2_theme_search"));
    }

    public WebElement getUserLoginBtn() {
        return userLoginBtn;
    }

    public WebElement getMyProfile() {
        return myProfile;
    }

    public WebElement getButtonCatalog() { return buttonCatalog; }

    public void clickLogin() {
        userLoginBtn.click();
    }

    public WebElement getRegion() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("region-form-opener")));
        return driver.findElement(By.className("region-form-opener"));
    }

    public void clickChangeCity() {
        getRegion().click();
    }

    public void hoverOverMyProfile() {
        Actions mouseHover = new Actions(driver);
        reloadPageObject();
        mouseHover.moveToElement(getMyProfile()).perform();
    }

    public WebElement getMySettings() {
        driverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.className("header2-user-menu__item_type_settings")));
        return driver.findElement(By.className("header2-user-menu__item_type_settings"));
    }

    public void clickMySettings() {
        getMySettings().click();
    }

    public WebElement getMainButton() {
        return driver.findElement(By.className("header2__logo"));
    }

    public void moveToCart() {
        driver.findElement(By.className("header2-nav-item_type_cart")).click();
    }
}
