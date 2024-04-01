package org.example.tests;

import org.example.common.annotation.Api;
import org.example.common.controller.ReposController;
import org.example.common.controller.UserController;
import org.example.common.extension.ApiExtension;
import org.example.common.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.common.properties.Properties.EMAIL;
import static org.example.common.properties.Properties.PASS;

@ExtendWith(ApiExtension.class)
public class GitHubTest {

    ReposController reposController = new ReposController();
    MainPage mainPage = new MainPage();

    @Test
    @Api(name = "TestRepo123", isPrivate = "false")
    void createPublicRepositoryTest() {
        var repoList = new UserController().getRepositoryList();
        Assertions.assertEquals(1, repoList.size());
    }

    @Test
    void correctLoginTest(String email, String pass) {
        mainPage.selectLoginForm()
                .loginWitchCorrectData(email, pass)
                .userIsAuthorized();
    }

    @ParameterizedTest
    @MethodSource("getArgumentsForLoginTest")
    void incorrectLoginTest(String email, String pass) {
        mainPage.loginWitchIncorrectData(email, pass);
    }

    static public Stream<Arguments> getArgumentsForLoginTest() {
        return Stream.of(
                Arguments.of("f43241@fma.com", PASS),
                Arguments.of("POkdm@@gmail.com", "fds123AD"),
                Arguments.of(EMAIL, PASS)

        );
    }

}
