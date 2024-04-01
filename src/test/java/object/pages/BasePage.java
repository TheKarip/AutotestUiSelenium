package object.pages;

import common.core.Driver;
import common.core.properties.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver = Driver.getDriver();
    protected Wait<WebDriver> wait;

    public BasePage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Properties.TIMEOUT), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Properties.TIMEOUT));
    }
}
