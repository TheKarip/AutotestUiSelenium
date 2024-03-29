package org.example.common;

import org.openqa.selenium.WebDriver;

public class DriverAssist {

    public static WebDriver open(String url) {
        WebDriver d = Driver.getDriver();
        d.manage().window().fullscreen();
        d.get(url);
        return d;
    }

    public static void close() {
        WebDriver d = Driver.getDriver();
        d.quit();
    }
}