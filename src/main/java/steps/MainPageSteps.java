package steps;

import credentials.UserCredentials;
import io.qameta.allure.Step;
import object.pages.MainPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPageSteps extends MainPage {

    @Step("Open login form")
    public MainPageSteps selectLoginForm() {
        wait.until(ExpectedConditions.visibilityOf(loginForm)).click();
        return this;
    }

    @Step("Enter login and password")
    public MainPageSteps fillLoginAndPassword(UserCredentials user) {
        loginField.sendKeys(user.getEmail());
        passField.sendKeys(user.getPassword());
        return this;
    }

    public MainPageSteps clickSingInButton() {
        singInButton.click();
        return this;
    }
    @Step("Error display for incorrect login data")
    public Boolean alertDetection() {
        return incorrectAlert.isDisplayed();
    }

    public HomePageSteps loginCorrectData(UserCredentials user) {
        fillLoginAndPassword(user);
        clickSingInButton();
        return new HomePageSteps();
    }
}
