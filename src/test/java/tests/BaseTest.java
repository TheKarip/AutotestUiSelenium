package tests;

import common.core.properties.Properties;
import common.core.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    static {
        Driver.getDriver();
    }

    @BeforeEach
    void setUp() {
        Driver.loadApplication(Properties.HOME_PAGE_URL);
    }

    @AfterAll
   static void closeDriver() {
        Driver.closeDriver();
    }
}
