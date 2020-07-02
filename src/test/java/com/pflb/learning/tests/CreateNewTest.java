package com.pflb.learning.tests;

import com.pflb.learning.testpages.CreateNewTestPage;
import com.pflb.learning.testpages.RegAndAuthPage;
import com.pflb.learning.testpages.RegistrationTestPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewTest {

    private final RegistrationTestPage registrationTestPage = new RegistrationTestPage();
    private final CreateNewTestPage createNewTestPage = new CreateNewTestPage();
    private final RegAndAuthPage regAndAuthPage = new RegAndAuthPage();

    private static final String BASEURL = "http://test.uxcrowd.ru";
    private static final String EXCEPTEDTEXT = "Ура! Тест создан и отправлен пользователям.";


    @BeforeTest
    public void authClient() {
        registrationTestPage.open(BASEURL);
        regAndAuthPage.registrationClient();
        regAndAuthPage.authClient();
    }

    @Test
    public void goToNewTest() {
        createNewTestPage.createNewTest();
        String actualText = createNewTestPage.getActualText();
        Assert.assertEquals(actualText, EXCEPTEDTEXT);
    }

}
