package org.example.tests;

import org.example.common.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import static org.example.common.properties.Properties.HOME_PAGE_URL;

public abstract class BaseTest {

    static {
        Driver.getDriver();
    }

    @BeforeEach
    void setUp() {
        Driver.loadApplication(HOME_PAGE_URL);
    }

    @AfterAll
   static void closeDriver() {
        Driver.closeDriver();
    }
}
