package org.example.tests;

import org.example.common.annotation.Api;
import org.example.common.controller.ReposController;
import org.example.common.controller.UserController;
import org.example.common.extension.ApiExtension;
import org.example.common.pages.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.common.Const.*;
import static org.example.common.DriverAssist.close;
import static org.example.common.DriverAssist.open;

@ExtendWith(ApiExtension.class)
public class BaseTest {

    ReposController reposController = new ReposController();
    static MainPage mainPage = new MainPage();

    @Test
    @Api(name = "TestRepo123", isPrivate = "false")
    void createPublicRepository() {
        var repoList = new UserController().getRepositoryList();
        Assertions.assertEquals(1, repoList.size());
    }

    @ParameterizedTest
    @MethodSource("getArgumentsForLoginTest")
    void checkFillLogin(String email, String pass) {
        open(HOME_PAGE_URL);
        mainPage.selectLoginForm().fillLoginForm(email, pass);
    }

    @AfterAll
    static void closeDriver(){
        close();
    }

    static public Stream<Arguments> getArgumentsForLoginTest() {
        return Stream.of(
                Arguments.of("f43241@fma.com", PASS),
                Arguments.of("POkdm@@gmail.com", "fds123AD"),
                Arguments.of(EMAIL, PASS)

        );
    }
}
