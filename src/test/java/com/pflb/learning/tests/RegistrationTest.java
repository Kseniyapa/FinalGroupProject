package com.pflb.learning.tests;

import com.pflb.learning.testpages.RegistrationTestPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTest {
    private final RegistrationTestPage registrationTestPage = new RegistrationTestPage();
    private final String email = "testclientmail" + new Random().nextInt(1000);
    private static final String BASEURL = "http://test.uxcrowd.ru";
    private static final String EXCEPTEDTEXTAFTERREGISTRATION = "Спасибо за регистрацию на UXCrowd!";

    @Test(priority = 1)
    public void registrationClient() {
        registrationTestPage.open(BASEURL);
        registrationTestPage.registrationClient("ivan", "Junior"
                , "perfomance", email + "@1secmail.com", "79999999999");
        String actualTextAfterReg = registrationTestPage.getActualTextAfterReg();
        Assert.assertEquals(actualTextAfterReg, EXCEPTEDTEXTAFTERREGISTRATION);
    }
}
