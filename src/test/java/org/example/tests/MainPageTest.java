package org.example.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MainPageTest extends BaseTest {

    @Test
    public void testLoginForm() {
        mainPage.selectLoginForm().fillLoginForm().createPublicRepository();
    }

    @ParameterizedTest
    @MethodSource("org.example.common.ArgumentsForTest#getArgumentsForLoginTest")
    public void checkIncorrectFill(String email, String pass) {
        mainPage.selectLoginForm().checkIncorrectData(email, pass);
    }

}
