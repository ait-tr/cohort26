package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewUserTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        //click on login link
        clickOnLoginLink();
    }

    @Test
    public void createExistedUserNegativeTest() {
        //enter email & password
        fillLoginRegisterForm();
        //click on Registration button
        clickOnRegistrationButton();
        //assert Sign out button present
        Assert.assertTrue(isAlertPresent());
    }
}
