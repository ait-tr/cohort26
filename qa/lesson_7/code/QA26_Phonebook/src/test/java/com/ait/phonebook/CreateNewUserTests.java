package com.ait.phonebook;

import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewUserTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        //click on login link
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void createExistedUserNegativeTest() {
        //enter email & password
        app.getUser().fillLoginRegisterForm(new User().setEmail("stark@gmail.com")
                .setPassword("Stark1234$"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //assert Sign out button present
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
