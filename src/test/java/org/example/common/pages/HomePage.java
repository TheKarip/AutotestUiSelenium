package org.example.common.pages;

import org.example.common.controller.UserController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage{

    @FindBy(css = ".Button-label .avatar")
    WebElement avatarButton;

    @FindBy(css = "span .Truncate-text")
    WebElement userLogin;

    public HomePage userIsAuthorized() {
        String login = new UserController().getUserData().getLogin();
        avatarButton.click();
        System.out.println(login);
        assertEquals(login, userLogin.getText());
        return this;
    }

}
