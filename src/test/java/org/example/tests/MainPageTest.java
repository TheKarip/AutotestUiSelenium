package org.example.tests;

import org.junit.jupiter.api.Test;

public class MainPageTest extends BaseTest {

    @Test
    public void loginForm() {
       var page = mainPage
               .selectLoginForm()
               .fillLoginForm();
    }
}
