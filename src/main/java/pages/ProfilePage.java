package pages;

import com.pflb.learning.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private static final int SECWAIT = 10;

    public ProfilePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[2]/div[1]/div[1]/span")
    private WebElement buttonCreateTest;//Элемент , который даёт понять нам что мы перешли на страницу профиля

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[1]/aside/section[2]/div")
    private WebElement profileSettings;

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/input")
    private WebElement checkProfileLogin;

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/input")
    private WebElement checkProfileEmail;
    //Added new test
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[1]/aside/section[1]")
    private WebElement buttonAddNewTest;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div[2]/label/input")
    private WebElement nameTest;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[3]/div[2]/label/input")
    private WebElement url;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/button")
    private WebElement goToChangePersons;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div[2]/div[1]/label[1]/div")
    private WebElement elementWhichWait;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/ul/li/div/div[1]/div[2]/label/input")
    private WebElement nameSegment;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/button[2]")
    private WebElement goToQuest;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/label/textarea")
    private WebElement setQuest;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/button")
    private WebElement addedQuest;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/button[2]")
    private WebElement checkAndRun;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/section[4]/div/button")
    private WebElement runFreeTest;

    @FindBy(xpath = "//*[@id=\"modal-root\"]/div/div/div/div/div/div[1]")
    private WebElement actualTextAfterCreateTest;


    public String actualText() {
        return actualTextAfterCreateTest.getText();
    }

    public void descriptionTest(String testName, String site, String segment, String quest) {
        nameTest.sendKeys(testName);
        url.sendKeys(site);
        new WebDriverWait(DriverManager.getDriver(), SECWAIT);
        goToChangePersons.click();
        new WebDriverWait(DriverManager.getDriver(), SECWAIT).until(ExpectedConditions.visibilityOf(elementWhichWait));
        nameSegment.sendKeys(segment);
        goToQuest.click();
        new WebDriverWait(DriverManager.getDriver(), SECWAIT).until(ExpectedConditions.visibilityOf(setQuest));
        setQuest.sendKeys(quest);
        new WebDriverWait(DriverManager.getDriver(), SECWAIT).until(ExpectedConditions.elementToBeClickable(addedQuest));
        addedQuest.click();
        new WebDriverWait(DriverManager.getDriver(), SECWAIT).until(ExpectedConditions.elementToBeClickable(checkAndRun));
        checkAndRun.click();
        new WebDriverWait(DriverManager.getDriver(), SECWAIT).until(ExpectedConditions.elementToBeClickable(runFreeTest));
        runFreeTest.click();
    }

    public void pressButtonCreateNewTest() {
        buttonCreateTest.click();
    }

    public boolean isDisplayedButtonCreateTest() {
        return buttonCreateTest.isDisplayed();
    }

    public void checkProfileSettings() {
        profileSettings.click();
    }

    public String getProfileLogin() {
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.visibilityOf(checkProfileLogin));
        return checkProfileLogin.getAttribute("value");
    }

    public String getProfileEmail() {
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.visibilityOf(checkProfileEmail));
        return checkProfileEmail.getAttribute("value");
    }


}
