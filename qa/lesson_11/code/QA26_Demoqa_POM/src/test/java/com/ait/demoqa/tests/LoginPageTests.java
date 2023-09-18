package com.ait.demoqa.tests;

import com.ait.demoqa.data.UserData;
import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.LoginPage;
import com.ait.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStore();
        new SidePanel(driver).selectLogin();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver)
                .loginPositive(UserData.USER_NAME,UserData.USER_PASSWORD)
                .verifyUserName(UserData.USER_NAME);
    }
}
