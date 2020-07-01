package com.pflb.learning.tests;

import com.pflb.learning.DriverManager;
import com.pflb.learning.testpages.AuthTestPage;
import com.pflb.learning.testpages.MenuPage;
import com.pflb.learning.testpages.RegistrationTestPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest {

    private final MenuPage menuPage = new MenuPage();
    private final RegistrationTestPage registrationTestPage = new RegistrationTestPage();

    private static final String BASEURL = "http://test.uxcrowd.ru";
    private static final String realProductText = "Онлайн-инструмент для тестирования на пользователях";
    private static final String realPriceText = "Тарифы на использование UXCrowd";
    private static final String realFAQText = "Часто задаваемые вопросы";
    private static final String realWantTestText = "Работа дома — тестирование сайтов";


    @Test(priority = 1)
    public void checkProduct() {
        registrationTestPage.open(BASEURL);
        menuPage.clickItemProduct();
        String productText = menuPage.getProductTitle();

        assert productText.equals(realProductText): "can not check product item";
    }

    @Test(priority = 2)
    public void checkPrice() {
        menuPage.clickItemPrice();
        String priceText = menuPage.getPriceTitle();

        assert priceText.equals(realPriceText): "can not check price item";
    }

    @Test(priority = 3)
    public void checkFAQ() {
        menuPage.clickItemFAQ();
        String faqText = menuPage.getFAQTitle();

        assert faqText.equals(realFAQText): "can not check FAQ item";
    }

    @Test(priority = 4)
    public void checkWantTest() {
        menuPage.clickItemWantTest();
        String WantTestText = menuPage.getWantTestTitle();

        assert WantTestText.equals(realWantTestText): "can not check Want test sites item";

        DriverManager.getDriver().quit();
    }
}
