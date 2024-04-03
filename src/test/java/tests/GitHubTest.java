package tests;

import common.annotation.Api;
import common.core.properties.Properties;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import object.controller.UserController;
import object.pages.MainPage;
import object.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.extension.ApiExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ApiExtension.class)
@Owner("me")
public class GitHubTest  {

    UserCredentials userCred = UserCredentials.builder()
            .email("f")
            .password("1")
            .build();

    UserCredentials userCorrect = UserCredentials.builder()
            .email(Properties.EMAIL).password(Properties.PASS).build();

    @Test
    @Api(name = "TestRepo123", isPrivate = "false")
    @Description("api test")
    void createPublicRepositoryTest() {
        var repoList = new UserController().getRepositoryList();
        assertEquals(1, repoList.size(),
                "Expected 1 repositories, Repo size - " + repoList.size());
    }

    @Test
    @Description("Correct login test")
    void correctLoginTest() {
        User user = new UserController().getUserData();
        String login = new MainPage().selectLoginForm().loginCorrectData(userCorrect).userIsAuthorized();
        assertEquals(user.getLogin(), login, "Login does not match");
    }

    @ParameterizedTest
    @MethodSource("getArgumentsForLoginTest")
@Description("Incorrect login test")
    void incorrectLoginTest(String email, String pass) {
        Boolean alertIsDisplayed = new MainPage().selectLoginForm()
                .enteringLoginAndPassword(userCred)
                .clickTheSingInButton()
                .alertDetection();
        assertTrue(alertIsDisplayed);
    }

    static public Stream<Arguments> getArgumentsForLoginTest() {
        return Stream.of(
                Arguments.of("f43241@fma.com", Properties.PASS),
                Arguments.of("POkdm@@gmail.com", "fds123AD")
        );
    }
}