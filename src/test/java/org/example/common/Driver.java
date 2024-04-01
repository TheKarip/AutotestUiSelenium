package org.example.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import static org.example.common.properties.Properties.BROWSER;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initBrowser(BROWSER);
        }
        driver.manage().window().fullscreen();
        return driver;
    }

    private static void initBrowser(String browser) {
        switch (browser) {
            case "chrome" -> driver = WebDriverManager.chromedriver().create();
            case "firefox" -> driver = WebDriverManager.firefoxdriver().create();
            case "IE" -> driver = WebDriverManager.iedriver().create();
            default -> throw new RuntimeException("Browser not selected");
        }
    }

    public static void loadApplication(String url) {
        driver.get(url);
    }

    public static void closeDriver() {
        driver.quit();
    }
}
