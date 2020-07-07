package com.pflb.learning.testpages;

import com.pflb.learning.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class RegistrationTestPage {

    private final int key = new Random().nextInt(1000);
    private final String name = "Ivan" + key;
    private final String position = "Junior" + key;
    private final String company = "Perfomance" + key;
    private final String email = "testmailforclient" + key + "@1secmail.org";
    private final String phone = "79999999999";


    public RegistrationTestPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(id = "header-lk-button")
    private WebElement loginButton; // Кнопка открытия окошка "Вход/Регистрация"

    @FindBy(css = "[for=registrationLk]")
    private WebElement buttonRegistrationClient; // Кнопка "Регистрация"

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div[2]/section[2]/div[1]/button")
    private WebElement toClient; // Кнопка "Стать клиентом"

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement yourName; // Поле для заполнения "Имя"

    @FindBy(xpath = "//*[@id=\"position\"]")
    private WebElement yourPosition; // Поле для заполнения "Должность"

    @FindBy(xpath = "//*[@id=\"company\"]")
    private WebElement yourCompany; // Поле для заполнения "Компания"

    @FindBy(xpath = "//*[@id=\"emails\"]")
    private WebElement yourEmail; // Поле для заполнения "Почта"

    @FindBy(xpath = "//*[@id=\"phoneNumber\"]")
    private WebElement yourPhone; // Поле для заполнения "Телефон"

    @FindBy(xpath = "//*[@id=\"form_register_customer\"]/button")
    private WebElement buttonAgree; // Кнопка "Зарегистрироваться"

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div/div/div[2]/div/div")
    private WebElement afterRegistrationText;

    public String getActualTextAfterReg() {
        return afterRegistrationText.getText();
    }


    public void registrationClient() {
        clickWindowRegistration();
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(buttonRegistrationClient));
        clickButtonRegistration();
        clickToClient();
        fillYourName(name);
        fillYourPosition(position);
        fillYourCompany(company);
        fillYourEmail(email);
        fillYourPhone(phone);
        clickButtonAgree();
    }


    private void clickButtonAgree() {
        buttonAgree.click();
    }

    private void fillYourPhone(String phone) {
        yourPhone.sendKeys(phone);
    }

    private void fillYourEmail(String email) {
        yourEmail.sendKeys(email);
    }

    private void fillYourCompany(String company) {
        yourCompany.sendKeys(company);
    }

    private void fillYourPosition(String position) {
        yourPosition.sendKeys(position);
    }

    private void fillYourName(String name) {
        yourName.sendKeys(name);
    }

    private void clickToClient() {
        toClient.click();
    }

    private void clickButtonRegistration() {
        buttonRegistrationClient.click();
    }

    private void clickWindowRegistration() {
        loginButton.click();
    }

    public void open(String url) {
        DriverManager.getDriver().get(url);
    }

    public void close() {
        DriverManager.getDriver().close();
    }

}
