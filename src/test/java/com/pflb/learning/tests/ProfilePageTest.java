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
    private static final String EXCEPTEDLOGIN = "testtempmail685";
    private static final String EXCEPTEDEMAIL = "testtempmail685@1secmail.org";
    private static final String PASSWORD = "NhBugH";
    private static final String EXCEPTEDFIO = "Ivan685";


    @BeforeTest
    public void authClient() {
        registrationTestPage.open(BASEURL);
        authTestPage.authClient(EXCEPTEDEMAIL, PASSWORD);
    }

    @Test(priority = 1)
    public void checkValidLogin() {
        profilePage.clickProfileSettings();
        String profileLogin = profilePage.getProfileLogin();
        Assert.assertEquals(profileLogin, EXCEPTEDLOGIN);
    }

    @Test(priority = 2)
    public void checkValidEmail() {
        profilePage.clickProfileSettings();
        String profileEmail = profilePage.getProfileEmail();
        Assert.assertEquals(profileEmail, EXCEPTEDEMAIL);
    }

    @Test(priority = 3)
    public void checkValidFIO() {
        profilePage.clickProfileSettings();
        String profileFIO = profilePage.getProfileFIO();
        Assert.assertEquals(profileFIO, EXCEPTEDFIO);

    }
}
