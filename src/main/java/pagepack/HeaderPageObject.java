package pagepack;

import io.qameta.allure.Step;
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

    public HeaderPageObject(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 10);
        reloadPageObject();
    }

    @Step("Access page header")
    public void reloadPageObject() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("header2-nav__user")));
        userLoginBtn = driver.findElement(By.className("header2-nav__user"));

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("header2-nav-item__text")));
        myProfile = driver.findElement(By.className("header2-nav-item__text"));
        buttonCatalog = driver.findElement(By.className("button2_theme_search"));
    }

    @Step("Get login button")
    public WebElement getUserLoginBtn() {
        return userLoginBtn;
    }

    @Step("Get my profile button")
    public WebElement getMyProfile() {
        return myProfile;
    }

    @Step("Get catalog button")
    public WebElement getButtonCatalog() { return buttonCatalog; }

    @Step("Click login button")
    public void clickLogin() {
        userLoginBtn.click();
    }

    @Step("Get user region in header")
    public WebElement getRegion() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("region-form-opener")));
        return driver.findElement(By.className("region-form-opener"));
    }

    @Step("Click region button to switch region")
    public void clickChangeCity() {
        getRegion().click();
    }

    @Step("Hover mouse over my profile")
    public void hoverOverMyProfile() {
        Actions mouseHover = new Actions(driver);
        reloadPageObject();
        mouseHover.moveToElement(getMyProfile()).perform();
    }

    @Step("Get my settings button")
    public WebElement getMySettings() {
        driverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.className("header2-user-menu__item_type_settings")));
        return driver.findElement(By.className("header2-user-menu__item_type_settings"));
    }

    @Step("Click my settings button")
    public void clickMySettings() {
        getMySettings().click();
    }

    @Step("Click main page button")
    public WebElement getMainButton() {
        return driver.findElement(By.className("header2__logo"));
    }

    @Step("Move to cart")
    public void moveToCart() {
        driver.findElement(By.className("header2-nav-item_type_cart")).click();
    }

    @Step("User authorization")
    public void authorize (WebDriver driver) {
        // Find the ad close element by its class name (If there is any)
        try {
            WebElement closeAd = driver.findElement(By.className("_1ZYDKa22GJ"));
            if (closeAd != null) {
                closeAd.click();
            }
        }
        catch (Exception expt) { System.out.println("Отсутствует pop-up"); }

        // Find user login button
        clickLogin();

        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.sendInputLogin("an9rybot");

        // Do the same for password field
        loginPageObject.sendInputPassword("veryangrybot");
        reloadPageObject();
    }
}
