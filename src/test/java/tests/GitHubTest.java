package tests;

import common.annotation.Api;
import io.qameta.allure.Description;
import object.controller.UserController;
import object.pages.MainPage;
import object.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tests.credentials.UserCredentials;
import tests.extension.ApiExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ApiExtension.class)
public class GitHubTest extends BaseTest{

    @Test
    @Api(name = "TestRepo123", isPrivate = "false")
    @Description("api test")
    void createPublicRepositoryTest() {
        var repoList = new UserController().getRepositoryList();
        assertEquals(1, repoList.size(),
                "Expected 1 repositories, Repo size - " + repoList.size());
    }

    @Test
    void correctLoginTest() {
        User user = new UserController().getUserData();
        String login = new MainPage().selectLoginForm()
                .loginCorrectData(UserCredentials.getCorrectUserData())
                .userIsAuthorized();
        assertEquals(user.getLogin(), login, "Login does not match");
    }

    @ParameterizedTest
    @MethodSource("tests.credentials.UserCredentials#getIncrorectUserData")
    void incorrectLoginTest(UserCredentials user) {
        Boolean alertIsDisplayed = new MainPage().selectLoginForm()
                .enteringLoginAndPassword(user)
                .clickTheSingInButton()
                .alertDetection();
        assertTrue(alertIsDisplayed);
    }
}