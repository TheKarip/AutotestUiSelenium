package steps;

import io.qameta.allure.Step;
import object.pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageSteps extends HomePage {

    @Step("Displaying the correct user login")
    public String userIsAuthorized() {
        wait.until(ExpectedConditions.visibilityOf(avatarButton)).click();
        return userLogin.getText();
    }
}
