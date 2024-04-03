package object.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.UserCredentials;

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

    public MainPage selectLoginForm() {
        wait.until(ExpectedConditions.visibilityOf(loginForm)).click();
        return this;
    }

    public MainPage enteringLoginAndPassword(UserCredentials user) {
        loginField.sendKeys(user.getEmail());
        passField.sendKeys(user.getPassword());
        return this;
    }

    public MainPage clickTheSingInButton() {
        singInButton.click();
        return this;
    }

    public Boolean alertDetection() {
        return incorrectAlert.isDisplayed();
    }

    public HomePage loginCorrectData(UserCredentials user) {
        enteringLoginAndPassword(user);
        clickTheSingInButton();
        return new HomePage();
    }
}
