package com.pflb.learning.maintest;

import com.pflb.learning.DriverManager;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProfilePage;
import pages.RegistrationPage;
import pages.StartPage;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.get;

public class UxCrowdTest {
    private final StartPage startPage = new StartPage();
    private final ProfilePage profilePage = new ProfilePage();
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final String email = "testtempmail" + new Random().nextInt(1000);
    private String idMessage = "";
    private String passwordMessage = "";
    private static final String BASEURL = "http://test.uxcrowd.ru";
    private static final String EXCEPTEDTEXTAFTERREGISTRATION = "Спасибо за регистрацию на UXCrowd!";
    private static final String EXCEPTEDTEXTAFTERCREATENEWTEST = "Ура! Тест создан и отправлен пользователям.";


    @Test(priority = 1)
    public void registrationClient() {
        startPage.open(BASEURL);
        startPage.registrationNewClient("Ifvsd", "dassf", "dsadsf", email, "78544567821");
        String actualTextAfterReg = registrationPage.getActualTextAfterReg();
        Assert.assertEquals(actualTextAfterReg, EXCEPTEDTEXTAFTERREGISTRATION);
    }

    @Test(priority = 2)
    public void checkMail() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Response response = get("https://www.1secmail.com/api/v1/?action=getMessages&login=" + email + "&domain=1secmail.com");
        JsonPath jsonPath = response.jsonPath();
        Object id = jsonPath.get("id");
        String s = String.valueOf(id);
        idMessage = s.substring(1, s.length() - 1);
    }

    @Test(priority = 3)
    public void getPasswordFromMessage() {
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
            //System.out.println(m2.group(2));
            passwordMessage = m2.group(2);
        }


    }


    @Test(priority = 4)
    public void auth() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startPage.open(BASEURL);
        startPage.authClient(email + "@1secmail.com", passwordMessage);
        boolean displayedButtonCreateTest = profilePage.isDisplayedButtonCreateTest();
        Assert.assertTrue(displayedButtonCreateTest);
    }

    @Test(priority = 5)
    public void checkValidLoginInProfile() {
        profilePage.checkProfileSettings();
        new WebDriverWait(DriverManager.getDriver(), 10);
        String profileLogin = profilePage.getProfileLogin();
        Assert.assertEquals(profileLogin, email);

    }

    @Test(priority = 6)
    public void checkValidEmailInProfile() {
        String profileEmail = profilePage.getProfileEmail();
        Assert.assertEquals(profileEmail, email + "@1secmail.com");
    }



    @Test(priority = 7)
    public void createNewTest (){
        profilePage.pressButtonCreateNewTest();
        profilePage.descriptionTest("Isdsa",
                "dasfdfdfa.ru",
                "fdsfdbhnfsnjgsdgs","ZADACHA");
        String actualText = profilePage.actualText();
        Assert.assertEquals(actualText,EXCEPTEDTEXTAFTERCREATENEWTEST);
    }


}
