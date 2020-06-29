package pages;

import com.pflb.learning.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    @FindBy(id = "header-lk-button")
    private WebElement loginButton;

    @FindBy(id = "login")
    private WebElement loginFiled;

    @FindBy(css = "[type=password]")
    private WebElement passwordField;

    @FindBy(css = "#form_auth button")
    private WebElement submitButton;

    public StartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void open() {
        DriverManager.getDriver().get("http://");
    }
}
