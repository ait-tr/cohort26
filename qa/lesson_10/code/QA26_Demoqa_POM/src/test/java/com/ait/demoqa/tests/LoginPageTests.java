package com.ait.demoqa.tests;

import com.ait.demoqa.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver)
                .loginPositive("neuer","Neuer1234!");
    }
}
