package pages;

import com.pflb.learning.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    public RegistrationPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div/div/div[2]/div/div")
    private WebElement afterRegistrationText;

    public String getActualTextAfterReg() {
        return afterRegistrationText.getText();
    }
}
