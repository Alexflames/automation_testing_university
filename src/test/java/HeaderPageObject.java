import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPageObject {
    private WebElement userLoginBtn;
    private WebElement myProfile;
    private WebDriver driver;

    HeaderPageObject(WebDriver driver) {
        this.driver = driver;
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("header2-nav__user")));
        userLoginBtn = driver.findElement(By.className("header2-nav__user"));
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("header2-nav-item__text")));
        myProfile = driver.findElement(By.className("header2-nav-item__text"));
    }

    public WebElement getUserLoginBtn() {
        return userLoginBtn;
    }

    public WebElement getMyProfile() {
        return myProfile;
    }

    public void clickLogin() {
        userLoginBtn.click();
    }
}
