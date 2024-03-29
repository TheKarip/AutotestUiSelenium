package org.example.common.pages;

import org.example.common.Driver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    WebDriverWait wait;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }
}
