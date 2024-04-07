package object.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.credentials.UserCredentials;

public class MainPage extends BasePage {

    @FindBy(css = ".HeaderMenu-link--sign-in")
    WebElement loginForm;

    @FindBy(id = "login_field")
    WebElement loginField;

    @FindBy(id = "password")
    WebElement passField;

    @FindBy(css = "[value='Sign in']")
    WebElement singInButton;

    @FindBy(css = ".js-flash-alert")
    WebElement incorrectAlert;

    @Step("Open login form")
    public MainPage selectLoginForm() {
        wait.until(ExpectedConditions.visibilityOf(loginForm)).click();
        return this;
    }

    @Step("Enter login and password")
    public MainPage fillLoginAndPassword(UserCredentials user) {
        loginField.sendKeys(user.getEmail());
        passField.sendKeys(user.getPassword());
        return this;
    }

    public MainPage clickSingInButton() {
        singInButton.click();
        return this;
    }
    @Step("Error display for incorrect login data")
    public Boolean alertDetection() {
        return incorrectAlert.isDisplayed();
    }

    public HomePage loginCorrectData(UserCredentials user) {
        fillLoginAndPassword(user);
        clickSingInButton();
        return new HomePage();
    }
}
