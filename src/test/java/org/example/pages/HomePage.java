package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends MainPage {

    @FindBy(id = "repository[name]")
    WebElement repositoryName;

    @FindBy(id = "repository[visibility]_public")
    WebElement publicButton;

    @FindBy(xpath = "//h3/strong")
    WebElement quickSetup;

    public void createPublicRepository() {
        wait.until(d -> publicButton.isDisplayed());
        publicButton.click();
        repositoryName.sendKeys("publicrep123", Keys.ENTER);
        wait.until(d -> quickSetup.isDisplayed());
        assertTrue(quickSetup.isDisplayed());
    }
}
