package pagepack;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {
    private WebElement inputLogin;
    private WebDriverWait driverWait;
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("passp-field-login")));
        inputLogin = driver.findElement(By.id("passp-field-login"));
    }

    @Step("Access input login")
    public WebElement getInputLogin() {
        return inputLogin;
    }

    @Step("Access input password")
    public WebElement getInputPassword() {
        // Due to dynamic page load this cannot be done in constructor
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("passp-field-passwd")));
        return driver.findElement(By.id("passp-field-passwd"));
    }

    @Step("Put user login")
    public void sendInputLogin(String login) {
        // Get login input field
        WebElement inputLogin = getInputLogin();
        inputLogin.sendKeys(login);
        // Now submit the form. WebDriver will find the form for us from the element
        inputLogin.submit();
    }

    @Step("Put user password")
    public void sendInputPassword(String password) {
        WebElement passwordInput = getInputPassword();
        passwordInput.sendKeys(password);
        passwordInput.submit();
    }
}