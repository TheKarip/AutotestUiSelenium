package org.example.common.pages;

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
        assertTrue(checkHomePage.isDisplayed());
        return this;
    }
}
