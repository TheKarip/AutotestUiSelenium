package tests;

import annotation.Api;
import api.controller.UserController;
import credentials.UserCredentials;
import extension.ApiExtension;
import listener.TestListener;
import object.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import steps.MainPageSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({ApiExtension.class, TestListener.class})
public class GitHubTest extends BaseTest{

    @Test
    @Api(name = "TestRepo123", isPrivate = "false")
    void createPublicRepositoryTest() {
        var repoList = new UserController().getRepositoryList();
        assertEquals(1, repoList.size(),
                "Expected 1 repositories, Repo size - " + repoList.size());
    }

    @Test
    void correctLoginTest() {
        User user = new UserController().getUserData();
        String login = new MainPageSteps().selectLoginForm()
                .loginCorrectData(UserCredentials.getCorrectUserData())
                .userIsAuthorized();
        assertEquals(user.getLogin(), login, "Login does not match");
    }

    @ParameterizedTest
    @MethodSource("credentials.UserCredentials#getIncorrectUserData")
    void incorrectLoginTest(UserCredentials user) {
        Boolean alertIsDisplayed = new MainPageSteps().selectLoginForm()
                .fillLoginAndPassword(user)
                .clickSingInButton()
                .alertDetection();
        assertTrue(alertIsDisplayed);
    }
}