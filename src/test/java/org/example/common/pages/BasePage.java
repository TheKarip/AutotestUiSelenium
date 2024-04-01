package org.example.common.pages;

import org.example.common.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.common.properties.Properties.TIMEOUT;

public abstract class BasePage {

    protected WebDriver driver = Driver.getDriver();
    protected Wait<WebDriver> wait;

    public BasePage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }
}
