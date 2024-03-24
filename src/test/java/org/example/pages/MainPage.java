package org.example.pages;

import org.example.common.API.ApiTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.example.common.Const.EMAIL;
import static org.example.common.Const.PASS;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div//a[contains(@class, 'sign-in')]")
    WebElement loginForm;

    @FindBy(id = "login_field")
    WebElement loginField;

    @FindBy(id = "password")
    WebElement passField;

    @FindBy(xpath = "//h2[contains(text(),'Home')]")
    WebElement checkHomePage;

    @FindBy(className = "js-flash-alert")
    WebElement incorrectAlert;


    public MainPage selectLoginForm() {
        wait.until(d -> loginForm.isDisplayed());
        loginForm.click();
        return this;
    }

    public MainPage fillLoginForm() {
        wait.until(d -> loginField.isDisplayed());
        wait.until(d -> passField.isDisplayed());
        loginField.sendKeys(EMAIL);
        passField.sendKeys(PASS, Keys.ENTER);
        wait.until(d -> checkHomePage.isDisplayed());
        assertTrue(checkHomePage.isDisplayed(), "Home page didn't load");
        return this;
    }

    public void checkIncorrectData(String email, String pass) {
        wait.until(d -> loginField.isDisplayed());
        wait.until(d -> passField.isDisplayed());
        loginField.sendKeys(email);
        passField.sendKeys(pass, Keys.ENTER);
        wait.until(d -> incorrectAlert.isDisplayed());
        assertTrue(incorrectAlert.isDisplayed());
    }
}
