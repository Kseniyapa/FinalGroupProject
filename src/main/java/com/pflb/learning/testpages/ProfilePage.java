package com.pflb.learning.testpages;

import com.pflb.learning.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    public ProfilePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[1]/aside/section[2]/div")
    private WebElement profileSettings; // Кнопка перехода к настройкам профиля

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/input")
    private WebElement checkProfileLogin; // Поле с логином

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/input")
    private WebElement checkProfileEmail; // Поле с почтой

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/form[2]/div[1]/input")
    private WebElement checkProfileFIO; // Поле с Именем


    public String getProfileFIO() {
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.visibilityOf(checkProfileFIO));
        return checkProfileFIO.getAttribute("value");
    }


    public String getProfileLogin() {
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.visibilityOf(checkProfileLogin));
        return checkProfileLogin.getAttribute("value");
    }

    public String getProfileEmail() {
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.visibilityOf(checkProfileEmail));
        return checkProfileEmail.getAttribute("value");
    }

    public void clickProfileSettings() {
        profileSettings.click();
    }
}
