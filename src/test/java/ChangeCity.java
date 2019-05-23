import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.hamcrest.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagepack.HeaderPageObject;
import pagepack.RegionSelectPageObject;
import pagepack.SettingsPageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;

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
        HeaderPageObject header = new HeaderPageObject(driver);
        header.clickChangeCity();

        RegionSelectPageObject regionSelect = new RegionSelectPageObject(driver);
        regionSelect.setCity(dataCityName);

        // Hover mouse over 'My profile'
        header.hoverOverMyProfile();
        header.clickMySettings();

        // Check of top-left city button & settings city name
        SettingsPageObject settings = new SettingsPageObject(driver);

        MatcherAssert.assertThat(header.getRegion().getText(), Matchers.containsString(dataCityName));
        MatcherAssert.assertThat(settings.getMyCity().getText(), Matchers.containsString(dataCityName));

        WebElement returnToMain = driver.findElement(By.className("header2__logo"));
        returnToMain.click();
    }
}
