package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        //click on login link - //a[contains(.,'LOGIN')] - xpath
        clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest() {
        //enter email - [placeholder='Email'] - css
        fillLoginRegisterForm();
        //click on Login button
        click(By.xpath("//button[text()='Login']"));
        //assert is Sign out button present
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));
    }
}
