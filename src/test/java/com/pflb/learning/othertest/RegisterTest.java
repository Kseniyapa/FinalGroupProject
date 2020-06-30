package com.pflb.learning.othertest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.StartPage;
import java.util.Random;

public class RegisterTest {
    private final StartPage startPage = new StartPage();
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final String email = "testtempmail" + new Random().nextInt(1000);
    private static final String BASEURL = "http://test.uxcrowd.ru";
    private static final String EXCEPTEDTEXTAFTERREGISTRATION = "Спасибо за регистрацию на UXCrowd!";

    @Test(priority = 1)
    public void registrationClient() {
        startPage.open(BASEURL);
        startPage.registrationNewClient("Perfomance", "Junior", "Lalalend", email, "78544567821");
        String actualTextAfterReg = registrationPage.getActualTextAfterReg();
        Assert.assertEquals(actualTextAfterReg, EXCEPTEDTEXTAFTERREGISTRATION);
        startPage.close();
    }
}
