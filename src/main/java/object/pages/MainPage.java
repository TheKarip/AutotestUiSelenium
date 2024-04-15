package object.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(css = ".HeaderMenu-link--sign-in")
   protected WebElement loginForm;

    @FindBy(id = "login_field")
    protected WebElement loginField;

    @FindBy(id = "password")
    protected WebElement passField;

    @FindBy(css = "[value='Sign in']")
    protected WebElement singInButton;

    @FindBy(css = ".js-flash-alert")
    protected WebElement incorrectAlert;
}
