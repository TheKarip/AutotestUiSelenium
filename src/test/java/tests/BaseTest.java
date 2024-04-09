package tests;

import common.core.Driver;
import common.core.properties.PropertiesLoader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static common.core.properties.Properties.HOME_PAGE_URL;


public abstract class BaseTest {

    @BeforeAll
   static void ab() {
        PropertiesLoader.getInstance().loadProperties();
    }

    @BeforeEach
    void setUp() {
        Driver.getDriver();
        Driver.loadApplication(System.getProperty(HOME_PAGE_URL));
    }

    @AfterEach
    void cleanCookie() {
        Driver.cleanCookie();
    }

    @AfterAll
    static void closeDriver() {
        Driver.closeDriver();
    }
}
