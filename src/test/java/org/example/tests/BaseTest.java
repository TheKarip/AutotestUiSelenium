package org.example.tests;

import org.example.common.Driver;
import org.example.pages.MainPage;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import static org.example.common.Const.URL;

public  class BaseTest {

    WebDriver driver;
    MainPage mainPage;

    @BeforeAll
    void setUp() {
        driver = Driver.getDriver();
        mainPage = new MainPage();
        driver.get(URL);
        driver.manage().window().fullscreen();
    }
}
