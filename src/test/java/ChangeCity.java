import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.hamcrest.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagepack.AutoTest;
import pagepack.HeaderPageObject;
import pagepack.RegionSelectPageObject;
import pagepack.SettingsPageObject;

public class ChangeCity extends AutoTest {

    @DataProvider
    public Object[] cityOptions() {
        return new Object[]{
                "Хвалынск",
                "Москва"
        };
    }

    @Test(dataProvider = "cityOptions")
    public void runCityTest(String dataCityName) {
        HeaderPageObject header = new HeaderPageObject(AutoTest.getDriver());
        header.authorize(getDriver());
        header.clickChangeCity();

        RegionSelectPageObject regionSelect = new RegionSelectPageObject(AutoTest.getDriver());
        regionSelect.setCity(dataCityName);

        // Hover mouse over 'My profile'
        header.hoverOverMyProfile();
        header.clickMySettings();

        // Check of top-left city button & settings city name
        SettingsPageObject settings = new SettingsPageObject(AutoTest.getDriver());

        MatcherAssert.assertThat(header.getRegion().getText(), Matchers.containsString(dataCityName));
        MatcherAssert.assertThat(settings.getMyCity().getText(), Matchers.containsString(dataCityName));

        WebElement returnToMain = AutoTest.getDriver().findElement(By.className("header2__logo"));
        returnToMain.click();
    }
}
