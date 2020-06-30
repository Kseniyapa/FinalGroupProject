package com.pflb.learning;

import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AuthTest {
    StartPage startPage = new StartPage();
    LoginPage loginPage = new LoginPage();
    LoggedinPage loggedinPage = new LoggedinPage();

    private static final String realWelcomeText = "ДОБРЫЙ ДЕНЬ!";
    @Test(priority = 1)
    public void auth() {
        InputStream inputStream = DriverManager.class.getClassLoader().getResourceAsStream("config.properties");

        Properties properties = new Properties();
        try { properties.load(inputStream); }
        catch (IOException e) { throw new RuntimeException(e);}

        String url = properties.getProperty("test.stand");
        DriverManager.getDriver().get(url);
        DriverManager.getDriver().manage().window().maximize();

        startPage.clickEnterButton();
        String login = properties.getProperty("login");

        loginPage.fillLogin(login);
        String password = properties.getProperty("password");

        loginPage.fillPassword(password);
        String welcomText = loggedinPage.getWelcomeText();
        String realWelcomeText = properties.getProperty("realWelcomeText");
        realWelcomeText = "ДОБРЫЙ ДЕНЬ!";
        assert welcomText.equals(realWelcomeText): "can not log in";
        DriverManager.getDriver().quit();
    }
}
