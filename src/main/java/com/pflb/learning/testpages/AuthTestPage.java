package com.pflb.learning.testpages;

import com.pflb.learning.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthTestPage {

    private static final String EMAILCLIENT = "bxgq0bhpvj@1secmail.org";

    private static final String PASSWORDCLIENT = "7lhnGr";

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

    public void authCLient() {
        getLoginButton();
        getLoginField(EMAILCLIENT);
        getPasswordField(PASSWORDCLIENT);
        getSubmitButton();
    }

    private void getSubmitButton() {
        submitButton.click();
    }

    private void getPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    private void getLoginField(String email) {
        loginFiled.sendKeys(email);
    }

    private void getLoginButton() {
        loginButton.click();
    }

}
