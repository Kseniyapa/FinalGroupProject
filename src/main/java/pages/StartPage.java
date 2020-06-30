package pages;

import com.pflb.learning.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {

    private final String email = "@1secmail.com";

    public StartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    //AUTH
    @FindBy(id = "header-lk-button")
    private WebElement loginButton;

    @FindBy(css = "#login")
    private WebElement loginFiled;

    @FindBy(css = "[type=password]")
    private WebElement passwordField;

    @FindBy(css = "#form_auth button")
    private WebElement submitButton;
    //REGISTRATION
    @FindBy(css = "[for=registrationLk]")
    private WebElement buttonRegistrationClient;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div[2]/section[2]/div[1]/button")
    private WebElement toConsumer;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement yourName;

    @FindBy(xpath = "//*[@id=\"position\"]")
    private WebElement yourPosition;

    @FindBy(xpath = "//*[@id=\"company\"]")
    private WebElement yourCompany;

    @FindBy(xpath = "//*[@id=\"emails\"]")
    private WebElement yourEmail;

    @FindBy(xpath = "//*[@id=\"phoneNumber\"]")
    private WebElement yourPhone;

    @FindBy(xpath = "//*[@id=\"form_register_customer\"]/button")
    private WebElement buttonAgree;

    @FindBy(xpath = "//*[@id=\"header-lk-button\"]")
    WebElement enterButton;

    @FindBy(xpath = "//a[@href=\"/about\"][@class=\"nl-header-link\"]")
    WebElement menuItemProduct;

    @FindBy(xpath = "//h2[@ng-tr=\"NLABO.NLABO1\"][@class=\"section-start__text-header\"]")
    WebElement productTitle;

    public String getProductTitle(){
        return productTitle.getText();
    }

    public void clickItemProduct(){
        menuItemProduct.click();
    }


    public void clickEnterButton(){
        enterButton.click();
        int secondsToWait = 2;
        WebDriverWait wait = new WebDriverWait( DriverManager.getDriver(), secondsToWait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name=\"login\"]")));

    }


    public void authClient(String login, String password) {
        loginButton.click();
        new WebDriverWait(DriverManager.getDriver(), 10);
        loginFiled.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void open(String url) {
        DriverManager.getDriver().get(url);
    }

    public void registrationNewClient(String name, String position, String company, String mail, String phone) {
        loginButton.click();
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(buttonRegistrationClient));
        buttonRegistrationClient.click();
        new WebDriverWait(DriverManager.getDriver(),10).until(ExpectedConditions.elementToBeClickable(toConsumer));
        toConsumer.click();
        yourName.sendKeys(name);
        yourPosition.sendKeys(position);
        yourCompany.sendKeys(company);
        yourEmail.sendKeys(mail + email );
        yourPhone.sendKeys(phone);
        buttonAgree.click();
    }
}
