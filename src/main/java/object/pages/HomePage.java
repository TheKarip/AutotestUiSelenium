package object.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".Button-label .avatar")
    protected WebElement avatarButton;

    @FindBy(css = "span .Truncate-text")
    protected WebElement userLogin;
}
