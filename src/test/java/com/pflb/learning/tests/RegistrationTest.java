package com.pflb.learning.tests;

import com.pflb.learning.testpages.RegistrationTestPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest {
    private final RegistrationTestPage registrationTestPage = new RegistrationTestPage();
    private static final String BASEURL = "http://test.uxcrowd.ru";
    private static final String EXCEPTEDTEXTAFTERREGISTRATION = "Спасибо за регистрацию на UXCrowd!";

    @Test(priority = 1)
    public void registrationClient() {
        registrationTestPage.open(BASEURL);
        registrationTestPage.registrationClient();
        String actualTextAfterReg = registrationTestPage.getActualTextAfterReg();
        Assert.assertEquals(actualTextAfterReg, EXCEPTEDTEXTAFTERREGISTRATION, "Can not register");
    }

}
