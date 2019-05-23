package pagepack;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestScreenshotter extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenShot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenShot() {
        return ((TakesScreenshot) AutoTest.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
