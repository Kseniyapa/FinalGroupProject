package pages;

import com.pflb.learning.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedinPage {
    @FindBy(css = "#form_auth button")
    private WebElement submitButton;

    @FindBy(xpath = "//*[contains(@class, 'slide-header welcome-h')]")
    private WebElement Welcome;

    public LoggedinPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public String getWelcomeText() {
        submitButton.click();
        int secondsToWait = 2;
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), secondsToWait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'slide-header welcome-h')]")));
        return Welcome.getText();

    }
}


