package com.pflb.learning.testpages;

import com.pflb.learning.DriverManager;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.get;

public class RegAndAuthPage {

    private final int key = new Random().nextInt(1000);
    private final String name = "Ivan" + key;
    private final String position = "Junior" + key;
    private final String company = "Perfomance" + key;
    private final String email = "testmailforclient" + key;
    private final String phone = "79999999999";
    private final String endEmail = "@1secmail.com";


    public RegAndAuthPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    //Registration new client
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

    //Authorization client
    @FindBy(css = "#login")
    private WebElement loginFiled; // Поле ввода почты

    @FindBy(css = "[type=password]")
    private WebElement passwordField; // Поле ввода пароля

    @FindBy(css = "#form_auth button")
    private WebElement submitButton; // Кнопка "Вход"

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[2]/div[1]/div[1]/span")
    private WebElement buttonCreateTest; //Элемент , который даёт понять нам что мы перешли на страницу профиля

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
        fillYourEmail(email + endEmail);
        fillYourPhone(phone);
        clickButtonAgree();
    }

    private String checkMail() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Response response = get("https://www.1secmail.com/api/v1/?action=getMessages&login=" + email + "&domain=1secmail.com");
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.prettyPrint());
        Object id = jsonPath.get("id");
        String s = String.valueOf(id);
        return s.substring(1, s.length() - 1);
    }

    private String getPasswordFromMessage(String idMessage) {
        Response response = get("https://www.1secmail.com/api/v1/?action=readMessage&login=" + email + "&domain=1secmail.com&id=" + idMessage);
        JsonPath jsonPath = response.jsonPath();
        String body = jsonPath.get("body");

        Pattern p = Pattern.compile(".*<p>Пароль: [a-zA-Z0-9]+</p>.*");

        Matcher m = p.matcher(body);
        String res = "";
        if (m.find()) {
            res = m.group();
        }
        Pattern p2 = Pattern.compile("(.* )([a-zA-Z0-9]+)(<.*)");

        Matcher m2 = p2.matcher(res);

        if (m2.find()) {
            return m2.group(2);
        }
        return null;

    }

    public void authClient() {
        String idMessage = checkMail();
        String passwordFromMessage = getPasswordFromMessage(idMessage);
        clickLoginButton();
        fillLoginField(email + endEmail);
        fillPasswordField(passwordFromMessage);
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

}
