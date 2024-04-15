package listener;

import common.Driver;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestListener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        getScreenshot();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        getScreenshot();
    }

    private void getScreenshot() {
        Allure.getLifecycle().addAttachment(
                "screenshot", "image/png", "png",
                ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES)
        );
    }
}
