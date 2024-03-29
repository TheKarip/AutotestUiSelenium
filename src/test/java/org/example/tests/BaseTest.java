package org.example.tests;

import org.example.common.annotation.Api;
import org.example.common.controller.ReposController;
import org.example.common.controller.UserController;
import org.example.common.extension.ApiExtension;
import org.example.common.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.example.common.Const.HOME_PAGE_URL;
import static org.example.common.DriverAssist.close;
import static org.example.common.DriverAssist.open;

@ExtendWith(ApiExtension.class)
public class BaseTest {

    ReposController reposController = new ReposController();
    static MainPage mainPage = new MainPage();

    @Test
    @Api(name ="TestRepo123", isPrivate = "false")
    void createPublicRepository() {
       var repoList = new UserController().getRepositoryList();
        Assertions.assertEquals(1, repoList.size());
    }

    @Test
    void checkIncorrectFill() {
        open(HOME_PAGE_URL);
        mainPage.selectLoginForm().fillLoginForm();
        close();
    }

}
