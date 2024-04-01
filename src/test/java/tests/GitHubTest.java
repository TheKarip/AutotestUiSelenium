package tests;

import common.core.properties.Properties;
import common.annotation.Api;
import object.controller.UserController;
import tests.extension.ApiExtension;
import object.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@ExtendWith(ApiExtension.class)
public class GitHubTest extends BaseTest {

    @Test
    @Api(name = "TestRepo123", isPrivate = "false")
    void createPublicRepositoryTest() {
        var repoList = new UserController().getRepositoryList();
        Assertions.assertEquals(1, repoList.size());
    }

    @Test
    void correctLoginTest() {
        new MainPage().selectLoginForm()
                .loginWitchCorrectData(Properties.EMAIL, Properties.PASS)
                .userIsAuthorized();
    }

    @ParameterizedTest
    @MethodSource("getArgumentsForLoginTest")
    void incorrectLoginTest(String email, String pass) {
        new MainPage().selectLoginForm()
                .loginWitchIncorrectData(email, pass);
    }

    static public Stream<Arguments> getArgumentsForLoginTest() {
        return Stream.of(
                Arguments.of("f43241@fma.com", Properties.PASS),
                Arguments.of("POkdm@@gmail.com", "fds123AD")
        );
    }

}
