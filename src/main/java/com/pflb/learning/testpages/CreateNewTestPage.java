package com.pflb.learning.testpages;

import com.pflb.learning.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewTestPage {

    public CreateNewTestPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[1]/aside/section[1]/div")
    private WebElement buttonCreateNewTest; // Кнопка "Новый тест"
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div[2]/label/input")
    private WebElement nameTestField; // Поле "Название теста"
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[3]/div[2]/label/input")
    private WebElement webSiteField; // Поле "Адрес сайта"
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/button")
    private WebElement buttonPeoples; // Кнопка "К выбору аудитории
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/ul/li/div/div[1]/div[2]/label/input")
    private WebElement nameSegmentField; // Поле "Название сегмента"
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/button[2]")
    private WebElement goToQuestButton; // Кнопка "К заданиям"
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/label/textarea")
    private WebElement answerField; // Поле "Голосовой ответ"
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/button")
    private WebElement addedButton; // Кнопка "Добавить"
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/button[2]")
    private WebElement checkAndRunButton; // Кнопка "Проверка и запуск"
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/section[4]/div/button")
    private WebElement runFreeTestButton; // Кнопка "Запустить бесплатный тест"
    @FindBy(xpath = "//*[@id=\"modal-root\"]/div/div/div/div/div/div[1]")
    private WebElement actualTextAfterCreateNewTest; // Текст , который даёт нам понять , что тест создан

    public String getActualText() {
        return actualTextAfterCreateNewTest.getText();
    }

    public void createNewTest() {
        clickButtonCreateNewTest();
        fillNameTest("da");
        fillWebSite("dasdasda.ru");
        clickButtonPeoples();
        fillNameSegmentField("dsadsfs");
        clickButtnoToQuest();
        fillAnswerField("dasdgfd");
        clickAddedButton();
        clickCheckAndRunButton();
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(runFreeTestButton));
        clickRunFreeTestButton();
    }

    private void clickRunFreeTestButton() {
        runFreeTestButton.click();
    }

    private void clickCheckAndRunButton() {
        checkAndRunButton.click();
    }

    private void clickAddedButton() {
        addedButton.click();
    }

    private void fillAnswerField(String answer) {
        answerField.sendKeys(answer);
    }

    private void clickButtnoToQuest() {
        goToQuestButton.click();
    }

    private void fillNameSegmentField(String segment) {
        nameSegmentField.sendKeys(segment);
    }

    private void clickButtonPeoples() {
        buttonPeoples.click();
    }

    private void fillWebSite(String web) {
        webSiteField.sendKeys(web);
    }

    private void fillNameTest(String testName) {
        nameTestField.sendKeys(testName);
    }

    private void clickButtonCreateNewTest() {
        buttonCreateNewTest.click();
    }
}
