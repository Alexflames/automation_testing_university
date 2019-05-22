import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Pattern;

public class FreeDelivery extends AutoTest {
    private String priceFrom = "999";
    private String priceTo = "1999";

    @Test
    public void runFreeDeliveryTest() {
        HeaderPageObject headerPageObject = new HeaderPageObject(driver);
        headerPageObject.getButtonCatalog().click();

        CatalogPageObject catalog = new CatalogPageObject(driver);

        catalog.hoverOverCategory(catalog.getCategoryByName("Красота и гигиена"));
        catalog.moveToSubCategory("Электрические зубные щетки");

        catalog.setPriceRangeFromTo(priceFrom, priceTo);

        // test that search results provide prices in range
        Assert.assertEquals(catalog.checkPriceInformation(priceFrom, priceTo), Boolean.TRUE);

        catalog.buyPrevLastItem();

        // test that price is calculated properly
        Assert.assertEquals(catalog.checkPriceInCart(headerPageObject), 0);
        int freePrice = Integer.parseInt(catalog.addItemsUntilFree());
        String totalPriceText = catalog.checkFreeDelivery();
        // check that price is the same as of items that are bought
        Assert.assertEquals(Integer.parseInt(totalPriceText), freePrice);
        catalog.clearBrushesIfAny();
    }
}
