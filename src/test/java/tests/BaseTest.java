package tests;

import common.core.Driver;
import common.core.properties.Properties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    static {
        Driver.getDriver();
    }

    @BeforeEach
    void setUp() {
        Driver.getDriver();
        Driver.loadApplication(Properties.HOME_PAGE_URL);
    }

    @AfterAll
   static void closeDriver() {
        Driver.closeDriver();
    }
}
