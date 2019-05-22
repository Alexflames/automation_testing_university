import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CatalogPageObject {
    private int freeDeliveryFrom = 2499;
    private WebDriverWait driverWait;
    WebDriver driver;

    CatalogPageObject(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 10);
    }

    public WebElement getCategoryByName(String categoryTitle) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(categoryTitle)));
        WebElement el = driver.findElement(By.className("popup2__content")).findElement(By.linkText(categoryTitle));
        return el;
    }

    public void hoverOverCategory(WebElement category) {
        Actions mouse = new Actions(driver);
        mouse.moveToElement(category).perform();
    }

    public void moveToSubCategory(String subCategoryTitle) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(subCategoryTitle)));
        driver.findElement(By.className("popup2__content")).findElement(By.linkText(subCategoryTitle)).click();
    }

    public void setPriceRangeFromTo(String priceFrom, String priceTo) {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("glpricefrom")));
        driver.findElement(By.id("glpricefrom")).sendKeys(String.valueOf(priceFrom));
        driver.findElement(By.id("glpriceto")).sendKeys(String.valueOf(priceTo));
    }

    public void getPriceInformation() {

    }

    public Boolean checkPriceInformation(String fromPrice, String toPrice){
        int fromPriceInt = Integer.parseInt(fromPrice);
        int toPriceInt = Integer.parseInt(toPrice);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_1PQIIOelRL")));
        List<WebElement> prices = driver.findElements(By.className("_1u3j_pk1db"));
        for (WebElement price : prices) {
            int priceNum = Integer.parseInt(price.getText().replaceAll("[^\\d]", ""));
            if (priceNum < fromPriceInt || priceNum > toPriceInt) {
                return false;
            }
        }
        return true;
    }

    public void buyPrevLastItem() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_1PQIIOelRL")));
        List<WebElement> buttons = driver.findElements(By.className("THqSbzx07u"));
        int i = 0;
        for (WebElement button : buttons) {
            if (i == buttons.size() - 2) {
                button.click();
            }
            i = i + 1;
        }
    }

    public int checkPriceInCart(HeaderPageObject header) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_39B7yXQbvm")));
        header.moveToCart();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("_3BLMSktvAP")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_1oBlNqVHPq")));
        String toFree =
                driver.findElement(By.className("_3BLMSktvAP")).getText().replaceAll("[\\D]", "");
        List<WebElement> prices = driver.findElements(By.className("_1Q9ASvPbPN"));
        System.out.println(prices.get(0).getText());
        String priceFirstItem = prices.get(0).getText().replaceAll("[\\D]", "");
        System.out.println(toFree);
        System.out.println(priceFirstItem);
        return (freeDeliveryFrom - (Integer.parseInt(priceFirstItem) - 10000) - Integer.parseInt(toFree));
    }

    public String addItemsUntilFree() {
        WebElement price = driver.findElement(By.className("_1JLs4_hnVR"));
        String priceText = price.getText().replaceAll("[\\D]", "");
        while (Integer.parseInt(priceText) < freeDeliveryFrom) {
            driver.findElement(By.className("_3hWhO4rvmA")).click();
            priceText = price.getText().replaceAll("[\\D]", "");
        }
        return priceText;
    }

    public String checkFreeDelivery() {
        // check that icon displays free delivery
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("_2Bly7jUuwC")));
        WebElement totalPrice = driver.findElement(By.className("_1oBlNqVHPq"));
        String totalPriceText = totalPrice.getText().replaceAll("[\\D]", "");
        return totalPriceText;
    }

    public void clearBrushesIfAny() {
        WebElement deleteButton = driver.findElement(By.className("_3c1Ff1irZC"));
        if (deleteButton != null) {
            deleteButton.click();
        }
    }
}
