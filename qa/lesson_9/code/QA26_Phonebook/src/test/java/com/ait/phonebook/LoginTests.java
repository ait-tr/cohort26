package com.ait.phonebook;

import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        //click on login link - //a[contains(.,'LOGIN')] - xpath
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest() {
        //enter email - [placeholder='Email'] - css
        app.getUser().fillLoginRegisterForm(new User().setEmail("stark@gmail.com")
                .setPassword("Stark1234$"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert is Sign out button present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutPasswordTest() {
        //enter email - [placeholder='Email'] - css
        app.getUser().fillLoginRegisterForm(new User().setEmail("stark@gmail.com"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert is alert present
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test
    public void loginPositiveTestWithScreenCast() throws IOException, AWTException {
        app.getUser().deleteScreenCast("record");
        app.getUser().startRecording();

        app.getUser().fillLoginRegisterFormForScreenCast(new User()
                .setEmail("stark@gmail.com")
                .setPassword("Stark1234$"));

        app.getUser().clickOnLoginButton();
        app.getUser().pause(2000);

        app.getUser().stopRecording();
    }
}
