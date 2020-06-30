package com.pflb.learning;

import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MenuCheckTest {
    StartPage startPage = new StartPage();
    private static final String realProductText = "Онлайн-инструмент для тестирования на пользователях";
    @Test(priority = 1)
    public void checkMenuProduct() {
        InputStream inputStream = DriverManager.class.getClassLoader().getResourceAsStream("config.properties");

        Properties properties = new Properties();
        try { properties.load(inputStream); }
        catch (IOException e) { throw new RuntimeException(e);}

        String url = properties.getProperty("test.stand");
        DriverManager.getDriver().get(url);
        DriverManager.getDriver().manage().window().maximize();

        startPage.clickItemProduct();
        String productText = startPage.getProductTitle();
        assert productText.equals(realProductText): "can not log in";

        DriverManager.getDriver().quit();

    }
}
