package com.pflb.learning.tests;

import com.pflb.learning.testpages.AuthTestPage;
import com.pflb.learning.testpages.ProfilePage;
import com.pflb.learning.testpages.RegistrationTestPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProfilePageTest {
    private final RegistrationTestPage registrationTestPage = new RegistrationTestPage();
    private final AuthTestPage authTestPage = new AuthTestPage();
    private final ProfilePage profilePage = new ProfilePage();
    private static final String BASEURL = "http://test.uxcrowd.ru";
    private static final String EXCEPTEDLOGIN = "bxgq0bhpvj";
    private static final String EXCEPTEDEMAIL = "bxgq0bhpvj@1secmail.org";
    private static final String EXCEPTEDFIO = "Ivan";


    @BeforeTest
    public void authClient() {
        registrationTestPage.open(BASEURL);
        authTestPage.authCLient();
    }

    @Test(priority = 1)
    public void checkValidLogin() {
        profilePage.getProfileSettings();
        String profileLogin = profilePage.getProfileLogin();
        Assert.assertEquals(profileLogin, EXCEPTEDLOGIN);
    }

    @Test(priority = 2)
    public void checkValidemail() {
        profilePage.getProfileSettings();
        String profileEmail = profilePage.getProfileEmail();
        Assert.assertEquals(profileEmail, EXCEPTEDEMAIL);
    }

    @Test(priority = 3)
    public void checkValidFIO() {
        profilePage.getProfileSettings();
        String profileFIO = profilePage.getProfileFIO();
        Assert.assertEquals(profileFIO, EXCEPTEDFIO);

    }
}
