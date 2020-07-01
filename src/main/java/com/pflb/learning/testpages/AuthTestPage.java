package com.pflb.learning.testpages;

import com.pflb.learning.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthTestPage {

    private static final String EMAILCLIENT = "testmailforclient2@1secmail.com";

    private static final String PASSWORDCLIENT = "wyJpVF";

    public AuthTestPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(id = "header-lk-button")
    private WebElement loginButton; // Кнопка открытия окошка "Вход/Регистрация"

    @FindBy(css = "#login")
    private WebElement loginFiled; // Поле ввода почты

    @FindBy(css = "[type=password]")
    private WebElement passwordField; // Поле ввода пароля

    @FindBy(css = "#form_auth button")
    private WebElement submitButton; // Кнопка "Вход"

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[2]/div[1]/div[1]/span")
    private WebElement buttonCreateTest; //Элемент , который даёт понять нам что мы перешли на страницу профиля


    public boolean getElementAfterAuth() {
        return buttonCreateTest.isDisplayed();
    }

    public void authClient(String email, String password) {
        clickLoginButton();
        fillLoginField(email);
        fillPasswordField(password);
        clickSubmitButton();
    }

    public void authClient() {
        clickLoginButton();
        fillLoginField(EMAILCLIENT);
        fillPasswordField(PASSWORDCLIENT);
        clickSubmitButton();
    }

    private void clickSubmitButton() {
        submitButton.click();
    }

    private void fillPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    private void fillLoginField(String email) {
        loginFiled.sendKeys(email);
    }

    private void clickLoginButton() {
        loginButton.click();
    }

}
