package object.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div//a[contains(@class, 'sign-in')]")
    WebElement loginForm;

    @FindBy(id = "login_field")
    WebElement loginField;

    @FindBy(id = "password")
    WebElement passField;

    @FindBy(xpath = "//div[@class='js-flash-alert']")
    WebElement incorrectAlert;

    public MainPage selectLoginForm() {
        wait.until(d -> loginForm.isDisplayed());
        loginForm.click();
        return this;
    }

    public HomePage loginWitchCorrectData(String email, String pass) {
        loginField.sendKeys(email);
        passField.sendKeys(pass, Keys.ENTER);
        return new HomePage();
    }

    public MainPage loginWitchIncorrectData(String email, String pass) {
        loginField.sendKeys(email);
        passField.sendKeys(pass, Keys.ENTER);
        assertTrue(incorrectAlert.isDisplayed());
        return this;
    }
}
