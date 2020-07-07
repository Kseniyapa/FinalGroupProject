package com.pflb.learning.tests;

import com.pflb.learning.testpages.AuthTestPage;
import com.pflb.learning.testpages.RegAndAuthPage;
import com.pflb.learning.testpages.RegistrationTestPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationAndAuthorizationTest {
    private final RegistrationTestPage registrationTestPage = new RegistrationTestPage();
    private final RegAndAuthPage regAndAuthPage = new RegAndAuthPage();
    private final AuthTestPage authTestPage = new AuthTestPage();

    private static final String BASEURL = "http://test.uxcrowd.ru";
    private static final String EXCEPTEDTEXTAFTERREGISTRATION = "Спасибо за регистрацию на UXCrowd!";


    @Test(priority = 1)
    public void registrationClient() {
        registrationTestPage.open(BASEURL);
        regAndAuthPage.registrationClient();
        String actualTextAfterReg = regAndAuthPage.getActualTextAfterReg();
        Assert.assertEquals(actualTextAfterReg, EXCEPTEDTEXTAFTERREGISTRATION, "Can not register");
    }

    @Test(priority = 2)
    public void authClient() {
        registrationTestPage.open(BASEURL);
        regAndAuthPage.authClient();
        boolean elementAfterAuth = authTestPage.getElementAfterAuth();
        Assert.assertTrue(elementAfterAuth, "Can not login after automatic registration");
    }


}
