package object.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(css = ".Button-label .avatar")
    WebElement avatarButton;

    @FindBy(css = "span .Truncate-text")
    WebElement userLogin;

    @Step("Displaying the correct user login")
    public String userIsAuthorized() {
        wait.until(ExpectedConditions.visibilityOf(avatarButton)).click();
        return userLogin.getText();
    }
}
