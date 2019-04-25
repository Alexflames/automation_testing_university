import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {
    private WebElement inputLogin;
    WebDriver driver;

    LoginPageObject(WebDriver driver) {
        this.driver = driver;
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.id("passp-field-login")));
        inputLogin = driver.findElement(By.id("passp-field-login"));
    }

    public WebElement getInputLogin() {
        return inputLogin;
    }

    public WebElement getInputPassword() {
        // Due to dynamic page load this cannot be done in constructor
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.id("passp-field-passwd")));
        return driver.findElement(By.id("passp-field-passwd"));
    }

    public void InputLogin(String login) {
        // Get login input field
        WebElement inputLogin = getInputLogin();
        inputLogin.sendKeys(login);
        // Now submit the form. WebDriver will find the form for us from the element
        inputLogin.submit();
    }

    public void InputPassword(String password) {
        WebElement passwordInput = getInputPassword();
        passwordInput.sendKeys(password);
        passwordInput.submit();
    }
}