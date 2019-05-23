import org.testng.Assert;
import org.testng.annotations.Test;

import pagepack.CatalogPageObject;
import pagepack.HeaderPageObject;

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
        Assert.assertEquals(catalog.getPriceInCart(headerPageObject), 0);
        int freePrice = Integer.parseInt(catalog.addItemsUntilFree());
        String totalPriceText = catalog.getFreeDeliveryTotalPrice();
        // check that price is the same as of items that are bought
        Assert.assertEquals(Integer.parseInt(totalPriceText), freePrice);
        catalog.clearBrushesIfAny();
    }
}
