package pages;

import com.pflb.learning.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    @FindBy(id = "login")
    private WebElement loginField;

    @FindBy(css = "[type=password]")
    private WebElement passwordField;

    @FindBy(css = "#form_auth button")
    private WebElement submitButton;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void fillLogin(String login){
        //fill in login
        loginField.sendKeys(login);
    }

    public void fillPassword(String password){
        //fill in login
        passwordField.sendKeys(password);
    }

    public void enter() {
        submitButton.click();
        int secondsToWait = 2;
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), secondsToWait);
    }
}

