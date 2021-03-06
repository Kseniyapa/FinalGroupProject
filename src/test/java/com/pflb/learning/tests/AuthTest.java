package com.pflb.learning.tests;

import com.pflb.learning.testpages.AuthTestPage;
import com.pflb.learning.testpages.RegistrationTestPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest {
    private final RegistrationTestPage registrationTestPage = new RegistrationTestPage();
    private final AuthTestPage authTestPage = new AuthTestPage();
    private static final String BASEURL = "http://test.uxcrowd.ru";

    @Test
    public void authClient() {
        registrationTestPage.open(BASEURL);
        authTestPage.authClient();
        boolean elementAfterAuth = authTestPage.getCreateTestButtonState();
        Assert.assertTrue(elementAfterAuth, "Can not log in");
    }
}
