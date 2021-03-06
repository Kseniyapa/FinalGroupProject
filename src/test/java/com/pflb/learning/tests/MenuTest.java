package com.pflb.learning.tests;

import com.pflb.learning.DriverManager;
import com.pflb.learning.testpages.MenuPage;
import com.pflb.learning.testpages.RegistrationTestPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest {

    private final MenuPage menuPage = new MenuPage();
    private final RegistrationTestPage registrationTestPage = new RegistrationTestPage();

    private static final String BASEURL = "http://test.uxcrowd.ru";
    private static final String REAL_PRODUCT_TEXT = "Онлайн-инструмент для тестирования на пользователях";
    private static final String REAL_PRICE_TEXT = "Тарифы на использование UXCrowd";
    private static final String REAL_FAQ_TEXT = "Часто задаваемые вопросы";
    private static final String REAL_WANT_TEST_TEXT = "Работа дома — тестирование сайтов";


    @Test(priority = 1)
    public void checkProduct() {
        registrationTestPage.open(BASEURL);
        menuPage.clickItemProduct();
        String productText = menuPage.getProductTitle();
        Assert.assertEquals(productText, REAL_PRODUCT_TEXT, "Can not enter Product section");
    }

    @Test(priority = 2)
    public void checkPrice() {
        menuPage.clickItemPrice();
        String priceText = menuPage.getPriceTitle();
        Assert.assertEquals(priceText, REAL_PRICE_TEXT, "Can not enter Price section");
    }

    @Test(priority = 3)
    public void checkFAQ() {
        menuPage.clickItemFAQ();
        String faqText = menuPage.getFAQTitle();
        Assert.assertEquals(faqText, REAL_FAQ_TEXT, "Can not enter FAQ section");
    }

    @Test(priority = 4)
    public void checkWantTest() {
        menuPage.clickItemWantTest();
        String WantTestText = menuPage.getWantTestTitle();
        Assert.assertEquals(WantTestText, REAL_WANT_TEST_TEXT, "Can not enter Want section");

        DriverManager.getDriver().quit();
    }
}
