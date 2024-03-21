package org.example.tests;

import org.example.common.ArgumentsForTest;
import org.example.common.Driver;
import org.example.pages.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.example.common.Const.URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    public BaseTest() {
    }

    WebDriver driver;
    MainPage mainPage;

    @BeforeEach
    void setUp() {
        driver = Driver.getDriver();
        mainPage = new MainPage();
        driver.get(URL);
        driver.manage().window().fullscreen();
    }

    @AfterAll
    void close() {
        driver.quit();
    }
}
